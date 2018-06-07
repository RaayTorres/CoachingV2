package pdg.modelo.logic;

import pdg.modelo.Categoria;
import pdg.modelo.Coach;
import pdg.modelo.Coachee;
import pdg.modelo.RegContable;
import pdg.modelo.dto.CoachDTO;

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
public interface ICoachLogic {
    public List<Coach> getCoach() throws Exception;

    /**
         * Save an new Coach entity
         */
    public void saveCoach(Coach entity) throws Exception;

    /**
         * Delete an existing Coach entity
         *
         */
    public void deleteCoach(Coach entity) throws Exception;

    /**
        * Update an existing Coach entity
        *
        */
    public void updateCoach(Coach entity) throws Exception;

    /**
         * Load an existing Coach entity
         *
         */
    public Coach getCoach(Long long1) throws Exception;

    public List<Coach> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Coach> findPageCoach(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberCoach() throws Exception;

    public List<CoachDTO> getDataCoach() throws Exception;

    public void validateCoach(Coach coach) throws Exception;
    
    /*
     R3.CO1: El sistema debe permitir visualizar en qué categoría (de ascenso) se encuentra el coach 
     si se encuentra en uno Ser flexible 
     con el organismo de la certificación, la categoría debe ser opcional..
	R3.CO2: El sistema debe permitir visualizar las horas faltantes (pro-bono y pagas) 
	que le hacen falta al coach para alcanzar determinado ascenso.
	
	R9.CO1: El sistema debe permitir visualizar todos los clientes que tiene asociados
 	el Coach, mostrando la foto y el nombre de cada cliente.
 	
	R11.CO1: El sistema debe permitir al coach visualizar el historial de pagos de los clientes.
     */
    public Categoria categoriaAscenso(Coach coach);
    
    public String horasFaltantesAscenso(Coach coach);
    
    public Set<Coachee>  coacheeDelCoach(Coach coach);
    
    public List<RegContable> historialDePagoDelosCoachee(Coach coach);
    
    public Coach validarCredencialesCoach(String login, String passwd)throws Exception;
    
    public long genSecuencia();
}




