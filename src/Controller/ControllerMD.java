/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.MainDashboard;
import Model.BusinessLogic;

/**
 *
 * @author Mario
 */
public class ControllerMD {

    public ControllerMD() {
    }

    public void starMD() {
        MainDashboard md = new MainDashboard();
        BusinessLogic bl = new BusinessLogic();
        ManagerMD managerMD = new ManagerMD(md, bl);
    }

}
