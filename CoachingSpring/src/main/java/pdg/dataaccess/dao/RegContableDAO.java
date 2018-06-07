package pdg.dataaccess.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

import pdg.dataaccess.api.JpaDaoImpl;

import pdg.modelo.RegContable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * A data access object (DAO) providing persistence and search support for
 * RegContable entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.RegContable
 */
@Scope("singleton")
@Repository("RegContableDAO")
public class RegContableDAO extends JpaDaoImpl<RegContable, Double>
    implements IRegContableDAO {
    private static final Logger log = LoggerFactory.getLogger(RegContableDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static IRegContableDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (IRegContableDAO) ctx.getBean("RegContableDAO");
    }
}
