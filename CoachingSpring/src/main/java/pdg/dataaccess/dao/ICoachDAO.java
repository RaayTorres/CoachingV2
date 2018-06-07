package pdg.dataaccess.dao;

import pdg.dataaccess.api.Dao;

import pdg.modelo.Coach;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Interface for   CoachDAO.
*
*/
public interface ICoachDAO extends Dao<Coach, Double> {
	
	
	public Coach consultarCoachPorLogin(String login);
}
