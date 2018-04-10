/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
//icompone_mario
//        Mario2018

import iComponents.iButton;
import iComponents.iClock;
import iComponents.iFrame;
import iComponents.iPanel;
import iComponents.iPasswordField;
import iComponents.iTextField;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.SwingConstants.CENTER;
import static javax.swing.SwingConstants.LEFT;
import static javax.swing.SwingConstants.RIGHT;

/**
 *
 * @author crodas
 */
public class Login {

    //600, 400, 5, 5, 5
    public iPanel panel;
    public JLabel tri_lbl = new JLabel();
    public JLabel usr_lbl = new JLabel();
    public JLabel pass_lbl = new JLabel();
    public iTextField usr_txt = new iTextField("Digite usuario", 6);
    public iPasswordField pass_txt = new iPasswordField("Digite contraseña", 6);
    public iButton btn_ingresar = new iButton("ACCESAR", 6, new Color(106, 203, 214), Color.WHITE);
    public iFrame frm;

    public Login() {
        frm = new iFrame(43.0f, 55.0f, 5, 2, "", JFrame.EXIT_ON_CLOSE);
        panel = new iPanel(0, 0, 600, 600, 5, 5, frm);
        panel.setResponsiveHeight(100.0f, 0);
        panel.setResponsiveWidth(100.0f, 0);
        frm.setHeaderBackground(new Color(255, 255, 255));
        initcomponets();
    }

    public void initcomponets() {
        // TODO code application logic here

        ImageIcon logo = new ImageIcon(System.getProperty("user.dir") + ("//src//Img//ul.png"));
        JLabel logo_label = new JLabel(logo);

        ImageIcon logo2 = new ImageIcon(System.getProperty("user.dir") + ("//src//Img//psi.jpeg"));
        JLabel logo_label2 = new JLabel(logo2);

        //Panel       
        panel.setBounds(0, 0, 600, 400);
        panel.setBackground(new Color(255, 255, 255));

        //Campo Usuario       
        usr_lbl.setText("Usuario");
        usr_lbl.setForeground(new Color(156, 156, 156));
   
        //Campo Password    
        pass_lbl.setText("Contraseña");
        pass_lbl.setForeground(new Color(156, 156, 156));

        //clock
        iClock clock = new iClock(80, 100, 100, 100);
        clock.setForeground(new Color(156, 156, 156));
        //clock.setBounds(30, 290, 80, 100);

        panel.AddObject(logo_label, 275, 125, LEFT);
        panel.AddObject(logo_label2, 275, 125, LEFT);
        panel.newLine();

        panel.AddObject(usr_lbl, 140, 30, CENTER);
        panel.newLine();
        panel.AddObject(usr_txt, 140, 25, CENTER);
        panel.newLine();

        panel.AddObject(pass_lbl, 140, 30, CENTER);
        panel.newLine();
        panel.AddObject(pass_txt, 140, 25, CENTER);
        panel.newLine();

        panel.AddObject(btn_ingresar, 140, 30, CENTER);
        panel.newLine();

        panel.AddObject(clock, 80, 100, CENTER);
        panel.newLine();

        frm.add(panel);
        frm.finalice();
    }

}
