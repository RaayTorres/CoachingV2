package pdg.dataaccess.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


/**
 *
 * @author <a href="mailto:dgomez@vortexbird.com">Diego A Gomez</a>
 * @project zathuracode
 * @class JpaDaoImpl
 * @date Nov 01, 2013
 *
 */
@SuppressWarnings({"unchecked",
    "rawtypes"
})
public class JpaDaoImpl<T, PK extends Serializable> implements Dao<T, PK> {
    private Class<T> entityClass;
    private Logger log = null;
    @PersistenceContext
    private EntityManager entityManager;
    private int maxResults = 0;

    public JpaDaoImpl() {
        super();
        this.entityClass = (Class<T>) ((ParameterizedType) getClass()
                                                               .getGenericSuperclass()).getActualTypeArguments()[0];
        log = LoggerFactory.getLogger(entityClass);
    }

    public void save(T newEntity) throws DaoException {
        entityManager.persist(newEntity);
    }

    public T findById(long id) {
        return (T) entityManager.find(entityClass, id);
    }

    public void update(T entity) throws DaoException {
        entityManager.merge(entity);
    }

    public void delete(T entity) throws DaoException {
        entityManager.remove(entity);
    }

    public void deleteById(long id) throws DaoException {
        T toRemove = findById(id);
        entityManager.remove(toRemove);
    }

    public void deleteByProperty(String tableName, String propertyName,
        Object value) throws DaoException {
        String queryString = "delete from " + tableName +
            " as model where model." + propertyName + "= ?0";
        Query queryObject = entityManager.createQuery(queryString);
        queryObject.setParameter(0, value);
        queryObject.executeUpdate();
    }

    public void deleteAll() throws DaoException {
        String queryString = "delete from " + entityClass.getName();
        Query queryObject = entityManager.createQuery(queryString);
        queryObject.executeUpdate();
    }

    public Long count() {
        Query query = createQuery("select count(*) from " +
                entityClass.getName());
        Long result = (Long) query.getSingleResult();

        return (result != null) ? result : 0;
    }

    protected Query createQuery(String queryString) {
        Query query = entityManager.createQuery(queryString);
        prepareQuery(query);

        return query;
    }

    protected void prepareQuery(Query queryObject) {
        if (getMaxResults() > 0) {
            queryObject.setMaxResults(getMaxResults());
        }
    }

    public List<T> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<T> cq = cb.createQuery(entityClass);
        Root<T> root = cq.from(entityClass);

        return entityManager.createQuery(cq.select(root)).getResultList();
    }

    public List<T> findPage(String sortColumnName, boolean sortAscending,
        int startRow, int maxResults) {
        log.debug("findPage " + entityClass.getName());

        if ((sortColumnName != null) && (sortColumnName.length() > 0)) {
            try {
                String queryString = "select model from " +
                    entityClass.getName() + " model order by model." +
                    sortColumnName + " " + (sortAscending ? "asc" : "desc");

                Query queryObject = entityManager.createQuery(queryString);
                queryObject.setFirstResult(startRow);
                queryObject.setMaxResults(maxResults);

                return queryObject.getResultList();
            } catch (RuntimeException re) {
                throw re;
            }
        } else {
            try {
                String queryString = "select model from " +
                    entityClass.getName() + " model";

                Query queryObject = entityManager.createQuery(queryString);
                queryObject.setFirstResult(startRow);
                queryObject.setMaxResults(maxResults);

                return queryObject.getResultList();
            } catch (RuntimeException re) {
                log.error("findPage " + entityClass.getName() + " failed", re);
                throw re;
            }
        }
    }

    public List<T> findByCriteria(String whereCondition) {
        log.debug("finding " + entityClass.getName() + " " + whereCondition);

        try {
            String where = ((whereCondition == null) ||
                (whereCondition.length() == 0)) ? "" : ("where " +
                whereCondition);
            final String queryString = "select model from " +
                entityClass.getName() + " model " + where;

            Query queryObject = entityManager.createQuery(queryString);

            return queryObject.getResultList();
        } catch (RuntimeException re) {
            log.error("find By Criteria failed", re);
            throw re;
        }
    }

    public List<T> findByProperty(String propertyName, Object value) {
        log.debug("finding " + entityClass.getName() +
            " instance with property: " + propertyName + ", value: " + value);

        try {
            String queryString = "select model from " + entityClass.getName() +
                " as model where model." + propertyName + "= ?0";
            Query queryObject = entityManager.createQuery(queryString);
            queryObject.setParameter(0, value);

            return queryObject.getResultList();
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public int getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(int maxResults) {
        this.maxResults = maxResults;
    }
    
    
    public long genSecuencia() {
  		// nameSquence= "seq_prueba";
    	
    	String enSt= entityClass.getName();
    	String[] parts = enSt.split(Pattern.quote("."));
    	
    	BigInteger nig= (BigInteger) entityManager.createNativeQuery("select nextval('seq_"+parts[2]+"')").getSingleResult();
    	//Double nue= new BigDecimal(nig).doubleValue();
    	
    	
  		return nig.longValue();
  	}

	@Override
	public T findById(Long idParam) {
		   return (T) entityManager.find(entityClass, idParam);
	}

	@Override
	public void deleteById(Long long1) throws DaoException {
		 T toRemove = findById(long1);
	        entityManager.remove(toRemove);
		
	}


}
