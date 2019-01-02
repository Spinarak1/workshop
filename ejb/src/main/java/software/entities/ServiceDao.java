package software.entities;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Stateless
public class ServiceDao {

    @PersistenceContext(unitName = "primary")
    protected EntityManager em;

    public ServiceDao(){}

    public Optional<ServiceEntity> getServicesById(long aId){
        return Optional.of(em.find(ServiceEntity.class, aId));
    }

    public List<ServiceEntity> getAll(){
        return em.createQuery("SELECT b FROM ServiceEntity b", ServiceEntity.class).getResultList();
    }

    public ServiceEntity addService(ServiceEntity aService){
        em.persist(aService);
        return aService;
    }

    public void remove(long aId) {
        ServiceEntity aService = getServicesById(aId).get();
        em.remove(aService);
    }

    public ServiceEntity update(ServiceEntity aService) {
        return em.merge(aService);
    }
}