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
public class CategoriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(CategoriaDTO.class);
    private String catNombre;
    private Double horaPagada;
    private Double horaProbono;
    private Long idCat;
    private String nombreCorto;

    public String getCatNombre() {
        return catNombre;
    }

    public void setCatNombre(String catNombre) {
        this.catNombre = catNombre;
    }

    public Double getHoraPagada() {
        return horaPagada;
    }

    public void setHoraPagada(Double horaPagada) {
        this.horaPagada = horaPagada;
    }

    public Double getHoraProbono() {
        return horaProbono;
    }

    public void setHoraProbono(Double horaProbono) {
        this.horaProbono = horaProbono;
    }

    public Long getIdCat() {
        return idCat;
    }

    public void setIdCat(Long idCat) {
        this.idCat = idCat;
    }

    public String getNombreCorto() {
        return nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }
}
