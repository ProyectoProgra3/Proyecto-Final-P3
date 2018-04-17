/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BusinessLogic extends InitModel {

    public BusinessLogic() {

    }

    /**
     * Obtiene la fecha de hoy con la hora actual
     *
     * @param
     * @return String con el formato de fecha y hora
     */
    public String getDate() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");

        return dateFormat.format(date);
    }

    /**
     * Busca Los cursos de la base de datos
     *
     * @param
     * @return ResultSet con los cursos de la base de datos
     */
    public ArrayList addAllPersonassincita() {
        try {
            ArrayList<Object> objs = new ArrayList<>();
            ResultSet rs = sql.SELECT("SELECT  `ID`,  Estado.Estado ,\n"
                    + "Persona.Nombre,  Persona.Apellido,  \n"
                    + "`Telefono`,`Motivo`,"
                    + "`Fecha_Solicitud`"
                    + "FROM `Persona`\n"
                    + "inner join Estado on Persona.Estado_idEstado=Estado.idEstado\n"
                    + "inner join Tipo_de_solicitud on Persona.Tipo_de_solicitud_idSolicitud=Tipo_de_solicitud.idSolicitud\n"
                    + "where Cita = \"0000-00-00\" \n"
                    + "order by Persona.Fecha_Solicitud\n"
                    + "limit 2", objs);

            try {
                if (rs.next()) {
                    for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                        objs.add(rs.getMetaData().getColumnName(i));
                    }
                }
            } catch (Exception e) {
                System.out.println("Error" + e);
            }
            return objs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something was wrong contact the Admin" + e);
            return null;
        }
    }

    public ArrayList<Object[]> addAllPersonasObjectsincita() {
        try {
            ArrayList<Object[]> objs = new ArrayList<>();
            ResultSet rt = sql.SELECT("SELECT  `ID`,  Estado.Estado ,\n"
                    + "Persona.Nombre,  Persona.Apellido,  \n"
                    + "`Telefono`,`Motivo`,"
                    + "`Fecha_Solicitud`"
                    + "FROM `Persona`\n"
                    + "inner join Estado on Persona.Estado_idEstado=Estado.idEstado\n"
                    + "inner join Tipo_de_solicitud on Persona.Tipo_de_solicitud_idSolicitud=Tipo_de_solicitud.idSolicitud\n"
                    + "where Cita = \"0000-00-00\" \n"
                    + "order by Persona.Fecha_Solicitud\n"
                    + "limit 10", new ArrayList<>());

            try {
                while (rt.next()) {
                    Object[] row = new Object[rt.getMetaData().getColumnCount()];
                    for (int i = 1; i <= rt.getMetaData().getColumnCount(); i++) {
                        row[i - 1] = rt.getObject(i);
                    }
                    objs.add(row);
                }
            } catch (Exception e) {
                System.out.println("Error" + e);
            }
            return objs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something was wrong contact the Admin" + e);
            return null;
        }
    }

    public ArrayList addAllPersonascitadia() {
        try {
            ArrayList<Object> objs = new ArrayList<>();
            ResultSet rs = sql.SELECT("SELECT  `ID`,  Estado.Estado ,\n"
                    + "Persona.Nombre,  Persona.Apellido,  \n"
                    + "`Telefono`,`Motivo`,"
                    + "`Fecha_Solicitud`"
                    + "FROM `Persona`\n"
                    + "inner join Estado on Persona.Estado_idEstado=Estado.idEstado\n"
                    + "inner join Tipo_de_solicitud on Persona.Tipo_de_solicitud_idSolicitud=Tipo_de_solicitud.idSolicitud\n"
                    + "where  Cita = CURDATE()"
                    + "order by Persona.Fecha_Solicitud\n"
                    + "limit 25", objs);

            try {
                if (rs.next()) {
                    for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                        objs.add(rs.getMetaData().getColumnName(i));
                    }
                }
            } catch (Exception e) {
                System.out.println("Error" + e);
            }
            return objs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something was wrong contact the Admin" + e);
            return null;
        }
    }

    public ArrayList<Object[]> addAllPersonasObjectcitadia() {
        try {
            ArrayList<Object[]> objs = new ArrayList<>();
            ResultSet rt = sql.SELECT("SELECT  `ID`,  Estado.Estado ,\n"
                    + "Persona.Nombre,  Persona.Apellido,  \n"
                    + "`Telefono`,`Motivo`,"
                    + "`Fecha_Solicitud`"
                    + "FROM `Persona`\n"
                    + "inner join Estado on Persona.Estado_idEstado=Estado.idEstado\n"
                    + "inner join Tipo_de_solicitud on Persona.Tipo_de_solicitud_idSolicitud=Tipo_de_solicitud.idSolicitud\n"
                    + "where Cita = CURDATE()"
                    + "order by Persona.Fecha_Solicitud\n"
                    + "limit 25", new ArrayList<>());

            try {
                while (rt.next()) {
                    Object[] row = new Object[rt.getMetaData().getColumnCount()];
                    for (int i = 1; i <= rt.getMetaData().getColumnCount(); i++) {
                        row[i - 1] = rt.getObject(i);
                    }
                    objs.add(row);
                }
            } catch (Exception e) {
                System.out.println("Error" + e);
            }
            return objs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something was wrong contact the Admin" + e);
            return null;
        }
    }

    public ArrayList SearchCursos() {
        try {
            ArrayList<Object> objs = new ArrayList<>();
            ResultSet rs = sql.SELECT("SELECT `Nombre` FROM Curso ", objs);
            objs.clear();
            try {
                while (rs.next()) {
                    objs.add(rs.getObject("Nombre"));
                }
            } catch (Exception e) {
                System.out.println("Error" + e);
            }
            return objs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something was wrong contact the Admin" + e);
            return null;
        }
    }

    /**
     * Busca los estados de los pacientes
     *
     * @param
     * @return Resultset con los estados de la base de datos
     */
    public ArrayList SearchEstados() {
        try {
            ArrayList<Object> objs = new ArrayList<>();
            ResultSet rs = sql.SELECT("SELECT `Estado` FROM Estado ", objs);
            try {
                while (rs.next()) {
                    objs.add(rs.getObject("Estado"));
                }
            } catch (Exception e) {
                System.out.println("Error" + e);
            }
            return objs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something was wrong contact the Admin" + e);
            return null;
        }
    }

    /**
     * Busca los psicologos
     *
     * @param
     * @return ArrayList con los psicologos de la base de datos
     */
    public ArrayList SearchPsicologos() {
        try {
            ArrayList<Object> objs = new ArrayList<>();
            ResultSet rs = sql.SELECT("SELECT `Nombre` FROM Psicologo ", objs);
            try {
                while (rs.next()) {
                    objs.add(rs.getObject("Nombre"));
                }
            } catch (Exception e) {
                System.out.println("Error" + e);
            }
            return objs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something was wrong contact the Admin" + e);
            return null;
        }
    }

    /**
     * Busca los tipo de solicitud
     *
     * @param
     * @return ArrayList con los tipos de la base de datos
     */
    public ArrayList SearchTipo() {
        try {
            ArrayList<Object> objs = new ArrayList<>();
            ResultSet rs = sql.SELECT("SELECT `Tipo de solicitud` FROM Tipo_de_solicitud ", objs);
            try {
                while (rs.next()) {
                    objs.add(rs.getObject("Tipo de solicitud"));
                }
            } catch (Exception e) {
                System.out.println("Error" + e);
            }
            return objs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something was wrong contact the Admin" + e);
            return null;
        }
    }

    /**
     * Busca los estados iniciales de los pacientes
     *
     * @param
     * @return Resultset con los estados de la base de datos
     */
    public ResultSet SearchEstadosInit() {
        try {
            ArrayList<Object> objs = new ArrayList<>();
            ResultSet rs = sql.SELECT("SELECT `Estado` FROM Estado where `Estado`not like \"En Proceso\" and `Estado`not like \"Seguimiento\" and `Estado`not like \"Caído\" and `Estado`not like \"Cierre\" and `Estado`not like \"Lista Negra\" and `Estado`not like \"Abandono\" ", objs);
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something was wrong contact the Admin" + e);
            return null;
        }
    }

    /**
     * Busca a un paciente por la cedula
     *
     * @param String ID
     * @return ResultSet con todos los dato de la tabla
     */
    public ResultSet SearchbyId(String Id) {
        try {
            ArrayList<Object> objs = new ArrayList<>();
            objs.addAll(Arrays.asList(Id));
            ResultSet rs = sql.SELECT("SELECT  `ID`,  `Estado_idEstado`,  `Tipo_de_solicitud_idSolicitud`,  `Nombre`,  `Apellido`,  `Edad`,  `Telefono`,  `Ocupacion`,`Motivo`,  `Referencia`,  `Detalle_Horario`,  `Email`,  `Detalle`,  `Fecha_Solicitud`,  `NombreSolicitante`,   `Curso_idCurso`,  `Psicologo_idPsicologo`,  `Cita` ,  `Expediente` FROM `Persona` Where ID = ? ; ", objs);
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something was wrong contact the Admin" + e);
            return null;
        }
    }

    public ResultSet SearchbyIdandEstadoCitas(String Id, String Estado) {
        try {
            ArrayList<Object> objs = new ArrayList<>();
            objs.addAll(Arrays.asList(Id, Estado));
            ResultSet rs = sql.SELECT("SELECT  `ID`, "
                    + "Persona.Nombre,"
                    + "Psicologo.Nombre,"
                    + " Persona.Apellido,"
                    + " `Detalle_Horario`,"
                    + " Curso.Nombre, "
                    + " `Cita` , "
                    + "`Expediente` ,"
                    + "Persona.Fecha_Solicitud \n"
                    + "FROM `Persona` \n"
                    + "inner join Curso on Persona.Curso_idCurso= Curso.idCurso\n"
                    + "inner join Psicologo on Persona.Psicologo_idPsicologo=Psicologo.idPsicologo\n"
                    + "Where  ID = ? "
                    + " and `Estado_idEstado`=(Select `idEstado` from `Estado` where Estado = ? ) ", objs);
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something was wrong contact the Admin" + e);
            return null;
        }
    }

    /**
     * Busca a los pacientes por estado
     *
     * @param String ID
     * @return ResultSet con todos los dato de la tabla
     */
    public ResultSet SearchbyEstado(String Estado) {
        try {
            ArrayList<Object> objs = new ArrayList<>();
            objs.addAll(Arrays.asList(Estado));
            ResultSet rs = sql.SELECT("SELECT  `ID`,  `Estado_idEstado`,  `Tipo_de_solicitud_idSolicitud`,  `Nombre`,  `Apellido`,  `Edad`,  `Telefono`,  `Ocupacion`,`Motivo`,  `Referencia`,  `Detalle_Horario`,  `Email`,  `Detalle`,  `Fecha_Solicitud`,  `NombreSolicitante`,   `Curso_idCurso`,  `Psicologo_idPsicologo`,  `Cita` ,  `Expediente` FROM `Persona` Where `Estado_idEstado`=(Select `idEstado` from `Estado` where Estado = ? ) ; ", objs);
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something was wrong contact the Admin" + e);
            return null;
        }
    }

    /**
     * Busca a los pacientes por estado y cedula
     *
     * @param String ID
     * @return ResultSet con todos los dato de la tabla
     */
    public ResultSet SearchbyIdandEstado(String Id, String Estado) {
        try {
            ArrayList<Object> objs = new ArrayList<>();
            objs.addAll(Arrays.asList(Id, Estado));
            ResultSet rs = sql.SELECT("SELECT  `ID`,  Estado.Estado ,\n"
                    + "Tipo_de_solicitud.`Tipo de solicitud`,\n"
                    + "Persona.Nombre,  Persona.Apellido,  \n"
                    + "`Edad`,  `Telefono`,  `Ocupacion`,`Motivo`,\n"
                    + "`Referencia`,  `Detalle_Horario`,  Persona.Email,\n"
                    + "`Detalle`,  `Fecha_Solicitud`,  `NombreSolicitante`, \n"
                    + "Curso.Nombre,  Psicologo.Nombre,  `Cita` ,  \n"
                    + "`Expediente` \n"
                    + "FROM `Persona`\n"
                    + "inner join Curso on Persona.Curso_idCurso= Curso.idCurso\n"
                    + "inner join Psicologo on Persona.Psicologo_idPsicologo=Psicologo.idPsicologo\n"
                    + "inner join Estado on Persona.Estado_idEstado=Estado.idEstado\n"
                    + "inner join Tipo_de_solicitud on Persona.Tipo_de_solicitud_idSolicitud=Tipo_de_solicitud.idSolicitud\n"
                    + "Where  ID = ? and `Estado_idEstado`=(Select `idEstado` from `Estado` where Estado = ?) ", objs);
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something was wrong contact the Admin" + e);
            return null;
        }
    }

    /**
     * Busca a los pacientes por tipo de solicitud y cedula
     *
     * @param String ID , String Tipo de solicitud
     * @return ResultSet con todos los dato de la tabla
     */
    public ResultSet SearchbyIdandTipo(String Id, String Tipo) {
        try {
            ArrayList<Object> objs = new ArrayList<>();
            objs.addAll(Arrays.asList(Id, Tipo));
            ResultSet rs = sql.SELECT("SELECT  `ID`,  Estado.Estado ,\n"
                    + "Tipo_de_solicitud.`Tipo de solicitud`,\n"
                    + "Persona.Nombre,  Persona.Apellido,  \n"
                    + "`Edad`,  `Telefono`,  `Ocupacion`,`Motivo`,\n"
                    + "`Referencia`,  `Detalle_Horario`,  Persona.Email,\n"
                    + "`Detalle`,  `Fecha_Solicitud`,  `NombreSolicitante`, \n"
                    + "Curso.Nombre,  Psicologo.Nombre,  `Cita` ,  \n"
                    + "`Expediente`,`Dir`,`Integrantes` \n"
                    + "FROM `Persona`\n"
                    + "inner join Curso on Persona.Curso_idCurso= Curso.idCurso\n"
                    + "inner join Psicologo on Persona.Psicologo_idPsicologo=Psicologo.idPsicologo\n"
                    + "inner join Estado on Persona.Estado_idEstado=Estado.idEstado\n"
                    + "inner join Tipo_de_solicitud on Persona.Tipo_de_solicitud_idSolicitud=Tipo_de_solicitud.idSolicitud\n"
                    + "Where  ID = ? and `Tipo_de_solicitud_idSolicitud`=(Select `idSolicitud`  from Tipo_de_solicitud where  `Tipo de solicitud` = ?) ; ", objs);
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something was wrong contact the Admin" + e);
            return null;
        }
    }

    /**
     * Busca a un paciente por la cedula
     *
     * @param String Expediente
     * @return ResultSet con todos los dato de la tabla
     */
    public ResultSet SearchbyExpediente(String Expediente) {
        try {
            ArrayList<Object> objs = new ArrayList<>();
            objs.addAll(Arrays.asList(Expediente));
            ResultSet rs = sql.SELECT("SELECT  `ID`, `Estado_idEstado`,  `Tipo_de_solicitud_idSolicitud`,  `Nombre`,  `Apellido`,  `Edad`,  `Telefono`,  `Ocupacion`,`Motivo`,  `Referencia`,  `Detalle_Horario`,  `Email`,  `Detalle`,  `Fecha_Solicitud`,  `NombreSolicitante`,   `Curso_idCurso`,  `Psicologo_idPsicologo`,  `Cita`,  `Expediente` FROM `Persona` Where ID = ? ; ", objs);
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something was wrong contact the Admin" + e);
            return null;
        }
    }

    /**
     * Inserta un curso en la tabla
     *
     * @param String Siglas , String Nombre
     * @return True si se inserta correctamente false si existe algun problema
     */
    public boolean addCurso(String Siglas, String Nombre) {

        ArrayList<Object> objs = new ArrayList<>();
        objs.addAll(Arrays.asList(Siglas, Nombre));
        ResultSet rs = sql.SELECT("SELECT `Nombre` FROM Curso Where `Siglas`=? and `Nombre`=? ", objs);
        if (sql.Exists(rs)) {
            JOptionPane.showMessageDialog(null, "El curso ya existe");
            return false;
        }
        boolean result = sql.exec("INSERT INTO `icompone_mario`.`Curso` (`Siglas`, `Nombre`) VALUES (?, ?)", objs);
        if (result) {
            JOptionPane.showMessageDialog(null, "Se inserto correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Upsss ,Hubo un problema");
        }
        return result;
    }

    public void deleteCurso(String Nombre) {
        ArrayList<Object> objs = new ArrayList<>();
        objs.addAll(Arrays.asList(Nombre));
        ResultSet rs = sql.SELECT("SELECT `Nombre` FROM Curso Where `Nombre`=? ", objs);
        if (!sql.Exists(rs)) {
            JOptionPane.showMessageDialog(null, "El curso no existe");
            return;
        }
        boolean result = sql.exec("delete \n"
                + "from Curso\n"
                + "where Nombre= ?", objs);
        if (result) {
            JOptionPane.showMessageDialog(null, "Se borro corectamente");
        } else {
            JOptionPane.showMessageDialog(null, "Upsss ,Hubo un problema");
        }

    }

    /**
     * Inserta un psicologo en la tabla
     *
     * @param String ID , String Nombre,String Apellido , String Carnet , int
     * celular , String email
     * @return True si se inserta correctamente false si existe algun problema
     */
    public boolean addPsicologo(String id, String Nombre, String Apellido, String Carnet, int celular, String email) {
        ArrayList<Object> objs = new ArrayList<>();
        objs.addAll(Arrays.asList(id, Nombre));
        try {
            ResultSet rs = sql.SELECT("SELECT `idPsicologo` FROM `Psicologo` Where `idPsicologo`=? and `Nombre`=? ", objs);
            if (sql.Exists(rs)) {
                JOptionPane.showMessageDialog(null, "Este psicologo ya existe");
                return false;
            }
            ArrayList<Object> objs1 = new ArrayList<>();
            objs1.addAll(Arrays.asList(id, Nombre, Apellido, Carnet, celular, email));
            boolean result = sql.exec("INSERT INTO `icompone_mario`.`Psicologo` (`idPsicologo`, `Nombre`, `Apellido`, `Carnet`, `Celular`, `Email`) VALUES (?, ?, ?, ?, ?, ?);", objs1);
            if (result) {
                JOptionPane.showMessageDialog(null, "Se inserto correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Upsss ,Hubo un problema");
            }
            return result;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * Modifica un psicologo en la tabla
     *
     * @param String ID , String Nombre,String Apellido , String Carnet , int
     * celular , String email
     * @return True si se inserta correctamente false si existe algun problema
     */
    public boolean modifyPsicologo(String id, String Nombre, String Apellido, String Carnet, int celular, String email) {

        ArrayList<Object> objs1 = new ArrayList<>();
        objs1.addAll(Arrays.asList(id, Nombre, Apellido, Carnet, celular, email, id));
        boolean result = sql.exec("UPDATE `icompone_mario`.`Psicologo` SET `idPsicologo`= ?, `Nombre`= ? , `Apellido`=? , `Carnet`= ?, `Celular`= ?, `Email`= ? WHERE  `idPsicologo`= ?;", objs1);
        if (result) {
            JOptionPane.showMessageDialog(null, "Se modifico correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Upsss ,Hubo un problema");
        }
        return result;

    }

    /**
     * Elimina los psicologos de la tabla
     *
     * @param
     * @return True si se realiza correctamente false si existe algun problema
     */
    public boolean DeletePsicologos() {
        ArrayList<Object> objs1 = new ArrayList<>();
        objs1.addAll(Arrays.asList());
        boolean result1 = sql.exec("Update `Persona` SET Psicologo_IdPsicologo = 0", objs1);
        boolean result = sql.exec("Delete  From `Psicologo` where `idPsicologo`!=0  ", objs1);
        return result;
    }

    public boolean confirmacion(String Id, String password) {
        ArrayList<Object> objs1 = new ArrayList<>();
        objs1.addAll(Arrays.asList(Id, password));
        ResultSet rs = sql.SELECT("Select * from `Login` where `Username`= ? and `Password`=? and `Username` != 1 ", objs1);
        if (sql.Exists(rs)) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Añade a una solicitud de ni;o a la base de datos.
     *
     * @param String ID, int Estado, String Nombre, String Apellido, int edad,
     * int telefono, String Ocupacion, String Motivo, String Referencia, String
     * Detalle_Horario, String email, String detalle, String NombreSolicitante,
     * String Cita, String Direccion
     * @return return true si la persona se añade , y false si existe algun
     * problema.
     */
    public boolean AgregarSolicitudNiño(String ID, String Estado, String Nombre, String Apellido, int edad,
            int telefono, String Ocupacion, String Motivo, String Referencia,
            String Detalle_Horario, String email, String detalle, String NombreSolicitante, String Direccion) {
        try {
            ArrayList<Object> objs = new ArrayList<>();
            objs.addAll(Arrays.asList(ID, Estado, Nombre,
                    Apellido, edad,
                    telefono, Ocupacion, Motivo, Referencia,
                    Detalle_Horario, email, detalle, this.getDate(), NombreSolicitante, Direccion));
            boolean result = sql.exec(
                    "INSERT INTO `icompone_mario`.`Persona`"
                    + " (`ID`, `Estado_idEstado`, `Tipo_de_solicitud_idSolicitud`, `Nombre`, `Apellido`, `Edad`, `Telefono`, `Ocupacion`, `Motivo`, `Referencia`, `Detalle_Horario`, `Email`, `Detalle`, `Fecha_Solicitud`, `NombreSolicitante`, `Dir`,`Integrantes`) "
                    + "VALUES (?, (SELECT `idEstado` FROM Estado where `Estado`= ?), '1',?,?,?,?,?,?,?,?,?,?,?,?,?,1);", objs);
            if (result) {
                JOptionPane.showMessageDialog(null, "Se añadio correctamente");
            }
            return result;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something was wrong contact the Admin" + e);
            return false;
        }

    }

    /**
     * Añade a una solicitud a la base de datos.
     *
     * @param String ID, int Estado, String Nombre, String Apellido, int edad,
     * int telefono, String Ocupacion, String Motivo, String Referencia, String
     * Detalle_Horario, String email, String detalle, String NombreSolicitante,
     * String Cita, String Direccion
     * @return return true si la persona se añade , y false si existe algun
     * problema.
     */
    public boolean AgregarSolicitudAdoslecente(String ID, String Estado, String Nombre, String Apellido, int edad,
            int telefono, String Ocupacion, String Motivo, String Referencia,
            String Detalle_Horario, String email, String detalle, String NombreSolicitante, String Direccion) {
        try {
            ArrayList<Object> objs = new ArrayList<>();
            objs.addAll(Arrays.asList(ID, Estado, Nombre,
                    Apellido, telefono,
                    edad, Ocupacion, Motivo, Referencia,
                    Detalle_Horario, email, detalle, this.getDate(), NombreSolicitante, Direccion));
            boolean result = sql.exec(
                    "INSERT INTO `icompone_mario`.`Persona`"
                    + " (`ID`, `Estado_idEstado`, `Tipo_de_solicitud_idSolicitud`, `Nombre`, `Apellido`, `Edad`, `Telefono`, `Ocupacion`, `Motivo`, `Referencia`, `Detalle_Horario`, `Email`, `Detalle`, `Fecha_Solicitud`, `NombreSolicitante`, `Dir`,`Integrantes`) "
                    + "VALUES (?, (SELECT `idEstado` FROM Estado where `Estado`= ?), '2',?,?,?,?,?,?,?,?,?,?,?,?,?,1);", objs);
            if (result) {
                JOptionPane.showMessageDialog(null, "Se añadio correctamente");
            }
            return result;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something was wrong contact the Admin" + e);
            return false;
        }

    }

    /**
     * Añade a una solicitud de adulto a la base de datos.
     *
     * @param String ID, int Estado, String Nombre, String Apellido, int edad,
     * int telefono, String Ocupacion, String Motivo, String Referencia, String
     * Detalle_Horario, String email, String detalle, String NombreSolicitante,
     * String Cita, String Direccion
     * @return return true si la persona se añade , y false si existe algun
     * problema.
     */
    public boolean AgregarSolicitudAdulto(String ID, String Estado, String Nombre, String Apellido, int edad,
            int telefono, String Ocupacion, String Motivo, String Referencia,
            String Detalle_Horario, String email, String detalle, String NombreSolicitante, String Direccion) {
        try {
            ArrayList<Object> objs = new ArrayList<>();
            objs.addAll(Arrays.asList(ID, Estado, Nombre,
                    Apellido, edad,
                    telefono, Ocupacion, Motivo, Referencia,
                    Detalle_Horario, email, detalle, this.getDate(), NombreSolicitante, Direccion));
            boolean result = sql.exec(
                    "INSERT INTO `icompone_mario`.`Persona`"
                    + " (`ID`, `Estado_idEstado`, `Tipo_de_solicitud_idSolicitud`, `Nombre`, `Apellido`, `Edad`, `Telefono`, `Ocupacion`, `Motivo`, `Referencia`, `Detalle_Horario`, `Email`, `Detalle`, `Fecha_Solicitud`, `NombreSolicitante`, `Dir`,`Integrantes`) "
                    + "VALUES (?, (SELECT `idEstado` FROM Estado where `Estado`= ?), '3',?,?,?,?,?,?,?,?,?,?,?,?,?,1);", objs);
            if (result) {
                JOptionPane.showMessageDialog(null, "Se añadio correctamente");
            }
            return result;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something was wrong contact the Admin" + e);
            return false;
        }

    }

    /**
     * Añade a una solicitud de pareja a la base de datos.
     *
     * @param String ID, int Estado, String Nombre, String Apellido, int edad,
     * int telefono, String Ocupacion, String Motivo, String Referencia, String
     * Detalle_Horario, String email, String detalle, String NombreSolicitante,
     * String Cita, String Direccion
     * @return return true si la persona se añade , y false si existe algun
     * problema.
     */
    public boolean AgregarSolicitudPareja(String ID, String Estado, String Nombre, String Apellido, int edad,
            int telefono, String Ocupacion, String Motivo, String Referencia,
            String Detalle_Horario, String email, String detalle, String NombreSolicitante, String Direccion) {
        try {
            ArrayList<Object> objs = new ArrayList<>();
            objs.addAll(Arrays.asList(ID, Estado, Nombre,
                    Apellido, edad,
                    telefono, Ocupacion, Motivo, Referencia,
                    Detalle_Horario, email, detalle, this.getDate(), NombreSolicitante, Direccion));
            boolean result = sql.exec(
                    "INSERT INTO `icompone_mario`.`Persona`"
                    + " (`ID`, `Estado_idEstado`, `Tipo_de_solicitud_idSolicitud`, `Nombre`, `Apellido`, `Edad`, `Telefono`, `Ocupacion`, `Motivo`, `Referencia`, `Detalle_Horario`, `Email`, `Detalle`, `Fecha_Solicitud`, `NombreSolicitante`, `Dir`,`Integrantes`) "
                    + "VALUES (?, (SELECT `idEstado` FROM Estado where `Estado`= ?), '4',?,?,?,?,?,?,?,?,?,?,?,?,?,2);", objs);
            if (result) {
                JOptionPane.showMessageDialog(null, "Se añadio correctamente");
            }
            return result;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something was wrong contact the Admin" + e);
            return false;
        }

    }

    /**
     * Añade a una solicitud de familia a la base de datos.
     *
     * @param String ID, int Estado, String Nombre, String Apellido, int edad,
     * int telefono, String Ocupacion, String Motivo, String Referencia, String
     * Detalle_Horario, String email, String detalle, String NombreSolicitante,
     * String Cita, String Direccion
     * @return return true si la persona se añade , y false si existe algun
     * problema.
     */
    public boolean AgregarSolicitudFamilia(String ID, String Estado, String Nombre, String Apellido, int edad,
            int telefono, String Ocupacion, String Motivo, String Referencia,
            String Detalle_Horario, String email, String detalle, String NombreSolicitante, String Direccion, int integrantes) {
        try {
            ArrayList<Object> objs = new ArrayList<>();
            objs.addAll(Arrays.asList(ID, Estado, Nombre,
                    Apellido, edad,
                    telefono, Ocupacion, Motivo, Referencia,
                    Detalle_Horario, email, detalle, this.getDate(), NombreSolicitante, Direccion, integrantes));
            boolean result = sql.exec(
                    "INSERT INTO `icompone_mario`.`Persona`"
                    + " (`ID`, `Estado_idEstado`, `Tipo_de_solicitud_idSolicitud`, `Nombre`, `Apellido`, `Edad`, `Telefono`, `Ocupacion`, `Motivo`, `Referencia`, `Detalle_Horario`, `Email`, `Detalle`, `Fecha_Solicitud`, `NombreSolicitante`, `Dir`,`Integrantes`) "
                    + "VALUES (?, (SELECT `idEstado` FROM Estado where `Estado`= ?), '5',?,?,?,?,?,?,?,?,?,?,?,?,?,?);", objs);
            if (result) {
                JOptionPane.showMessageDialog(null, "Se añadio correctamente");
                System.out.println();
            }
            return result;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something was wrong contact the Admin" + e);
            return false;
        }

    }

    /**
     * Modifica un psicologo en la tabla
     *
     * @param String ID , String Nombre,String Apellido , String Carnet , int
     * celular , String email
     * @return True si se inserta correctamente false si existe algun problema
     */
    public boolean modifyEnProceso(String id, String Tipo, String estado) {

        ArrayList<Object> objs1 = new ArrayList<>();
        objs1.addAll(Arrays.asList(id, Tipo, estado));
        boolean result = sql.exec("UPDATE `icompone_mario`.`Persona` SET `Estado`= ?, `Nombre`= ? , `Apellido`=? , `Carnet`= ?, `Celular`= ?, `Email`= ? WHERE  `idPsicologo`= ?;", objs1);
        if (result) {
            JOptionPane.showMessageDialog(null, "Se modifico correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Upsss ,Hubo un problema");
        }
        return result;

    }

    public boolean modifyPersona(String ID, String Estado, String TipodeSolicitud, String Nombre,
            String Apellido, int edad, int telefono, String Ocupacion, String Motivo,
            String Referencia, String Detalle_Horario, String email, String detalle,
            String NombreSolicitante, String Curso, String Psicologo, String Cita, String Expediente,
            String Direccion, int integrantes, String cedula, String estadoini) {

        ArrayList<Object> objs = new ArrayList<>();
        objs.addAll(Arrays.asList(ID, Estado, TipodeSolicitud, Nombre,
                Apellido, edad, telefono, Ocupacion, Motivo,
                Referencia, Detalle_Horario, email, detalle,
                NombreSolicitante, Curso, Psicologo, Cita, Expediente,
                Direccion, integrantes, cedula, estadoini));
        boolean result = sql.exec("UPDATE Persona\n"
                + "                  SET `ID`= ? ,\n"
                + "                  `Estado_idEstado`  =(SELECT `idEstado` FROM Estado where `Estado`= ?),\n"
                + "                  `Tipo_de_solicitud_idSolicitud`  =(SELECT `idSolicitud` FROM Tipo_de_solicitud where `Tipo de solicitud`= ?),\n"
                + "                   `Nombre`=?, \n"
                + "                   `Apellido`=?,"
                + "                   `Edad`=?,\n"
                + "                   `Telefono` =?, \n"
                + "                  `Ocupacion`  =?,\n"
                + "                   `Motivo`  =?,\n"
                + "                   `Referencia`  =?,\n"
                + "                   `Detalle_Horario` =?,\n"
                + "                   `Email`  =?, \n"
                + "                  `Detalle`  =?,\n"
                + "                   `NombreSolicitante`  =?,\n"
                + "                  `Curso_idCurso`  =(SELECT `idCurso` FROM Curso where `Nombre`= ?), \n"
                + "                 `Psicologo_idPsicologo`  =(SELECT `idPsicologo` FROM Psicologo where `Nombre`= ?), \n"
                + "                   `Cita`  =?, \n"
                + "                   `Expediente`  =?, \n"
                + "                   `Dir`  =?, \n"
                + "                `Integrantes` =? \n"
                + "                 WHERE  `ID`=? and `Tipo_de_solicitud_idSolicitud`=(SELECT `idSolicitud` FROM Tipo_de_solicitud where `Tipo de solicitud`=?)", objs);
        if (result) {
            JOptionPane.showMessageDialog(null, "Se modifico correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Upsss ,Hubo un problema");
        }
        return result;
    }

    public boolean modificarcitas(String Curso,
            String Psicologo, String Cita, String cedula, String estado
    ) {
        ArrayList<Object> objs = new ArrayList<>();
        objs.addAll(Arrays.asList(Curso, Psicologo, Cita, cedula, estado
        ));
        boolean result = sql.exec("UPDATE Persona\n"
                + "                  SET "
                + "                  `Curso_idCurso`  =(SELECT `idCurso` FROM Curso where `Nombre`= ?), \n"
                + "                 `Psicologo_idPsicologo`  =(SELECT `idPsicologo` FROM Psicologo where `Nombre`= ?), \n"
                + "                   `Cita`  = ? "
                + " WHERE `ID`=? "
                + " AND `Estado_idEstado`=(SELECT `idEstado` FROM Estado where `Estado`= ?)", objs);
        if (result) {
            JOptionPane.showMessageDialog(null, "Se modifico correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Upsss ,Hubo un problema");
        }
        return result;
    }

    public boolean GenerarExcel() throws FileNotFoundException, IOException {
        String[] Columnas = {"Cedula", "Estado", "Tipo de solicitud",
            "Nombre", "Apellido", "Edad",
            "Telefono", "Ocupacion", "Motivo",
            "Referencia", "Horario", "Email",
            "Detalle", "Fecha de solicitud", "Solicitante",
            "Curso", "Psicologo", "Expediente", "Direccion", "Integrantes"};
        ArrayList<Persona> Personas = new ArrayList<>();

        try {
            ArrayList<Object> objs = new ArrayList<>();
            ResultSet rs = sql.SELECT("Select ID,"
                    + "Estado,"
                    + "Tipo_de_solicitud.`Tipo de solicitud`,"
                    + " Persona.Nombre,"
                    + "Persona.Apellido,\n"
                    + "Persona.Edad,"
                    + "Persona.Telefono,"
                    + "Persona.Ocupacion,"
                    + "Persona.Motivo,"
                    + "Persona.Referencia,"
                    + "Persona.Detalle_Horario,\n"
                    + "Persona.Email,"
                    + "Persona.Detalle,"
                    + "Persona.Fecha_Solicitud,"
                    + "Persona.NombreSolicitante,\n"
                    + " Curso.Nombre,"
                    + " Psicologo.Nombre,"
                    + "Persona.Expediente,"
                    + "Persona.Dir,"
                    + "Persona.Integrantes from Persona \n"
                    + "inner join Estado on Persona.Estado_idEstado=Estado.idEstado\n"
                    + "inner join Tipo_de_solicitud on Persona.Tipo_de_solicitud_idSolicitud=Tipo_de_solicitud.idSolicitud\n"
                    + "left join 	Curso on Persona.Curso_idCurso=Curso.idCurso \n"
                    + "left join Psicologo on Persona.Psicologo_idPsicologo=Psicologo.idPsicologo", objs);
            try {
                while (rs.next()) {
                    Persona p = new Persona(rs.getObject("ID").toString(),
                            rs.getObject("Estado").toString(),
                            rs.getObject("Tipo_de_solicitud.Tipo de solicitud").toString(),
                            rs.getObject("Persona.Nombre").toString(),
                            rs.getObject("Persona.Apellido").toString(),
                            rs.getObject("Persona.Ocupacion").toString(),
                            rs.getObject("Persona.Motivo").toString(),
                            rs.getObject("Persona.Referencia").toString(),
                            rs.getObject("Persona.Detalle_Horario").toString(),
                            rs.getObject("Persona.Email").toString(),
                            rs.getObject("Persona.Detalle").toString(),
                            rs.getObject("Persona.Fecha_Solicitud").toString(),
                            rs.getObject("Persona.NombreSolicitante").toString(),
                            rs.getObject("Curso.Nombre").toString(),
                            rs.getObject("Psicologo.Nombre").toString(),
                            rs.getObject("Persona.Expediente").toString(),
                            rs.getObject("Persona.Dir").toString(),
                            Integer.parseInt(rs.getObject("Persona.Integrantes").toString()),
                            Integer.parseInt(rs.getObject("Persona.Edad").toString()),
                            Integer.parseInt(rs.getObject("Persona.Telefono").toString()));
                    Personas.add(p);
                }

            } catch (Exception e) {
                System.out.println("Error" + e);
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something was wrong contact the Admin" + e);
            return false;

        }

        Workbook workbook = new XSSFWorkbook();
        CreationHelper createHelper = workbook.getCreationHelper();
        Sheet sheet = workbook.createSheet("Persona");
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        Row headerRow = sheet.createRow(0);
//        sheet = workbook.getSheetAt(0);
//        Iterator<Row> rowIte = sheet.iterator();
//        while (rowIte.hasNext()) {
//            rowIte.next();
//            rowIte.remove();
//        }
//         Creating cells
        for (int i = 0; i < Columnas.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(Columnas[i]);
            cell.setCellStyle(headerCellStyle);
        }
        int rowNum = 1;
        for (Persona persona : Personas) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0)
                    .setCellValue(persona.getID());
            row.createCell(1)
                    .setCellValue(persona.getEstado_idEstado());
            row.createCell(2)
                    .setCellValue(persona.getTipo_de_solicitud_idSolicitud());
            row.createCell(3)
                    .setCellValue(persona.getNombre());
            row.createCell(4)
                    .setCellValue(persona.getApellido());
            row.createCell(5)
                    .setCellValue(persona.getEdad());
            row.createCell(6)
                    .setCellValue(persona.getTelefono());
            row.createCell(7)
                    .setCellValue(persona.getOcupacion());
            row.createCell(8)
                    .setCellValue(persona.getMotivo());
            row.createCell(9)
                    .setCellValue(persona.getReferencia());
            row.createCell(10)
                    .setCellValue(persona.getDetalle_Horario());
            row.createCell(11)
                    .setCellValue(persona.getEmail());
            row.createCell(12)
                    .setCellValue(persona.getDetalle());
            row.createCell(13)
                    .setCellValue(persona.getFecha_Solicitud());
            row.createCell(14)
                    .setCellValue(persona.getNombreSolicitante());
            row.createCell(15)
                    .setCellValue(persona.getCurso_idCurso());
            row.createCell(16)
                    .setCellValue(persona.getPsicologo_idPsicologo());
            row.createCell(17)
                    .setCellValue(persona.getExpediente());
            row.createCell(18)
                    .setCellValue(persona.getDir());
            row.createCell(19)
                    .setCellValue(persona.getIntegrantes());

        }

//         Resize all columns to fit the content size
        for (int i = 0; i < Columnas.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream(System.getProperty("user.dir") + ("//src//Img//Reportes.xlsx"));
        workbook.write(fileOut);
        fileOut.close();

        // Closing the workbook
        workbook.close();
        try {
            String url = System.getProperty("user.dir") + ("//src//Img//Reportes.xlsx");
            ProcessBuilder p = new ProcessBuilder();
            p.command("cmd.exe", "/c", url);
            p.start();
        } catch (IOException exe) {
            return false;
        }
        return true;
    }

    /**
     * Elimina a una persona de la base de datos
     *
     * @param cedula.
     * @return return true si la persona se elimina , y false si existe algun
     * problema.
     */
    public boolean Eliminar(String pcedula) {
        try {
            ArrayList<Object> objs = new ArrayList<>();
            objs.addAll(Arrays.asList(pcedula));
            boolean result = sql.exec("DELETE FROM `Persona` WHERE `Persona`.`Cedula` = ?", objs);
            return result;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something was wrong contact the Admin");
            return false;
        }

    }

    /**
     * Busca a una persona por la cedula
     *
     * @param cedula.
     * @return un ResultSet que contiene los datos.
     */
    public ResultSet BuscarporCedula(String pcedula) {
        try {
            ArrayList<Object> objs = new ArrayList<>();
            objs.addAll(Arrays.asList(pcedula));
            ResultSet rs = sql.SELECT("SELECT `Nombre`,`Cedula`,`Edad`,`Apellido1`,`Apellido2` FROM `Persona` WHERE `Cedula`=? ", objs);

            return rs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something was wrong contact the Admin");
            return null;
        }

    }

    /**
     * Actualiza a una persona segun la cedula
     *
     * @param cedula, nombre,edad,apellido1, apellido2.
     * @return return true si la persona se actualiza , y false si existe algun
     * problema.
     */
    public boolean Actualizar(String pcedula, String pnombre, int pedad, String papellido1, String papellido2) {
        try {
            ArrayList<Object> objs = new ArrayList<>();
            objs.addAll(Arrays.asList(pnombre, pedad, papellido1, papellido2, pcedula));
            boolean result = sql.exec("UPDATE `Persona`"
                    + " SET `Nombre`=?,`Edad`=?,`Apellido1`=?,`Apellido2`=?"
                    + "WHERE `Cedula`=?  ", objs);
            return result;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something was wrong contact the Admin");
            return false;
        }

    }
}
