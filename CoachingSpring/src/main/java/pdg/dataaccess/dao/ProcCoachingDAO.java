package pdg.dataaccess.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

import pdg.dataaccess.api.JpaDaoImpl;

import pdg.modelo.ProcCoaching;
import pdg.modelo.SesCoaching;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 * A data access object (DAO) providing persistence and search support for
 * ProcCoaching entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.ProcCoaching
 */
@Scope("singleton")
@Repository("ProcCoachingDAO")
public class ProcCoachingDAO extends JpaDaoImpl<ProcCoaching, Double>
    implements IProcCoachingDAO {
    private static final Logger log = LoggerFactory.getLogger(ProcCoachingDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static IProcCoachingDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (IProcCoachingDAO) ctx.getBean("ProcCoachingDAO");
    }
    
    public SesCoaching ultimaSesion(String esta){
    	
   	 SesCoaching listado=  	
   	    	 (SesCoaching) entityManager.createNativeQuery("select ses from SES_COACHING ses where ses.estado.nombreEstado="
   	    			 + esta+"and max(ses.fecha)").getSingleResult();
   	    
   	return listado;
   }
    
    public List<SesCoaching> sesionesProcesoCoachee(long idCoachee, long idCoach, long esta){
    	
    	Query  listado=  	
    	    	  (Query) entityManager.createQuery("select ses from SesCoaching ses where ses.procCoaching.coach.idCoach=:idCoach "
		  		+ "and ses.procCoaching.coachee.idCoachee=:idCoachee "
		  		+ "and ses.estado.idEstado=:Completo");
    	listado.setParameter("idCoachee", idCoachee);
    	listado.setParameter("idCoach", idCoach);
    	listado.setParameter("Completo", esta);

    	    
    	return listado.getResultList();
    }
    
    
   public List<SesCoaching> sesionesTotalesProcesoCoachee(long idCoachee, long idCoach){
    	
    	Query  listado=  	
    	    	  (Query) entityManager.createQuery("select ses from SesCoaching ses where ses.procCoaching.coach.idCoach=:idCoach "
		  		+ "and ses.procCoaching.coachee.idCoachee=:idCoachee");
    	listado.setParameter("idCoachee", idCoachee);
    	listado.setParameter("idCoach", idCoach);
    	//listado.setParameter("Completo", esta);
    	return listado.getResultList();
    
   }
   
   public List<SesCoaching> sesionesTotalesProcesoCoacheeUnico(long idCoachee, long idCoach, long proc){
		Query  listado=  	
  	    	  (Query) entityManager.createQuery("select ses from SesCoaching ses where ses.procCoaching.coach.idCoach=:idCoach "
		  		+ "and ses.procCoaching.coachee.idCoachee=:idCoachee "+ "and ses.procCoaching.idProc=:proc");
  	listado.setParameter("idCoachee", idCoachee);
  	listado.setParameter("idCoach", idCoach);
  	listado.setParameter("proc", proc);
  	return listado.getResultList();
   }
   
   public List<SesCoaching> sesionesProceso(long proc){
		Query  listado=  	
  	    	  (Query) entityManager.createQuery("select ses from SesCoaching ses where ses.procCoaching.idProc=:proc");
  //	listado.setParameter("idCoachee", idCoachee);
  //	listado.setParameter("idCoach", idCoach);
  	listado.setParameter("proc", proc);
  	return listado.getResultList();
   }
   
}
