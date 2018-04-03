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
        //agregar solicitud
        this.md.btn_agregar.addMouseListener(this);
        //nino
        this.md.btn_niño.addMouseListener(this);
        this.md.btn_agregar_niño.addMouseListener(this);
        //adolescentes
        this.md.btn_adol.addMouseListener(this);
        this.md.btn_agregar_adolescente.addMouseListener(this);
        //adulto
        this.md.btn_adulto.addMouseListener(this);
        this.md.btn_agregar_adulto.addMouseListener(this);
        //pareja
        this.md.btn_pareja.addMouseListener(this);
        this.md.btn_agregar_pareja.addMouseListener(this);
        //familia
        this.md.btn_fam.addMouseListener(this);
        this.md.btn_agregar_familia.addMouseListener(this);
        //modificar paciente
        this.md.btn_modif.addMouseListener(this);
        this.md.btn_buscar_modificar_persona.addMouseListener(this);
        this.md.btn_guardar_modificar_persona.addMouseListener(this);

        //agregar citas
        this.md.btn_citas.addMouseListener(this);
        this.md.btn_type.addMouseListener(this);
        this.md.btn_ced.addMouseListener(this);

        //agregar psciologo
        this.md.btn_psico.addMouseListener(this);
        this.md.btn_eliTodos.addMouseListener(this);
        this.md.btn_eliPsico.addMouseListener(this);
        this.md.btn_agrePsico.addMouseListener(this);
        this.md.btn_mosPsico.addMouseListener(this);
        //cursos
        this.md.btn_curso.addMouseListener(this);
        this.md.btn_mosCurso.addMouseListener(this);
        this.md.btn_agrcurso.addMouseListener(this);
        this.md.btn_eliminar.addMouseListener(this);
        //justificacion
        this.md.btn_just.addMouseListener(this);

        //reportes
        this.md.btn_report.addMouseListener(this);

    }

    public void mousePressed(MouseEvent me) {
        //agregar
        if (md.btn_agregar == me.getSource()) {
            md.BtnAregarSolic();
        }
        //nino
        if (md.btn_niño == me.getSource()) {
            md.Agregar_solicitud_niño();
        }
        if (md.btn_agregar_niño == me.getSource()) {
            agregarSolicitanteNiño();
        }
        //adolescente
        if (md.btn_adol == me.getSource()) {
            md.Agregar_solicitud_adolescente();
        }
        if (md.btn_agregar_adolescente == me.getSource()) {
            agregarSolicitudAdolescente();
        }
        //adulto
        if (md.btn_adulto == me.getSource()) {
            md.Agregar_solicitud_adulto();
        }
        if (md.btn_agregar_adulto == me.getSource()) {
            agregarSolicitudAdulto();
        }
        //pareja
        if (md.btn_pareja == me.getSource()) {
            md.Agregar_solicitud_pareja();
        }
        if (md.btn_agregar_pareja == me.getSource()) {
            agregarSolicitudPareja();
        }
        //familia
        if (md.btn_fam == me.getSource()) {
            md.Agregar_solicitud_familia();
        }
        if (md.btn_agregar_familia == me.getSource()) {
            agregarSolicitudFamilia();
        }
        //modificar
        if (md.btn_modif == me.getSource()) {
            md.BtnModificarPersona();
        }
        if (md.btn_buscar_modificar_persona == me.getSource()) {
            md.Modificar_persona_buscar();
        }
          if (md.btn_guardar_modificar_persona == me.getSource()) {
  
        }
        
        //citas
        if (md.btn_citas == me.getSource()) {
            md.Btn_Cita();
        }
        if (md.btn_type == me.getSource()) {

        }
        if (md.btn_ced == me.getSource()) {

        }
        //piscologo
        if (md.btn_psico == me.getSource()) {
            md.BtnPsicologos();
        }
        if (md.btn_eliTodos == me.getSource()) {

        }
        if (md.btn_eliPsico == me.getSource()) {
            md.Eliminar_Psicologo();
        }
        if (md.btn_agrePsico == me.getSource()) {
            md.Agregar_Psicologo();
        }
        if (md.btn_eliTodos == me.getSource()) {

        }
        //curso
        if (md.btn_curso == me.getSource()) {
            md.BtnCurso();
        }
        if (md.btn_mosCurso == me.getSource()) {

        }
        if (md.btn_agrcurso == me.getSource()) {
            md.Agregar_Curso();
        }
        if (md.btn_eliminar == me.getSource()) {
            md.Eliminar_Curso();
        }

        //justificacion        
        if (md.btn_just == me.getSource()) {
            md.BtnJustificacion();
        }
        //reporte
        if (md.btn_report == me.getSource()) {
            md.BtnReportes();
        }

    }

    public void agregarSolicitanteNiño() {
        if (md.nid_txt.getText().compareTo("") == 0 || md.nnombre_txt.getText().compareTo("") == 0 || md.napellido_txt.getText().compareTo("") == 0 || md.nedad_txt.getText().compareTo("") == 0 || md.ntelefono_txt.getText().compareTo("") == 0 || md.nocupacion_txt.getText().compareTo("") == 0 || md.ndireccion_txt.getText().compareTo("") == 0 || md.nmotivo_txt.getText().compareTo("") == 0 || md.nhorario_txt.getText().compareTo("") == 0 || md.nsolicitante_txt.getText().compareTo("") == 0) {
            JOptionPane.showMessageDialog(null, "Falta gente ");
            return;
        }
        this.bl.AgregarSolicitudNiño(md.nid_txt.getText(), md.ntipo_cbm.getSelectedItem().toString(), md.nnombre_txt.getText(), md.napellido_txt.getText(), Integer.parseInt(md.nedad_txt.getText()), Integer.parseInt(md.ntelefono_txt.getText()), md.nocupacion_txt.getText(), md.nmotivo_txt.getText(), md.nreferencia_txt.getText(), md.nhorario_txt.getText(), md.nemail_txt.getText(), md.ndetalle_txt.getText(), md.nsolicitante_txt.getText(), md.ndireccion_txt.getText());
    }

    public void agregarSolicitudAdolescente() {
        if (md.adolescente_id_txt.getText().compareTo("") == 0 || md.adolescente_apellido_txt.getText().compareTo("") == 0 || md.adolescente_edad_txt.getText().compareTo("") == 0 || md.adolescente_nombre_txt.getText().compareTo("") == 0 || md.adolescente_horario_txt.getText().compareTo("") == 0 || md.adolescente_motivo_txt.getText().compareTo("") == 0 || md.adolescente_telefono_txt.getText().compareTo("") == 0 || md.adolescente_ocupacion_txt.getText().compareTo("") == 0) {
            JOptionPane.showMessageDialog(null, "Falta gente ");
            return;
        }
        this.bl.AgregarSolicitudAdoslecente(md.adolescente_id_txt.getText(), md.adolescente_tipo_cbm.getSelectedItem().toString(), md.adolescente_nombre_txt.getText(), md.adolescente_apellido_txt.getText(), Integer.parseInt(md.adolescente_telefono_txt.getText()), Integer.parseInt(md.adolescente_edad_txt.getText()), md.adolescente_ocupacion_txt.getText(), md.adolescente_motivo_txt.getText(), md.adolescente_referencia_txt.getText(), md.adolescente_horario_txt.getText(), md.adolescente_email_txt.getText(), md.adolescente_detalle_txt.getText(),
                md.adolescente_solicitante_txt.getText(), md.adolescente_direccion_txt.getText());
    }

    public void agregarSolicitudAdulto() {
        if (md.adulto_id_txt.getText().compareTo("") == 0 || md.adulto_apellido_txt.getText().compareTo("") == 0 || md.adulto_edad_txt.getText().compareTo("") == 0 || md.adulto_nombre_txt.getText().compareTo("") == 0 || md.adulto_horario_txt.getText().compareTo("") == 0 || md.adulto_motivo_txt.getText().compareTo("") == 0 || md.adulto_telefono_txt.getText().compareTo("") == 0 || md.adulto_ocupacion_txt.getText().compareTo("") == 0) {
            JOptionPane.showMessageDialog(null, "Falta gente ");
            return;
        }
        this.bl.AgregarSolicitudAdoslecente(md.adulto_id_txt.getText(), md.adulto_tipo_cbm.getSelectedItem().toString(), md.adulto_nombre_txt.getText(), md.adulto_apellido_txt.getText(), Integer.parseInt(md.adulto_telefono_txt.getText()), Integer.parseInt(md.adulto_edad_txt.getText()), md.adulto_ocupacion_txt.getText(), md.adulto_motivo_txt.getText(), md.adulto_referencia_txt.getText(), md.adulto_horario_txt.getText(), md.adulto_email_txt.getText(), md.adulto_detalle_txt.getText(),
                md.adulto_solicitante_txt.getText(), md.adulto_direccion_txt.getText());
    }

    public void agregarSolicitudPareja() {
        if (md.pareja_id_txt.getText().compareTo("") == 0 || md.pareja_apellido_txt.getText().compareTo("") == 0 || md.pareja_edad_txt.getText().compareTo("") == 0 || md.adulto_nombre_txt.getText().compareTo("") == 0 || md.pareja_horario_txt.getText().compareTo("") == 0 || md.pareja_motivo_txt.getText().compareTo("") == 0 || md.pareja_telefono_txt.getText().compareTo("") == 0 || md.adulto_ocupacion_txt.getText().compareTo("") == 0) {
            JOptionPane.showMessageDialog(null, "Falta gente ");
            return;
        }
        this.bl.AgregarSolicitudAdoslecente(md.adulto_id_txt.getText(), md.adulto_tipo_cbm.getSelectedItem().toString(), md.pareja_nombre_txt.getText(), md.pareja_apellido_txt.getText(), Integer.parseInt(md.pareja_telefono_txt.getText()), Integer.parseInt(md.pareja_edad_txt.getText()), md.pareja_ocupacion_txt.getText(), md.pareja_motivo_txt.getText(), md.pareja_referencia_txt.getText(), md.pareja_horario_txt.getText(), md.pareja_email_txt.getText(), md.pareja_detalle_txt.getText(),
                md.pareja_solicitante_txt.getText(), md.pareja_direccion_txt.getText());
    }

    public void agregarSolicitudFamilia() {
        if (md.familia_id_txt.getText().compareTo("") == 0 || md.familia_apellido_txt.getText().compareTo("") == 0 || md.familia_edad_txt.getText().compareTo("") == 0 || md.familia_nombre_txt.getText().compareTo("") == 0 || md.familia_horario_txt.getText().compareTo("") == 0 || md.familia_motivo_txt.getText().compareTo("") == 0 || md.pareja_telefono_txt.getText().compareTo("") == 0 || md.adulto_ocupacion_txt.getText().compareTo("") == 0) {
            JOptionPane.showMessageDialog(null, "Falta gente ");
            return;
        }
        this.bl.AgregarSolicitudAdoslecente(md.familia_id_txt.getText(), md.familia_tipo_cbm.getSelectedItem().toString(), md.familia_nombre_txt.getText(), md.familia_apellido_txt.getText(), Integer.parseInt(md.familia_telefono_txt.getText()), Integer.parseInt(md.familia_edad_txt.getText()), md.familia_ocupacion_txt.getText(), md.familia_motivo_txt.getText(), md.familia_referencia_txt.getText(), md.familia_horario_txt.getText(), md.familia_email_txt.getText(), md.familia_detalle_txt.getText(),
                md.familia_solicitante_txt.getText(), md.familia_direccion_txt.getText());
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
