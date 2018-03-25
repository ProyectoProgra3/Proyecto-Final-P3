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


 

    public BusinessLogic() {
     
    }
//    public iTextField nid_txt = new iTextField("Digite ID", 6);
//    public iTextField nnombre_txt = new iTextField("Digite Nombre", 6);
//    public iTextField napellido_txt = new iTextField("Digite Apellido", 6);
//    public iTextField nedad_txt = new iTextField("Digite Edad", 6);
//    public iTextField nreferencia_txt = new iTextField("Digite Referencia", 6);
//    public iTextField nocupacion_txt = new iTextField("Digite Ocupación", 6);
//    public iTextField ndireccion_txt = new iTextField("Digite Dirección", 6);
//    public iTextField ntelefono_txt = new iTextField("Digite Teléfono", 6);
//    public iTextField nemail_txt = new iTextField("Digite Correo", 6);
//    public iTextField nmotivo_txt = new iTextField("Digite Motivo", 6);
//    public iTextField nhorario_txt = new iTextField("Digite Horario", 6);
//    public iTextField ndetalle_txt = new iTextField("Digite Detalle de Horario", 6);
//    public iTextField nsolicitante_txt = new iTextField("Digite Nombre de Solicitante", 6);
//    public iButton btn_agr = new iButton("Agregar", 6, new Color(106, 203, 214), Color.WHITE);
//    public iComboCheckBox tipo_cbm = new iComboCheckBox();
    public String getDate() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");

        return dateFormat.format(date);
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
                    tipoSolicitud,Apellido, edad,
                    telefono, Ocupacion,Direccion, Motivo, Referencia,
                    Detalle_Horario, email, detalle,this.getDate(),NombreSolicitante ));
            boolean result = InitModel.sql.exec("INSERT INTO `icompone_mario`.`Persona` "
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
            boolean result = InitModel.sql.exec("DELETE FROM `Persona` WHERE `Persona`.`Cedula` = ?", objs);
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
            ResultSet rs = InitModel.sql.SELECT("SELECT `Nombre`,`Cedula`,`Edad`,`Apellido1`,`Apellido2` FROM `Persona` WHERE `Cedula`=? ", objs);

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
            boolean result = InitModel.sql.exec("UPDATE `Persona`"
                    + " SET `Nombre`=?,`Edad`=?,`Apellido1`=?,`Apellido2`=?"
                    + "WHERE `Cedula`=?  ", objs);
            return result;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something was wrong contact the Admin");
            return false;
        }

    }
}
