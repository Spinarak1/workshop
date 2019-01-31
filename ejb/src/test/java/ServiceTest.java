import junit.framework.Assert;
import org.junit.Test;
import software.entities.ClientEntity;
import software.entities.ServiceEntity;

import java.time.LocalDate;

public class ServiceTest {

    @Test
    public void testCreate() {
        ClientEntity client1 = new ClientEntity("Jan", "Grzelczyk", "Winna góra 11", "4422112233");
        String description = "Wymiana nagrzewnicy";
        LocalDate l1 = LocalDate.of(2019, 01, 30);
        LocalDate l2 = LocalDate.of(2019, 01, 31);
        ServiceEntity service = new ServiceEntity(client1, l1, l2, description);
        Assert.assertNotNull(service);
    }


    @Test
    public void testSetValue() {
        ClientEntity client1 = new ClientEntity("Jan", "Grzelczyk", "Winna góra 11", "4422112233");
        ServiceEntity service1 = new ServiceEntity(client1, LocalDate.of(2019,01,20),  LocalDate.of(2019,01,21), "wymiana oleju");
        service1.setClient(client1);
        Assert.assertEquals(true, service1.getClient().equals(client1));
        service1.setDateOfAcceptance(LocalDate.of(2019,01,20));
        Assert.assertEquals(true, service1.getDateOfAcceptance().equals(LocalDate.of(2019,01,20)));
        service1.setDateOfAcceptance(LocalDate.of(2019,01,21));
        Assert.assertEquals(true, service1.getDateOfAcceptance().equals(LocalDate.of(2019,01,21)));
        service1.setDescription("wymiana oleju");
        Assert.assertEquals(true, service1.getDescription().equals("wymiana oleju"));
    }
    @Test
    public void testSetWrongValue(){
        ClientEntity client = new ClientEntity("Andrzej", "Wawrzyniak", "Winna góra 11", "4422112233");
        ClientEntity client1 = new ClientEntity("Jan", "Grzelczyk", "Winna góra 15", "4422112233");
        ServiceEntity service1 = new ServiceEntity(client1, LocalDate.of(2019,01,20),  LocalDate.of(2019,01,21), "wymiana oleju");
        service1.setDescription("wymiana skrzyni");
        Assert.assertEquals(false, service1.getDescription().equals("Jan"));
        service1.setDateOfAcceptance(LocalDate.of(2019,01,19));
        Assert.assertEquals(false, service1.getDateOfAcceptance().equals(LocalDate.of(2019,11,20)));
        service1.setEndDate(LocalDate.of(2019,01,21));
        Assert.assertEquals(false, service1.getEndDate().equals(LocalDate.of(2019,12,19)));
    }
}