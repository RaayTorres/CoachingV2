package pdg.dataaccess.dao;

import pdg.dataaccess.api.Dao;

import pdg.modelo.ProcCoaching;
import pdg.modelo.SesCoaching;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Interface for   ProcCoachingDAO.
*
*/
public interface IProcCoachingDAO extends Dao<ProcCoaching, Double> {
	
	public List<SesCoaching> sesionesProcesoCoachee(long idCoachee, long idCoach, long esta);
	
	 public List<SesCoaching> sesionesTotalesProcesoCoachee(long idCoachee, long idCoach);
	 
	 public List<SesCoaching> sesionesTotalesProcesoCoacheeUnico(long idCoachee, long idCoach, long proc);
	 
	 public List<SesCoaching> sesionesProceso(long proc);
}
