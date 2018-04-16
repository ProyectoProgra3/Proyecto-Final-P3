/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.MainDashboard;
import Model.BusinessLogic;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        //busqueda
        this.md.btn_busqueda_rapida.addMouseListener(this);
        this.md.btn_busqueda.addMouseListener(this);
        this.md.busqueda_citasdia.addMouseListener(this);
        this.md.busqueda_sincitas.addMouseListener(this);

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
        this.md.btn_buscar_cita.addMouseListener(this);
        md.btn_guardar_modificar_cita.addMouseListener(this);
        //this.md.btn_type.addMouseListener(this);
//        this.md.btn_ced.addMouseListener(this);

        //agregar psciologo
        this.md.btn_psico.addMouseListener(this);
        this.md.btn_eliTodos.addMouseListener(this);

        this.md.btn_agrePsico.addMouseListener(this);
        this.md.btn_agregar_psicologo.addMouseListener(this);
        this.md.btn_mosPsico.addMouseListener(this);
        //cursos
        this.md.btn_curso.addMouseListener(this);
        this.md.btn_mosCurso.addMouseListener(this);
        this.md.btn_agrcurso.addMouseListener(this);
        this.md.btn_agregar_curso.addMouseListener(this);
        this.md.btn_curso_eliminar.addMouseListener(this);
        this.md.btn_mosCurso.addMouseListener(this);

        this.md.btn_eliminar.addMouseListener(this);
        //justificacion
        this.md.btn_just.addMouseListener(this);

        //reportes
        this.md.btn_report.addMouseListener(this);
        this.md.btn_report_mensual.addMouseListener(this);
        this.md.btn_justi.addMouseListener(this);

    }

    public void mousePressed(MouseEvent me) {
        //buscar
        if (md.btn_busqueda_rapida == me.getSource()) {
            md.BtnBusquedaRapida();
        }
        if (md.btn_busqueda == me.getSource()) {

        }
        if (md.busqueda_sincitas == me.getSource()) {
            md.TABLA(this.bl.addAllPersonassincita(), this.bl.addAllPersonasObjectsincita());
        }
        if (md.busqueda_citasdia == me.getSource()) {
            md.TABLA(this.bl.addAllPersonascitadia(), this.bl.addAllPersonasObjectcitadia());
        }

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
            llenar1Modificar();
            llenarCbModificar();
            md.BtnModificarPersona();
        }
        if (md.btn_buscar_modificar_persona == me.getSource()) {

            md.Modificar_persona_buscar();
            llenarModificar();
        }
        if (md.btn_guardar_modificar_persona == me.getSource()) {
            modificar();
        }

        //citas
        if (md.btn_citas == me.getSource()) {
            md.Btn_Cita();

        }
        if (this.md.btn_buscar_cita == me.getSource()) {
            LLenarCboxcita();
            md.modificar_citas();
            llenarCita();
        }
        if (md.btn_guardar_modificar_cita == me.getSource()) {
            modificarcitas();
        }

        //piscologo
        if (md.btn_psico == me.getSource()) {
            md.BtnPsicologos();
              md.Mostrar_Psicologos();
        }
        if (md.btn_mosPsico == me.getSource()) {
            md.Mostrar_Psicologos();
        }
        if (md.btn_eliTodos == me.getSource()) {
//eliminartodos();ya esta no tocar !!!!
        }

        if (md.btn_agrePsico == me.getSource()) {
            md.Agregar_Psicologo();
        }
        if (md.btn_agregar_psicologo == me.getSource()) {
            agregarPsicologo();
        }
        if (md.btn_eliTodos == me.getSource()) {

        }
        //curso
        if (md.btn_curso == me.getSource()) {
            md.BtnCurso();
            md.Mostrar_Cursos();
            
        }
        if (md.btn_mosCurso == me.getSource()) {
            md.Mostrar_Cursos();
        }
        if (md.btn_agrcurso == me.getSource()) {
            md.Agregar_Curso();
        }
        if (md.btn_agregar_curso == me.getSource()) {
            agregarCurso();
        }
        if (md.btn_eliminar == me.getSource()) {
            md.Eliminar_Curso();
        }
        if (md.btn_curso_eliminar == me.getSource()) {
            eliminarCurso();
        }

        //justificacion        
        if (md.btn_just == me.getSource()) {
            md.BtnJustificacion();
        }
        if (md.btn_justi == me.getSource()) {
            try {
                md.Generar_Justificaccion();
            } catch (IOException e) {

            }
        }
        //reporte
        if (md.btn_report == me.getSource()) {
            md.BtnReportes();
        }
        if (md.btn_report_mensual == me.getSource()) {
            try {
                GenerarReporte();
            } catch (IOException ex) {
                Logger.getLogger(ManagerMD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void agregarSolicitanteNiño() {
        if (md.nid_txt.getText().compareTo("") == 0
                || md.nnombre_txt.getText().compareTo("") == 0
                || md.napellido_txt.getText().compareTo("") == 0
                || md.nedad_txt.getText().compareTo("") == 0
                || md.nreferencia_txt.getText().compareTo("") == 0
                || md.nocupacion_txt.getText().compareTo("") == 0
                || md.ntelefono_txt.getText().compareTo("") == 0
                || md.nemail_txt.getText().compareTo("") == 0
                || md.nocupacion_txt.getText().compareTo("") == 0
                || md.ndireccion_txt.getText().compareTo("") == 0
                || md.nmotivo_txt.getText().compareTo("") == 0
                || md.nhorario_txt.getText().compareTo("") == 0
                || md.nsolicitante_txt.getText().compareTo("") == 0) {
            JOptionPane.showMessageDialog(null, "Te faltan campos por llenar");
            return;
        }
        if (this.bl.AgregarSolicitudNiño(md.nid_txt.getText(), md.tipo_cbm.getSelectedItem().toString(), md.nnombre_txt.getText(), md.napellido_txt.getText(), Integer.parseInt(md.nedad_txt.getText()), Integer.parseInt(md.ntelefono_txt.getText()), md.nocupacion_txt.getText(), md.nmotivo_txt.getText(), md.nreferencia_txt.getText(), md.nhorario_txt.getText(), md.nemail_txt.getText(), md.ndetalle_txt.getText(), md.nsolicitante_txt.getText(), md.ndireccion_txt.getText())) {
            md.LimpiarCasillas();
        };
    }

    public void agregarSolicitudAdolescente() {
        if (md.adolescente_id_txt.getText().compareTo("") == 0
                || md.adolescente_nombre_txt.getText().compareTo("") == 0
                || md.adolescente_apellido_txt.getText().compareTo("") == 0
                || md.adolescente_edad_txt.getText().compareTo("") == 0
                || md.adolescente_referencia_txt.getText().compareTo("") == 0
                || md.adolescente_ocupacion_txt.getText().compareTo("") == 0
                || md.adolescente_telefono_txt.getText().compareTo("") == 0
                || md.adolescente_email_txt.getText().compareTo("") == 0
                || md.adolescente_ocupacion_txt.getText().compareTo("") == 0
                || md.adolescente_direccion_txt.getText().compareTo("") == 0
                || md.adolescente_motivo_txt.getText().compareTo("") == 0
                || md.adolescente_horario_txt.getText().compareTo("") == 0
                || md.adolescente_solicitante_txt.getText().compareTo("") == 0) {
            JOptionPane.showMessageDialog(null, "Te faltan campos");
            return;
        }
        if (this.bl.AgregarSolicitudAdoslecente(md.adolescente_id_txt.getText(), md.tipo_cbm.getSelectedItem().toString(), md.adolescente_nombre_txt.getText(), md.adolescente_apellido_txt.getText(), Integer.parseInt(md.adolescente_telefono_txt.getText()), Integer.parseInt(md.adolescente_edad_txt.getText()), md.adolescente_ocupacion_txt.getText(), md.adolescente_motivo_txt.getText(), md.adolescente_referencia_txt.getText(), md.adolescente_horario_txt.getText(), md.adolescente_email_txt.getText(), md.adolescente_detalle_txt.getText(),
                md.adolescente_solicitante_txt.getText(), md.adolescente_direccion_txt.getText())) {
            md.LimpiarCasillas();
        };
    }

    public void agregarSolicitudAdulto() {
        if (md.adulto_id_txt.getText().compareTo("") == 0
                || md.adulto_nombre_txt.getText().compareTo("") == 0
                || md.adulto_apellido_txt.getText().compareTo("") == 0
                || md.adulto_edad_txt.getText().compareTo("") == 0
                || md.adulto_referencia_txt.getText().compareTo("") == 0
                || md.adulto_ocupacion_txt.getText().compareTo("") == 0
                || md.adulto_telefono_txt.getText().compareTo("") == 0
                || md.adulto_email_txt.getText().compareTo("") == 0
                || md.adulto_ocupacion_txt.getText().compareTo("") == 0
                || md.adulto_direccion_txt.getText().compareTo("") == 0
                || md.adulto_motivo_txt.getText().compareTo("") == 0
                || md.adulto_horario_txt.getText().compareTo("") == 0
                || md.adulto_solicitante_txt.getText().compareTo("") == 0) {
            JOptionPane.showMessageDialog(null, "Te faltan campos");
            return;
        }
        if (this.bl.AgregarSolicitudAdoslecente(md.adulto_id_txt.getText(), md.tipo_cbm.getSelectedItem().toString(), md.adulto_nombre_txt.getText(), md.adulto_apellido_txt.getText(), Integer.parseInt(md.adulto_telefono_txt.getText()), Integer.parseInt(md.adulto_edad_txt.getText()), md.adulto_ocupacion_txt.getText(), md.adulto_motivo_txt.getText(), md.adulto_referencia_txt.getText(), md.adulto_horario_txt.getText(), md.adulto_email_txt.getText(), md.adulto_detalle_txt.getText(),
                md.adulto_solicitante_txt.getText(), md.adulto_direccion_txt.getText())) {
            md.LimpiarCasillas();
        };
    }

    public void agregarSolicitudPareja() {
        if (md.pareja_id_txt.getText().compareTo("") == 0
                || md.pareja_nombre_txt.getText().compareTo("") == 0
                || md.pareja_apellido_txt.getText().compareTo("") == 0
                || md.pareja_edad_txt.getText().compareTo("") == 0
                || md.pareja_referencia_txt.getText().compareTo("") == 0
                || md.pareja_ocupacion_txt.getText().compareTo("") == 0
                || md.pareja_telefono_txt.getText().compareTo("") == 0
                || md.pareja_email_txt.getText().compareTo("") == 0
                || md.pareja_ocupacion_txt.getText().compareTo("") == 0
                || md.pareja_direccion_txt.getText().compareTo("") == 0
                || md.pareja_motivo_txt.getText().compareTo("") == 0
                || md.pareja_horario_txt.getText().compareTo("") == 0
                || md.pareja_solicitante_txt.getText().compareTo("") == 0
                || md.pareja_detalle_txt.getText().compareTo("") == 0) {
            JOptionPane.showMessageDialog(null, "Te faltan campos");
            return;
        }
        if (this.bl.AgregarSolicitudAdoslecente(md.pareja_id_txt.getText(),
                md.tipo_cbm.getSelectedItem().toString(),
                md.pareja_nombre_txt.getText(),
                md.pareja_apellido_txt.getText(),
                Integer.parseInt(md.pareja_telefono_txt.getText()),
                Integer.parseInt(md.pareja_edad_txt.getText()),
                md.pareja_ocupacion_txt.getText(),
                md.pareja_motivo_txt.getText(),
                md.pareja_referencia_txt.getText(),
                md.pareja_horario_txt.getText(),
                md.pareja_email_txt.getText(),
                md.pareja_detalle_txt.getText(),
                md.pareja_solicitante_txt.getText(),
                md.pareja_direccion_txt.getText())) {
            md.LimpiarCasillas();
        };
    }

    public void agregarSolicitudFamilia() {
        if (md.familia_id_txt.getText().compareTo("") == 0
                || md.familia_nombre_txt.getText().compareTo("") == 0
                || md.familia_apellido_txt.getText().compareTo("") == 0
                || md.familia_edad_txt.getText().compareTo("") == 0
                || md.familia_referencia_txt.getText().compareTo("") == 0
                || md.familia_ocupacion_txt.getText().compareTo("") == 0
                || md.familia_telefono_txt.getText().compareTo("") == 0
                || md.familia_email_txt.getText().compareTo("") == 0
                || md.familia_ocupacion_txt.getText().compareTo("") == 0
                || md.familia_direccion_txt.getText().compareTo("") == 0
                || md.familia_motivo_txt.getText().compareTo("") == 0
                || md.familia_horario_txt.getText().compareTo("") == 0
                || md.familia_solicitante_txt.getText().compareTo("") == 0
                || md.familia_detalle_txt.getText().compareTo("") == 0) {
            JOptionPane.showMessageDialog(null, "Te faltan campos");
            return;
        }
        this.bl.AgregarSolicitudFamilia(md.familia_id_txt.getText(), md.tipo_cbm.getSelectedItem().toString(), md.familia_nombre_txt.getText(), md.familia_apellido_txt.getText(), Integer.parseInt(md.familia_telefono_txt.getText()), Integer.parseInt(md.familia_edad_txt.getText()), md.familia_ocupacion_txt.getText(), md.familia_motivo_txt.getText(), md.familia_referencia_txt.getText(), md.familia_horario_txt.getText(), md.familia_email_txt.getText(), md.familia_detalle_txt.getText(),
                md.familia_solicitante_txt.getText(), md.familia_direccion_txt.getText(), Integer.parseInt(this.md.familia_integrantes_txt.getText()));
        md.LimpiarCasillas();
    }

    public void llenarModificar() {
        if (this.md.modificar_persona_txt.getText().compareTo("") == 0) {
            JOptionPane.showMessageDialog(null, "La cedula esta vacia");
            return;
        }
        ResultSet rs = this.bl.SearchbyIdandTipo(this.md.modificar_persona_txt.getText(),
                md.modificar_persona_cbm.getSelectedItem().toString());
        try {

            while (rs.next()) {

                this.md.modificar_persona_id_txt.setText(rs.getObject("ID").toString());
                this.md.modificar_persona_nombre_txt.setText(rs.getObject("Persona.Nombre").toString());
                this.md.modificar_persona_apellido_txt.setText(rs.getObject("Persona.Apellido").toString());
                this.md.modificar_persona_edad_txt.setText(rs.getObject("Edad").toString());
                this.md.modificar_persona_telefono_txt.setText(rs.getObject("Telefono").toString());
                this.md.modificar_persona_ocupacion_txt.setText(rs.getObject("Ocupacion").toString());
                this.md.modificar_persona_motivo_txt.setText(rs.getObject("Motivo").toString());
                this.md.modificar_persona_referencia_txt.setText(rs.getObject("Referencia").toString());
                this.md.modificar_persona_horario_txt.setText(rs.getObject("Detalle_Horario").toString());
                this.md.modificar_persona_email_txt.setText(rs.getObject("Persona.Email").toString());
                this.md.modificar_persona_detalle_txt.setText(rs.getObject("Detalle").toString());
                this.md.modificar_persona_solicitante_txt.setText(rs.getObject("NombreSolicitante").toString());
                this.md.modificar_persona_direccion_txt.setText(rs.getObject("Dir").toString());
                this.md.modificar_persona_expediente_txt.setText(rs.getObject("Expediente").toString());
                this.md.modificar_persona_cita_txt.setText(rs.getObject("Cita").toString());
                this.md.modificar_persona_integrantes_txt.setText(rs.getObject("Integrantes").toString());
                this.md.Solicitud.setText(rs.getObject("Fecha_Solicitud").toString());
                this.md.modificar_persona_clase_cbm.setSelectedItem(rs.getObject("Estado.Estado").toString());
                this.md.modificar_persona_psicologo_cbm.setSelectedItem(rs.getObject("Psicologo.Nombre").toString());
                this.md.modificar_persona_curso_cbm.setSelectedItem(rs.getObject("Curso.Nombre").toString());
                this.md.modificar_persona_tipo_cbm.setSelectedItem(rs.getObject("Tipo_de_solicitud.Tipo de solicitud").toString());
            }
        } catch (Exception e) {
            System.out.println("error" + e);
        }

    }

    public void modificar() {
        if (md.modificar_persona_id_txt.getText().compareTo("") == 0
                || md.modificar_persona_nombre_txt.getText().compareTo("") == 0
                || md.modificar_persona_apellido_txt.getText().compareTo("") == 0
                || md.modificar_persona_edad_txt.getText().compareTo("") == 0
                || md.modificar_persona_telefono_txt.getText().compareTo("") == 0
                || md.modificar_persona_ocupacion_txt.getText().compareTo("") == 0
                || md.modificar_persona_motivo_txt.getText().compareTo("") == 0
                || md.modificar_persona_referencia_txt.getText().compareTo("") == 0
                || md.modificar_persona_horario_txt.getText().compareTo("") == 0
                || md.modificar_persona_detalle_txt.getText().compareTo("") == 0
                || md.modificar_persona_email_txt.getText().compareTo("") == 0
                || md.modificar_persona_solicitante_txt.getText().compareTo("") == 0
                || md.modificar_persona_direccion_txt.getText().compareTo("") == 0
                || md.modificar_persona_expediente_txt.getText().compareTo("") == 0
                || md.modificar_persona_cita_txt.getText().compareTo("") == 0
                || md.modificar_persona_integrantes_txt.getText().compareTo("") == 0) {
            JOptionPane.showMessageDialog(null, "Te faltan datos por llenar");
            return;
        }
        if (this.bl.modifyPersona(md.modificar_persona_id_txt.getText(),
                md.modificar_persona_clase_cbm.getSelectedItem().toString(),
                md.modificar_persona_tipo_cbm.getSelectedItem().toString(),
                md.modificar_persona_nombre_txt.getText(),
                md.modificar_persona_nombre_txt.getText(),
                Integer.parseInt(md.modificar_persona_edad_txt.getText()),
                Integer.parseInt(md.modificar_persona_telefono_txt.getText()),
                md.modificar_persona_ocupacion_txt.getText(),
                md.modificar_persona_motivo_txt.getText(),
                md.modificar_persona_referencia_txt.getText(),
                md.modificar_persona_horario_txt.getText(),
                md.modificar_persona_email_txt.getText(),
                md.modificar_persona_detalle_txt.getText(),
                md.modificar_persona_solicitante_txt.getText(),
                md.modificar_persona_curso_cbm.getSelectedItem().toString(),
                md.modificar_persona_psicologo_cbm.getSelectedItem().toString(),
                md.modificar_persona_cita_txt.getText(),
                md.modificar_persona_expediente_txt.getText(),
                md.modificar_persona_direccion_txt.getText(),
                Integer.parseInt(md.modificar_persona_integrantes_txt.getText()),
                md.modificar_persona_txt.getText(),
                md.modificar_persona_cbm.getSelectedItem().toString())) {         
        }
    }

    public void modificarcitas() {
        if (md.modificar_cita_cita_txt.getText().compareTo("") == 0) {
            JOptionPane.showMessageDialog(null, "Te faltan campos por llenar");
            return;
        }
      
        this.bl.modificarcitas(md.modificar_cita_curso_cbm.getSelectedItem().toString(), md.modificar_cita_psicologo_cbm.getSelectedItem().toString(), md.modificar_cita_cita_txt.getText().toString(), md.cita_txt.getText(), md.cita_cbm.getSelectedItem().toString());
    }

    public void agregarPsicologo() {
        if (bl.addPsicologo("hola", this.md.nombre_psicologo_txt.getText(), this.md.apellidos_psicologo_txt.getText(), this.md.carnet_psicologo_txt.getText(), Integer.parseInt(this.md.celular_psicologo_txt.getText()), this.md.email_psicologo_txt.getText())) {
            JOptionPane.showMessageDialog(null,"Se agrego el psicologo correctamente");
        } else {
            System.out.println("upps hubo un problema");
        };

    }

    public void eliminartodos() {
        bl.DeletePsicologos();
    }

    public void agregarCurso() {
        bl.addCurso(this.md.siglas_curso_txt.getText(), this.md.nombre_curso_txt.getText());
    }

    public void llenarCbModificar() {
        ArrayList a = this.bl.SearchTipo();
        for (int i = 0; i < a.size(); i++) {
            this.md.modificar_persona_tipo_cbm.addItem(a.get(i));
        }
        ArrayList b = this.bl.SearchCursos();
        for (int i = 0; i < b.size(); i++) {
            this.md.modificar_persona_curso_cbm.addItem(b.get(i));
        }
        ArrayList c = this.bl.SearchPsicologos();
        for (int i = 0; i < c.size(); i++) {
            this.md.modificar_persona_psicologo_cbm.addItem(c.get(i));
        }
        ArrayList d = this.bl.SearchEstados();
        for (int i = 0; i < d.size(); i++) {
            this.md.modificar_persona_clase_cbm.addItem(d.get(i));
        }
    }

    public void LLenarCboxcita() {
        ArrayList b = this.bl.SearchCursos();
        for (int i = 0; i < b.size(); i++) {
            this.md.modificar_cita_curso_cbm.addItem(b.get(i));
        }
        ArrayList c = this.bl.SearchPsicologos();
        for (int i = 0; i < c.size(); i++) {
            this.md.modificar_cita_psicologo_cbm.addItem(c.get(i));
        }
    }

    public void llenar1Modificar() {
        ArrayList n = this.bl.SearchTipo();
        for (int i = 0; i < n.size(); i++) {
            this.md.modificar_persona_cbm.addItem(n.get(i));
        }

    }

    public void eliminarCurso() {
        this.bl.deleteCurso(this.md.curso_eliminar_txt.getText());
    }

    public void GenerarReporte() throws IOException {
        if (this.bl.GenerarExcel()) {
            JOptionPane.showMessageDialog(null, "Su Reporte se genero ");
        } else {
            JOptionPane.showMessageDialog(null, "Upsss hubo un error ");
        }
    }

    public void llenarCita() {
        ResultSet rs = this.bl.SearchbyIdandEstadoCitas(this.md.cita_txt.getText(), this.md.cita_cbm.getSelectedItem().toString());
        if (rs != null) {
            try {
                while (rs.next()) {
                    this.md.modificar_cita_id_txt.setText(rs.getObject("ID").toString());
                    this.md.modificar_cita_nombre_txt.setText(rs.getObject("Persona.Nombre").toString());
                    this.md.modificar_cita_apellido_txt.setText(rs.getObject("Persona.Apellido").toString());
                    this.md.modificar_cita_horario_txt.setText(rs.getObject("Detalle_Horario").toString());
                    this.md.modificar_cita_expediente_txt.setText(rs.getObject("Expediente").toString());
                    this.md.modificar_cita_cita_txt.setText(rs.getObject("Cita").toString());
                    this.md.Solicitud.setText(rs.getObject("Persona.Fecha_Solicitud").toString());
                    this.md.modificar_cita_psicologo_cbm.setSelectedItem(rs.getObject("Psicologo.Nombre").toString());
                    this.md.modificar_cita_curso_cbm.setSelectedItem(rs.getObject("Curso.Nombre").toString());
                }
            } catch (Exception e) {
            }

        }
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
