/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.SQL;
import static iComponents.ComponentInterfaz.LEFT;
import iComponents.iButton;
import iComponents.iButtonFake;
import iComponents.iClock;
import iComponents.iComboCheckBox;
import iComponents.iFrame;
import iComponents.iPanel;
import iComponents.iTable;
import iComponents.iTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import javafx.geometry.Pos;
import static javafx.geometry.Pos.BOTTOM_CENTER;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.SwingConstants.BOTTOM;
import static javax.swing.SwingConstants.CENTER;
import static javax.swing.SwingConstants.RIGHT;
import static javax.swing.SwingConstants.TOP;
import javax.swing.SwingUtilities;
import jiconfont.icons.GoogleMaterialDesignIcons;

/**
 *
 * @author crodas
 */
public class MainDashboard {

    private final SQL sql;

    public iFrame dash_frm;
    public iPanel info_panel;
    public iPanel menu_panel;
    public iPanel search_panel;
    public iButtonFake btn_agregar = new iButtonFake("Agregar Solicitud", "", new Color(247, 247, 247), new Color(106, 203, 214), new Color(247, 247, 247).darker(), new Color(106, 203, 214), GoogleMaterialDesignIcons.ADD_CIRCLE_OUTLINE);
    public iButtonFake btn_modif = new iButtonFake("Modificar persona", "", new Color(247, 247, 247), new Color(106, 203, 214), new Color(247, 247, 247).darker(), new Color(106, 203, 214), GoogleMaterialDesignIcons.PERSON);
    public iButtonFake btn_citas = new iButtonFake("Citas", "", new Color(247, 247, 247), new Color(106, 203, 214), new Color(247, 247, 247).darker(), new Color(106, 203, 214), GoogleMaterialDesignIcons.DATE_RANGE);
    public iButtonFake btn_psico = new iButtonFake("Psicólogos", "", new Color(247, 247, 247), new Color(106, 203, 214), new Color(247, 247, 247).darker(), new Color(106, 203, 214), GoogleMaterialDesignIcons.PERM_IDENTITY);
    public iButtonFake btn_just = new iButtonFake("Justificación", "", new Color(247, 247, 247), new Color(106, 203, 214), new Color(247, 247, 247).darker(), new Color(106, 203, 214), GoogleMaterialDesignIcons.CLASS);
    public iButtonFake btn_report = new iButtonFake("Reportes", "", new Color(247, 247, 247), new Color(106, 203, 214), new Color(247, 247, 247).darker(), new Color(106, 203, 214), GoogleMaterialDesignIcons.CHROME_READER_MODE);
    public iButtonFake btn_curso = new iButtonFake("Cursos", "", new Color(247, 247, 247), new Color(106, 203, 214), new Color(247, 247, 247).darker(), new Color(106, 203, 214), GoogleMaterialDesignIcons.ATTACH_FILE);
    public iButtonFake btn_busqueda_rapida = new iButtonFake("Buscar", "", new Color(247, 247, 247), new Color(106, 203, 214), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.SEARCH);

    //Botones PANEL SUPERIOR
    //Botones asociados a Agregar solicitud
    public iButtonFake btn_niño = new iButtonFake("Niño", " Tipo Paciente", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.CHILD_CARE);
    public iButtonFake btn_adol = new iButtonFake("Adolescente", " Tipo Paciente", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.ACCESSIBILITY);
    public iButtonFake btn_adulto = new iButtonFake("Adulto", " Tipo Paciente", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.DIRECTIONS_WALK);
    public iButtonFake btn_pareja = new iButtonFake("Pareja", " Tipo Paciente", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.WC);
    public iButtonFake btn_fam = new iButtonFake("Familia", " Tipo Paciente", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.PEOPLE);
//** AYUDA 
    public iButtonFake btn_ayuda_agregarsol = new iButtonFake("Ayuda", " Tipo Paciente", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.PRIORITY_HIGH);
    //Botónes asociados a CITA
    public iTextField cita_txt = new iTextField("", 6);
    public iComboCheckBox cita_cbm;
    public iButtonFake btn_buscar_cita = new iButtonFake("Buscar", "cita", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.SEARCH);
    public iButtonFake btn_ayuda_cita = new iButtonFake("Ayuda", " cita", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.PRIORITY_HIGH);

    // Botones  modificar 
    public iTextField modificar_persona_txt = new iTextField("", 6);
    public iComboCheckBox modificar_persona_cbm;
    public iButtonFake btn_buscar_modificar_persona = new iButtonFake("Buscar", " Persona", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.SEARCH);
//** AYUDA 
    public iButtonFake btn_ayuda_modificar = new iButtonFake("Ayuda", " Persona", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.PRIORITY_HIGH);

    // BOTONES Psicologis 
    public iButtonFake btn_mosPsico = new iButtonFake("Mostar Psicólogos", "Psicólogos", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.VISIBILITY);
    public iButtonFake btn_agrePsico = new iButtonFake("Agregar Psicólogos", "Psicólogos", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.GROUP_ADD);
    public iButtonFake btn_eliTodos = new iButtonFake("Deshabilitar Todos ", "Psicólogos", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.DELETE_FOREVER);
//** AYUDA 
    public iButtonFake btn_ayuda_psicologos = new iButtonFake("Ayuda ", " Psicólogos", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.PRIORITY_HIGH);

    //Botones Cursos
    public iButtonFake btn_mosCurso = new iButtonFake("Mostar Cursos", "Cursos", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.VISIBILITY);
    public iButtonFake btn_eliminar = new iButtonFake("Eliminar", "Curso", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.DELETE_SWEEP);
    public iButtonFake btn_agrcurso = new iButtonFake("Agregar", "Curso", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.LIBRARY_ADD);
//** AYUDA 
    public iButtonFake btn_ayuda_cursos = new iButtonFake("Ayuda ", " Curso", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.PRIORITY_HIGH);

    //Botones justificacion
    public iButtonFake btn_justi = new iButtonFake("Justificación", " Generar Justificacion", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.INSERT_CHART);
    /* public iButtonFake btn_justi_print = new iButtonFake("Imprimir", "Imprimir justificación", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.PRINT);*/
//** AYUDA 
    public iButtonFake btn_ayuda_justificacion = new iButtonFake("Ayuda", " Justificación", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.PRIORITY_HIGH);

    //Boton Reportes
    public iButtonFake btn_report_diario = new iButtonFake("Diario", "Reporte Diario", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.TODAY);
    public iButtonFake btn_report_semanal = new iButtonFake("Semanal", "Reporte Semanal", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.DATE_RANGE);
    public iButtonFake btn_report_mensual = new iButtonFake("Mensual", "Reporte Mensual", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.EVENT_NOTE);
//** AYUDA 
    public iButtonFake btn_ayuda_reportes = new iButtonFake("Ayuda", " Reportes ", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.PRIORITY_HIGH);

    ///////////////////////////////////////////////////////////////////////////
    //// CONTENIDO DEL PANEL DE INFORMACIÓN////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    ///NIÑO///
    public iTextField nid_txt = new iTextField("", 6);
    public iTextField nnombre_txt = new iTextField("", 6);
    public iTextField napellido_txt = new iTextField("", 6);
    public iTextField nedad_txt = new iTextField("", 6);
    public iTextField nreferencia_txt = new iTextField("", 6);
    public iTextField nocupacion_txt = new iTextField("", 6);
    public iTextField ndireccion_txt = new iTextField("", 6);
    public iTextField ntelefono_txt = new iTextField("", 6);
    public iTextField nemail_txt = new iTextField("", 6);
    public iTextField nmotivo_txt = new iTextField("", 6);
    public iTextField nhorario_txt = new iTextField("", 6);
    public iTextField ndetalle_txt = new iTextField("", 6);
    public iTextField nsolicitante_txt = new iTextField("", 6);
    public iButtonFake btn_agregar_niño = new iButtonFake("Agregar", " Tipo Paciente", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.INPUT);
    public iComboCheckBox tipo_cbm;
    ///ADOLESCENTE///
    public iTextField adolescente_id_txt = new iTextField("", 6);
    public iTextField adolescente_nombre_txt = new iTextField("", 6);
    public iTextField adolescente_apellido_txt = new iTextField("", 6);
    public iTextField adolescente_edad_txt = new iTextField("", 6);
    public iTextField adolescente_referencia_txt = new iTextField("", 6);
    public iTextField adolescente_ocupacion_txt = new iTextField("", 6);
    public iTextField adolescente_direccion_txt = new iTextField("", 6);
    public iTextField adolescente_telefono_txt = new iTextField("", 6);
    public iTextField adolescente_email_txt = new iTextField("", 6);
    public iTextField adolescente_motivo_txt = new iTextField("", 6);
    public iTextField adolescente_horario_txt = new iTextField("", 6);
    public iTextField adolescente_detalle_txt = new iTextField("", 6);
    public iTextField adolescente_solicitante_txt = new iTextField("", 6);
    public iButtonFake btn_agregar_adolescente = new iButtonFake("Agregar", " Tipo Paciente", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.INPUT);

    ///ADULTO///
    public iTextField adulto_id_txt = new iTextField("", 6);
    public iTextField adulto_nombre_txt = new iTextField("", 6);
    public iTextField adulto_apellido_txt = new iTextField("", 6);
    public iTextField adulto_edad_txt = new iTextField("", 6);
    public iTextField adulto_referencia_txt = new iTextField("", 6);
    public iTextField adulto_ocupacion_txt = new iTextField("", 6);
    public iTextField adulto_direccion_txt = new iTextField("", 6);
    public iTextField adulto_telefono_txt = new iTextField("", 6);
    public iTextField adulto_email_txt = new iTextField("", 6);
    public iTextField adulto_motivo_txt = new iTextField("", 6);
    public iTextField adulto_horario_txt = new iTextField("", 6);
    public iTextField adulto_detalle_txt = new iTextField("", 6);
    public iTextField adulto_solicitante_txt = new iTextField("", 6);
    public iButtonFake btn_agregar_adulto = new iButtonFake("Agregar", " Tipo Paciente", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.INPUT);

    ///PAREJA///
    public iTextField pareja_id_txt = new iTextField("", 6);
    public iTextField pareja_apellido_txt = new iTextField("", 6);
    public iTextField pareja_nombre_txt = new iTextField("", 6);
    public iTextField pareja_edad_txt = new iTextField("", 6);
    public iTextField pareja_referencia_txt = new iTextField("", 6);
    public iTextField pareja_ocupacion_txt = new iTextField("", 6);
    public iTextField pareja_direccion_txt = new iTextField("", 6);
    public iTextField pareja_telefono_txt = new iTextField("", 6);
    public iTextField pareja_email_txt = new iTextField("", 6);
    public iTextField pareja_motivo_txt = new iTextField("", 6);
    public iTextField pareja_horario_txt = new iTextField("", 6);
    public iTextField pareja_detalle_txt = new iTextField("", 6);
    public iTextField pareja_solicitante_txt = new iTextField("", 6);
    public iButtonFake btn_agregar_pareja = new iButtonFake("Agregar", " Tipo Paciente", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.INPUT);

