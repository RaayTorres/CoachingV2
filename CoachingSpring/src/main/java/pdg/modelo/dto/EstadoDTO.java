package pdg.modelo.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public class EstadoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(EstadoDTO.class);
    private Long idEstado;
    private String nombreEstado;
    private Long idTestado_TipoEstado;

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public Long getIdTestado_TipoEstado() {
        return idTestado_TipoEstado;
    }

    public void setIdTestado_TipoEstado(Long idTestado_TipoEstado) {
        this.idTestado_TipoEstado = idTestado_TipoEstado;
    }
}
