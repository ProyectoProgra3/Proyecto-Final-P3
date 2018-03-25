/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import javax.swing.JOptionPane;

public class BusinessLogic {

    public SQL sql;

    public BusinessLogic() {
        this.sql = new SQL();

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
    public ResultSet SearchCursos() {
        try {
            ArrayList<Object> objs = new ArrayList<>();
            ResultSet rs = sql.SELECT("SELECT `Nombre` FROM Curso ", objs);
            return rs;
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
    public ResultSet SearchEstados() {
        try {
            ArrayList<Object> objs = new ArrayList<>();
            ResultSet rs = sql.SELECT("SELECT `Estado` FROM Estado ", objs);
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
            ResultSet rs = sql.SELECT("SELECT  `ID`,  `Estado_idEstado`,  `Tipo_de_solicitud_idSolicitud`,  `Nombre`,  `Apellido`,  `Edad`,  `Telefono`,  `Ocupacion`,`Motivo`,  `Referencia`,  `Detalle_Horario`,  `Email`,  `Detalle`,  `Fecha_Solicitud`,  `NombreSolicitante`,   `Curso_idCurso`,  `Psicologo_idPsicologo`,  `Cita` ,  `Expediente` FROM `Persona` Where  ID = ? and `Estado_idEstado`=(Select `idEstado` from `Estado` where Estado = ? ) ; ", objs);
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
            ResultSet rs = sql.SELECT("SELECT  `ID`,  `Estado_idEstado`,  `Tipo_de_solicitud_idSolicitud`,  `Nombre`,  `Apellido`,  `Edad`,  `Telefono`,  `Ocupacion`,`Motivo`,  `Referencia`,  `Detalle_Horario`,  `Email`,  `Detalle`,  `Fecha_Solicitud`,  `NombreSolicitante`,   `Curso_idCurso`,  `Psicologo_idPsicologo`,  `Cita` ,  `Expediente` FROM `Persona` Where  ID = ? and `Tipo_de_Solicitud_idSolicitud`=(Select `idSolicitud` from `Tipo_de_solicitud` where `Tipo de solicitud` = ? ) ; ", objs);
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

    /**
     * Inserta un osicologo en la tabla
     *
     * @param String ID , String Nombre,String Apellido , String Carnet , int
     * celular , String email
     * @return True si se inserta correctamente false si existe algun problema
     */
    public boolean addPsicologo(String id, String Nombre, String Apellido, String Carnet, int celular, String email) {
        ArrayList<Object> objs = new ArrayList<>();
        objs.addAll(Arrays.asList(id, Nombre));
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

    }

    /**
     * Añade a una solicitud a la base de datos.
     *
     * @param cedula ,nombre,edad,apellido1,apellido2.
     * @return return true si la persona se añade , y false si existe algun
     * problema.
     */
    public boolean AgregarSolicitud(String ID, String Nombre, int Estado,
            int tipoSolicitud, String Apellido, int edad,
            int telefono, String Ocupacion, String Direccion, String Motivo, String Referencia,
            String Detalle_Horario, String email, String detalle, String NombreSolicitante) {
// `Psicologo_idPsicologo`, `Apellido`, `Edad`, `Telefono`, `Ocupacion`, `Motivo`, `Referencia`, `Detalle_Horario`, `Email`, `Detalle`) VALUES ('2', 'Jose', '3', '3', '123', 'rodriguez', '23', '8888888', 'estudiante', 'los de la clinica me tienen loco', 'hospital', 'lunes tarde', '@gmail', 'Pareja sharon');

//Expediente INSERT INTO `icompone_mario`.`Expediente` (`idExpediente`, `Persona_ID`, `Persona_Clase_Paciente_idClase_Paciente`, `Persona_Tipo de solicitud_idTipo de solicitud`) VALUES ('1231b', '2', '3', '3');        
//Persona INSERT INTO `icompone_mario`.`Persona` (`ID`, `Nombre`, `Clase_Paciente_idClase_Paciente`, `Tipo de solicitud_idTipo de solicitud`, `Psicologo_idPsicologo`, `Apellido`, `Edad`, `Telefono`, `Ocupacion`, `Motivo`, `Referencia`, `Detalle_Horario`, `Email`, `Detalle`) VALUES ('2', 'Jose', '3', '3', '123', 'rodriguez', '23', '8888888', 'estudiante', 'los de la clinica me tienen loco', 'hospital', 'lunes tarde', '@gmail', 'Pareja sharon');
        try {
            ArrayList<Object> objs = new ArrayList<>();
            objs.addAll(Arrays.asList(ID, Nombre, Estado,
                    tipoSolicitud, Apellido, edad,
                    telefono, Ocupacion, Direccion, Motivo, Referencia,
                    Detalle_Horario, email, detalle, this.getDate(), NombreSolicitante));
            boolean result = sql.exec("INSERT INTO `icompone_mario`.`Persona` "
                    + "(`ID`, `Nombre`, `Estado`, `Tipo_solicitud`, `Psicologo`, `Apellido`, `Edad`, `Telefono`, `Ocupacion`,`Direccion`, `Motivo`, `Referencia`, `Detalle_Horario`, `Email`, `Detalle`,`FechaSolicitud`,`Nombre_Solicitante`) "
                    + "VALUES (?,?,?,?,(NULL),?,?,?,?,?,?,?,?,?,?,?,?);", objs);
            if (result) {
                System.out.println("Se añadio correctamente");
            }
            return result;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something was wrong contact the Admin" + e);
            return false;
        }

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
