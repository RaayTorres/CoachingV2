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
@Table(name = "proc_coaching", schema = "public")
public class ProcCoaching implements java.io.Serializable {
	 @NotNull
	    private Long idProc;
	    @NotNull
	    private Coach coach;
	    @NotNull
	    private Coachee coachee;
	    @NotNull
	    private RegContable regContable;
//	    @NotNull
//	    private Long idTpago;
//	    
	    private String focoProceso;
	    
	    
	    private Set<SesCoaching> sesCoachings = new HashSet<SesCoaching>(0);

    public ProcCoaching() {
    }

    public ProcCoaching(Long idProc, Coach coach, Coachee coachee,
    		Long idTpago, RegContable regContable, Set<SesCoaching> sesCoachings,  String focoProceso) {
        this.idProc = idProc;
        this.coach = coach;
        this.coachee = coachee;
        this.regContable = regContable;
      //  this.idTpago = idTpago;
        this.sesCoachings = sesCoachings;
        this.focoProceso= focoProceso;
    }

    @Id
    @Column(name = "id_proc", unique = true, nullable = false)
    public Long getIdProc() {
        return this.idProc;
    }

    public void setIdProc(Long idProc) {
        this.idProc = idProc;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coach_id_coach")
    public Coach getCoach() {
        return this.coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coachee_id_coachee")
    public Coachee getCoachee() {
        return this.coachee;
    }

    public void setCoachee(Coachee coachee) {
        this.coachee = coachee;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reg_contable_id_his")
    public RegContable getRegContable() {
        return this.regContable;
    }

    public void setRegContable(RegContable regContable) {
        this.regContable = regContable;
    }

//    @Column(name = "id_tpago", nullable = false)
//    public Long getIdTpago() {
//        return this.idTpago;
//    }
//
//    public void setIdTpago(Long idTpago) {
//        this.idTpago = idTpago;
//    }
    
    
    
  
    @Column(name = "foco_proc")
    public String getFocoProceso() {
        return this.focoProceso;
    }

    public void setFocoProceso(String focoProceso) {
        this.focoProceso = focoProceso;
    }
    
    

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "procCoaching")
    public Set<SesCoaching> getSesCoachings() {
        return this.sesCoachings;
    }

    public void setSesCoachings(Set<SesCoaching> sesCoachings) {
        this.sesCoachings = sesCoachings;
    }
}
