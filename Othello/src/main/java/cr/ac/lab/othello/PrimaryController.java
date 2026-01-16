/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alenc
 */
    package cr.ac.lab.othello;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {



    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
    