    ///FAMILIA///
    public iTextField familia_id_txt = new iTextField("", 6);
    public iTextField familia_nombre_txt = new iTextField("", 6);
    public iTextField familia_apellido_txt = new iTextField("", 6);
    public iTextField familia_integrantes_txt = new iTextField("", 6);
    public iTextField familia_edad_txt = new iTextField("", 6);
    public iTextField familia_referencia_txt = new iTextField("", 6);
    public iTextField familia_ocupacion_txt = new iTextField("", 6);
    public iTextField familia_direccion_txt = new iTextField("", 6);
    public iTextField familia_telefono_txt = new iTextField("", 6);
    public iTextField familia_email_txt = new iTextField("", 6);
    public iTextField familia_motivo_txt = new iTextField("", 6);
    public iTextField familia_horario_txt = new iTextField("", 6);
    public iTextField familia_detalle_txt = new iTextField("", 6);
    public iTextField familia_solicitante_txt = new iTextField("", 6);
    public iButtonFake btn_agregar_familia = new iButtonFake("Agregar", " Tipo Paciente", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.INPUT);

    ///MODIFICAR PERSONA///
    public JLabel Solicitud;
    public iTextField modificar_persona_id_txt = new iTextField("", 6);
    public iTextField modificar_persona_nombre_txt = new iTextField("", 6);
    public iTextField modificar_persona_apellido_txt = new iTextField("", 6);
    public iTextField modificar_persona_edad_txt = new iTextField("", 6);
    public iTextField modificar_persona_integrantes_txt = new iTextField("", 6);
    public iTextField modificar_persona_referencia_txt = new iTextField("", 6);
    public iTextField modificar_persona_ocupacion_txt = new iTextField("", 6);
    public iTextField modificar_persona_direccion_txt = new iTextField("", 6);
    public iTextField modificar_persona_telefono_txt = new iTextField("", 6);
    public iTextField modificar_persona_email_txt = new iTextField("", 6);
    public iTextField modificar_persona_motivo_txt = new iTextField("", 6);
    public iTextField modificar_persona_horario_txt = new iTextField("", 6);
    public iTextField modificar_persona_detalle_txt = new iTextField("", 6);
    public iTextField modificar_persona_solicitante_txt = new iTextField("", 6);
    public iTextField modificar_persona_cita_txt = new iTextField("", 6);
    public iTextField modificar_persona_expediente_txt = new iTextField("", 6);
    public iButtonFake btn_guardar_modificar_persona = new iButtonFake("Guardar", " Tipo Paciente", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.INPUT);
    public iComboCheckBox modificar_persona_clase_cbm;
    public iComboCheckBox modificar_persona_tipo_cbm;
    public iComboCheckBox modificar_persona_curso_cbm;
    public iComboCheckBox modificar_persona_psicologo_cbm;

    ///MODIFICAR CITA///
    public iTextField modificar_cita_id_txt = new iTextField("", 6);
    public iTextField modificar_cita_nombre_txt = new iTextField("", 6);
    public iTextField modificar_cita_apellido_txt = new iTextField("", 6);
    public iTextField modificar_cita_motivo_txt = new iTextField("", 6);
    public iTextField modificar_cita_horario_txt = new iTextField("", 6);
    public iTextField modificar_cita_cita_txt = new iTextField("", 6);
    public iTextField modificar_cita_expediente_txt = new iTextField("", 6);
    public iButtonFake btn_guardar_modificar_cita = new iButtonFake("Guardar", " Tipo Paciente", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.INPUT);
    public iComboCheckBox modificar_cita_curso_cbm;
    public iComboCheckBox modificar_cita_psicologo_cbm;

    ///////////////////////AGREGAR PSICOLOGO
    public iTextField nombre_psicologo_txt = new iTextField("", 6);
    public iTextField apellidos_psicologo_txt = new iTextField("", 6);
    public iTextField carnet_psicologo_txt = new iTextField("", 6);
    public iTextField id_psicologo_txt = new iTextField("", 6);
    public iTextField celular_psicologo_txt = new iTextField("", 6);
    public iTextField email_psicologo_txt = new iTextField("", 6);
    public iButtonFake btn_agregar_psicologo = new iButtonFake("Agregar", "", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.INPUT);
    /////////////////////AGREGAR CURSO
    public iTextField nombre_curso_txt = new iTextField("", 6);
    public iTextField siglas_curso_txt = new iTextField("", 6);
    public iButtonFake btn_agregar_curso = new iButtonFake("Agregar", "", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.INPUT);
    ////////////////////ELIMINAR CURSO
    public iTextField curso_eliminar_txt = new iTextField("", 6);
    public iButtonFake btn_curso_eliminar = new iButtonFake("Eliminar", "", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.INPUT);
////////////   generar Justificacion 
    public iTextField generar_justi_txt = new iTextField("", 6);
    public iTextField nombre_justi_txt = new iTextField("", 6);
    public iTextField apellidos_justi_txt = new iTextField("", 6);
    public iTextField cedula_justi_txt = new iTextField("", 6);
    public iTextField telefono_justi_txt = new iTextField("", 6);
    public iTextField hotario_justi_txt = new iTextField("", 6);

    public iButtonFake btn_Imprimir_justi = new iButtonFake("Imprimir Justificación", "", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.INPUT);

    public iButtonFake btn_generar_justi = new iButtonFake("Generar Justificación", "", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.INPUT);

//////////// BUSQUEDA ///////////////
    public iButtonFake busqueda_sincitas = new iButtonFake("Personas sin cita", "", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.DO_NOT_DISTURB_ALT);
    public iButtonFake busqueda_citasdia = new iButtonFake("Citas del dia", "", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.NOTIFICATIONS_ACTIVE);
    public iButtonFake busqueda_modificar = new iButtonFake("Modificar", "", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.FIBER_NEW);
    public iButtonFake busqueda_agregar_cita = new iButtonFake("Agregar Cita", "", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.DEVELOPER_BOARD);
    public iButtonFake btn_busqueda = new iButtonFake("Buscar", "", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.SEARCH);

    public MainDashboard() {
        this.sql = new SQL();
        //ARRAY DEL COMBOBOX
        ArrayList<String> items = new ArrayList<String>();

        items.add("En Espera");
        items.add("Atención inmediata");
        items.add("Atención prioritaria");
        items.add("Caído ");
        items.add("En Proceso");
        items.add("Cierre");
        items.add("Lista Negra");

        dash_frm = new iFrame(60.0f, 80.0f, 5, 2, "", JFrame.EXIT_ON_CLOSE);
        menu_panel = new iPanel(0, 30, 200, 0, 5, 5, dash_frm);
        menu_panel.setResponsiveHeight(100.0f, 30);
        search_panel = new iPanel(200, 30, 0, 60, 0, -5, dash_frm);
        search_panel.setResponsiveWidth(100.0f, 200);
        info_panel = new iPanel(200, 90, 0, 0, 10, 5, dash_frm);
        info_panel.setResponsiveWidth(100.0f, 200);
        info_panel.setResponsiveHeight(100.0f, 90);
        info_panel.setBackground(new Color(255, 255, 255));
        dash_frm.setHeaderBackground(new Color(106, 203, 214));
        tipo_cbm = new iComboCheckBox(items);
        modificar_persona_cbm = new iComboCheckBox();
        modificar_persona_clase_cbm = new iComboCheckBox();
        modificar_persona_tipo_cbm = new iComboCheckBox();
        modificar_persona_curso_cbm = new iComboCheckBox();
        modificar_persona_psicologo_cbm = new iComboCheckBox();
        modificar_cita_curso_cbm = new iComboCheckBox();
        modificar_cita_psicologo_cbm = new iComboCheckBox();
        cita_cbm = new iComboCheckBox(items);

        initComponents();
    }

    public void initComponents() {
        JLabel bienvenidos_lbl = new JLabel();
        bienvenidos_lbl.setText("BIENVENIDOS");
        bienvenidos_lbl.setForeground(new Color(55, 55, 5));

        ImageIcon logo_menu = new ImageIcon(System.getProperty("user.dir") + ("//src//Img//logo_menu.png"));
        JLabel menu_label = new JLabel(logo_menu);

        ImageIcon fondo = new ImageIcon(System.getProperty("user.dir") + ("//src//Img//fondo.png"));
        JLabel fondo_label = new JLabel(fondo);
        fondo_label.setBounds(110, 30, 400, 400);

        //clock
        iClock clock = new iClock(80, 100, 100, 100);
        clock.setForeground(new Color(247, 247, 247));
        clock.setFont(new Font("Rockwell", 1, 12));
        clock.setBounds(65, 450, 80, 100);

        menu_panel.setBackground(new Color(106, 203, 214));

        //Busqueda Ráída//
        //*** Aqui agregamos los FAKE BUTTONS al panel, (Nombre, largo, ancho, posicion)
        menu_panel.AddSingleObject(menu_label, 180, 50, CENTER);
        menu_panel.AddSingleObject(btn_busqueda_rapida, 110, 40, LEFT);
        menu_panel.AddSingleObject(btn_agregar, 171, 40, LEFT);
        menu_panel.AddSingleObject(btn_modif, 172, 40, LEFT);
        menu_panel.AddSingleObject(btn_citas, 95, 40, LEFT);
        menu_panel.AddSingleObject(btn_psico, 135, 40, LEFT);
        menu_panel.AddSingleObject(btn_curso, 105, 40, LEFT);
        menu_panel.AddSingleObject(btn_just, 140, 40, LEFT);
        menu_panel.AddSingleObject(btn_report, 120, 40, LEFT);

        menu_panel.newLine();

        search_panel.setBackground(new Color(137, 185, 185));
        search_panel.AddObject(bienvenidos_lbl, 300, 250, CENTER);
        search_panel.newLine();
        //Panel de informacion (Aqui se desplegara toda la informacion de prueba)
        ///////////////////////////////////////////////////////////////       
        bienvenidos_lbl.setVisible(true);
        menu_panel.add(clock);
        info_panel.add(fondo_label);
        dash_frm.add(info_panel);
        dash_frm.add(search_panel);
        dash_frm.add(menu_panel);
        dash_frm.finalice();
    }

    //Metódo crear tabla de busqueda rápida//
    public void BtnBusquedaRapida() {
        //Panel de busquedas      
        search_panel.dispose();
        search_panel.repaint();
        info_panel.dispose();
        info_panel.repaint();

        ImageIcon fondo = new ImageIcon(System.getProperty("user.dir") + ("//src//Img//fondo.png"));
        JLabel fondo_label = new JLabel(fondo);
        fondo_label.setBounds(110, 30, 400, 400);

        JLabel id2_lbl = new JLabel();
        id2_lbl.setText("Texto: ");
        id2_lbl.setForeground(new Color(255, 255, 255));

        JLabel tipo_lbl = new JLabel();

        search_panel.AddObject(busqueda_citasdia, 120, 60, 2);
        busqueda_citasdia.setBorder(0, 1, 0, 0, new Color(162, 202, 202));
        search_panel.AddObject(busqueda_sincitas, 120, 60, LEFT);
        busqueda_sincitas.setBorder(0, 1, 0, 0, new Color(162, 202, 202));
        search_panel.AddObject(busqueda_modificar, 120, 60, LEFT);
        busqueda_modificar.setBorder(0, 1, 0, 0, new Color(162, 202, 202));
        search_panel.AddObject(busqueda_agregar_cita, 120, 60, LEFT);
        busqueda_agregar_cita.setBorder(0, 1, 0, 0, new Color(162, 202, 202));

        //search_panel.AddObject(btn_busqueda, 120, 30, 1);
        //btn_busqueda.setBorder(0, 1, 0, 0, new Color(162, 202, 202));
        search_panel.newLine();

        info_panel.add(fondo_label);
    }

