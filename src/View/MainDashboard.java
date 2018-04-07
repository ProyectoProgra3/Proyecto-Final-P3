/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

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
import java.io.File;
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

    //BUSQUEDA RÁPIDA//
    public JTable busquedas;
    public iButtonFake btn_busqueda_rapida = new iButtonFake("Buscar", "", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.SEARCH);

    //Botones PANEL SUPERIOR
    //Botones asociados a Agregar solicitud
    public iButtonFake btn_niño = new iButtonFake("Niño", " Tipo Paciente", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.CHILD_CARE);
    public iButtonFake btn_adol = new iButtonFake("Adolescente", " Tipo Paciente", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.ACCESSIBILITY);
    public iButtonFake btn_adulto = new iButtonFake("Adulto", " Tipo Paciente", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.DIRECTIONS_WALK);
    public iButtonFake btn_pareja = new iButtonFake("Pareja", " Tipo Paciente", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.WC);
    public iButtonFake btn_fam = new iButtonFake("Familia", " Tipo Paciente", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.PEOPLE);

    //Botónes asociados a CITA
    public iButtonFake btn_ced = new iButtonFake("Cédula", "Tipo Búsqueda", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.ACCOUNT_BALANCE_WALLET);
    public iButtonFake btn_type = new iButtonFake("Tipo Paciente", " Tipo Búsqueda", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.ACCOUNT_BALANCE_WALLET);

    // Botones  modificar 
    public iTextField modificar_persona_txt = new iTextField("", 6);
    public iComboCheckBox modificar_persona_cbm;
    public iButtonFake btn_buscar_modificar_persona = new iButtonFake("Buscar", " Persona", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.SEARCH);

    // BOTONES Psicologis 
    public iButtonFake btn_mosPsico = new iButtonFake("Mostar Psicólogos", "Psicólogos", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.VISIBILITY);
    public iButtonFake btn_agrePsico = new iButtonFake("Agregar Psicólogos", "Psicólogos", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.GROUP_ADD);
    public iButtonFake btn_eliPsico = new iButtonFake("Eliminar Psicólogos", "Psicólogos", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.DELETE);
    public iButtonFake btn_eliTodos = new iButtonFake("Eliminar Todos ", "Psicólogos", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.DELETE_FOREVER);

    //Botones Cursos
    public iButtonFake btn_mosCurso = new iButtonFake("Mostar Cursos", "Cursos", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.VISIBILITY);
    public iButtonFake btn_eliminar = new iButtonFake("Eliminar", "Curso", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.DELETE_SWEEP);
    public iButtonFake btn_agrcurso = new iButtonFake("Agregar", "Curso", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.LIBRARY_ADD);

    //Botones justificacion
    public iButtonFake btn_justi = new iButtonFake("Justificación", " Generar Justificacion", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.INSERT_CHART);
    /* public iButtonFake btn_justi_print = new iButtonFake("Imprimir", "Imprimir justificación", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.PRINT);*/

    //Boton Reportes
    public iButtonFake btn_report_diario = new iButtonFake("Diario", "Reporte Diario", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.TODAY);
    public iButtonFake btn_report_semanal = new iButtonFake("Semanal", "Reporte Semanal", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.DATE_RANGE);
    public iButtonFake btn_report_mensual = new iButtonFake("Mensual", "Reporte Mensual", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.EVENT_NOTE);

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
    public iTextField pareja2_id_txt = new iTextField("", 6);
    public iTextField pareja_apellido_txt = new iTextField("", 6);
    public iTextField pareja_nombre_txt = new iTextField("", 6);
    public iTextField pareja_edad_txt = new iTextField("", 6);
    public iTextField pareja2_edad_txt = new iTextField("", 6);
    public iTextField pareja_referencia_txt = new iTextField("", 6);
    public iTextField pareja_ocupacion_txt = new iTextField("", 6);
    public iTextField pareja2_ocupacion_txt = new iTextField("", 6);
    public iTextField pareja_direccion_txt = new iTextField("", 6);
    public iTextField pareja_telefono_txt = new iTextField("", 6);
    public iTextField pareja2_telefono_txt = new iTextField("", 6);
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

    ///////////////////////AGREGAR PSICOLOGO
    public iTextField nombre_psicologo_txt = new iTextField("", 6);
    public iTextField apellidos_psicologo_txt = new iTextField("", 6);
    public iTextField carnet_psicologo_txt = new iTextField("", 6);
    public iTextField id_psicologo_txt = new iTextField("",6);
    public iTextField celular_psicologo_txt = new iTextField("",6);
    public iTextField email_psicologo_txt = new iTextField("",6);
    public iButtonFake btn_agregar_psicologo = new iButtonFake("Agregar", "", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.INPUT);
    //////////////////////ELIMINAR PSICOLOGO
    public iTextField eliminar_nombre_psicologo_txt = new iTextField("", 6);
    public iTextField eliminar_apellidos_psicologo_txt = new iTextField("", 6);
    public iButtonFake btn_psicologo_eliminar = new iButtonFake("Eliminar", "", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.INPUT);
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

    public MainDashboard() {
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
        busquedas = new JTable();

        initComponents();
    }

    public void initComponents() {

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
        info_panel.AddObject(btn_busqueda_rapida, 80, 30, LEFT);
        info_panel.newLine();
        info_panel.AddObject(busquedas, 200, 200, CENTER);
        info_panel.newLine();

        //*** Aqui agregamos los FAKE BUTTONS al panel, (Nombre, largo, ancho, posicion)
        menu_panel.AddSingleObject(menu_label, 180, 40, CENTER);
        menu_panel.AddSingleObject(btn_agregar, 171, 40, LEFT);
        menu_panel.AddSingleObject(btn_modif, 172, 40, LEFT);
        menu_panel.AddSingleObject(btn_citas, 95, 40, LEFT);
        menu_panel.AddSingleObject(btn_psico, 135, 40, LEFT);
        menu_panel.AddSingleObject(btn_curso, 105, 40, LEFT);
        menu_panel.AddSingleObject(btn_just, 140, 40, LEFT);
        menu_panel.AddSingleObject(btn_report, 120, 40, LEFT);
        menu_panel.newLine();

        search_panel.setBackground(new Color(137, 185, 185));

        //Panel de informacion (Aqui se desplegara toda la informacion de prueba)
        ///////////////////////////////////////////////////////////////       
        menu_panel.add(clock);
        info_panel.add(fondo_label);
        dash_frm.add(info_panel);
        dash_frm.add(search_panel);
        dash_frm.add(menu_panel);
        dash_frm.finalice();
    }

    //Metódo crear tabla de busqueda rápida//
    public void BtnBusquedaRapida() {

    }

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
        search_panel.AddObject(btn_fam, 100, 60, 425);
        btn_fam.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
        search_panel.AddObject(btn_pareja, 100, 60, 325);
        btn_pareja.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
        search_panel.AddObject(btn_adulto, 100, 60, 225);
        btn_adulto.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
        search_panel.AddObject(btn_adol, 125, 60, 100);
        btn_adol.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
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
        search_panel.AddObject(btn_type, 150, 60, 99);
        btn_type.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
        search_panel.AddObject(btn_ced, 100, 60, -1);
        btn_ced.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
        search_panel.newLine();
        info_panel.add(fondo_label);
        //hola
        //holaMario
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

        search_panel.AddObject(btn_buscar_modificar_persona, 120, 30, 1);
        btn_buscar_modificar_persona.setBorder(0, 1, 0, 0, new Color(162, 202, 202));
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
        search_panel.AddObject(btn_eliTodos, 135, 60, 407);
        btn_eliTodos.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
        search_panel.AddObject(btn_eliPsico, 135, 60, 272);
        btn_eliPsico.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
        search_panel.AddObject(btn_agrePsico, 135, 60, 135);
        btn_agrePsico.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
        search_panel.AddObject(btn_mosPsico, 135, 60, -1);
        btn_mosPsico.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
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
        search_panel.AddObject(btn_justi, 140, 60, 2);
        btn_justi.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
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
        search_panel.AddObject(btn_report_diario, 120, 60, 240);
        btn_report_diario.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
        search_panel.AddObject(btn_report_semanal, 120, 60, 120);
        btn_report_semanal.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
        search_panel.AddObject(btn_report_mensual, 120, 60, -1);
        btn_report_mensual.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
        search_panel.newLine();

        info_panel.add(fondo_label);
    }

