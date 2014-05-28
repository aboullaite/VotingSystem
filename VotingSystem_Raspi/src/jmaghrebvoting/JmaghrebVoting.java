/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmaghrebvoting;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;

/**
 *
 * @author mohammed
 */
public class JmaghrebVoting extends Application {

    final String loginRegex = "(\\w+\\|\\d+)";
    // create gpio controller
    final GpioController gpio = GpioFactory.getInstance();

    // provision gpio pin #02 as an input pin with its internal pull down resistor enabled
    final GpioPinDigitalInput voteButton1 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_02, PinPullResistance.PULL_DOWN);
    final GpioPinDigitalInput voteButton2 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_03, PinPullResistance.PULL_DOWN);
    final GpioPinDigitalInput voteButton3 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_04, PinPullResistance.PULL_DOWN);
    final GpioPinDigitalOutput ledPin =  gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, PinState.LOW); // Application Views
    
    //App Screens
    public static String sessionId = "Default";
    public static String screen1ID = "welcome";
    public static String screen1File = "WelcomeScreen.fxml";
    public static String screen2ID = "admin";
    public static String screen2File = "Admin.fxml";
    public static String screen3ID = "vote";
    public static String screen3File = "VoteScreen.fxml";
    public static String screen4ID = "aftervote";
    public static String screen4File = "AfterVote.fxml";
    //session Id
    private static final ScreensController jMaghreb = new ScreensController();
    // Boolean to check if card is in or not
    public static Boolean cardIn = false;
    // Conncetion to Database
    SqlLite db = new SqlLite();

    @Override
    public void start(Stage primaryStage) throws Exception {
        userLogin();
        // in the start connection to sqlite is very slow 
        // so we gonna check it at the beginning
        db.connect();
        db.close();
        //make connection to server and syncronize data
        Timer timer = new Timer() ;
        
        Syncronization syn=new Syncronization(timer);
        timer.schedule(syn, 10000,60000);
        
        //load screens
        jMaghreb.loadScreen(JmaghrebVoting.screen1ID, JmaghrebVoting.screen1File);
        jMaghreb.loadScreen(JmaghrebVoting.screen2ID, JmaghrebVoting.screen2File);
        jMaghreb.loadScreen(JmaghrebVoting.screen3ID, JmaghrebVoting.screen3File);
        jMaghreb.loadScreen(JmaghrebVoting.screen4ID, JmaghrebVoting.screen4File);
        jMaghreb.setScreen(JmaghrebVoting.screen1ID);

        Group root = new Group();
        root.getChildren().addAll(jMaghreb);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        // primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    private void userLogin() {
        Task task;
        task = new Task() {

            @Override
            protected Object call() throws Exception {
                while (true) {
                    Scanner sc = new Scanner(System.in);
                    String login = sc.nextLine();
                    if (!JmaghrebVoting.cardIn) {
                        if (login.equals("admin")) {
                            jMaghreb.setScreen(JmaghrebVoting.screen2ID);
                            JmaghrebVoting.cardIn = true;
                        } else if (login.matches(loginRegex)) {

                            jMaghreb.setScreen(JmaghrebVoting.screen3ID);
                            JmaghrebVoting.cardIn = true;
                            voteButton1.addListener(new GpioPinListenerDigital() {
                                @Override
                                public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                                    // display vote on console
                                    if (event.getState().isHigh()) {
                                        ledPin.setState(PinState.HIGH);
                                        onVote(login, "A");
                                        
                                    }
                                    else ledPin.setState(PinState.LOW);

                                }

                            });
                            voteButton2.addListener(new GpioPinListenerDigital() {
                                @Override
                                public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                                    // display vote on console
                                    if (event.getState().isHigh()) {
                                        ledPin.setState(PinState.HIGH);
                                        onVote(login, "B");
                                     
                                    } else ledPin.setState(PinState.LOW);
                                
                                }

                            });
                            voteButton3.addListener(new GpioPinListenerDigital() {
                                @Override
                                public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {

                                    // display vote on console
                                    if (event.getState().isHigh()) {
                                        ledPin.setState(PinState.HIGH);
                                        onVote(login, "C");
                                        
                                    } else ledPin.setState(PinState.LOW);

                                }

                            });
                        }
                    }
                }

            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }

    //This function update the session 
    // so every vote after this update will have this sessionId
    public static void updateSessionId(String sessionId) {

        Action response = Dialogs.create()
                .title("JmaghrebVoting")
                .masthead("You have chosen " + sessionId + " as session id for next votes")
                .message("Please confirm your choice? Otherwise please cancel.")
                .actions(Dialog.Actions.OK, Dialog.Actions.CANCEL)
                .showConfirm();

        if (response == Dialog.Actions.OK) {
            showConfirmDialog();
            JmaghrebVoting.sessionId = sessionId;
            jMaghreb.setScreen(JmaghrebVoting.screen1ID);
            JmaghrebVoting.cardIn = false;
            System.out.println("SessionId updated: " + JmaghrebVoting.sessionId);

        } else {
            //nothing to do here
            System.out.println("not updated ");
        }

    }

    public static void showConfirmDialog() {
        Task<Object> worker = new Task<Object>() {
            @Override
            protected Object call() throws Exception {
                Thread.sleep(2000);
                return null;
            }
        };

        Dialogs.create().title("Please wait").showWorkerProgress(worker);

        Thread th = new Thread(worker);
        th.setDaemon(true);
        th.start();
    }

    private void onVote(String idVoter, String vote) {
        db.connect();
        if (db.voteNotExist(idVoter, sessionId)) {
            db.addVote(new Vote(sessionId, idVoter, vote, new Date(), "no"));
        }
        db.close();
        JmaghrebVoting.cardIn = false;
        jMaghreb.setScreen(JmaghrebVoting.screen4ID);
           Runnable switchScreenTask= () -> { 
            try {
                Thread.sleep(2000);
                  jMaghreb.setScreen(JmaghrebVoting.screen1ID);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
             
           };
           switchScreenTask.run();
           }
        
        
    }
