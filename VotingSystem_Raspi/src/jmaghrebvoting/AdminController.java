/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jmaghrebvoting;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author mohammed
 */
public class AdminController implements Initializable,ScreenController {

    ScreensController controller;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void setScreenParent(ScreensController screenPage) {
        controller = screenPage;
           }
  /*
    @FXML
    private void goToScreen1(ActionEvent event){
       controller.setScreen(JmaghrebVoting.screen1ID);
    }
    */
   // First Day: University Day 
    @FXML
    private void d01r01s01_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D01R01S01");
    
    }
     @FXML
    private void d01r01s02_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D01R01S02");
    }
    
     @FXML
    private void d01r01s03_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D01R01S03");
    }
    
     @FXML
    private void d01r01s04_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D01R01S04");
    }
    
     @FXML
    private void d01r01s05_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D01R01S05");
    }
     @FXML
    private void d01r01s06_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D01R01S06");
    }
     @FXML
    private void d01r02s01_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D01R02S01");
    }
     @FXML
    private void d01r02s02_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D01R02S02");
    }
     @FXML
    private void d01r02s03_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D01R02S03");
    }
     @FXML
    private void d01r02s04_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D01R02S04");
    }
     @FXML
    private void d01r03s01_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D01R03S01");
    }
     @FXML
    private void d01r03s02_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D01R03S02");
    }
    @FXML
    private void d01r03s03_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D01R03S03");
    }
     @FXML
    private void d01r03s04_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D01R03S04");
    }
   
             @FXML
    private void d01r03s05_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D01R03S05");
    }
    
       @FXML
    private void d01r03s06_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D01R03S06");
    }
    
    // Sesond Day: Conference day 1
       @FXML
    private void d02r01s01_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D02R01S01");
    }
     @FXML
    private void d02r01s02_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D02R01S02");
    }
    
     @FXML
    private void d02r01s03_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D02R01S03");
    }
    
     @FXML
    private void d02r01s04_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D02R01S04");
    }
    
     @FXML
    private void d02r02s01_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D02R02S01");
    }
     @FXML
    private void d02r02s02_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D02R02S02");
    }
     @FXML
    private void d02r02s03_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D02R02S03");
    }
     @FXML
    private void d02r02s04_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D02R02S04");
    }
     @FXML
    private void d02r03s01_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D02R03S01");
    }
     @FXML
    private void d02r03s02_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D02R03S02");
    }
    @FXML
    private void d02r03s03_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D02R03S03");
    }
     @FXML
    private void d02r03s04_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D02R03S04");
    }
   
             @FXML
    private void d02r03s05_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D02R03S05");
    }
    
    // Third Day: Conference day 2
    
       @FXML
    private void d03r01s01_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D03R01S01");
    }
     @FXML
    private void d03r01s02_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D03R01S02");
    }
    
     @FXML
    private void d03r01s03_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D03R01S03");
    }
    
     @FXML
    private void d03r01s04_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D03R01S04");
    }
    
     @FXML
    private void d03r01s05_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D03R01S05");
    }
     @FXML
    private void d03r01s06_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D03R01S06");
    }
     @FXML
    private void d03r02s01_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D03R02S01");
    }
     @FXML
    private void d03r02s02_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D03R02S02");
    }
     @FXML
    private void d03r02s03_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D03R02S03");
    }
     @FXML
    private void d03r02s04_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D03R02S04");
    }
     @FXML
    private void d03r03s01_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D03R03S01");
    }
     @FXML
    private void d03r03s02_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D03R03S02");
    }
    @FXML
    private void d03r03s03_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D03R03S03");
    }
     @FXML
    private void d03r03s04_click(ActionEvent event){
       JmaghrebVoting.updateSessionId("D03R03S04");
    }
   
    
    
    
    
    
}
