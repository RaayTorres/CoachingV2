package pdg.modelo.logic;

import pdg.modelo.Coach;
import pdg.modelo.Coachee;
import pdg.modelo.Estado;
import pdg.modelo.ProcCoaching;
import pdg.modelo.SesCoaching;

import pdg.modelo.dto.SesCoachingDTO;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface ISesCoachingLogic {
    public List<SesCoaching> getSesCoaching() throws Exception;

    /**
         * Save an new SesCoaching entity
         */
    public void saveSesCoaching(SesCoaching entity) throws Exception;

    /**
         * Delete an existing SesCoaching entity
         *
         */
    public void deleteSesCoaching(SesCoaching entity) throws Exception;

    /**
        * Update an existing SesCoaching entity
        *
        */
    public void updateSesCoaching(SesCoaching entity) throws Exception;

    /**
         * Load an existing SesCoaching entity
         *
         */
    public SesCoaching getSesCoaching(Long idSesi) throws Exception;

    public List<SesCoaching> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<SesCoaching> findPageSesCoaching(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberSesCoaching() throws Exception;

    public List<SesCoachingDTO> getDataSesCoaching() throws Exception;

    public void validateSesCoaching(SesCoaching sesCoaching)
        throws Exception;
    

	 public List<SesCoaching> filtrarSesionPorEstado(Long esta); 
	 
	 
	 public List<SesCoaching> sesionesHoy(Coach coc);
	 
	 public List<Coachee> clientesSesionesHoy(Coach coc);
	 
	 public Set<SesCoaching> sesionCompletas(ProcCoaching pro);
}
