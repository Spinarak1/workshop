package software;


import software.entities.ActionEntity;
import software.entities.ClientEntity;
import software.entities.ServiceEntity;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.GregorianCalendar;

@Singleton
@Startup
public class InitializeDatabaseBean {


    @PersistenceContext(unitName = "primary")
    protected EntityManager em;

    @PostConstruct
    public void init(){
        Date date1 = new GregorianCalendar(2018, 12, 13, 12, 22 ,32).getTime();
        Date date2 = new GregorianCalendar(2018, 12, 15, 12, 22 ,32).getTime();

        ClientEntity c1 = new ClientEntity("Pawel", "Grzegorkiewicz", "Polna 2", "777666555");
        ClientEntity c2 = new ClientEntity("Adam", "Misiejuk", "Mickiewicza 12", "999888777");
        ClientEntity c3 = new ClientEntity("Jan", "Kowalski", "Matejki 22", "888777666");

        ServiceEntity s1 = new ServiceEntity(c1, date1, date2, "Olej");
        ServiceEntity s2 = new ServiceEntity(c2, date1, date2, "Skrzynia");
        ServiceEntity s3 = new ServiceEntity(c3, date1, date2, "Opony");

        ActionEntity a1 = new ActionEntity(s1, 200, "Olej");
        ActionEntity a2 = new ActionEntity(s2, 300, "Skrzynia");
        ActionEntity a3 = new ActionEntity(s3, 400, "Opony");

        em.persist(c1);
        em.persist(c2);
        em.persist(c3);

        em.persist(s1);
        em.persist(s2);
        em.persist(s3);

        em.persist(a1);
        em.persist(a2);
        em.persist(a3);

    }
}
