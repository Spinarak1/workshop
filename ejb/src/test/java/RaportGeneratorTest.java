import java.io.File;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import software.entities.*;

@Singleton
@Startup
public class RaportGeneratorTest{
    @PersistenceContext(unitName = "sTest")
    @Test
    public void RaportTest(){
        EntityManager entityManager = null;

        EntityManagerFactory entityManagerFactory = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("sTest");
            entityManager = entityManagerFactory.createEntityManager();

            databaseInit(entityManager);
            RaportGenerator generator = new RaportGenerator();
            generator.sumOfCosts(entityManager, new SimpleDateFormat("yyyy-MM-dd").parse("2018-01-11"), "C:\\Users\\patkrz2\\Desktop\\Test.xml");
            entityManager.close();
            File inputFile = new File("C:\\Users\\spina\\Desktop\\Test.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            Element ServicesS = doc.getDocumentElement();
            Assert.assertEquals("ServiceEntity", ServicesS.getNodeName());
            NodeList ServicesE = ServicesS.getElementsByTagName("Service");
            Assert.assertEquals(4, ServicesE.getLength());
            Element ServicesZ = (Element)ServicesE.item(0);
            Assert.assertEquals("1", ServicesZ.getAttribute("id"));
            NodeList dateOfAcceptanceE = ServicesZ.getElementsByTagName("dateOfAcceptance");
            Assert.assertEquals(1, dateOfAcceptanceE.getLength());
            Element dateOfAcceptanceS = (Element)dateOfAcceptanceE.item(0);
            Assert.assertEquals("2017-05-19", dateOfAcceptanceS.getTextContent());

        } catch (Throwable ex) {
            ex.printStackTrace();
            Assert.assertEquals(1, 0);
        }
    }

    @PostConstruct
    private void databaseInit(EntityManager entityManager){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = "2019-01-21";
        String date2 = "2019-01-23";
        String date3 = "2018-12-23";
        String date4 = "2019-01-11";
        String date5 = "2019 0121";
        String date6 = "20190123";
        try {
            entityManager.getTransaction().begin();

            Date firstDate = formatter.parse(date1);
            Date secondDate = formatter.parse(date2);
            Date thirdDate = formatter.parse(date3);
            Date fourthDate = formatter.parse(date4);
            Date fifthDate = formatter.parse(date5);
            Date sixthDate = formatter.parse(date6);


            ClientEntity c1 = new ClientEntity("Adam", "Walaszek", "Polna 2", "777666555");
            ClientEntity c2 = new ClientEntity("Andrzej", "Misiejuk", "Mickiewicza 12", "999888777");
            ClientEntity c3 = new ClientEntity("Jan", "Kowalski", "Matejki 22", "888777666");

            ServiceEntity s1 = new ServiceEntity(c1, firstDate, secondDate, "Olej");
            ServiceEntity s2 = new ServiceEntity(c2, thirdDate, fourthDate, "Skrzynia");
            ServiceEntity s3 = new ServiceEntity(c3, formatter.parse("2018-3322"), formatter.parse("2018-01-23"), "Opony");

            ActionEntity a1 = new ActionEntity(s1, 200, "Olej");
            ActionEntity a2 = new ActionEntity(s2, 300, "Skrzynia");
            ActionEntity a3 = new ActionEntity(s3, 400, "Opony");

            entityManager.persist(c1);
            entityManager.persist(c2);
            entityManager.persist(c3);

            entityManager.persist(s1);
            entityManager.persist(s2);
            entityManager.persist(s3);

            entityManager.persist(a1);
            entityManager.persist(a2);
            entityManager.persist(a3);
        }catch (ParseException e){
            System.out.println("Incorrect parse");
        }
    }
}