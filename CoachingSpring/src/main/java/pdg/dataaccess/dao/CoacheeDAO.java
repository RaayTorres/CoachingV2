package pdg.dataaccess.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

import pdg.dataaccess.api.JpaDaoImpl;
import pdg.modelo.Coach;
import pdg.modelo.Coachee;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * A data access object (DAO) providing persistence and search support for
 * Coachee entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Coachee
 */
@Scope("singleton")
@Repository("CoacheeDAO")
public class CoacheeDAO extends JpaDaoImpl<Coachee, Double>
    implements ICoacheeDAO {
    private static final Logger log = LoggerFactory.getLogger(CoacheeDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static ICoacheeDAO getFromApplicationContext(ApplicationContext ctx) {
        return (ICoacheeDAO) ctx.getBean("CoacheeDAO");
    }
    
    public Coachee consultarClientePorLogin(String identificacion) {
		
    	
		String consulta = "SELECT usu FROM Coachee usu WHERE usu.identificacion=:identificacion";
		//return (Usuarios)entityManager.createQuery(jpql).setParameter("login", usuLogin).getSingleResult();
		return (Coachee)entityManager.createQuery(consulta).setParameter("identificacion", identificacion).getSingleResult();
	}

	@Override
	public Coachee consultarClientePorLoginReal(String login) {
		
		String consulta = "SELECT usu FROM Coachee usu WHERE usu.login=:login";
		
		return (Coachee)entityManager.createQuery(consulta).setParameter("login", login).getSingleResult();
	}
	
	
	}
