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
public class SesCoachingDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(SesCoachingDTO.class);
    private String accion;
    private String compromiso;
    private Date fecha;
    private String focoSesion;
    private String hora;
    private Long idHis;
    private Long idSesi;
    private String indicador;
    private String profundidad;
    private Long idEstado_Estado;
    private Long idProc_ProcCoaching;

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getCompromiso() {
        return compromiso;
    }

    public void setCompromiso(String compromiso) {
        this.compromiso = compromiso;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getFocoSesion() {
        return focoSesion;
    }

    public void setFocoSesion(String focoSesion) {
        this.focoSesion = focoSesion;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Long getIdHis() {
        return idHis;
    }

    public void setIdHis(Long idHis) {
        this.idHis = idHis;
    }

    public Long getIdSesi() {
        return idSesi;
    }

    public void setIdSesi(Long idSesi) {
        this.idSesi = idSesi;
    }

    public String getIndicador() {
        return indicador;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }

    public String getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(String profundidad) {
        this.profundidad = profundidad;
    }

    public Long getIdEstado_Estado() {
        return idEstado_Estado;
    }

    public void setIdEstado_Estado(Long idEstado_Estado) {
        this.idEstado_Estado = idEstado_Estado;
    }

    public Long getIdProc_ProcCoaching() {
        return idProc_ProcCoaching;
    }

    public void setIdProc_ProcCoaching(Long idProc_ProcCoaching) {
        this.idProc_ProcCoaching = idProc_ProcCoaching;
    }
}
