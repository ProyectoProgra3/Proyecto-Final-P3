/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.InitModel;
import View.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Mario
 */
public class InitManager implements ActionListener {

    InitModel initModel;
    Login login;

    public InitManager(InitModel initModel, Login login) {
        this.initModel = initModel;
        this.login = login;
        this.login.btn_ingresar.addActionListener(this);
        this.login.pass_txt.addActionListener(this);
    }

    public void actionPerformed(ActionEvent evento) {
        if (login.btn_ingresar == evento.getSource() || login.pass_txt == evento.getSource()) {
            mangaerLogin();
        }

    }

    public void mangaerLogin() {
        if (initModel.Login(login.usr_txt.getText(), login.pass_txt.getText())) {
            login.frm.dispose();
            login.frm.setVisible(false);
            ControllerMD cmd = new ControllerMD();
            cmd.starMD();
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta");

        }

    }

}
