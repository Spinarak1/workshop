package software;


import com.fasterxml.jackson.annotation.JsonFormat;
import software.entities.ActionEntity;
import software.entities.ClientEntity;
import software.entities.ServiceEntity;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

@Singleton
@Startup
public class InitializeDatabaseBean {


    @PersistenceContext(unitName = "primary")
    protected EntityManager em;

    @PostConstruct
    public void init(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = "2019-01-21";
        String date2 = "2019-01-23";
        try {
            Date firstDate = formatter.parse(date1);
            Date secondDate = formatter.parse(date2);


        ClientEntity c1 = new ClientEntity("Adam", "Walaszek", "Polna 2", "777666555");
        ClientEntity c2 = new ClientEntity("Adam", "Misiejuk", "Mickiewicza 12", "999888777");
        ClientEntity c3 = new ClientEntity("Jan", "Kowalski", "Matejki 22", "888777666");

        ServiceEntity s1 = new ServiceEntity(c1, firstDate, secondDate, "Olej");
        ServiceEntity s2 = new ServiceEntity(c2, firstDate, secondDate, "Skrzynia");
        ServiceEntity s3 = new ServiceEntity(c3, firstDate, secondDate, "Opony");

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
        }catch (ParseException e){
            System.out.println("Incorrect parse");
        }

    }
}
