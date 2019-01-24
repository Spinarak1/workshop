package software.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class RaportGeneratorSheduler {

    @PersistenceContext
    private EntityManager entityManager;

    private static final Logger log = LoggerFactory.getLogger(RaportGeneratorSheduler.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Schedule(second = "*/5", minute = "*", hour = "*", persistent = true)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
        try {
            RaportGenerator generator = new RaportGenerator();
            generator.sumCostsOfYesterday(entityManager, "C:\\Users\\spina\\Desktop\\XML\\");
        }catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
        } finally {
        }
    }}