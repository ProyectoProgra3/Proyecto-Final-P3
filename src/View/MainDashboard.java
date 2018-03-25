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
import javafx.geometry.Pos;
import static javafx.geometry.Pos.BOTTOM_CENTER;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.SwingConstants.BOTTOM;
import static javax.swing.SwingConstants.CENTER;
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
    
    
    
    //Botones PANEL SUPERIOR
    public iButtonFake btn_niño = new iButtonFake("Niño", " Tipo Paciente", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.CHILD_CARE);
    public iButtonFake btn_adol = new iButtonFake("Adolescente", " Tipo Paciente", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.ACCESSIBILITY);
    public iButtonFake btn_pareja = new iButtonFake("Pareja", " Tipo Paciente", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.WC);
    public iButtonFake btn_fam = new iButtonFake("Familia", " Tipo Paciente", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.PEOPLE);

    //Botónes asociados a CITA
    public iButtonFake btn_ced = new iButtonFake("Cédula", "Tipo Búsqueda", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.ACCOUNT_BALANCE_WALLET);
    public iButtonFake btn_type = new iButtonFake("Tipo Paciente", " Tipo Búsqueda", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.ACCOUNT_BALANCE_WALLET);
    // Botones  modificar 
    public iButtonFake btn_solicitudes = new iButtonFake("Solicitud", "Expediente", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.ACCOUNT_BALANCE_WALLET);
    public iButtonFake btn_clinica = new iButtonFake("Clínica", " Expediente", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.ACCOUNT_BALANCE_WALLET);
    public iButtonFake btn_Lnegra = new iButtonFake("Lista Negra", " Expedientes", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.ACCOUNT_BALANCE_WALLET);
    // BOTONES Psicologis 
    public iButtonFake btn_mosPsico = new iButtonFake("Mostar Psicólogos", "Psicólogos", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.VISIBILITY);
    public iButtonFake btn_agrePsico = new iButtonFake("Agregar Psicólogos", "Psicólogos", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.GROUP_ADD);
    public iButtonFake btn_eliPsico = new iButtonFake("Eliminar Psicólogos", "Psicólogos", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.DELETE);
    public iButtonFake btn_eliTodos = new iButtonFake("Eliminar Todos ", "Psicólogos", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.DELETE_FOREVER);

    //Botones Cursos
    public iButtonFake btn_eliminar = new iButtonFake("Eliminar", "Curso", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.DELETE_SWEEP);
    public iButtonFake btn_agrcurso = new iButtonFake("Agregar", "Curso", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.LIBRARY_ADD);
 
    
    
    //Botones justificacion
    public iButtonFake btn_justi = new iButtonFake("Generar Justificación", "", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.INSERT_CHART);
    public iButtonFake btn_justi_print = new iButtonFake("Imprimir", "Imprimir justificación", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.PRINT);

    //Boton Reportes
    public iButtonFake btn_report_diario = new iButtonFake("Diario", "Reporte Diario", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.TODAY);
    public iButtonFake btn_report_semanal = new iButtonFake("Semanal", "Reporte Semanal", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.DATE_RANGE);
    public iButtonFake btn_report_mensual = new iButtonFake("Mensual", "Reporte Mensual", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.EVENT_NOTE	);

    ///////////////////////////////////////////////////////////////////////////
    //// CONTENIDO DEL PANEL DE INFORMACIÓN////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    ///NIÑO///
    public iTextField nid_txt = new iTextField("Digite ID", 6);
    public iTextField nnombre_txt = new iTextField("Digite Nombre", 6);
    public iTextField napellido_txt = new iTextField("Digite Apellido", 6);
    public iTextField nedad_txt = new iTextField("Digite Edad", 6);
    public iTextField nreferencia_txt = new iTextField("Digite Referencia", 6);
    public iTextField nocupacion_txt = new iTextField("Digite Ocupación", 6);
    public iTextField ndireccion_txt = new iTextField("Digite Dirección", 6);
    public iTextField ntelefono_txt = new iTextField("Digite Teléfono", 6);
    public iTextField nemail_txt = new iTextField("Digite Correo", 6);
    public iTextField nmotivo_txt = new iTextField("Digite Motivo", 6);
    public iTextField nhorario_txt = new iTextField("Digite Horario", 6);
    public iTextField ndetalle_txt = new iTextField("Digite Detalle de Horario", 6);
    public iTextField nsolicitante_txt = new iTextField("Digite Nombre de Solicitante", 6);
    public iButtonFake btn_agr = new iButtonFake("Agregar", " Tipo Paciente", new Color(255, 255, 255), new Color(137, 185, 185), new Color(247, 247, 247), new Color(106, 203, 214).darker(), GoogleMaterialDesignIcons.INPUT);
    public iComboCheckBox tipo_cbm = new iComboCheckBox();
    
    public MainDashboard() {

        dash_frm = new iFrame(80.0f, 80.0f, 5, 2,"", JFrame.EXIT_ON_CLOSE);
        menu_panel  = new iPanel(0, 30, 200, 0, 5, 5, dash_frm);
        menu_panel.setResponsiveHeight(100.0f, 30);
        search_panel = new iPanel(200, 30, 0, 60, 2, -5, dash_frm);
        search_panel.setResponsiveWidth(100.0f, 200);
        info_panel = new iPanel(200, 90, 0, 0, 5, 5, dash_frm);
        info_panel.setResponsiveWidth(100.0f, 200);
        info_panel.setResponsiveHeight(100.0f, 90);
        info_panel.setBackground(new Color(255, 255, 255));
        dash_frm.setHeaderBackground(new Color(106, 203, 214));
        
        initComponents();
    }

    public void initComponents() {

        //Panel del Menú   
        JLabel triage_lbl = new JLabel();
        triage_lbl.setBounds(60, -40, 150, 150);
        triage_lbl.setFont(new Font("Broadway", 1, 20));
        triage_lbl.setForeground(new Color(247, 247, 247));
        triage_lbl.setText("INICIO");

        menu_panel.setBackground(new Color(106, 203, 214));

        //*** Aquí agregamos los FAKE BUTTONS al panel, (Nombre, largo, ancho, posición)
        menu_panel.AddSingleObject(triage_lbl, 180, 40, LEFT);
        menu_panel.AddSingleObject(btn_agregar, 180, 40, LEFT);
        menu_panel.AddSingleObject(btn_modif, 180, 40, LEFT);
        menu_panel.AddSingleObject(btn_citas, 95, 40, LEFT);
        menu_panel.AddSingleObject(btn_psico, 135, 40, LEFT);
        menu_panel.AddSingleObject(btn_curso, 105, 40, LEFT);
        menu_panel.AddSingleObject(btn_just, 140, 40, LEFT);
        menu_panel.AddSingleObject(btn_report, 120, 40, LEFT);
        menu_panel.newLine();

        
        search_panel.setBackground(new Color(137, 185, 185));


        //Panel de información (Aqui se desplegaría toda la información)
        
 ///////////////////////////////////////////////////////////////////////////////       
        JLabel id_lbl = new JLabel();
        id_lbl.setText("ID: ");
        id_lbl.setForeground(new Color(156, 156, 156));
        id_lbl.setBounds(10, 10, 50, 20);
        nid_txt.setBounds(90, 10, 140, 20);
        
        JLabel nombre_lbl = new JLabel();
        nombre_lbl.setText("Nombre: ");
        nombre_lbl.setForeground(new Color(156, 156, 156));
        nombre_lbl.setBounds(10, 50, 60, 20);
        nnombre_txt.setBounds(90, 50, 140, 20);
        
        JLabel apellido_lbl = new JLabel();
        apellido_lbl.setText("Apellido: ");
        apellido_lbl.setForeground(new Color(156, 156, 156));
        apellido_lbl.setBounds(260, 50, 60, 20);
        napellido_txt.setBounds(320, 50, 140, 20);
        
        JLabel edad_lbl = new JLabel();
        edad_lbl.setText("Edad: ");
        edad_lbl.setForeground(new Color(156, 156, 156));
        edad_lbl.setBounds(10, 90, 50, 20);
        nedad_txt.setBounds(90, 90, 140, 20);
        
        JLabel referencia_lbl = new JLabel();
        referencia_lbl.setText("Referencia: ");
        referencia_lbl.setForeground(new Color(156, 156, 156));
        referencia_lbl.setBounds(10, 130, 70, 20);
        nreferencia_txt.setBounds(90, 130, 140, 20);
        
        JLabel ocupacion_lbl = new JLabel();
        ocupacion_lbl.setText("Ocupación: ");
        ocupacion_lbl.setForeground(new Color(156, 156, 156));
        ocupacion_lbl.setBounds(10, 170, 70, 20);
        nocupacion_txt.setBounds(90, 170, 140, 20);
        
        JLabel direccion_lbl = new JLabel();
        direccion_lbl.setText("Dirección: ");
        direccion_lbl.setForeground(new Color(156, 156, 156));
        direccion_lbl.setBounds(10, 210, 70, 20);
        ndireccion_txt.setBounds(90, 210, 440, 20);
        
        JLabel telefono_lbl = new JLabel();
        telefono_lbl.setText("Teléfono: ");
        telefono_lbl.setForeground(new Color(156, 156, 156));
        telefono_lbl.setBounds(10, 250, 70, 20);
        ntelefono_txt.setBounds(90, 250, 140, 20);
        
        JLabel email_lbl = new JLabel();
        email_lbl.setText("Correo: ");
        email_lbl.setForeground(new Color(156, 156, 156));
        email_lbl.setBounds(260, 250, 70, 20);
        nemail_txt.setBounds(320, 250, 140, 20);
        
        JLabel motivo_lbl = new JLabel();
        motivo_lbl.setText("Motivo: ");
        motivo_lbl.setForeground(new Color(156, 156, 156));
        motivo_lbl.setBounds(10, 290, 70, 20);
        nmotivo_txt.setBounds(90, 290, 220, 60);
        
        JLabel horario_lbl = new JLabel();
        horario_lbl.setText("Horario: ");
        horario_lbl.setForeground(new Color(156, 156, 156));
        horario_lbl.setBounds(10, 370, 70, 20);
        nhorario_txt.setBounds(90, 370, 140, 20);
        
        JLabel detalle_lbl = new JLabel();
        detalle_lbl.setText("Detalle: ");
        detalle_lbl.setForeground(new Color(156, 156, 156));
        detalle_lbl.setBounds(10, 410, 70, 20);
        ndetalle_txt.setBounds(90, 410, 140, 20);
        
        JLabel solicitante_lbl = new JLabel();
        solicitante_lbl.setText("Solicitante: ");
        solicitante_lbl.setForeground(new Color(156, 156, 156));
        solicitante_lbl.setBounds(10, 450, 70, 20);
        nsolicitante_txt.setBounds(90, 450, 140, 20);
        
        tipo_cbm.setBounds(90, 500, 70, 20);
        btn_agr.setBounds(550, 410, 100, 60);
        btn_agr.setBorder(2, 2, 2, 2, new Color(162, 202, 202));
  //////////////////////////////////////////////////////////////////////////////      

        //clock
        iClock clock = new iClock(80, 100, 100, 100);
        clock.setForeground(new Color(247, 247, 247));
        clock.setFont(new Font("Rockwell", 1, 12));
        clock.setBounds(65, 450, 80, 100);

        ImageIcon fondo = new ImageIcon("C:/Users/crodas/Pictures/fondo.png");
        JLabel fondo_label = new JLabel(fondo);
        fondo_label.setBounds(150, 60, 400, 400);
        
        
        
        info_panel.add(id_lbl);
        info_panel.add(nid_txt);
        info_panel.add(nombre_lbl);
        info_panel.add(nnombre_txt);
        info_panel.add(apellido_lbl);
        info_panel.add(napellido_txt);
        info_panel.add(edad_lbl);
        info_panel.add(nedad_txt);
        info_panel.add(referencia_lbl);
        info_panel.add(nreferencia_txt);
        info_panel.add(ocupacion_lbl);
        info_panel.add(nocupacion_txt);
        info_panel.add(direccion_lbl);
        info_panel.add(ndireccion_txt);
        info_panel.add(telefono_lbl);
        info_panel.add(ntelefono_txt);
        info_panel.add(email_lbl);
        info_panel.add(nemail_txt);
        info_panel.add(motivo_lbl);
        info_panel.add(nmotivo_txt);
        info_panel.add(horario_lbl);
        info_panel.add(nhorario_txt);
        info_panel.add(detalle_lbl);
        info_panel.add(ndetalle_txt);
        info_panel.add(solicitante_lbl);
        info_panel.add(nsolicitante_txt);
        info_panel.add(btn_agr);
      //info_panel.add(tipo_cbm);
                
        menu_panel.add(clock);
        info_panel.add(fondo_label);
        dash_frm.add(info_panel);
        dash_frm.add(search_panel);
        dash_frm.add(menu_panel);
        dash_frm.finalice();
    }

    //Metódos para cargar botones al panel
    public void BtnAregarSolic() {
        //Metodo para cargar botones al clickear "AGREGAR SOLICITUD"    
        search_panel.dispose();
        search_panel.repaint();
        search_panel.AddObject(btn_fam, 100, 60, 325);
        btn_fam.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
        search_panel.AddObject(btn_pareja, 100, 60, 225);
        btn_pareja.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
        search_panel.AddObject(btn_adol, 125, 60, 100);
        btn_adol.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
        search_panel.AddObject(btn_niño, 100, 60, -1);
        btn_niño.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
        search_panel.newLine();
        search_panel.finalice();

    }

    public void Btn_Cita() {
        //Metodo para cargar botones al clickear "CITAS"
        search_panel.dispose();
        search_panel.repaint();
        search_panel.AddObject(btn_type, 150, 60, 99);
        btn_type.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
        search_panel.AddObject(btn_ced, 100, 60, -1);
        btn_ced.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
        search_panel.newLine();
        //hola
        //holaMario
    }

    public void BtnExpedientes() {
        //Panel de busquedas      
        search_panel.dispose();
        search_panel.repaint();
        search_panel.AddObject(btn_solicitudes, 120, 60, 243);
        btn_solicitudes.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
        search_panel.AddObject(btn_clinica, 120, 60, 123);
        btn_clinica.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
        search_panel.AddObject(btn_Lnegra, 120, 60, -1);
        btn_Lnegra.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
        search_panel.newLine();
    }

    public void BtnPsicologos() {
        //Panel de busquedas        
        search_panel.dispose();
        search_panel.repaint();  
        search_panel.AddObject(btn_eliTodos, 135, 60, 407);
        btn_eliTodos.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
        search_panel.AddObject(btn_eliPsico, 135, 60, 272);
        btn_eliPsico.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
        search_panel.AddObject(btn_agrePsico, 135, 60, 135);
        btn_agrePsico.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
        search_panel.AddObject(btn_mosPsico, 135, 60, -1);
        btn_mosPsico.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
        search_panel.newLine();
    }
    
    public void BtnCurso(){
        //Metodo para cargar botones al clickear "CURSOS"
        search_panel.dispose();
        search_panel.repaint();                
        search_panel.AddObject(btn_eliminar, 120, 60, 123);
        btn_eliminar.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
        search_panel.AddObject(btn_agrcurso, 120, 60, -1);
        btn_agrcurso.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
        search_panel.newLine();
    }

    public void BtnJustificacion() {
        search_panel.dispose();
        search_panel.repaint();
        search_panel.AddObject(btn_justi, 140, 60, 129);
        btn_justi.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
        search_panel.AddObject(btn_justi_print, 130, 60, -1);
        btn_justi_print.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
        search_panel.newLine();
    }

    public void BtnReportes() {
        search_panel.dispose();
        search_panel.repaint();
        search_panel.AddObject(btn_report_diario, 120, 60, 240);
        btn_report_diario.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
        search_panel.AddObject(btn_report_semanal, 120, 60, 120);
        btn_report_semanal.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
        search_panel.AddObject(btn_report_mensual, 120, 60, -1);
        btn_report_mensual.setBorder(0, 0, 0, 1, new Color(162, 202, 202));
        search_panel.newLine();
    }

}