    //UN POQUITO MAS ABAJO
    public iTable tab;

    public void TABLA(ArrayList cols, ArrayList<Object[]> row) {
        info_panel.dispose();
        info_panel.repaint();
        tab = new iTable(cols);
        ResultSet rt = sql.SELECT("SELECT * FROM `Persona`", new ArrayList<>());
        for (int i = 0; i < row.size(); i++) {
            tab.addrow(row.get(i));
        }
        JScrollPane scrollPane = new JScrollPane(tab);
        scrollPane.setBounds(0, 0, 620, 493);
        info_panel.add(scrollPane);
    }
    //YA SE PASO 

    //Metódos para cargar botones al panel
    public void BtnAregarSolic() {
        //Metodo para cargar botones al clickear "AGREGAR SOLICITUD"    
        search_panel.dispose();
        search_panel.repaint();
        info_panel.dispose();
        info_panel.repaint();
        ImageIcon fondo = new ImageIcon(System.getProperty("user.dir") + ("//src//Img//fondo.png"));
        JLabel fondo_label = new JLabel(fondo);
        fondo_label.setBounds(110, 30, 400, 400);

        search_panel.AddObject(btn_ayuda_agregarsol, 100, 60, 525);
        btn_ayuda_agregarsol.setBorder(0, 0, 0, 1, new Color(162, 202, 202));

        search_panel.AddObject(btn_fam, 100, 60, 425);
        btn_fam.setBorder(0, 0, 0, 1, new Color(162, 202, 202));

        search_panel.AddObject(btn_pareja, 100, 60, 325);
        btn_pareja.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
//        
        search_panel.AddObject(btn_adulto, 100, 60, 225);
        btn_adulto.setBorder(0, 0, 0, 1, new Color(162, 202, 202));

        search_panel.AddObject(btn_adol, 100, 60, 125);
        btn_adol.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
//        
        search_panel.AddObject(btn_niño, 100, 60, -1);
        btn_niño.setBorder(0, 0, 0, 1, new Color(162, 202, 202));

        search_panel.newLine();
        info_panel.add(fondo_label);
        search_panel.finalice();

    }

    public void Btn_Cita() {
        //Metodo para cargar botones al clickear "CITAS"
        search_panel.dispose();
        search_panel.repaint();
        info_panel.dispose();
        info_panel.repaint();
        ImageIcon fondo = new ImageIcon(System.getProperty("user.dir") + ("//src//Img//fondo.png"));
        JLabel fondo_label = new JLabel(fondo);
        fondo_label.setBounds(110, 30, 400, 400);

        JLabel id2_lbl = new JLabel();
        id2_lbl.setText("Cédula: ");
        id2_lbl.setForeground(new Color(255, 255, 255));

        JLabel tipo_lbl = new JLabel();
        tipo_lbl.setText("Tipo: ");
        tipo_lbl.setForeground(new Color(255, 255, 255));

        search_panel.AddObject(id2_lbl, 50, 42, LEFT);
        search_panel.AddObject(cita_txt, 120, 32, LEFT);
        search_panel.AddObject(tipo_lbl, 50, 42, LEFT);
        search_panel.AddObject(cita_cbm, 120, 32, LEFT);

        search_panel.AddObject(btn_buscar_cita, 120, 30, 2);
        btn_buscar_cita.setBorder(0, 1, 0, 0, new Color(162, 202, 202));

        search_panel.AddObject(btn_ayuda_cita, 120, 30, 1);
        btn_ayuda_cita.setBorder(0, 1, 0, 0, new Color(162, 202, 202));

        search_panel.newLine();

        info_panel.add(fondo_label);

    }

    public void BtnModificarPersona() {
        //Panel de busquedas      
        search_panel.dispose();
        search_panel.repaint();
        info_panel.dispose();
        info_panel.repaint();

        ImageIcon fondo = new ImageIcon(System.getProperty("user.dir") + ("//src//Img//fondo.png"));
        JLabel fondo_label = new JLabel(fondo);
        fondo_label.setBounds(110, 30, 400, 400);

        JLabel id2_lbl = new JLabel();
        id2_lbl.setText("Cédula: ");
        id2_lbl.setForeground(new Color(255, 255, 255));

        JLabel tipo_lbl = new JLabel();
        tipo_lbl.setText("Tipo: ");
        tipo_lbl.setForeground(new Color(255, 255, 255));

        search_panel.AddObject(id2_lbl, 50, 42, LEFT);
        search_panel.AddObject(modificar_persona_txt, 120, 32, LEFT);
        search_panel.AddObject(tipo_lbl, 50, 42, LEFT);
        search_panel.AddObject(modificar_persona_cbm, 120, 32, LEFT);

        search_panel.AddObject(btn_buscar_modificar_persona, 120, 30, 2);
        btn_buscar_modificar_persona.setBorder(0, 1, 0, 0, new Color(162, 202, 202));

        search_panel.AddObject(btn_ayuda_modificar, 120, 30, 1);
        btn_ayuda_modificar.setBorder(0, 1, 0, 0, new Color(162, 202, 202));

        search_panel.newLine();

        info_panel.add(fondo_label);

    }

    public void BtnPsicologos() {
        //Panel de busquedas        
        search_panel.dispose();
        search_panel.repaint();
        info_panel.dispose();
        info_panel.repaint();
        ImageIcon fondo = new ImageIcon(System.getProperty("user.dir") + ("//src//Img//fondo.png"));
        JLabel fondo_label = new JLabel(fondo);
        fondo_label.setBounds(110, 30, 400, 400);
        search_panel.AddObject(btn_eliTodos, 135, 60, 272);
        btn_eliTodos.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
        search_panel.AddObject(btn_agrePsico, 135, 60, 135);
        btn_agrePsico.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
        search_panel.AddObject(btn_mosPsico, 135, 60, -1);
        btn_mosPsico.setBorder(0, 0, 0, 1, new Color(162, 202, 202));

        search_panel.AddObject(btn_ayuda_psicologos, 135, 60, 372);
        btn_ayuda_psicologos.setBorder(0, 1, 0, 0, new Color(162, 202, 202));
        search_panel.newLine();

        info_panel.add(fondo_label);
    }

    public void BtnCurso() {
        //Metodo para cargar botones al clickear "CURSOS"
        search_panel.dispose();
        search_panel.repaint();
        info_panel.dispose();
        info_panel.repaint();
        ImageIcon fondo = new ImageIcon(System.getProperty("user.dir") + ("//src//Img//fondo.png"));
        JLabel fondo_label = new JLabel(fondo);
        fondo_label.setBounds(110, 30, 400, 400);
        search_panel.AddObject(btn_mosCurso, 135, 60, -1);
        btn_mosCurso.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
        search_panel.AddObject(btn_eliminar, 135, 60, 271);
        btn_eliminar.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
        search_panel.AddObject(btn_agrcurso, 135, 60, 135);
        btn_agrcurso.setBorder(0, 0, 0, 1, new Color(162, 202, 202));

        search_panel.AddObject(btn_ayuda_cursos, 135, 60, 375);
        btn_ayuda_cursos.setBorder(0, 0, 0, 1, new Color(162, 202, 202));

        search_panel.newLine();

        info_panel.add(fondo_label);
    }

    public void BtnJustificacion() {
        search_panel.dispose();
        search_panel.repaint();
        info_panel.dispose();
        info_panel.repaint();
        ImageIcon fondo = new ImageIcon(System.getProperty("user.dir") + ("//src//Img//fondo.png"));
        JLabel fondo_label = new JLabel(fondo);
        fondo_label.setBounds(110, 30, 400, 400);
        search_panel.AddObject(btn_justi, 140, 60, CENTER);

        search_panel.AddObject(btn_ayuda_justificacion, 140, 60, 1);
//        btn_ayuda_justificacion.setBorder(0, 1, 0, 0, new Color(162, 202, 202));
        /*        search_panel.AddObject(btn_justi_print, 130, 60, -1);
        btn_justi_print.setBorder(0, 0, 0, 1, new Color(162, 202, 202));*/
        search_panel.newLine();

        info_panel.add(fondo_label);
    }

