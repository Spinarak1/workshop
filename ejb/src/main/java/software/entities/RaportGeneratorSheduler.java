package software.entities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RaportGeneratorSheduler {

    @PersistenceContext(unitName = "primary")
    protected EntityManager em;

    private static final Logger log = LoggerFactory.getLogger(RaportGeneratorSheduler.class);

    @Schedule(second = "*/5", minute = "*", hour = "*", persistent = true)
    public void reportCurrentTime() {
        try {
            RaportGenerator generator = new RaportGenerator();
            generator.sumCostsOfYesterday(em, "C:\\Users\\spina\\Desktop\\XML\\");
            convertToPDF.convert();
        }catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
        } finally {
        }
    }}