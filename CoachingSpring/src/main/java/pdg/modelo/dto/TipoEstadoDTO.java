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
public class TipoEstadoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TipoEstadoDTO.class);
    private Long idTestado;
    private String nombreTipoEstado;

    public Long getIdTestado() {
        return idTestado;
    }

    public void setIdTestado(Long idTestado) {
        this.idTestado = idTestado;
    }

    public String getNombreTipoEstado() {
        return nombreTipoEstado;
    }

    public void setNombreTipoEstado(String nombreTipoEstado) {
        this.nombreTipoEstado = nombreTipoEstado;
    }
}
