/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jmaghrebvoting;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author mohammed
 */
public class AfterVoteController implements Initializable,ScreenController {
 ScreensController controller;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
      @Override
    public void setScreenParent(ScreensController screenPage) {
        controller = screenPage;
           }
}
