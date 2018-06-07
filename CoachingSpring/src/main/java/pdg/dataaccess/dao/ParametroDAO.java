package pdg.dataaccess.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

import pdg.dataaccess.api.JpaDaoImpl;

import pdg.modelo.Parametro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 * A data access object (DAO) providing persistence and search support for
 * Parametro entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Parametro
 */
@Scope("singleton")
@Repository("ParametroDAO")
public class ParametroDAO extends JpaDaoImpl<Parametro, Double>
    implements IParametroDAO {
    private static final Logger log = LoggerFactory.getLogger(ParametroDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static IParametroDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (IParametroDAO) ctx.getBean("ParametroDAO");
    }

	@Override
	public Parametro findValorSesion() {
		
		Query  listado=  	
  	    	  (Query) entityManager.createQuery("select ses from Parametro ses where "
  	    	  		+ "ses.texto=:valor");
		
		listado.setParameter("valor", "valor");
  
		return (Parametro) listado.getSingleResult();
	}
}
