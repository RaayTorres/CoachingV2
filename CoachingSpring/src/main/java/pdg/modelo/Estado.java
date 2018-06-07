package pdg.modelo;

import org.hibernate.validator.constraints.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "estado", schema = "public")
public class Estado implements java.io.Serializable {
	   @NotNull
	    private Long idEstado;
	    @NotNull
	    private TipoEstado tipoEstado;
	    @NotNull
	    @NotEmpty
	    @Size(max = 60)
	    private String nombreEstado;
	    private Set<Coachee> coachees = new HashSet<Coachee>(0);
	    private Set<SesCoaching> sesCoachings = new HashSet<SesCoaching>(0);
    public Estado() {
    }

    public Estado(Long idEstado, Set<Coachee> coachees, 
        String nombreEstado, Set<SesCoaching> sesCoachings,
        TipoEstado tipoEstado) {
        this.idEstado = idEstado;
        this.tipoEstado = tipoEstado;
        this.nombreEstado = nombreEstado;
        this.coachees = coachees;
        this.sesCoachings = sesCoachings;
    }

    @Id
    @Column(name = "id_estado", unique = true, nullable = false)
    public Long getIdEstado() {
        return this.idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_estado_id_testado")
    public TipoEstado getTipoEstado() {
        return this.tipoEstado;
    }

    public void setTipoEstado(TipoEstado tipoEstado) {
        this.tipoEstado = tipoEstado;
    }

    @Column(name = "nombre_estado", nullable = false)
    public String getNombreEstado() {
        return this.nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estado")
    public Set<Coachee> getCoachees() {
        return this.coachees;
    }

    public void setCoachees(Set<Coachee> coachees) {
        this.coachees = coachees;
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estado")
    public Set<SesCoaching> getSesCoachings() {
        return this.sesCoachings;
    }

    public void setSesCoachings(Set<SesCoaching> sesCoachings) {
        this.sesCoachings = sesCoachings;
    }
}
