/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.MainDashboard;
import Model.BusinessLogic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Mario
 */
public class ManagerMD implements MouseListener {

    MainDashboard md;
    BusinessLogic bl;

    public ManagerMD(MainDashboard md, BusinessLogic bl) {
        this.md = md;
        this.bl = bl;
        this.md.btn_agregar.addMouseListener(this);
        this.md.btn_citas.addMouseListener(this);
        this.md.btn_modif.addMouseListener(this);
        this.md.btn_psico.addMouseListener(this);
        this.md.btn_just.addMouseListener(this);
        this.md.btn_report.addMouseListener(this);
        this.md.btn_agr.addMouseListener(this);
    }

    public void mousePressed(MouseEvent me) {
        if (md.btn_agregar == me.getSource()) {
            md.BtnAregarSolic();
        }
        if (md.btn_citas == me.getSource()) {
            md.Btn_Cita();
        }
        if (md.btn_modif == me.getSource()) {
            md.BtnExpedientes();
        }
        if (md.btn_psico == me.getSource()) {
            md.BtnPsicologos();
        }
        if (md.btn_just == me.getSource()) {
            md.BtnJustificacion();
        }
        if (md.btn_report == me.getSource()) {
            md.BtnReportes();
        }
        if(md.btn_agr==me.getSource()){
            agregarSolicitanteNiño();
    }

    }
    public void agregarSolicitanteNiño(){
        if(md.nid_txt.getText().compareTo("")==0|| md.nnombre_txt.getText().compareTo("")==0|| md.napellido_txt.getText().compareTo("")==0|| md.nedad_txt.getText().compareTo("")==0||  md.ntelefono_txt.getText().compareTo("")==0||  md.nocupacion_txt.getText().compareTo("")==0|| md.ndireccion_txt.getText().compareTo("")==0|| md.nmotivo_txt.getText().compareTo("")==0||md.nhorario_txt.getText().compareTo("")==0|| md.nsolicitante_txt.getText().compareTo("")==0){
        JOptionPane.showMessageDialog(null,"FAlta gente men");
        return;
        }
//    this.bl.AgregarSolicitud(md.nid_txt.getText(),md.nnombre_txt.getText(),1,1,md.napellido_txt.getText(),Integer.parseInt(md.nedad_txt.getText()), Integer.parseInt(md.ntelefono_txt.getText()), md.nocupacion_txt.getText(),md.ndireccion_txt.getText(),md.nmotivo_txt.getText(), md.nreferencia_txt.getText(), md.nhorario_txt.getText(),md.nemail_txt.getText(),md.ndetalle_txt.getText(), md.nsolicitante_txt.getText());
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

}
