/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.InitModel;
import View.Login;

/**
 *
 * @author Mario
 */
public class InitController {
    public InitController(){}
    public void Starprogram(){
        InitModel im= new InitModel();
        Login l= new Login();
        InitManager initManager= new InitManager(im, l);
    }
    
}
