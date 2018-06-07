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
public class ProcCoachingDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ProcCoachingDTO.class);
    private Long idProc;
    private Long idTpago;
    private Long idCoach_Coach;
    private Long idCoachee_Coachee;
    private Long idHis_RegContable;

    public Long getIdProc() {
        return idProc;
    }

    public void setIdProc(Long idProc) {
        this.idProc = idProc;
    }

    public Long getIdTpago() {
        return idTpago;
    }

    public void setIdTpago(Long idTpago) {
        this.idTpago = idTpago;
    }

    public Long getIdCoach_Coach() {
        return idCoach_Coach;
    }

    public void setIdCoach_Coach(Long idCoach_Coach) {
        this.idCoach_Coach = idCoach_Coach;
    }

    public Long getIdCoachee_Coachee() {
        return idCoachee_Coachee;
    }

    public void setIdCoachee_Coachee(Long idCoachee_Coachee) {
        this.idCoachee_Coachee = idCoachee_Coachee;
    }

    public Long getIdHis_RegContable() {
        return idHis_RegContable;
    }

    public void setIdHis_RegContable(Long idHis_RegContable) {
        this.idHis_RegContable = idHis_RegContable;
    }
}
