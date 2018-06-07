package pdg.dataaccess.dao;

import pdg.dataaccess.api.Dao;
import pdg.modelo.Estado;
import pdg.modelo.SesCoaching;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Interface for   SesCoachingDAO.
*
*/
public interface ISesCoachingDAO extends Dao<SesCoaching, Double> {
	
	 List<SesCoaching> filtrarSesionPorEstado(Long esta); 
	 List<SesCoaching> sesionesCompletasCoachee(long idCoachee, long idCoach);
}
