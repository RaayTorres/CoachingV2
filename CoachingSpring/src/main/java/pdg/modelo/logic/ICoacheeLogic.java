package pdg.modelo.logic;

import pdg.modelo.Coachee;

import pdg.modelo.dto.CoacheeDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface ICoacheeLogic {
    public List<Coachee> getCoachee() throws Exception;

    /**
         * Save an new Coachee entity
         */
    public void saveCoachee(Coachee entity) throws Exception;

    /**
         * Delete an existing Coachee entity
         *
         */
    public void deleteCoachee(Coachee entity) throws Exception;

    /**
        * Update an existing Coachee entity
        *
        */
    public void updateCoachee(Coachee entity) throws Exception;

    /**
         * Load an existing Coachee entity
         *
         */
    public Coachee getCoachee(Long long1) throws Exception;

    public List<Coachee> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Coachee> findPageCoachee(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberCoachee() throws Exception;

    public List<CoacheeDTO> getDataCoachee() throws Exception;

    public void validateCoachee(Coachee coachee) throws Exception;
    
    public Coachee validarCredenciales (String user, String password) throws Exception ;

	Coachee consultarClienteByIdentificacion(String identificacion);
}
