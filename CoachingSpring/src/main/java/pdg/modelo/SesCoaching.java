package pdg.modelo;

import org.hibernate.validator.constraints.*;

import java.util.Date;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "ses_coaching", schema = "public")
public class SesCoaching implements java.io.Serializable {
	  @NotNull
	    private Long idSesi;
	   // @NotNull
	    private Estado estado;
	    @NotNull
	    private ProcCoaching procCoaching;
	    private String accion;
	    private String compromiso;
	    private Date fecha;
	    private String focoSesion;
	    private String hora;
	    @NotNull
	    private Long idHis;
	    private String indicador;
	    private String profundidad;
	    
	    private Long numSes;

	    private Double precio;
	    private boolean isEncuadre;
	    
	    private String tipoSes;
	    
	    private String valor;
	    private String proposito;
	    private String aprendizaje;
	    private String cierre;
	    

    public SesCoaching() {
    }

    public SesCoaching(Long idSesi, String accion,Long numSes, String compromiso,
        Estado estado, Date fecha, String focoSesion, String hora,
        Long idHis, String indicador, ProcCoaching procCoaching,
        String profundidad, Double precio,
   boolean isEncuadre,String valor, String proposito,
     String aprendizaje,String cierre,String tipoSes ) {
        this.idSesi = idSesi;
        this.estado = estado;
        this.procCoaching = procCoaching;
        this.accion = accion;
        this.compromiso = compromiso;
        this.fecha = fecha;
        this.focoSesion = focoSesion;
        this.hora = hora;
        this.idHis = idHis;
        this.indicador = indicador;
        this.profundidad = profundidad;
        this.tipoSes= tipoSes;
        
        this.precio = precio;
        this.isEncuadre = isEncuadre;
        
        this.numSes= numSes;
        this.aprendizaje = aprendizaje;
        this.valor = valor;
        this.proposito = proposito;
        this.cierre = cierre;
    }

    @Id
    @Column(name = "id_sesi", unique = true, nullable = false)
    public Long getIdSesi() {
        return this.idSesi;
    }

    public void setIdSesi(Long idSesi) {
        this.idSesi = idSesi;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estado_id_estado")
    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "proc_coaching_id_proc")
    public ProcCoaching getProcCoaching() {
        return this.procCoaching;
    }

    public void setProcCoaching(ProcCoaching procCoaching) {
        this.procCoaching = procCoaching;
    }

    @Column(name = "accion")
    public String getAccion() {
        return this.accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    @Column(name = "compromiso")
    public String getCompromiso() {
        return this.compromiso;
    }

    public void setCompromiso(String compromiso) {
        this.compromiso = compromiso;
    }

    @Column(name = "fecha")
    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Column(name = "foco_sesion")
    public String getFocoSesion() {
        return this.focoSesion;
    }

    public void setFocoSesion(String focoSesion) {
        this.focoSesion = focoSesion;
    }

    @Column(name = "hora")
    public String getHora() {
        return this.hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Column(name = "id_his", nullable = false)
    public Long getIdHis() {
        return this.idHis;
    }

    public void setIdHis(Long idHis) {
        this.idHis = idHis;
    }

    @Column(name = "indicador")
    public String getIndicador() {
        return this.indicador;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }

    @Column(name = "profundidad")
    public String getProfundidad() {
        return this.profundidad;
    }

    public void setProfundidad(String profundidad) {
        this.profundidad = profundidad;
    }
    
    //TODO descomentar edspues
    @Column(name = "precio")
    public Double getPrecio() {
        return this.precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    //
     @Column(name = "isEncuadre")
     public boolean getIsEncuadre() {
         return this.isEncuadre;
     }

     public void setIsEncuadre(boolean isEncuadre) {
         this.isEncuadre = isEncuadre;
     }
     
     
// valores del cliente
    @Column(name = "valor")
     public String getValor() {
         return this.valor;
     }

     public void setValor(String valor) {
         this.valor = valor;
     }
     
       @Column(name = "proposito")
     public String getProposito() {
         return this.proposito;
     }

     public void setProposito(String proposito ) {
         this.proposito  = proposito ;
     }
     
       @Column(name = "aprendizaje")
     public String getAprendizaje() {
         return this.aprendizaje;
     }

     public void setAprendizaje(String aprendizaje ) {
         this.aprendizaje  = aprendizaje ;
     }
     
     
       @Column(name = "cierre")
     public String getCierre() {
         return this.cierre;
     }

     public void setCierre(String cierre ) {
         this.cierre  = cierre ;
     }

     
     @Column(name = "num_Sesi")
	public Long getNumSes() {
		return numSes;
	}

	public void setNumSes(Long numSes) {
		this.numSes = numSes;
	}

	public void setEncuadre(boolean isEncuadre) {
		this.isEncuadre = isEncuadre;
	}
     
	//Tipo de la sesion. pro-bono o pagada
	  @Column(name = "tipo_ses")
	    public String getTipoSes() {
	        return this.tipoSes;
	    }

	    public void setTipoSes(String tipoSes) {
	        this.tipoSes = tipoSes;
	    }
     
}
