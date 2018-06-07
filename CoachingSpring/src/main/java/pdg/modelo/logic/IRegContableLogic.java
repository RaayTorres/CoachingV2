package pdg.modelo.logic;

import pdg.modelo.RegContable;

import pdg.modelo.dto.RegContableDTO;

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
public interface IRegContableLogic {
    public List<RegContable> getRegContable() throws Exception;

    /**
         * Save an new RegContable entity
         */
    public void saveRegContable(RegContable entity) throws Exception;

    /**
         * Delete an existing RegContable entity
         *
         */
    public void deleteRegContable(RegContable entity) throws Exception;

    /**
        * Update an existing RegContable entity
        *
        */
    public void updateRegContable(RegContable entity) throws Exception;

    /**
         * Load an existing RegContable entity
         *
         */
    public RegContable getRegContable(Long long1) throws Exception;

    public List<RegContable> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<RegContable> findPageRegContable(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberRegContable() throws Exception;

    public List<RegContableDTO> getDataRegContable() throws Exception;

    public void validateRegContable(RegContable regContable)
        throws Exception;
}
