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
 * Coach entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Coach
 */
@Scope("singleton")
@Repository("CoachDAO")
public class CoachDAO extends JpaDaoImpl<Coach, Double> implements ICoachDAO {
    private static final Logger log = LoggerFactory.getLogger(CoachDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static ICoachDAO getFromApplicationContext(ApplicationContext ctx) {
        return (ICoachDAO) ctx.getBean("CoachDAO");
    }

	@Override
	public Coach consultarCoachPorLogin(String login) {
		
		
		String consulta = "SELECT usu FROM Coach usu WHERE usu.login=:login";
		return (Coach)entityManager.createQuery(consulta).setParameter("login", login).getSingleResult();
	}
}
