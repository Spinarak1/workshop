package software;


import software.entities.ActionEntity;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class InitializeDatabaseBean {


    @PersistenceContext(unitName = "primary")
    protected EntityManager em;

    @PostConstruct
    public void init(){
        em.persist(new ActionEntity(1l, 200, "Olej"));
        em.persist(new ActionEntity(2l, 300, "Skrzynia"));
        em.persist(new ActionEntity(3l, 400, "Opony"));
    }
}
