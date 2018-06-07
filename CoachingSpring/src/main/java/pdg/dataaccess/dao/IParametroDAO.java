package pdg.dataaccess.dao;

import pdg.dataaccess.api.Dao;

import pdg.modelo.Parametro;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Interface for   ParametroDAO.
*
*/
public interface IParametroDAO extends Dao<Parametro, Double> {
	
	  public Parametro findValorSesion();
}
