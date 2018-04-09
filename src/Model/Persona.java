/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

public class Persona {

    String ID, Estado_idEstado, Tipo_de_solicitud_idSolicitud, Nombre, Apellido, Ocupacion, Motivo,
            Referencia, Detalle_Horario, Email, Detalle, Fecha_Solicitud, NombreSolicitante, Curso_idCurso,
            Psicologo_idPsicologo, Expediente, Dir;
    int Edad, Telefono, Integrantes;

    public Persona() {
    }



    public Persona(String ID, String Estado_idEstado, String Tipo_de_solicitud_idSolicitud,
            String Nombre, String Apellido, String Ocupacion, String Motivo, String Referencia,
            String Detalle_Horario, String Email, String Detalle, String Fecha_Solicitud,
            String NombreSolicitante, String Curso_idCurso, String Psicologo_idPsicologo,
            String Expediente, String Dir, int Integrantes, int Edad, int Telefono) {

        this.ID = ID;
        this.Estado_idEstado = Estado_idEstado;
        this.Tipo_de_solicitud_idSolicitud = Tipo_de_solicitud_idSolicitud;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Ocupacion = Ocupacion;
        this.Motivo = Motivo;
        this.Referencia = Referencia;
        this.Detalle_Horario = Detalle_Horario;
        this.Email = Email;
        this.Detalle = Detalle;
        this.Fecha_Solicitud = Fecha_Solicitud;
        this.NombreSolicitante = NombreSolicitante;
        this.Curso_idCurso = Curso_idCurso;
        this.Psicologo_idPsicologo = Psicologo_idPsicologo;
        this.Expediente = Expediente;
        this.Dir = Dir;
        this.Integrantes = Integrantes;
        this.Edad = Edad;
        this.Telefono = Telefono;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getEstado_idEstado() {
        return Estado_idEstado;
    }

    public void setEstado_idEstado(String Estado_idEstado) {
        this.Estado_idEstado = Estado_idEstado;
    }

    public String getTipo_de_solicitud_idSolicitud() {
        return Tipo_de_solicitud_idSolicitud;
    }

    public void setTipo_de_solicitud_idSolicitud(String Tipo_de_solicitud_idSolicitud) {
        this.Tipo_de_solicitud_idSolicitud = Tipo_de_solicitud_idSolicitud;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getOcupacion() {
        return Ocupacion;
    }

    public void setOcupacion(String Ocupacion) {
        this.Ocupacion = Ocupacion;
    }

    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String Motivo) {
        this.Motivo = Motivo;
    }

    public String getReferencia() {
        return Referencia;
    }

    public void setReferencia(String Referencia) {
        this.Referencia = Referencia;
    }

    public String getDetalle_Horario() {
        return Detalle_Horario;
    }

    public void setDetalle_Horario(String Detalle_Horario) {
        this.Detalle_Horario = Detalle_Horario;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDetalle() {
        return Detalle;
    }

    public void setDetalle(String Detalle) {
        this.Detalle = Detalle;
    }

    public String getFecha_Solicitud() {
        return Fecha_Solicitud;
    }

    public void setFecha_Solicitud(String Fecha_Solicitud) {
        this.Fecha_Solicitud = Fecha_Solicitud;
    }

    public String getNombreSolicitante() {
        return NombreSolicitante;
    }

    public void setNombreSolicitante(String NombreSolicitante) {
        this.NombreSolicitante = NombreSolicitante;
    }

    public String getCurso_idCurso() {
        return Curso_idCurso;
    }

    public void setCurso_idCurso(String Curso_idCurso) {
        this.Curso_idCurso = Curso_idCurso;
    }

    public String getPsicologo_idPsicologo() {
        return Psicologo_idPsicologo;
    }

    public void setPsicologo_idPsicologo(String Psicologo_idPsicologo) {
        this.Psicologo_idPsicologo = Psicologo_idPsicologo;
    }

    public String getExpediente() {
        return Expediente;
    }

    public void setExpediente(String Expediente) {
        this.Expediente = Expediente;
    }

    public String getDir() {
        return Dir;
    }

    public void setDir(String Dir) {
        this.Dir = Dir;
    }

    public int getIntegrantes() {
        return Integrantes;
    }

    public void setIntegrantes(int Integrantes) {
        this.Integrantes = Integrantes;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

}
