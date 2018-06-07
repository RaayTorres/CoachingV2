package pdg.modelo.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;

import javax.faces.bean.ApplicationScoped;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@ApplicationScoped
public class CoacheeDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(CoacheeDTO.class);
    private String apellido;
    private String celular;
    private String correo;
    private String direccion;
    private byte[] foto;
    private String hobbies;
    private Long idCoachee;
    private String identificacion;
    private String nombre;
    private String telefono;
    private Long idEstado_Estado;
    private Long idDoc_TipoDocumento;

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public Long getIdCoachee() {
        return idCoachee;
    }

    public void setIdCoachee(Long idCoachee) {
        this.idCoachee = idCoachee;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Long getIdEstado_Estado() {
        return idEstado_Estado;
    }

    public void setIdEstado_Estado(Long idEstado_Estado) {
        this.idEstado_Estado = idEstado_Estado;
    }

    public Long getIdDoc_TipoDocumento() {
        return idDoc_TipoDocumento;
    }

    public void setIdDoc_TipoDocumento(Long idDoc_TipoDocumento) {
        this.idDoc_TipoDocumento = idDoc_TipoDocumento;
    }
}