///METODOS PARA BOTONES DEL PANEL DE BUSQUEDAS////  
//////////////////////////////////////////////////
/////////////////////AGREGAR SOLICITUD//////////////////////////////    
    public void Agregar_solicitud_niño() {
        info_panel.dispose();
        info_panel.repaint();

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
        telefono_lbl.setText("Teléono: ");
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

    }

    public void Agregar_solicitud_adolescente() {
        info_panel.dispose();
        info_panel.repaint();

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
        telefono_lbl.setText("Teléono: ");
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

    }

    public void Agregar_solicitud_adulto() {
        info_panel.dispose();
        info_panel.repaint();

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
        telefono_lbl.setText("Teléono: ");
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

    }

    public void Agregar_solicitud_pareja() {
        info_panel.dispose();
        info_panel.repaint();

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

    }

    public void Agregar_solicitud_familia() {
        info_panel.dispose();
        info_panel.repaint();

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
        info_panel.newLine();

        info_panel.AddObject(edad_lbl, 80, 20, LEFT);
        info_panel.AddObject(familia_edad_txt, 150, 20, LEFT);
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
        telefono_lbl.setText("Teléono: ");
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

        info_panel.AddObject(expediente_lbl, 60, 20, LEFT);
        info_panel.AddObject(modificar_persona_expediente_txt, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(nombre_lbl, 80, 20, LEFT);
        info_panel.AddObject(modificar_persona_nombre_txt, 160, 20, LEFT);

        info_panel.AddObject(apellido_lbl, 60, 20, LEFT);
        info_panel.AddObject(modificar_persona_apellido_txt, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(edad_lbl, 80, 20, LEFT);
        info_panel.AddObject(modificar_persona_edad_txt, 160, 20, LEFT);
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

////////////////////PSICOLOGOS/////////////////////////////// 
    public void Agregar_Psicologo() {
        info_panel.dispose();
        info_panel.repaint();

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

        info_panel.AddObject(lbl_id, 80,20,LEFT);
        info_panel.AddObject(id_psicologo_txt, 160,20,LEFT);
        info_panel.newLine();
        
        info_panel.AddObject(lbl_NombrePsicologo, 80, 20, LEFT);
        info_panel.AddObject(nombre_psicologo_txt, 160, 20, LEFT);

        info_panel.AddObject(lbl_ApellidosPsicologo, 80, 20, LEFT);
        info_panel.AddObject(apellidos_psicologo_txt, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(lbl_carnet, 80, 20, LEFT);
        info_panel.AddObject(carnet_psicologo_txt, 160, 20, LEFT);
        info_panel.newLine();
        
        info_panel.AddObject(lbl_celular, 100, 20, LEFT);
        info_panel.AddObject(celular_psicologo_txt, 160, 20, LEFT);
        info_panel.newLine();
        
        info_panel.AddObject(lbl_email, 120, 20, LEFT);
        info_panel.AddObject(email_psicologo_txt, 160, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(btn_agregar_psicologo, 130, 40, CENTER);
        info_panel.newLine();
    }

    public void Eliminar_Psicologo() {
        info_panel.dispose();
        info_panel.repaint();

        JLabel lbl_titulo = new JLabel();
        lbl_titulo.setText("Digite el psicologo a eliminar: ");
        lbl_titulo.setForeground(new Color(156, 156, 156));

        JLabel lbl_nombreEliminar = new JLabel();
        lbl_nombreEliminar.setText("Nombre: ");
        lbl_nombreEliminar.setForeground(new Color(156, 156, 156));

        JLabel lbl_apellidoEliminar = new JLabel();
        lbl_apellidoEliminar.setText("Apellido: ");
        lbl_apellidoEliminar.setForeground(new Color(156, 156, 156));

        btn_psicologo_eliminar.setBorder(2, 2, 2, 2, new Color(162, 202, 202));

        info_panel.AddObject(lbl_titulo, 250, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(lbl_nombreEliminar, 60, 20, LEFT);
        info_panel.AddObject(eliminar_nombre_psicologo_txt, 200, 20, LEFT);

        info_panel.AddObject(lbl_apellidoEliminar, 60, 20, LEFT);
        info_panel.AddObject(eliminar_apellidos_psicologo_txt, 200, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(btn_psicologo_eliminar, 130, 40, CENTER);
        info_panel.newLine();
    }

    public void Agregar_Curso() {
        info_panel.dispose();
        info_panel.repaint();

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
    }

    public void Eliminar_Curso() {
        info_panel.dispose();
        info_panel.repaint();

        JLabel lbl_titulo = new JLabel();
        lbl_titulo.setText("Digite el curso a eliminar: ");
        lbl_titulo.setForeground(new Color(156, 156, 156));

        btn_curso_eliminar.setBorder(2, 2, 2, 2, new Color(162, 202, 202));

        info_panel.AddObject(lbl_titulo, 150, 20, LEFT);
        info_panel.AddObject(curso_eliminar_txt, 150, 20, LEFT);
        info_panel.newLine();

        info_panel.AddObject(btn_curso_eliminar, 130, 40, CENTER);
        info_panel.newLine();
    }

    public void Generar_Justificaccion() {
        // Hay que revisarlo para solo agregar el word 

        info_panel.dispose();
        info_panel.repaint();

        JLabel lbl_tituloJust = new JLabel();
        lbl_tituloJust.setText("Justificacion");

        JLabel lbl_Justificacion = new JLabel();

        JLabel lbl_nombre = new JLabel();
        lbl_nombre.setText("Digite el  Nombre Pacinete ");
        lbl_nombre.setForeground(new Color(156, 156, 156));

        JLabel lbl_Apellidos = new JLabel();
        lbl_Apellidos.setText("Digite el Apellidos del Paciente");
        lbl_Apellidos.setForeground(new Color(156, 156, 156));

        JLabel lbl_cedula = new JLabel();
        lbl_cedula.setText("Digite el Cedula del Paciente");
        lbl_cedula.setForeground(new Color(156, 156, 156));

        JLabel lbl_telefono = new JLabel();
        lbl_telefono.setText("Digite el Telefono del Paciente");
        lbl_telefono.setForeground(new Color(156, 156, 156));

        JLabel lbl_horario = new JLabel();
        lbl_horario.setText("Digite el Horario de cita");
        lbl_horario.setForeground(new Color(156, 156, 156));

        btn_generar_justi.setBorder(2, 2, 2, 2, new Color(162, 202, 202));
        btn_Imprimir_justi.setBorder(2, 2, 2, 2, new Color(162, 202, 202));
        info_panel.AddObject(lbl_Justificacion, 80, 20, LEFT);
        info_panel.AddObject(generar_justi_txt, 80, 20, LEFT);

        info_panel.AddObject(lbl_nombre, 80, 20, LEFT);
        info_panel.AddObject(nombre_justi_txt, 80, 20, LEFT);
        info_panel.AddObject(lbl_Apellidos, 80, 20, LEFT);
        info_panel.AddObject(apellidos_justi_txt, 80, 20, LEFT);
        info_panel.AddObject(lbl_cedula, 80, 20, LEFT);
        info_panel.AddObject(cedula_justi_txt, 80, 20, LEFT);
        info_panel.AddObject(lbl_telefono, 80, 20, LEFT);
        info_panel.AddObject(telefono_justi_txt, 80, 20, LEFT);
        info_panel.AddObject(lbl_horario, 80, 20, LEFT);
        info_panel.AddObject(hotario_justi_txt, 80, 20, LEFT);
        info_panel.newLine();
    }
}
