/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoclinica;

import Controller.InitController;
import Model.BusinessLogic;
import Model.SQL;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import iComponents.iSQL;
import javax.swing.JOptionPane;

/**
 *
 * @author Mario
 */
public class ProyectoClinica extends JPanel {
//
//    JProgressBar pbar;
//  static iSQL sQL;
//
//    static final int MY_MINIMUM = 0;
//
//    static final int MY_MAXIMUM = 100;
//
//   
//    public ProyectoClinica() {
//        // initialize Progress Bar
//       
//        pbar = new JProgressBar();
//        pbar.setMinimum(MY_MINIMUM);
//        pbar.setMaximum(MY_MAXIMUM);
//        // add to JPanel
//        add(pbar);
//        
//    }
//
//    public void updateBar(int newValue) {
//        pbar.setValue(newValue);
//    }
//
//    /**
//     * @param args the command line arguments
//     */
    public static void main(String[] args) {
// 
//
//     
//while(sQL==null){    
//
//     final ProyectoClinica it = new ProyectoClinica();
//     sQL = new iSQL();      
//        JFrame frame = new JFrame("Progress Bar Example");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setContentPane(it);
//        frame.pack();
//        frame.setVisible(true);
//        // run a loop to demonstrate raising
//        for (int i = MY_MINIMUM; i <= MY_MAXIMUM; i++) {
//            final int percent = i;
//            try {
//                SwingUtilities.invokeLater(new Runnable() {
//                    public void run() {
//                        it.updateBar(percent);
//                    }
//                });
//                java.lang.Thread.sleep(100);
//            } catch (InterruptedException e) {
//                ;
//            }
//        }
//
//        JOptionPane.showMessageDialog(null,"su base de datos esta"+ sQL.toString());
           InitController ic = new InitController();
        ic.Starprogram();
    }

}
