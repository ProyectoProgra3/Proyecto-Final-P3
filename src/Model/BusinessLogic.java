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
            ResultSet rs = sql.SELECT("SELECT  `ID`,  `Estado_idEstado`,  `Tipo_de_solicitud_idSolicitud`, "
                    + " `Nombre`,  `Apellido`,  `Edad`,  `Telefono`,  `Ocupacion`,`Motivo`,  `Referencia`, "
                    + " `Detalle_Horario`,  `Email`,  `Detalle`,  `Fecha_Solicitud`,  `NombreSolicitante`,"
                    + "   `Curso_idCurso`,  `Psicologo_idPsicologo`,  `Cita` ,`Dir`,  "
                    + "`Expediente` FROM `Persona`"
                    + " Where  ID = ? and `Tipo_de_Solicitud_idSolicitud`=(Select `idSolicitud` "
                    + "from `Tipo_de_solicitud` where `Tipo de solicitud` = ? ) ; ", objs);
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
        boolean result1 = sql.exec("Update `Persona` SET Psicologo_IdPsicologo =(NULL)", objs1);
        boolean result = sql.exec("Delete  From `Psicologo`", objs1);
        return result;
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
                System.out.println("Se añadio correctamente");
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
                System.out.println("Se añadio correctamente");
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
                System.out.println("Se añadio correctamente");
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
                System.out.println("Se añadio correctamente");
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
            String Detalle_Horario, String email, String detalle, String NombreSolicitante, String Direccion,int integrantes) {
        try {
            ArrayList<Object> objs = new ArrayList<>();
            objs.addAll(Arrays.asList(ID, Estado, Nombre,
                    Apellido, edad,
                    telefono, Ocupacion, Motivo, Referencia,
                    Detalle_Horario, email, detalle, this.getDate(), NombreSolicitante, Direccion,integrantes));
            boolean result = sql.exec(
                    "INSERT INTO `icompone_mario`.`Persona`"
                    + " (`ID`, `Estado_idEstado`, `Tipo_de_solicitud_idSolicitud`, `Nombre`, `Apellido`, `Edad`, `Telefono`, `Ocupacion`, `Motivo`, `Referencia`, `Detalle_Horario`, `Email`, `Detalle`, `Fecha_Solicitud`, `NombreSolicitante`, `Dir`,`Integrantes`) "
                    + "VALUES (?, (SELECT `idEstado` FROM Estado where `Estado`= ?), '5',?,?,?,?,?,?,?,?,?,?,?,?,?,?);", objs);
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
            String Direccion) {

        ArrayList<Object> objs1 = new ArrayList<>();
        ArrayList<Object> objs = new ArrayList<>();
        objs.addAll(Arrays.asList(ID, Estado, TipodeSolicitud, Nombre,
                Apellido, edad, telefono, Ocupacion, Motivo,
                Referencia, Detalle_Horario, email, detalle,
                NombreSolicitante, Curso, Psicologo, Cita, Expediente,
                Direccion));
        boolean result = sql.exec("UPDATE `icompone_mario`.`Persona` SET `ID`= ?, `Estado_idEstado`=?, "
                + "`Tipo_de_solicitud_idSolicitud`=?, `Nombre`=?, `Apellido`=?, `Edad`=?, `Telefono`=?, "
                + "`Ocupacion`=?, `Motivo`=?, `Referencia`=?, `Detalle_Horario`=?, `Email`=?, `Detalle`=?,"
                + " `NombreSolicitante`=?, `Curso_idCurso`=?, `Psicologo_idPsicologo`=?, `Cita`=?, "
                + "`Expediente`=?, `Direccion`=? "
                + "WHERE  `ID`=? AND `Estado_idEstado`=? AND `Tipo_de_solicitud_idSolicitud`=?;", objs1);
        if (result) {
            JOptionPane.showMessageDialog(null, "Se modifico correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Upsss ,Hubo un problema");
        }
        return result;
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