    public void BtnReportes() {
        search_panel.dispose();
        search_panel.repaint();
        info_panel.dispose();
        info_panel.repaint();
        ImageIcon fondo = new ImageIcon(System.getProperty("user.dir") + ("//src//Img//fondo.png"));
        JLabel fondo_label = new JLabel(fondo);
        fondo_label.setBounds(110, 30, 400, 400);
//        search_panel.AddObject(btn_report_diario, 120, 60, 240);
//        btn_report_diario.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
//        search_panel.AddObject(btn_report_semanal, 120, 60, 120);
//        btn_report_semanal.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
        search_panel.AddObject(btn_report_mensual, 120, 60, RIGHT);
        //btn_report_mensual.setBorder(0, 0, 0, 1, new Color(162, 202, 202));

        search_panel.AddObject(btn_ayuda_reportes, 120, 60, CENTER);
//        btn_ayuda_reportes.setBorder(0, 1, 0, 0, new Color(162, 202, 202));
        search_panel.newLine();

        info_panel.add(fondo_label);
    }

///METODOS PARA BOTONES DEL PANEL DE BUSQUEDAS////  
//////////////////////////////////////////////////
/////////////////////AGREGAR SOLICITUD//////////////////////////////    
    public void Agregar_solicitud_niño() {
        info_panel.dispose();
        info_panel.repaint();

        ImageIcon fondo = new ImageIcon(System.getProperty("user.dir") + ("//src//Img//fondo.png"));
        JLabel fondo_label = new JLabel(fondo);
        fondo_label.setBounds(110, 30, 400, 400);

        JLabel titulo_lbl = new JLabel();
        titulo_lbl.setText("- Modulo Agregar Niño -");
        titulo_lbl.setForeground(new Color(156, 156, 156));

        JLabel id_lbl = new JLabel();
        id_lbl.setText("ID: ");
        id_lbl.setForeground(new Color(156, 156, 156));

        JLabel nombre_lbl = new JLabel();
        nombre_lbl.setText("Nombre: ");
        nombre_lbl.setForeground(new Color(156, 156, 156));

        JLabel apellido_lbl = new JLabel();
        apellido_lbl.setText("Apellido: ");
        apellido_lbl.setForeground(new Color(156, 156, 156));

        JLabel edad_lbl = new JLabel();
        edad_lbl.setText("Edad: ");
        edad_lbl.setForeground(new Color(156, 156, 156));

        JLabel referencia_lbl = new JLabel();
        referencia_lbl.setText("Referencia: ");
        referencia_lbl.setForeground(new Color(156, 156, 156));

        JLabel ocupacion_lbl = new JLabel();
        ocupacion_lbl.setText("Ocupación: ");
        ocupacion_lbl.setForeground(new Color(156, 156, 156));

        JLabel direccion_lbl = new JLabel();
        direccion_lbl.setText("Dirección: ");
        direccion_lbl.setForeground(new Color(156, 156, 156));

        JLabel telefono_lbl = new JLabel();
        telefono_lbl.setText("Teléfono: ");
        telefono_lbl.setForeground(new Color(156, 156, 156));

        JLabel email_lbl = new JLabel();
        email_lbl.setText("Correo: ");
        email_lbl.setForeground(new Color(156, 156, 156));

        JLabel motivo_lbl = new JLabel();
        motivo_lbl.setText("Motivo: ");
        motivo_lbl.setForeground(new Color(156, 156, 156));

        JLabel horario_lbl = new JLabel();
        horario_lbl.setText("Horario: ");
        horario_lbl.setForeground(new Color(156, 156, 156));

        JLabel detalle_lbl = new JLabel();
        detalle_lbl.setText("Detalle: ");
        detalle_lbl.setForeground(new Color(156, 156, 156));

        JLabel solicitante_lbl = new JLabel();
        solicitante_lbl.setText("Solicitante: ");
        solicitante_lbl.setForeground(new Color(156, 156, 156));

        JLabel combo_lbl = new JLabel();
        combo_lbl.setText("Clase: ");
        combo_lbl.setForeground(new Color(156, 156, 156));

        JLabel clock2_lbl = new JLabel();
        clock2_lbl.setText("Registro: ");
        clock2_lbl.setForeground(new Color(156, 156, 156));
        String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        JLabel clock2 = new JLabel(date);

        btn_agregar_niño.setBorder(2, 2, 2, 2, new Color(162, 202, 202));
        //////////////////////////////////////////////////////////////////////////////      
        info_panel.AddObject(titulo_lbl, 200, 20, CENTER);
        info_panel.newLine();

        info_panel.AddObject(id_lbl, 80, 20, LEFT);
        info_panel.AddObject(nid_txt, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(nombre_lbl, 80, 20, LEFT);
        info_panel.AddObject(nnombre_txt, 160, 20, LEFT);

        info_panel.AddObject(apellido_lbl, 60, 20, LEFT);
        info_panel.AddObject(napellido_txt, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(edad_lbl, 80, 20, LEFT);
        info_panel.AddObject(nedad_txt, 160, 20, LEFT);
        nedad_txt.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();

                // Verificar si la tecla pulsada no es un digito
                if (((caracter < '0')
                        || (caracter > '9'))
                        && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
                    e.consume();  // ignorar el evento de teclado
                }
            }
        });
        info_panel.newLine();

        info_panel.AddObject(referencia_lbl, 80, 20, LEFT);
        info_panel.AddObject(nreferencia_txt, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(ocupacion_lbl, 80, 20, LEFT);
        info_panel.AddObject(nocupacion_txt, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(direccion_lbl, 80, 20, LEFT);
        info_panel.AddObject(ndireccion_txt, 400, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(telefono_lbl, 80, 20, LEFT);
        info_panel.AddObject(ntelefono_txt, 160, 20, LEFT);
        ntelefono_txt.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();

                // Verificar si la tecla pulsada no es un digito
                if (((caracter < '0')
                        || (caracter > '9'))
                        && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
                    e.consume();  // ignorar el evento de teclado
                }
            }
        });

