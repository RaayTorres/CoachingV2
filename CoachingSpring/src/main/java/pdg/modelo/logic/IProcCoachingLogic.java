package pdg.modelo.logic;

import pdg.modelo.Coach;
import pdg.modelo.Coachee;
import pdg.modelo.ProcCoaching;
import pdg.modelo.SesCoaching;
import pdg.modelo.dto.ProcCoachingDTO;

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
public interface IProcCoachingLogic {
    public List<ProcCoaching> getProcCoaching(Coach id) throws Exception;

    /**
         * Save an new ProcCoaching entity
         */
    public void saveProcCoaching(ProcCoaching entity) throws Exception;

    /**
         * Delete an existing ProcCoaching entity
         *
         */
    public void deleteProcCoaching(ProcCoaching entity)
        throws Exception;

    /**
        * Update an existing ProcCoaching entity
        *
        */
    public void updateProcCoaching(ProcCoaching entity)
        throws Exception;

    /**
         * Load an existing ProcCoaching entity
         *
         */
    public ProcCoaching getProcCoaching(Long long1)
        throws Exception;

    public List<ProcCoaching> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<ProcCoaching> findPageProcCoaching(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberProcCoaching() throws Exception;

    public List<ProcCoachingDTO> getDataProcCoaching()
        throws Exception;

    public void validateProcCoaching(ProcCoaching procCoaching)
        throws Exception;
    
    
    public int progresoProceso(long coach, long client) throws Exception;
    
    
    public List<SesCoaching> sesionesCoachee(long coach, long client,  long proc) ;
    
    
    public List<SesCoaching> sesionesProceso(long proc);
    
}
