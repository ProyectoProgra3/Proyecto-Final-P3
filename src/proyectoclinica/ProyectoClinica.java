/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoclinica;

import Controller.InitController;
import Model.BusinessLogic;
import java.sql.ResultSet;

/**
 *
 * @author Mario
 */
public class ProyectoClinica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        InitController ic = new InitController();
//        ic.Starprogram();
        BusinessLogic bl = new BusinessLogic();
bl.AgregarSolicitudNiño("6","En Espera","Maro","ro",90,120, "Me","ma","asd","Sabado", "@","Solo","Sha", "sabanilla");
//        try {
//        ResultSet rs=bl.DeletePsicologos();
//            while (rs.next()) {
//                System.out.println(rs.getObject("Estado"));                
//                
//            }
//        } catch (Exception e) {
//        }

    }

}