        info_panel.AddObject(email_lbl, 60, 20, LEFT);
        info_panel.AddObject(nemail_txt, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(motivo_lbl, 80, 20, LEFT);
        info_panel.AddObject(nmotivo_txt, 400, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(horario_lbl, 80, 20, LEFT);
        info_panel.AddObject(nhorario_txt, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(solicitante_lbl, 80, 20, LEFT);
        info_panel.AddObject(nsolicitante_txt, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(detalle_lbl, 80, 20, LEFT);
        info_panel.AddObject(ndetalle_txt, 400, 20, LEFT);
        info_panel.AddObject(btn_agregar_niño, 100, 60, LEFT);
        info_panel.newLine();

        info_panel.AddObject(combo_lbl, 80, 20, LEFT);
        info_panel.AddObject(tipo_cbm, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(clock2_lbl, 80, 20, LEFT);
        info_panel.AddObject(clock2, 80, 20, LEFT);
        info_panel.newLine();

        info_panel.add(fondo_label);
    }

    public void Agregar_solicitud_adolescente() {
        info_panel.dispose();
        info_panel.repaint();

        ImageIcon fondo = new ImageIcon(System.getProperty("user.dir") + ("//src//Img//fondo.png"));
        JLabel fondo_label = new JLabel(fondo);
        fondo_label.setBounds(110, 30, 400, 400);

        JLabel titulo_lbl = new JLabel();
        titulo_lbl.setText("- Modulo Agregar Adolescente -");
        titulo_lbl.setForeground(new Color(156, 156, 156));

        JLabel id_lbl = new JLabel();
        id_lbl.setText("ID: ");
        id_lbl.setForeground(new Color(156, 156, 156));

        JLabel nombre_lbl = new JLabel();
        nombre_lbl.setText("Nombre: ");
        nombre_lbl.setForeground(new Color(156, 156, 156));

        JLabel apellido_lbl = new JLabel();
        apellido_lbl.setText("Apellido: ");
        apellido_lbl.setForeground(new Color(156, 156, 156));

        JLabel edad_lbl = new JLabel();
        edad_lbl.setText("Edad: ");
        edad_lbl.setForeground(new Color(156, 156, 156));

        JLabel referencia_lbl = new JLabel();
        referencia_lbl.setText("Referencia: ");
        referencia_lbl.setForeground(new Color(156, 156, 156));

        JLabel ocupacion_lbl = new JLabel();
        ocupacion_lbl.setText("Ocupación: ");
        ocupacion_lbl.setForeground(new Color(156, 156, 156));

        JLabel direccion_lbl = new JLabel();
        direccion_lbl.setText("Dirección: ");
        direccion_lbl.setForeground(new Color(156, 156, 156));

        JLabel telefono_lbl = new JLabel();
        telefono_lbl.setText("Teléfono: ");
        telefono_lbl.setForeground(new Color(156, 156, 156));

        JLabel email_lbl = new JLabel();
        email_lbl.setText("Correo: ");
        email_lbl.setForeground(new Color(156, 156, 156));

        JLabel motivo_lbl = new JLabel();
        motivo_lbl.setText("Motivo: ");
        motivo_lbl.setForeground(new Color(156, 156, 156));

        JLabel horario_lbl = new JLabel();
        horario_lbl.setText("Horario: ");
        horario_lbl.setForeground(new Color(156, 156, 156));

        JLabel detalle_lbl = new JLabel();
        detalle_lbl.setText("Detalle: ");
        detalle_lbl.setForeground(new Color(156, 156, 156));

        JLabel solicitante_lbl = new JLabel();
        solicitante_lbl.setText("Solicitante: ");
        solicitante_lbl.setForeground(new Color(156, 156, 156));

        JLabel combo_lbl = new JLabel();
        combo_lbl.setText("Clase: ");
        combo_lbl.setForeground(new Color(156, 156, 156));

        JLabel clock2_lbl = new JLabel();
        clock2_lbl.setText("Registro: ");
        clock2_lbl.setForeground(new Color(156, 156, 156));
        String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        JLabel clock2 = new JLabel(date);

        btn_agregar_adolescente.setBorder(2, 2, 2, 2, new Color(162, 202, 202));
        //////////////////////////////////////////////////////////////////////////////      
        info_panel.AddObject(titulo_lbl, 200, 20, CENTER);
        info_panel.newLine();

        info_panel.AddObject(id_lbl, 80, 20, LEFT);
        info_panel.AddObject(adolescente_id_txt, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(nombre_lbl, 80, 20, LEFT);
        info_panel.AddObject(adolescente_nombre_txt, 160, 20, LEFT);

        info_panel.AddObject(apellido_lbl, 60, 20, LEFT);
        info_panel.AddObject(adolescente_apellido_txt, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(edad_lbl, 80, 20, LEFT);
        info_panel.AddObject(adolescente_edad_txt, 160, 20, LEFT);
        adolescente_edad_txt.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();

                // Verificar si la tecla pulsada no es un digito
                if (((caracter < '0')
                        || (caracter > '9'))
                        && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
                    e.consume();  // ignorar el evento de teclado
                }
            }
        });
        info_panel.newLine();

        info_panel.AddObject(referencia_lbl, 80, 20, LEFT);
        info_panel.AddObject(adolescente_referencia_txt, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(ocupacion_lbl, 80, 20, LEFT);
        info_panel.AddObject(adolescente_ocupacion_txt, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(direccion_lbl, 80, 20, LEFT);
        info_panel.AddObject(adolescente_direccion_txt, 400, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(telefono_lbl, 80, 20, LEFT);
        info_panel.AddObject(adolescente_telefono_txt, 160, 20, LEFT);
        adolescente_telefono_txt.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();

                // Verificar si la tecla pulsada no es un digito
                if (((caracter < '0')
                        || (caracter > '9'))
                        && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
                    e.consume();  // ignorar el evento de teclado
                }
            }
        });

        info_panel.AddObject(email_lbl, 60, 20, LEFT);
        info_panel.AddObject(adolescente_email_txt, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(motivo_lbl, 80, 20, LEFT);
        info_panel.AddObject(adolescente_motivo_txt, 400, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(horario_lbl, 80, 20, LEFT);
        info_panel.AddObject(adolescente_horario_txt, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(solicitante_lbl, 80, 20, LEFT);
        info_panel.AddObject(adolescente_solicitante_txt, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(detalle_lbl, 80, 20, LEFT);
        info_panel.AddObject(adolescente_detalle_txt, 400, 20, LEFT);
        info_panel.AddObject(btn_agregar_adolescente, 100, 60, LEFT);
        info_panel.newLine();

        info_panel.AddObject(combo_lbl, 80, 20, LEFT);
        info_panel.AddObject(tipo_cbm, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(clock2_lbl, 80, 20, LEFT);
        info_panel.AddObject(clock2, 80, 20, LEFT);
        info_panel.newLine();

        info_panel.add(fondo_label);

    }

    public void Agregar_solicitud_adulto() {
        info_panel.dispose();
        info_panel.repaint();

        ImageIcon fondo = new ImageIcon(System.getProperty("user.dir") + ("//src//Img//fondo.png"));
        JLabel fondo_label = new JLabel(fondo);
        fondo_label.setBounds(110, 30, 400, 400);

        JLabel titulo_lbl = new JLabel();
        titulo_lbl.setText("- Modulo Agregar Adulto -");
        titulo_lbl.setForeground(new Color(156, 156, 156));

        JLabel id_lbl = new JLabel();
        id_lbl.setText("ID: ");
        id_lbl.setForeground(new Color(156, 156, 156));

        JLabel nombre_lbl = new JLabel();
        nombre_lbl.setText("Nombre: ");
        nombre_lbl.setForeground(new Color(156, 156, 156));

        JLabel apellido_lbl = new JLabel();
        apellido_lbl.setText("Apellido: ");
        apellido_lbl.setForeground(new Color(156, 156, 156));

        JLabel edad_lbl = new JLabel();
        edad_lbl.setText("Edad: ");
        edad_lbl.setForeground(new Color(156, 156, 156));

        JLabel referencia_lbl = new JLabel();
        referencia_lbl.setText("Referencia: ");
        referencia_lbl.setForeground(new Color(156, 156, 156));

        JLabel ocupacion_lbl = new JLabel();
        ocupacion_lbl.setText("Ocupación: ");
        ocupacion_lbl.setForeground(new Color(156, 156, 156));

        JLabel direccion_lbl = new JLabel();
        direccion_lbl.setText("Dirección: ");
        direccion_lbl.setForeground(new Color(156, 156, 156));

        JLabel telefono_lbl = new JLabel();
        telefono_lbl.setText("Teléfono: ");
        telefono_lbl.setForeground(new Color(156, 156, 156));

        JLabel email_lbl = new JLabel();
        email_lbl.setText("Correo: ");
        email_lbl.setForeground(new Color(156, 156, 156));

        JLabel motivo_lbl = new JLabel();
        motivo_lbl.setText("Motivo: ");
        motivo_lbl.setForeground(new Color(156, 156, 156));

        JLabel horario_lbl = new JLabel();
        horario_lbl.setText("Horario: ");
        horario_lbl.setForeground(new Color(156, 156, 156));

        JLabel detalle_lbl = new JLabel();
        detalle_lbl.setText("Detalle: ");
        detalle_lbl.setForeground(new Color(156, 156, 156));

        JLabel solicitante_lbl = new JLabel();
        solicitante_lbl.setText("Solicitante: ");
        solicitante_lbl.setForeground(new Color(156, 156, 156));

        JLabel combo_lbl = new JLabel();
        combo_lbl.setText("Clase: ");
        combo_lbl.setForeground(new Color(156, 156, 156));

        JLabel clock2_lbl = new JLabel();
        clock2_lbl.setText("Registro: ");
        clock2_lbl.setForeground(new Color(156, 156, 156));
        String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        JLabel clock2 = new JLabel(date);

        btn_agregar_adulto.setBorder(2, 2, 2, 2, new Color(162, 202, 202));
        //////////////////////////////////////////////////////////////////////////////      
        info_panel.AddObject(titulo_lbl, 200, 20, CENTER);
        info_panel.newLine();

        info_panel.AddObject(id_lbl, 80, 20, LEFT);
        info_panel.AddObject(adulto_id_txt, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(nombre_lbl, 80, 20, LEFT);
        info_panel.AddObject(adulto_nombre_txt, 160, 20, LEFT);

        info_panel.AddObject(apellido_lbl, 60, 20, LEFT);
        info_panel.AddObject(adulto_apellido_txt, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(edad_lbl, 80, 20, LEFT);
        info_panel.AddObject(adulto_edad_txt, 160, 20, LEFT);
        adulto_edad_txt.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();

                // Verificar si la tecla pulsada no es un digito
                if (((caracter < '0')
                        || (caracter > '9'))
                        && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
                    e.consume();  // ignorar el evento de teclado
                }
            }
        });
        info_panel.newLine();

        info_panel.AddObject(referencia_lbl, 80, 20, LEFT);
        info_panel.AddObject(adulto_referencia_txt, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(ocupacion_lbl, 80, 20, LEFT);
        info_panel.AddObject(adulto_ocupacion_txt, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(direccion_lbl, 80, 20, LEFT);
        info_panel.AddObject(adulto_direccion_txt, 400, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(telefono_lbl, 80, 20, LEFT);
        info_panel.AddObject(adulto_telefono_txt, 160, 20, LEFT);
        adulto_telefono_txt.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();

                // Verificar si la tecla pulsada no es un digito
                if (((caracter < '0')
                        || (caracter > '9'))
                        && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
                    e.consume();  // ignorar el evento de teclado
                }
            }
        });
        info_panel.AddObject(email_lbl, 60, 20, LEFT);
        info_panel.AddObject(adulto_email_txt, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(motivo_lbl, 80, 20, LEFT);
        info_panel.AddObject(adulto_motivo_txt, 400, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(horario_lbl, 80, 20, LEFT);
        info_panel.AddObject(adulto_horario_txt, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(solicitante_lbl, 80, 20, LEFT);
        info_panel.AddObject(adulto_solicitante_txt, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(detalle_lbl, 80, 20, LEFT);
        info_panel.AddObject(adulto_detalle_txt, 400, 20, LEFT);
        info_panel.AddObject(btn_agregar_adulto, 100, 60, LEFT);
        info_panel.newLine();

        info_panel.AddObject(combo_lbl, 80, 20, LEFT);
        info_panel.AddObject(tipo_cbm, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(clock2_lbl, 80, 20, LEFT);
        info_panel.AddObject(clock2, 80, 20, LEFT);
        info_panel.newLine();

        info_panel.add(fondo_label);

    }

    public void Agregar_solicitud_pareja() {
        info_panel.dispose();
        info_panel.repaint();

        ImageIcon fondo = new ImageIcon(System.getProperty("user.dir") + ("//src//Img//fondo.png"));
        JLabel fondo_label = new JLabel(fondo);
        fondo_label.setBounds(110, 30, 400, 400);

        JLabel titulo_lbl = new JLabel();
        titulo_lbl.setText("- Modulo Agregar Pareja -");
        titulo_lbl.setForeground(new Color(156, 156, 156));

        JLabel id_lbl = new JLabel();
        id_lbl.setText("ID: ");
        id_lbl.setForeground(new Color(156, 156, 156));

        JLabel apellido_lbl = new JLabel();
        apellido_lbl.setText("Apellidos: ");
        apellido_lbl.setForeground(new Color(156, 156, 156));

        JLabel nombre_lbl = new JLabel();
        nombre_lbl.setText("Nombre: ");
        nombre_lbl.setForeground(new Color(156, 156, 156));

        JLabel edad_lbl2 = new JLabel();
        edad_lbl2.setText("Edad: ");
        edad_lbl2.setForeground(new Color(156, 156, 156));

        JLabel referencia_lbl = new JLabel();
        referencia_lbl.setText("Referencia: ");
        referencia_lbl.setForeground(new Color(156, 156, 156));

        JLabel ocupacion_lbl = new JLabel();
        ocupacion_lbl.setText("Ocupación: ");
        ocupacion_lbl.setForeground(new Color(156, 156, 156));

        JLabel ocupacion_lbl2 = new JLabel();
        ocupacion_lbl2.setText("Ocupación: ");
        ocupacion_lbl2.setForeground(new Color(156, 156, 156));

        JLabel direccion_lbl = new JLabel();
        direccion_lbl.setText("Dirección: ");
        direccion_lbl.setForeground(new Color(156, 156, 156));

        JLabel telefono_lbl = new JLabel();
        telefono_lbl.setText("Teléonos: ");
        telefono_lbl.setForeground(new Color(156, 156, 156));

        JLabel telefono_lbl2 = new JLabel();
        telefono_lbl2.setText("Teléonos: ");
        telefono_lbl2.setForeground(new Color(156, 156, 156));

        JLabel email_lbl = new JLabel();
        email_lbl.setText("Correo: ");
        email_lbl.setForeground(new Color(156, 156, 156));

        JLabel motivo_lbl = new JLabel();
        motivo_lbl.setText("Motivo: ");
        motivo_lbl.setForeground(new Color(156, 156, 156));

        JLabel horario_lbl = new JLabel();
        horario_lbl.setText("Horario: ");
        horario_lbl.setForeground(new Color(156, 156, 156));

        JLabel detalle_lbl = new JLabel();
        detalle_lbl.setText("Detalle: ");
        detalle_lbl.setForeground(new Color(156, 156, 156));

        JLabel solicitante_lbl = new JLabel();
        solicitante_lbl.setText("Solicitante: ");
        solicitante_lbl.setForeground(new Color(156, 156, 156));

        JLabel combo_lbl = new JLabel();
        combo_lbl.setText("Clase: ");
        combo_lbl.setForeground(new Color(156, 156, 156));

        JLabel clock2_lbl = new JLabel();
        clock2_lbl.setText("Registro: ");
        clock2_lbl.setForeground(new Color(156, 156, 156));
        String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        JLabel clock2 = new JLabel(date);

        btn_agregar_pareja.setBorder(2, 2, 2, 2, new Color(162, 202, 202));
        //////////////////////////////////////////////////////////////////////////////      
        info_panel.AddObject(titulo_lbl, 200, 20, CENTER);
        info_panel.newLine();

        info_panel.AddObject(id_lbl, 80, 20, LEFT);
        info_panel.AddObject(pareja_id_txt, 150, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(apellido_lbl, 80, 20, LEFT);
        info_panel.AddObject(pareja_apellido_txt, 400, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(nombre_lbl, 80, 20, LEFT);
        info_panel.AddObject(pareja_nombre_txt, 150, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(edad_lbl2, 80, 20, LEFT);
        info_panel.AddObject(pareja_edad_txt, 150, 20, LEFT);
        pareja_edad_txt.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();

                // Verificar si la tecla pulsada no es un digito
                if (((caracter < '0')
                        || (caracter > '9'))
                        && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
                    e.consume();  // ignorar el evento de teclado
                }
            }
        });
        info_panel.newLine();

        info_panel.AddObject(referencia_lbl, 80, 20, LEFT);
        info_panel.AddObject(pareja_referencia_txt, 150, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(ocupacion_lbl, 80, 20, LEFT);
        info_panel.AddObject(pareja_ocupacion_txt, 150, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(direccion_lbl, 80, 20, LEFT);
        info_panel.AddObject(pareja_direccion_txt, 400, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(telefono_lbl, 80, 20, LEFT);
        info_panel.AddObject(pareja_telefono_txt, 150, 20, LEFT);
        pareja_telefono_txt.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();

                // Verificar si la tecla pulsada no es un digito
                if (((caracter < '0')
                        || (caracter > '9'))
                        && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
                    e.consume();  // ignorar el evento de teclado
                }
            }
        });
        info_panel.newLine();

        info_panel.AddObject(email_lbl, 80, 20, LEFT);
        info_panel.AddObject(pareja_email_txt, 150, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(motivo_lbl, 80, 20, LEFT);
        info_panel.AddObject(pareja_motivo_txt, 400, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(horario_lbl, 80, 20, LEFT);
        info_panel.AddObject(pareja_horario_txt, 150, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(solicitante_lbl, 80, 20, LEFT);
        info_panel.AddObject(pareja_solicitante_txt, 150, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(detalle_lbl, 80, 20, LEFT);
        info_panel.AddObject(pareja_detalle_txt, 400, 20, LEFT);
        info_panel.AddObject(btn_agregar_pareja, 100, 60, LEFT);
        info_panel.newLine();

        info_panel.AddObject(combo_lbl, 80, 20, LEFT);
        info_panel.AddObject(tipo_cbm, 150, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(clock2_lbl, 80, 20, LEFT);
        info_panel.AddObject(clock2, 80, 20, LEFT);
        info_panel.newLine();

        info_panel.add(fondo_label);
    }

    public void Agregar_solicitud_familia() {
        info_panel.dispose();
        info_panel.repaint();

        ImageIcon fondo = new ImageIcon(System.getProperty("user.dir") + ("//src//Img//fondo.png"));
        JLabel fondo_label = new JLabel(fondo);
        fondo_label.setBounds(110, 30, 400, 400);

        JLabel titulo_lbl = new JLabel();
        titulo_lbl.setText("- Modulo Agregar Familia -");
        titulo_lbl.setForeground(new Color(156, 156, 156));

        JLabel id_lbl = new JLabel();
        id_lbl.setText("ID: ");
        id_lbl.setForeground(new Color(156, 156, 156));

        JLabel nombre_lbl = new JLabel();
        nombre_lbl.setText("Nombre: ");
        nombre_lbl.setForeground(new Color(156, 156, 156));

        JLabel apellido_lbl = new JLabel();
        apellido_lbl.setText("Apellidos: ");
        apellido_lbl.setForeground(new Color(156, 156, 156));

        JLabel integrantes_lbl = new JLabel();
        integrantes_lbl.setText("Integrantes: ");
        integrantes_lbl.setForeground(new Color(156, 156, 156));

        JLabel edad_lbl = new JLabel();
        edad_lbl.setText("Edad: ");
        edad_lbl.setForeground(new Color(156, 156, 156));

        JLabel referencia_lbl = new JLabel();
        referencia_lbl.setText("Referencia: ");
        referencia_lbl.setForeground(new Color(156, 156, 156));

        JLabel ocupacion_lbl = new JLabel();
        ocupacion_lbl.setText("Ocupación: ");
        ocupacion_lbl.setForeground(new Color(156, 156, 156));

        JLabel direccion_lbl = new JLabel();
        direccion_lbl.setText("Dirección: ");
        direccion_lbl.setForeground(new Color(156, 156, 156));

        JLabel telefono_lbl = new JLabel();
        telefono_lbl.setText("Teléonos: ");
        telefono_lbl.setForeground(new Color(156, 156, 156));

        JLabel email_lbl = new JLabel();
        email_lbl.setText("Correo: ");
        email_lbl.setForeground(new Color(156, 156, 156));

        JLabel motivo_lbl = new JLabel();
        motivo_lbl.setText("Motivo: ");
        motivo_lbl.setForeground(new Color(156, 156, 156));

        JLabel horario_lbl = new JLabel();
        horario_lbl.setText("Horario: ");
        horario_lbl.setForeground(new Color(156, 156, 156));

        JLabel detalle_lbl = new JLabel();
        detalle_lbl.setText("Detalle: ");
        detalle_lbl.setForeground(new Color(156, 156, 156));

        JLabel solicitante_lbl = new JLabel();
        solicitante_lbl.setText("Solicitante: ");
        solicitante_lbl.setForeground(new Color(156, 156, 156));

        JLabel combo_lbl = new JLabel();
        combo_lbl.setText("Clase: ");
        combo_lbl.setForeground(new Color(156, 156, 156));

        JLabel clock2_lbl = new JLabel();
        clock2_lbl.setText("Registro: ");
        clock2_lbl.setForeground(new Color(156, 156, 156));
        String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        JLabel clock2 = new JLabel(date);

        btn_agregar_familia.setBorder(2, 2, 2, 2, new Color(162, 202, 202));
        //////////////////////////////////////////////////////////////////////////////      
        info_panel.AddObject(titulo_lbl, 200, 20, CENTER);
        info_panel.newLine();

        info_panel.AddObject(id_lbl, 80, 20, LEFT);
        info_panel.AddObject(familia_id_txt, 150, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(nombre_lbl, 80, 20, LEFT);
        info_panel.AddObject(familia_nombre_txt, 150, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(apellido_lbl, 80, 20, LEFT);
        info_panel.AddObject(familia_apellido_txt, 400, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(integrantes_lbl, 80, 20, LEFT);
        info_panel.AddObject(familia_integrantes_txt, 150, 20, LEFT);
        familia_integrantes_txt.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();

                // Verificar si la tecla pulsada no es un digito
                if (((caracter < '0')
                        || (caracter > '9'))
                        && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
                    e.consume();  // ignorar el evento de teclado
                }
            }
        });
        info_panel.newLine();

        info_panel.AddObject(edad_lbl, 80, 20, LEFT);
        info_panel.AddObject(familia_edad_txt, 150, 20, LEFT);
        familia_edad_txt.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();

                // Verificar si la tecla pulsada no es un digito
                if (((caracter < '0')
                        || (caracter > '9'))
                        && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
                    e.consume();  // ignorar el evento de teclado
                }
            }
        });
        info_panel.newLine();

        info_panel.AddObject(referencia_lbl, 80, 20, LEFT);
        info_panel.AddObject(familia_referencia_txt, 150, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(ocupacion_lbl, 80, 20, LEFT);
        info_panel.AddObject(familia_ocupacion_txt, 150, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(direccion_lbl, 80, 20, LEFT);
        info_panel.AddObject(familia_direccion_txt, 400, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(telefono_lbl, 80, 20, LEFT);
        info_panel.AddObject(familia_telefono_txt, 150, 20, LEFT);
        familia_telefono_txt.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();

                // Verificar si la tecla pulsada no es un digito
                if (((caracter < '0')
                        || (caracter > '9'))
                        && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
                    e.consume();  // ignorar el evento de teclado
                }
            }
        });

        info_panel.AddObject(email_lbl, 80, 20, LEFT);
        info_panel.AddObject(familia_email_txt, 150, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(motivo_lbl, 80, 20, LEFT);
        info_panel.AddObject(familia_motivo_txt, 400, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(horario_lbl, 80, 20, LEFT);
        info_panel.AddObject(familia_horario_txt, 150, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(solicitante_lbl, 80, 20, LEFT);
        info_panel.AddObject(familia_solicitante_txt, 150, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(detalle_lbl, 80, 20, LEFT);
        info_panel.AddObject(familia_detalle_txt, 400, 20, LEFT);
        info_panel.AddObject(btn_agregar_familia, 100, 60, LEFT);
        info_panel.newLine();

        info_panel.AddObject(combo_lbl, 80, 20, LEFT);
        info_panel.AddObject(tipo_cbm, 150, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(clock2_lbl, 80, 20, LEFT);
        info_panel.AddObject(clock2, 80, 20, LEFT);
        info_panel.newLine();

        info_panel.add(fondo_label);
    }

////////////////////MODIFICAR PERSONA////////////////////////
    public void Modificar_persona_buscar() {
        info_panel.dispose();
        info_panel.repaint();

        ImageIcon fondo = new ImageIcon(System.getProperty("user.dir") + ("//src//Img//fondo.png"));
        JLabel fondo_label = new JLabel(fondo);
        fondo_label.setBounds(110, 30, 400, 400);

        JLabel id_lbl = new JLabel();
        id_lbl.setText("ID: ");
        id_lbl.setForeground(new Color(156, 156, 156));

        JLabel expediente_lbl = new JLabel();
        expediente_lbl.setText("Expediente: ");
        expediente_lbl.setForeground(new Color(156, 156, 156));

        JLabel nombre_lbl = new JLabel();
        nombre_lbl.setText("Nombre: ");
        nombre_lbl.setForeground(new Color(156, 156, 156));

        JLabel apellido_lbl = new JLabel();
        apellido_lbl.setText("Apellido: ");
        apellido_lbl.setForeground(new Color(156, 156, 156));

        JLabel edad_lbl = new JLabel();
        edad_lbl.setText("Edad: ");
        edad_lbl.setForeground(new Color(156, 156, 156));

        JLabel integrantes_lbl = new JLabel();
        integrantes_lbl.setText("No. Integrantes: ");
        integrantes_lbl.setForeground(new Color(156, 156, 156));

        JLabel referencia_lbl = new JLabel();
        referencia_lbl.setText("Referencia: ");
        referencia_lbl.setForeground(new Color(156, 156, 156));

        JLabel cita_lbl = new JLabel();
        cita_lbl.setText("Cita: ");
        cita_lbl.setForeground(new Color(156, 156, 156));

        JLabel ocupacion_lbl = new JLabel();
        ocupacion_lbl.setText("Ocupación: ");
        ocupacion_lbl.setForeground(new Color(156, 156, 156));

        JLabel direccion_lbl = new JLabel();
        direccion_lbl.setText("Dirección: ");
        direccion_lbl.setForeground(new Color(156, 156, 156));

        JLabel telefono_lbl = new JLabel();
        telefono_lbl.setText("Telfono: ");
        telefono_lbl.setForeground(new Color(156, 156, 156));

        JLabel email_lbl = new JLabel();
        email_lbl.setText("Correo: ");
        email_lbl.setForeground(new Color(156, 156, 156));

        JLabel motivo_lbl = new JLabel();
        motivo_lbl.setText("Motivo: ");
        motivo_lbl.setForeground(new Color(156, 156, 156));

        JLabel horario_lbl = new JLabel();
        horario_lbl.setText("Horario: ");
        horario_lbl.setForeground(new Color(156, 156, 156));

        JLabel detalle_lbl = new JLabel();
        detalle_lbl.setText("Detalle: ");
        detalle_lbl.setForeground(new Color(156, 156, 156));

        JLabel solicitante_lbl = new JLabel();
        solicitante_lbl.setText("Solicitante: ");
        solicitante_lbl.setForeground(new Color(156, 156, 156));

        JLabel combo_lbl = new JLabel();
        combo_lbl.setText("Clase: ");
        combo_lbl.setForeground(new Color(156, 156, 156));

        JLabel combo2_lbl = new JLabel();
        combo2_lbl.setText("Tipo: ");
        combo2_lbl.setForeground(new Color(156, 156, 156));

        JLabel combo3_lbl = new JLabel();
        combo3_lbl.setText("Curso: ");
        combo3_lbl.setForeground(new Color(156, 156, 156));

        JLabel combo4_lbl = new JLabel();
        combo4_lbl.setText("Psicólogo: ");
        combo4_lbl.setForeground(new Color(156, 156, 156));

        JLabel clock2_lbl = new JLabel();
        clock2_lbl.setText("Registro: ");
        clock2_lbl.setForeground(new Color(156, 156, 156));

        Solicitud = new JLabel();

        info_panel.AddObject(id_lbl, 80, 20, LEFT);
        info_panel.AddObject(modificar_persona_id_txt, 160, 20, LEFT);

        info_panel.AddObject(expediente_lbl, 100, 20, LEFT);
        info_panel.AddObject(modificar_persona_expediente_txt, 120, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(nombre_lbl, 80, 20, LEFT);
        info_panel.AddObject(modificar_persona_nombre_txt, 160, 20, LEFT);

        info_panel.AddObject(apellido_lbl, 60, 20, LEFT);
        info_panel.AddObject(modificar_persona_apellido_txt, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(edad_lbl, 80, 20, LEFT);
        info_panel.AddObject(modificar_persona_edad_txt, 160, 20, LEFT);
        modificar_persona_edad_txt.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();

                // Verificar si la tecla pulsada no es un digito
                if (((caracter < '0')
                        || (caracter > '9'))
                        && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
                    e.consume();  // ignorar el evento de teclado
                }
            }
        });

        info_panel.AddObject(integrantes_lbl, 100, 20, LEFT);
        info_panel.AddObject(modificar_persona_integrantes_txt, 120, 20, LEFT);
        modificar_persona_integrantes_txt.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();

                // Verificar si la tecla pulsada no es un digito
                if (((caracter < '0')
                        || (caracter > '9'))
                        && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
                    e.consume();  // ignorar el evento de teclado
                }
            }
        });
        info_panel.newLine();

        info_panel.AddObject(referencia_lbl, 80, 20, LEFT);
        info_panel.AddObject(modificar_persona_referencia_txt, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(cita_lbl, 80, 20, LEFT);
        info_panel.AddObject(modificar_persona_cita_txt, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(ocupacion_lbl, 80, 20, LEFT);
        info_panel.AddObject(modificar_persona_ocupacion_txt, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(direccion_lbl, 80, 20, LEFT);
        info_panel.AddObject(modificar_persona_direccion_txt, 400, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(telefono_lbl, 80, 20, LEFT);
        info_panel.AddObject(modificar_persona_telefono_txt, 160, 20, LEFT);
        modificar_persona_telefono_txt.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();

                // Verificar si la tecla pulsada no es un digito
                if (((caracter < '0')
                        || (caracter > '9'))
                        && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
                    e.consume();  // ignorar el evento de teclado
                }
            }
        });
        info_panel.AddObject(email_lbl, 60, 20, LEFT);
        info_panel.AddObject(modificar_persona_email_txt, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(motivo_lbl, 80, 20, LEFT);
        info_panel.AddObject(modificar_persona_motivo_txt, 400, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(horario_lbl, 80, 20, LEFT);
        info_panel.AddObject(modificar_persona_horario_txt, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(solicitante_lbl, 80, 20, LEFT);
        info_panel.AddObject(modificar_persona_solicitante_txt, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(detalle_lbl, 80, 20, LEFT);
        info_panel.AddObject(modificar_persona_detalle_txt, 400, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(combo_lbl, 80, 20, LEFT);
        info_panel.AddObject(modificar_persona_clase_cbm, 160, 20, LEFT);

        info_panel.AddObject(combo2_lbl, 60, 20, LEFT);
        info_panel.AddObject(modificar_persona_tipo_cbm, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(combo3_lbl, 80, 20, LEFT);
        info_panel.AddObject(modificar_persona_curso_cbm, 160, 20, LEFT);

        info_panel.AddObject(combo4_lbl, 60, 20, LEFT);
        info_panel.AddObject(modificar_persona_psicologo_cbm, 160, 20, LEFT);
        info_panel.AddObject(btn_guardar_modificar_persona, 100, 60, LEFT);
        info_panel.newLine();

        info_panel.AddObject(clock2_lbl, 80, 20, LEFT);
        info_panel.AddObject(Solicitud, 200, 20, LEFT);
        info_panel.newLine();

        info_panel.add(fondo_label);
    }

////////////////////CITAS////////////////////////////////////
    public void modificar_citas() {
        info_panel.dispose();
        info_panel.repaint();

        ImageIcon fondo = new ImageIcon(System.getProperty("user.dir") + ("//src//Img//fondo.png"));
        JLabel fondo_label = new JLabel(fondo);
        fondo_label.setBounds(110, 30, 400, 400);

        JLabel id_lbl = new JLabel();
        id_lbl.setText("ID: ");
        id_lbl.setForeground(new Color(156, 156, 156));

        JLabel expediente_lbl = new JLabel();
        expediente_lbl.setText("Expediente: ");
        expediente_lbl.setForeground(new Color(156, 156, 156));

        JLabel nombre_lbl = new JLabel();
        nombre_lbl.setText("Nombre: ");
        nombre_lbl.setForeground(new Color(156, 156, 156));

        JLabel apellido_lbl = new JLabel();
        apellido_lbl.setText("Apellido: ");
        apellido_lbl.setForeground(new Color(156, 156, 156));

        JLabel cita_lbl = new JLabel();
        cita_lbl.setText("Cita: ");
        cita_lbl.setForeground(new Color(156, 156, 156));

        JLabel horario_lbl = new JLabel();
        horario_lbl.setText("Horario: ");
        horario_lbl.setForeground(new Color(156, 156, 156));

        JLabel combo3_lbl = new JLabel();
        combo3_lbl.setText("Curso: ");
        combo3_lbl.setForeground(new Color(156, 156, 156));

        JLabel combo4_lbl = new JLabel();
        combo4_lbl.setText("Psicólogo: ");
        combo4_lbl.setForeground(new Color(156, 156, 156));

        JLabel clock2_lbl = new JLabel();
        clock2_lbl.setText("Registro: ");
        clock2_lbl.setForeground(new Color(156, 156, 156));

        Solicitud = new JLabel();

        info_panel.AddObject(id_lbl, 80, 20, LEFT);
        info_panel.AddObject(modificar_cita_id_txt, 160, 20, LEFT);
        modificar_cita_id_txt.setEditable(false);

        info_panel.AddObject(expediente_lbl, 100, 20, LEFT);
        info_panel.AddObject(modificar_cita_expediente_txt, 120, 20, LEFT);
        modificar_cita_expediente_txt.setEditable(false);
        info_panel.newLine();

        info_panel.AddObject(nombre_lbl, 80, 20, LEFT);
        info_panel.AddObject(modificar_cita_nombre_txt, 160, 20, LEFT);
        modificar_cita_nombre_txt.setEditable(false);

        info_panel.AddObject(apellido_lbl, 60, 20, LEFT);
        info_panel.AddObject(modificar_cita_apellido_txt, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(horario_lbl, 80, 20, LEFT);
        info_panel.AddObject(modificar_cita_horario_txt, 160, 20, LEFT);
        modificar_cita_horario_txt.setEditable(false);
        info_panel.newLine();

        info_panel.AddObject(cita_lbl, 80, 20, LEFT);
        info_panel.AddObject(modificar_cita_cita_txt, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(combo3_lbl, 80, 20, LEFT);
        info_panel.AddObject(modificar_cita_curso_cbm, 160, 20, LEFT);

        info_panel.AddObject(combo4_lbl, 60, 20, LEFT);
        info_panel.AddObject(modificar_cita_psicologo_cbm, 160, 20, LEFT);
        info_panel.AddObject(btn_guardar_modificar_cita, 100, 60, LEFT);
        info_panel.newLine();

        info_panel.AddObject(clock2_lbl, 80, 20, LEFT);
        info_panel.AddObject(Solicitud, 200, 20, LEFT);
        info_panel.newLine();

        info_panel.add(fondo_label);
    }
    
    public void Ayuda_citas(){
        
        try {
            String url = System.getProperty("user.dir") + ("//src//Img//citas.mp4");
            ProcessBuilder p = new ProcessBuilder();
            p.command("cmd.exe", "/c", url);
            p.start();
        } catch (IOException exe) {
        };
    }
////////////////////PSICOLOGOS/////////////////////////////// 
    public iTextField txt_ideliminarPsicologos = new iTextField("", 6);
    public iTextField txt_passwordPsicologo = new iTextField("", 6);
    public iButtonFake btn_eliminarbueyes = new iButtonFake("Eliminar", "Todos", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.INPUT);

    public void eliminarPsicologos() {
        info_panel.dispose();
        info_panel.repaint();
        JLabel lbl_NombrePsicologo = new JLabel();
        lbl_NombrePsicologo.setText("Id:");
        lbl_NombrePsicologo.setForeground(new Color(156, 156, 156));
        JLabel lbl_Contraseña = new JLabel();
        lbl_Contraseña.setText("Contraseña");
        lbl_Contraseña.setForeground(new Color(156, 156, 156));
        info_panel.AddObject(lbl_NombrePsicologo, 80, 20, LEFT);
        info_panel.AddObject(txt_ideliminarPsicologos, 160, 20, LEFT);
        info_panel.newLine();
        info_panel.AddObject(lbl_Contraseña, 80, 20, LEFT);
        info_panel.AddObject(txt_passwordPsicologo, 160, 20, LEFT);
        info_panel.newLine();
        info_panel.AddObject(btn_eliminarbueyes, 130, 40, CENTER);
        info_panel.newLine();
    }

    public void Mostrar_Cursos() {
        info_panel.dispose();
        info_panel.repaint();

        ArrayList<String> cols = new ArrayList<>();
        iTable tab = null;
        tab = new iTable(cols);
        ResultSet rs = sql.SELECT("SELECT `Siglas`, `Nombre` FROM `Curso`", new ArrayList<>());
        if (sql.Exists(rs)) {
            try {
                if (rs.next()) {
                    for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                        cols.add(rs.getMetaData().getColumnName(i));
                    }
                }

                tab = new iTable(cols);
                ResultSet rt = sql.SELECT("SELECT `Siglas`,`Nombre` FROM  `Curso`", new ArrayList<>());
                while (rt.next()) {
                    Object[] row = new Object[rt.getMetaData().getColumnCount()];
                    for (int i = 1; i <= rt.getMetaData().getColumnCount(); i++) {
                        row[i - 1] = rt.getObject(i);
                    }
                    tab.addrow(row);
                }

            } catch (SQLException ex) {
                System.out.println("no object fetch'd");
            }
        }
        JScrollPane scrollPane = new JScrollPane(tab);
        scrollPane.setBounds(0, 0, 620, 493);
        info_panel.add(scrollPane);

        ImageIcon fondo = new ImageIcon(System.getProperty("user.dir") + ("//src//Img//fondo.png"));
        JLabel fondo_label = new JLabel(fondo);
        fondo_label.setBounds(110, 30, 400, 400);

        info_panel.add(fondo_label);

    }

    public void Mostrar_Psicologos() {
        info_panel.dispose();
        info_panel.repaint();
        ArrayList<String> cols = new ArrayList<>();
        iTable tab = null;

        tab = new iTable(cols);
        ResultSet rs = sql.SELECT("SELECT `idPsicologo`, `Nombre`, `Apellido`, `Carnet`,`Celular`,`Email` FROM `Psicologo`", new ArrayList<>());

        if (sql.Exists(rs)) {
            try {

                if (rs.next()) {
                    for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                        cols.add(rs.getMetaData().getColumnName(i));
                    }
                }

                tab = new iTable(cols);
                ResultSet rt = sql.SELECT("SELECT * FROM  `Psicologo`", new ArrayList<>());
                while (rt.next()) {
                    Object[] row = new Object[rt.getMetaData().getColumnCount()];
                    for (int i = 1; i <= rt.getMetaData().getColumnCount(); i++) {
                        row[i - 1] = rt.getObject(i);
                    }
                    tab.addrow(row);
                }

            } catch (SQLException ex) {
                System.out.println("no object fetch'd");
            }
        }

        JScrollPane scrollPane = new JScrollPane(tab);

        scrollPane.setBounds(0, 0, 620, 493);

        info_panel.add(scrollPane);

        ImageIcon fondo = new ImageIcon(System.getProperty("user.dir") + ("//src//Img//fondo.png"));
        JLabel fondo_label = new JLabel(fondo);
        fondo_label.setBounds(110, 30, 400, 400);

        info_panel.add(fondo_label);
    }

    public void Agregar_Psicologo() {
        info_panel.dispose();
        info_panel.repaint();

        ImageIcon fondo = new ImageIcon(System.getProperty("user.dir") + ("//src//Img//fondo.png"));
        JLabel fondo_label = new JLabel(fondo);
        fondo_label.setBounds(110, 30, 400, 400);

        JLabel lbl_NombrePsicologo = new JLabel();
        lbl_NombrePsicologo.setText("Nombre: ");
        lbl_NombrePsicologo.setForeground(new Color(156, 156, 156));

        JLabel lbl_ApellidosPsicologo = new JLabel();
        lbl_ApellidosPsicologo.setText("Apellidos: ");
        lbl_ApellidosPsicologo.setForeground(new Color(156, 156, 156));

        JLabel lbl_carnet = new JLabel();
        lbl_carnet.setText("Carné: ");
        lbl_carnet.setForeground(new Color(156, 156, 156));

        JLabel lbl_id = new JLabel();
        lbl_id.setText("Cédula: ");
        lbl_id.setForeground(new Color(156, 156, 156));

        JLabel lbl_celular = new JLabel();
        lbl_celular.setText("Teléfono Celular: ");
        lbl_celular.setForeground(new Color(156, 156, 156));

        JLabel lbl_email = new JLabel();
        lbl_email.setText("Correo Electrónico: ");
        lbl_email.setForeground(new Color(156, 156, 156));

        //////////////////////////////////////
        btn_agregar_psicologo.setBorder(2, 2, 2, 2, new Color(162, 202, 202));

        info_panel.AddObject(lbl_id, 80, 20, LEFT);
        info_panel.AddObject(id_psicologo_txt, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(lbl_NombrePsicologo, 80, 20, LEFT);
        info_panel.AddObject(nombre_psicologo_txt, 160, 20, LEFT);

        info_panel.AddObject(lbl_ApellidosPsicologo, 80, 20, LEFT);
        info_panel.AddObject(apellidos_psicologo_txt, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(lbl_carnet, 80, 20, LEFT);
        info_panel.AddObject(carnet_psicologo_txt, 160, 20, LEFT);
        carnet_psicologo_txt.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();

                // Verificar si la tecla pulsada no es un digito
                if (((caracter < '0')
                        || (caracter > '9'))
                        && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
                    e.consume();  // ignorar el evento de teclado
                }
            }
        });
        info_panel.newLine();

        info_panel.AddObject(lbl_celular, 100, 20, LEFT);
        info_panel.AddObject(celular_psicologo_txt, 140, 20, LEFT);
        celular_psicologo_txt.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();

                // Verificar si la tecla pulsada no es un digito
                if (((caracter < '0')
                        || (caracter > '9'))
                        && (caracter != '\b' /*corresponde a BACK_SPACE*/)) {
                    e.consume();  // ignorar el evento de teclado
                }
            }
        });
        info_panel.newLine();

        info_panel.AddObject(lbl_email, 120, 20, LEFT);
        info_panel.AddObject(email_psicologo_txt, 120, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(btn_agregar_psicologo, 130, 40, CENTER);
        info_panel.newLine();

        info_panel.add(fondo_label);
    }

    public void Agregar_Curso() {
        info_panel.dispose();
        info_panel.repaint();

        ImageIcon fondo = new ImageIcon(System.getProperty("user.dir") + ("//src//Img//fondo.png"));
        JLabel fondo_label = new JLabel(fondo);
        fondo_label.setBounds(110, 30, 400, 400);

        JLabel lbl_nombreCurso = new JLabel();
        lbl_nombreCurso.setText("Nombre Curso: ");
        lbl_nombreCurso.setForeground(new Color(156, 156, 156));

        JLabel lbl_siglasCurso = new JLabel();
        lbl_siglasCurso.setText("Siglas: ");
        lbl_siglasCurso.setForeground(new Color(156, 156, 156));

        ///////////////////////////////
        btn_agregar_curso.setBorder(2, 2, 2, 2, new Color(162, 202, 202));

        info_panel.AddObject(lbl_nombreCurso, 100, 20, LEFT);
        info_panel.AddObject(nombre_curso_txt, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(lbl_siglasCurso, 100, 20, LEFT);
        info_panel.AddObject(siglas_curso_txt, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(btn_agregar_curso, 130, 40, CENTER);
        info_panel.newLine();

        info_panel.add(fondo_label);
    }

    public void Eliminar_Curso() {
        info_panel.dispose();
        info_panel.repaint();

        ImageIcon fondo = new ImageIcon(System.getProperty("user.dir") + ("//src//Img//fondo.png"));
        JLabel fondo_label = new JLabel(fondo);
        fondo_label.setBounds(110, 30, 400, 400);

        JLabel lbl_titulo = new JLabel();
        lbl_titulo.setText("Digite el curso a eliminar: ");
        lbl_titulo.setForeground(new Color(156, 156, 156));

        btn_curso_eliminar.setBorder(2, 2, 2, 2, new Color(162, 202, 202));

        info_panel.AddObject(lbl_titulo, 150, 20, LEFT);
        info_panel.AddObject(curso_eliminar_txt, 150, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(btn_curso_eliminar, 130, 40, CENTER);
        info_panel.newLine();

        info_panel.add(fondo_label);
    }

    ////////////JUSTIFICACION///////////////////////////////////
    public void Generar_Justificaccion() throws IOException {
        info_panel.dispose();
        info_panel.repaint();

        ImageIcon fondo = new ImageIcon(System.getProperty("user.dir") + ("//src//Img//fondo.png"));
        JLabel fondo_label = new JLabel(fondo);
        fondo_label.setBounds(110, 30, 400, 400);

        try {
            String url = System.getProperty("user.dir") + ("//src//Img//Justificacion Proyecto.docx");
            ProcessBuilder p = new ProcessBuilder();
            p.command("cmd.exe", "/c", url);
            p.start();
        } catch (IOException exe) {
        }
        btn_generar_justi.setBorder(2, 2, 2, 2, new Color(162, 202, 202));
        btn_Imprimir_justi.setBorder(2, 2, 2, 2, new Color(162, 202, 202));
        ;
        info_panel.newLine();

        info_panel.add(fondo_label);
    }

    public void LimpiarCasillas() {

        nid_txt.setText("");
        nnombre_txt.setText("");
        napellido_txt.setText("");
        nedad_txt.setText("");
        nreferencia_txt.setText("");
        nocupacion_txt.setText("");
        ndireccion_txt.setText("");
        ntelefono_txt.setText("");
        nemail_txt.setText("");
        nmotivo_txt.setText("");
        nhorario_txt.setText("");
        ndetalle_txt.setText("");
        nsolicitante_txt.setText("");

        ///ADOLESCENTE///
        adolescente_id_txt.setText("");
        adolescente_nombre_txt.setText("");
        adolescente_apellido_txt.setText("");
        adolescente_edad_txt.setText("");
        adolescente_referencia_txt.setText("");
        adolescente_ocupacion_txt.setText("");
        adolescente_direccion_txt.setText("");
        adolescente_telefono_txt.setText("");
        adolescente_email_txt.setText("");
        adolescente_motivo_txt.setText("");
        adolescente_horario_txt.setText("");
        adolescente_detalle_txt.setText("");
        adolescente_solicitante_txt.setText("");

        ///ADULTO///
        adulto_id_txt.setText("");
        adulto_nombre_txt.setText("");
        adulto_apellido_txt.setText("");
        adulto_edad_txt.setText("");
        adulto_referencia_txt.setText("");
        adulto_ocupacion_txt.setText("");
        adulto_direccion_txt.setText("");
        adulto_telefono_txt.setText("");
        adulto_email_txt.setText("");
        adulto_motivo_txt.setText("");
        adulto_horario_txt.setText("");
        adulto_detalle_txt.setText("");
        adulto_solicitante_txt.setText("");

        ///PAREJA///
        pareja_id_txt.setText("");

        pareja_apellido_txt.setText("");
        pareja_nombre_txt.setText("");
        pareja_edad_txt.setText("");

        pareja_referencia_txt.setText("");
        pareja_ocupacion_txt.setText("");

        pareja_direccion_txt.setText("");
        pareja_telefono_txt.setText("");

        pareja_email_txt.setText("");
        pareja_motivo_txt.setText("");
        pareja_horario_txt.setText("");
        pareja_detalle_txt.setText("");
        pareja_solicitante_txt.setText("");

        ///FAMILIA///
        familia_id_txt.setText("");
        familia_nombre_txt.setText("");
        familia_apellido_txt.setText("");
        familia_integrantes_txt.setText("");
        familia_edad_txt.setText("");
        familia_referencia_txt.setText("");
        familia_ocupacion_txt.setText("");
        familia_direccion_txt.setText("");
        familia_telefono_txt.setText("");
        familia_email_txt.setText("");
        familia_motivo_txt.setText("");
        familia_horario_txt.setText("");
        familia_detalle_txt.setText("");
        familia_solicitante_txt.setText("");

        ///MODIFICAR PERSONA///
        modificar_persona_id_txt.setText("");
        modificar_persona_nombre_txt.setText("");
        modificar_persona_apellido_txt.setText("");
        modificar_persona_edad_txt.setText("");
        modificar_persona_integrantes_txt.setText("");
        modificar_persona_referencia_txt.setText("");
        modificar_persona_ocupacion_txt.setText("");
        modificar_persona_direccion_txt.setText("");
        modificar_persona_telefono_txt.setText("");
        modificar_persona_email_txt.setText("");
        modificar_persona_motivo_txt.setText("");
        modificar_persona_horario_txt.setText("");
        modificar_persona_detalle_txt.setText("");
        modificar_persona_solicitante_txt.setText("");
        modificar_persona_cita_txt.setText("");
        modificar_persona_expediente_txt.setText("");

        ///////////////////////AGREGAR PSICOLOGO
        nombre_psicologo_txt.setText("");
        apellidos_psicologo_txt.setText("");
        carnet_psicologo_txt.setText("");
        id_psicologo_txt.setText("");
        celular_psicologo_txt.setText("");
        email_psicologo_txt.setText("");
        //////////////////////ELIMINAR PSICOLOGO

        /////////////////////AGREGAR CURSO
        nombre_curso_txt.setText("");
        siglas_curso_txt.setText("");
        ////////////////////ELIMINAR CURSO
        curso_eliminar_txt.setText("");
        ////////////   generar Justificacion 
        generar_justi_txt.setText("");
        nombre_justi_txt.setText("");
        apellidos_justi_txt.setText("");
        cedula_justi_txt.setText("");
        telefono_justi_txt.setText("");
        hotario_justi_txt.setText("");

    }

}
