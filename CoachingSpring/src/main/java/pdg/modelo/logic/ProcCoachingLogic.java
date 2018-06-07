package pdg.modelo.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pdg.dataaccess.dao.*;

import pdg.dto.mapper.IProcCoachingMapper;

import pdg.exceptions.*;

import pdg.modelo.*;

import pdg.modelo.dto.ProcCoachingDTO;

import pdg.utilities.Utilities;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("ProcCoachingLogic")
public class ProcCoachingLogic implements IProcCoachingLogic {
    private static final Logger log = LoggerFactory.getLogger(ProcCoachingLogic.class);

    /**
     * DAO injected by Spring that manages ProcCoaching entities
     *
     */
    @Autowired
    private IProcCoachingDAO procCoachingDAO;
    @Autowired
    private IProcCoachingMapper procCoachingMapper;
    @Autowired
    private Validator validator;

    /**
    * DAO injected by Spring that manages SesCoaching entities
    *
    */
    @Autowired
    private ISesCoachingDAO sesCoachingDAO;
    
    @Autowired
    private IEstadoDAO estadoDAo;
    
    
    @Autowired
    private IParametroDAO parametro;
    
    @Autowired
    ISesCoachingLogic sesLogic;
  
    /**
    * Logic injected by Spring that manages Coach entities
    *
    */
    @Autowired
    ICoachLogic logicCoach1;

    /**
    * Logic injected by Spring that manages Coachee entities
    *
    */
    @Autowired
    ICoacheeLogic logicCoachee2;

    /**
    * Logic injected by Spring that manages RegContable entities
    *
    */
    @Autowired
    IRegContableLogic logicRegContable3;
    
    
    @Autowired
    IEstadoLogic logicEstado;


