package pdg.modelo.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pdg.dataaccess.dao.*;

import pdg.dto.mapper.ISesCoachingMapper;

import pdg.exceptions.*;

import pdg.modelo.*;

import pdg.modelo.dto.SesCoachingDTO;

import pdg.utilities.Utilities;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;


/**
 * @author Zathura Code Generator http://zathuracode.org
 * www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("SesCoachingLogic")
public class SesCoachingLogic implements ISesCoachingLogic {
	private static final Logger log = LoggerFactory.getLogger(SesCoachingLogic.class);

	/**
	 * DAO injected by Spring that manages SesCoaching entities
	 *
	 */
	@Autowired
	private ISesCoachingDAO sesCoachingDAO;
	@Autowired
	private ISesCoachingMapper sesCoachingMapper;
	@Autowired
	private Validator validator;
	@Autowired
	private IEstadoDAO estadoDao;


	@Autowired
	private IParametroDAO parametro;
	/**
	 * Logic injected by Spring that manages Estado entities
	 *
	 */
	@Autowired
	IEstadoLogic logicEstado1;

	/**
	 * Logic injected by Spring that manages ProcCoaching entities
	 *
	 */
	@Autowired
	IProcCoachingLogic logicProcCoaching2;

	public void validateSesCoaching(SesCoaching sesCoaching)
			throws Exception {
		try {
			Set<ConstraintViolation<SesCoaching>> constraintViolations = validator.validate(sesCoaching);

			if (constraintViolations.size() > 0) {
				StringBuilder strMessage = new StringBuilder();

				for (ConstraintViolation<SesCoaching> constraintViolation : constraintViolations) {
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
	public List<SesCoaching> getSesCoaching() throws Exception {
		log.debug("finding all SesCoaching instances");

		List<SesCoaching> list = new ArrayList<SesCoaching>();

		try {
			list = sesCoachingDAO.findAll();
		} catch (Exception e) {
			log.error("finding all SesCoaching failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL +
					"SesCoaching");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveSesCoaching(SesCoaching entity) throws Exception {
		log.debug("saving SesCoaching instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("SesCoaching");
			}

			validateSesCoaching(entity);

			if (getSesCoaching(entity.getIdSesi()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			Date d = new Date(2,2,2);
			entity.setFecha(d);
			sesCoachingDAO.save(entity);
			log.debug("save SesCoaching successful");
		} catch (Exception e) {
			log.error("save SesCoaching failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteSesCoaching(SesCoaching entity) throws Exception {
		log.debug("deleting SesCoaching instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("SesCoaching");
		}

		if (entity.getIdSesi() == null) {
			throw new ZMessManager().new EmptyFieldException("idSesi");
		}

		try {
			sesCoachingDAO.deleteById(entity.getIdSesi());
			log.debug("delete SesCoaching successful");
		} catch (Exception e) {
			log.error("delete SesCoaching failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateSesCoaching(SesCoaching entity) throws Exception {
		log.debug("updating SesCoaching instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("SesCoaching");
			}

			validateSesCoaching(entity);
//			if (entity.getTipoSes().equalsIgnoreCase("Pro-bono")) {
//				entity.setPrecio(parametro.findValorSesion().getNumero());
//				//entity.setPrecio(precio);
//
		//	}
		if (entity.getCompromiso() != null) {
				entity.setEstado(logicEstado1.getEstado(2L));

			}

			sesCoachingDAO.update(entity);

			log.debug("update SesCoaching successful");
		} catch (Exception e) {
			log.error("update SesCoaching failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<SesCoachingDTO> getDataSesCoaching() throws Exception {
		try {
			List<SesCoaching> sesCoaching = sesCoachingDAO.findAll();

			List<SesCoachingDTO> sesCoachingDTO = new ArrayList<SesCoachingDTO>();

			for (SesCoaching sesCoachingTmp : sesCoaching) {
				SesCoachingDTO sesCoachingDTO2 = sesCoachingMapper.sesCoachingToSesCoachingDTO(sesCoachingTmp);
				sesCoachingDTO.add(sesCoachingDTO2);
			}

			return sesCoachingDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public SesCoaching getSesCoaching(Long long1) throws Exception {
		log.debug("getting SesCoaching instance");

		SesCoaching entity = null;

		try {
			entity = sesCoachingDAO.findById(long1);
		} catch (Exception e) {
			log.error("get SesCoaching failed", e);
			throw new ZMessManager().new FindingException("SesCoaching");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<SesCoaching> findPageSesCoaching(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
					throws Exception {
		List<SesCoaching> entity = null;

		try {
			entity = sesCoachingDAO.findPage(sortColumnName, sortAscending,
					startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("SesCoaching Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberSesCoaching() throws Exception {
		Long entity = null;

		try {
			entity = sesCoachingDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("SesCoaching Count");
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
	public List<SesCoaching> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
					throws Exception {
		List<SesCoaching> list = new ArrayList<SesCoaching>();
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
			list = sesCoachingDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	public List<SesCoaching> filtrarSesionPorEstado(Long esta) {


		List<SesCoaching> sesion = sesCoachingDAO.filtrarSesionPorEstado(estadoDao.findById(esta).getIdEstado());
		List<SesCoaching> listado=  new ArrayList<SesCoaching>();
		SesCoaching ses = new SesCoaching();

		for (int i = 0; i < sesion.size(); i++) {
			if (sesion!=null) {
				System.out.println(sesCoachingDAO.findById(sesion.get(i).getIdSesi()) + "++++++++++++++++++++++++++++++++++++++");
				//ses = ;
				listado.add(sesCoachingDAO.findById(sesion.get(i).getIdSesi()));
			}

		}
		return listado;
	}



	public List<SesCoaching> sesionesHoy(Coach coc) {
		List<SesCoaching> sesiones= sesCoachingDAO.findAll() ;
		List<SesCoaching> sesionesHoy= new ArrayList<SesCoaching>();
		Date dat= new Date();



		for (SesCoaching sesCoaching : sesiones) {
			Date fecha =sesCoaching.getFecha();
			if (coc.getIdCoach() == sesCoaching.getProcCoaching().getCoach().getIdCoach()) {


				if (fecha.getDay()==dat.getDay() && fecha.getMonth() == dat.getMonth()
						&& fecha.getYear()== dat.getYear()) {
					sesionesHoy.add(sesCoaching);
				}
			}
		}

		return sesionesHoy;

	}


	public List<Coachee> clientesSesionesHoy(Coach coc){

		List<SesCoaching> sesiones= sesionesHoy(coc);
		List<Coachee> coachee= new ArrayList<Coachee>();
		for (SesCoaching sesCoaching : sesiones) {
			System.out.println(sesCoaching.getProcCoaching().getIdProc());

			coachee.add(sesCoaching.getProcCoaching().getCoachee());
		}

		return coachee;
	}

	public Set<SesCoaching> sesionCompletas(ProcCoaching pro){

		Set<SesCoaching> sesiones=  pro.getSesCoachings();
		Set<SesCoaching> sesiCom= new HashSet<SesCoaching>();
		for (SesCoaching sesCoaching : sesiones) {
			if (sesCoaching.getEstado().getNombreEstado().trim().equalsIgnoreCase("completa")) {
				sesiCom.add(sesCoaching);
			}
		}


		return sesiCom;
	}




}

