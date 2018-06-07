package pdg.modelo.logic;

import pdg.modelo.TipoEstado;

import pdg.modelo.dto.TipoEstadoDTO;

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
public interface ITipoEstadoLogic {
    public List<TipoEstado> getTipoEstado() throws Exception;

    /**
         * Save an new TipoEstado entity
         */
    public void saveTipoEstado(TipoEstado entity) throws Exception;

    /**
         * Delete an existing TipoEstado entity
         *
         */
    public void deleteTipoEstado(TipoEstado entity) throws Exception;

    /**
        * Update an existing TipoEstado entity
        *
        */
    public void updateTipoEstado(TipoEstado entity) throws Exception;

    /**
         * Load an existing TipoEstado entity
         *
         */
    public TipoEstado getTipoEstado(Long long1) throws Exception;

    public List<TipoEstado> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TipoEstado> findPageTipoEstado(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoEstado() throws Exception;

    public List<TipoEstadoDTO> getDataTipoEstado() throws Exception;

    public void validateTipoEstado(TipoEstado tipoEstado)
        throws Exception;
}