    public void validateProcCoaching(ProcCoaching procCoaching)
        throws Exception {
        try {
            Set<ConstraintViolation<ProcCoaching>> constraintViolations = validator.validate(procCoaching);

            if (constraintViolations.size() > 0) {
                StringBuilder strMessage = new StringBuilder();

                for (ConstraintViolation<ProcCoaching> constraintViolation : constraintViolations) {
                    strMessage.append(constraintViolation.getPropertyPath()
                                                         .toString());
                    strMessage.append(" - ");
                    strMessage.append(constraintViolation.getMessage());
                    strMessage.append(". \n");
                }

                throw new Exception(strMessage.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ProcCoaching> getProcCoaching(Coach id) throws Exception {
        log.debug("finding all ProcCoaching instances");

        List<ProcCoaching> list = new ArrayList<ProcCoaching>();

        try {
        	for (ProcCoaching procCoaching : procCoachingDAO.findAll()) {
				if (procCoaching.getCoach().getIdCoach() == id.getIdCoach()) {
					list.add(procCoaching);
				}
			}
        } catch (Exception e) {
            log.error("finding all ProcCoaching failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "ProcCoaching");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveProcCoaching(ProcCoaching entity) throws Exception {
        log.debug("saving ProcCoaching instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("ProcCoaching");
            }
entity.setIdProc(procCoachingDAO.genSecuencia());
            validateProcCoaching(entity);

            if (getProcCoaching(entity.getIdProc()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }
entity.setFocoProceso("No definido");
            procCoachingDAO.save(entity);
            
            Long l = 0L;
            for (int i = 0; i < 10; i++) {
            	SesCoaching  newEntity= new SesCoaching();
            	
            	newEntity.setIdSesi(sesCoachingDAO.genSecuencia());
            	newEntity.setProcCoaching(entity);
            	newEntity.setIdHis(entity.getRegContable().getIdHis());
            	l++;
            	newEntity.setNumSes(l);
            //TODO problemas ocn el metodo getEstadoSesion	
            	
            	newEntity.setEstado(logicEstado.getEstadoSesion(2));
            	//Estado incompleto id 3
            	newEntity.setEstado(logicEstado.getEstado(3L));

            	newEntity.setPrecio(parametro.findValorSesion().getNumero());
            	
            	newEntity.setTipoSes("Pagada");
            	
            	newEntity.setFocoSesion("No definido");
            	
            	RegContable reg= entity.getRegContable();
            	
            	reg.setCredito(parametro.findValorSesion().getNumero() *10);
            	
            	logicRegContable3.updateRegContable(reg);
				sesLogic.saveSesCoaching(newEntity);
				
			//	sesLogic.updateSesCoaching(newEntity);
				log.info("Creando sesion ");
			}
            
            log.debug("save ProcCoaching successful");
        } catch (Exception e) {
            log.error("save ProcCoaching failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteProcCoaching(ProcCoaching entity)
        throws Exception {
        log.debug("deleting ProcCoaching instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("ProcCoaching");
        }

        if (entity.getIdProc() == null) {
            throw new ZMessManager().new EmptyFieldException("idProc");
        }

        List<SesCoaching> sesCoachings = null;

        try {
            sesCoachings = sesCoachingDAO.findByProperty("procCoaching.idProc",
                    entity.getIdProc());

            if (Utilities.validationsList(sesCoachings) == true) {
                throw new ZMessManager().new DeletingException("sesCoachings");
            }

            procCoachingDAO.deleteById(entity.getIdProc());
            log.debug("delete ProcCoaching successful");
        } catch (Exception e) {
            log.error("delete ProcCoaching failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateProcCoaching(ProcCoaching entity)
        throws Exception {
        log.debug("updating ProcCoaching instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("ProcCoaching");
            }

            validateProcCoaching(entity);

            procCoachingDAO.update(entity);

            log.debug("update ProcCoaching successful");
        } catch (Exception e) {
            log.error("update ProcCoaching failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<ProcCoachingDTO> getDataProcCoaching()
        throws Exception {
        try {
            List<ProcCoaching> procCoaching = procCoachingDAO.findAll();

            List<ProcCoachingDTO> procCoachingDTO = new ArrayList<ProcCoachingDTO>();

            for (ProcCoaching procCoachingTmp : procCoaching) {
                ProcCoachingDTO procCoachingDTO2 = procCoachingMapper.procCoachingToProcCoachingDTO(procCoachingTmp);
                procCoachingDTO.add(procCoachingDTO2);
            }

            return procCoachingDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public ProcCoaching getProcCoaching(Long idProc)
        throws Exception {
        log.debug("getting ProcCoaching instance");

        ProcCoaching entity = null;

        try {
            entity = procCoachingDAO.findById(idProc);
        } catch (Exception e) {
            log.error("get ProcCoaching failed", e);
            throw new ZMessManager().new FindingException("ProcCoaching");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<ProcCoaching> findPageProcCoaching(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<ProcCoaching> entity = null;

        try {
            entity = procCoachingDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("ProcCoaching Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberProcCoaching() throws Exception {
        Long entity = null;

        try {
            entity = procCoachingDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("ProcCoaching Count");
        } finally {
        }

        return entity;
    }

    /**
    *
    * @param varibles
    *            este arreglo debera tener:
    *
    * [0] = String variable = (String) varibles[i]; representa como se llama la
    * variable en el pojo
    *
    * [1] = Boolean booVariable = (Boolean) varibles[i + 1]; representa si el
    * valor necesita o no ''(comillas simples)usado para campos de tipo string
    *
    * [2] = Object value = varibles[i + 2]; representa el valor que se va a
    * buscar en la BD
    *
    * [3] = String comparator = (String) varibles[i + 3]; representa que tipo
    * de busqueda voy a hacer.., ejemplo: where nombre=william o where nombre<>william,
        * en este campo iria el tipo de comparador que quiero si es = o <>
            *
            * Se itera de 4 en 4..., entonces 4 registros del arreglo representan 1
            * busqueda en un campo, si se ponen mas pues el continuara buscando en lo
            * que se le ingresen en los otros 4
            *
            *
            * @param variablesBetween
            *
            * la diferencia son estas dos posiciones
            *
            * [0] = String variable = (String) varibles[j]; la variable ne la BD que va
            * a ser buscada en un rango
            *
            * [1] = Object value = varibles[j + 1]; valor 1 para buscar en un rango
            *
            * [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en un rango
            * ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria value2
                *
                * [3] = String comparator1 = (String) varibles[j + 3]; comparador 1
                * ejemplo: a comparator1 1 and a < 5
                    *
                    * [4] = String comparator2 = (String) varibles[j + 4]; comparador 2
                    * ejemplo: a comparador1>1  and a comparador2<5  (el original: a > 1 and a <
                            * 5) *
                            * @param variablesBetweenDates(en
                            *            este caso solo para mysql)
                            *  [0] = String variable = (String) varibles[k]; el nombre de la variable que hace referencia a
                            *            una fecha
                            *
                            * [1] = Object object1 = varibles[k + 2]; fecha 1 a comparar(deben ser
                            * dates)
                            *
                            * [2] = Object object2 = varibles[k + 3]; fecha 2 a comparar(deben ser
                            * dates)
                            *
                            * esto hace un between entre las dos fechas.
                            *
                            * @return lista con los objetos que se necesiten
                            * @throws Exception
                            */
    @Transactional(readOnly = true)
    public List<ProcCoaching> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<ProcCoaching> list = new ArrayList<ProcCoaching>();
        String where = new String();
        String tempWhere = new String();

        if (variables != null) {
            for (int i = 0; i < variables.length; i++) {
                if ((variables[i] != null) && (variables[i + 1] != null) &&
                        (variables[i + 2] != null) &&
                        (variables[i + 3] != null)) {
                    String variable = (String) variables[i];
                    Boolean booVariable = (Boolean) variables[i + 1];
                    Object value = variables[i + 2];
                    String comparator = (String) variables[i + 3];

                    if (booVariable.booleanValue()) {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " \'" +
                            value + "\' )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " \'" + value + "\' )");
                    } else {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " " +
                            value + " )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " " + value + " )");
                    }
                }

                i = i + 3;
            }
        }

        if (variablesBetween != null) {
            for (int j = 0; j < variablesBetween.length; j++) {
                if ((variablesBetween[j] != null) &&
                        (variablesBetween[j + 1] != null) &&
                        (variablesBetween[j + 2] != null) &&
                        (variablesBetween[j + 3] != null) &&
                        (variablesBetween[j + 4] != null)) {
                    String variable = (String) variablesBetween[j];
                    Object value = variablesBetween[j + 1];
                    Object value2 = variablesBetween[j + 2];
                    String comparator1 = (String) variablesBetween[j + 3];
                    String comparator2 = (String) variablesBetween[j + 4];
                    tempWhere = (tempWhere.length() == 0)
                        ? ("(" + value + " " + comparator1 + " " + variable +
                        " and " + variable + " " + comparator2 + " " + value2 +
                        " )")
                        : (tempWhere + " AND (" + value + " " + comparator1 +
                        " " + variable + " and " + variable + " " +
                        comparator2 + " " + value2 + " )");
                }

                j = j + 4;
            }
        }

        if (variablesBetweenDates != null) {
            for (int k = 0; k < variablesBetweenDates.length; k++) {
                if ((variablesBetweenDates[k] != null) &&
                        (variablesBetweenDates[k + 1] != null) &&
                        (variablesBetweenDates[k + 2] != null)) {
                    String variable = (String) variablesBetweenDates[k];
                    Object object1 = variablesBetweenDates[k + 1];
                    Object object2 = variablesBetweenDates[k + 2];
                    String value = null;
                    String value2 = null;

                    try {
                        Date date1 = (Date) object1;
                        Date date2 = (Date) object2;
                        value = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date1);
                        value2 = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date2);
                    } catch (Exception e) {
                        list = null;
                        throw e;
                    }

                    tempWhere = (tempWhere.length() == 0)
                        ? ("(model." + variable + " between " + value +
                        " and " + value2 + ")")
                        : (tempWhere + " AND (model." + variable + " between " +
                        value + " and " + value2 + ")");
                }

                k = k + 2;
            }
        }

        if (tempWhere.length() == 0) {
            where = null;
        } else {
            where = "(" + tempWhere + ")";
        }

        try {
            list = procCoachingDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
    
    
/*
 * R4.SE1: El sistema debe permitir crear un proceso de coaching para un cliente determinado,
 *  con un número de sesiones por defecto que podrán ser modificadas en aspectos tales como 
 *  (la fecha de la sesión, el tiempo, compromiso, acciones, indicadores, foco del proceso, profundidad).
R4.SE2: El sistema debe permitir añadir, modificar o remover sesiones a un proceso de Coaching si es necesario.
R10.SE1: El sistema debe permitir visualizar y filtrar las sesiones en (activas o completadas)
 que tiene un coach y dentro de cada sesión mostrar la fecha en la que se realizará o realizó la sesión.

 */
    
    public int progresoProceso( long coach, long client) throws Exception {
    	
    	double progreso = 0;
    	//Coachee cliente= logicCoachee2.getCoachee(client);
    	
    	List<SesCoaching> pro = procCoachingDAO.sesionesProcesoCoachee(client, coach, 2L);
    	List<SesCoaching> totas= procCoachingDAO.sesionesTotalesProcesoCoachee(client, coach);
    	Double p = (double) (pro.size())/(totas.size());
    	
	
//	
//	System.out.println(num + "-------------------------------------------");
//	System.out.println(den + "-------------------------------------------");
//			
//		 progreso = ((num)/(den)) * 100;
//			
		
		
    	
    	
    	return (int) (p*100);
    }

	@Override
	public List<SesCoaching> sesionesCoachee(long coach, long client, long proc) {
		//
		return procCoachingDAO.sesionesTotalesProcesoCoacheeUnico(client, coach,proc);
	}

	@Override
	public List<SesCoaching> sesionesProceso(long proc) {
	
		return procCoachingDAO.sesionesProceso(proc);
	}
    
}
