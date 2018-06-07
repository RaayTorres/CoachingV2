package pdg.dataaccess.dao;

import pdg.dataaccess.api.Dao;

import pdg.modelo.Coachee;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Interface for   CoacheeDAO.
*
*/
public interface ICoacheeDAO extends Dao<Coachee, Double> {
	
	public Coachee consultarClientePorLogin(String identificacion);
	
	public Coachee consultarClientePorLoginReal (String login);
}
