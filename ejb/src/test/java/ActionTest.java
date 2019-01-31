import junit.framework.Assert;
import org.junit.Test;
import software.entities.ActionEntity;
import software.entities.ClientEntity;
import software.entities.ServiceEntity;

import java.time.LocalDate;

public class ActionTest {

    @Test
    public void testCreate() {
        String decription = "Franciszek";
        int amount = 200;
        ServiceEntity service = new ServiceEntity(new ClientEntity("Paweł","Marciniak", "Romana Drewsa", "99433223"), LocalDate.of(2019,01,12),  LocalDate.of(2019,01,20), "wymiana oleju");
        ActionEntity action = new ActionEntity(service, amount, decription);
        Assert.assertNotNull(action);
    }


    @Test
    public void testSetValue() {
        ServiceEntity service = new ServiceEntity(new ClientEntity("Paweł","Marciniak", "Romana Drewsa", "99433223"), LocalDate.of(2019,01,12),  LocalDate.of(2019,01,20), "wymiana oleju");
        ActionEntity action = new ActionEntity(service, 100, "Rozrząd");
        action.setAmount(2000);
        Assert.assertEquals(true, action.getAmount() == 2000);
        action.setDescription("Wymiana paska klinowego");
        Assert.assertEquals(true, action.getDescription().equals("Wymiana paska klinowego"));
    }
    @Test
    public void testSetWrongValue(){
        ServiceEntity service = new ServiceEntity(new ClientEntity("Paweł","Marciniak", "Romana Drewsa", "99433223"), LocalDate.of(2019,01,12),  LocalDate.of(2019,01,20), "wymiana oleju");
        ServiceEntity service1 = new ServiceEntity(new ClientEntity("Jan","Fabiański", "Romana Drewsa", "99433223"), LocalDate.of(2019,01,20),  LocalDate.of(2019,01,21), "wymiana oleju");
        ActionEntity action = new ActionEntity(service, 100, "Rozrząd");
        action.setAmount(100);
        Assert.assertEquals(false, action.getAmount() == 200);
        action.setDescription("Naprawa błotnika");
        Assert.assertEquals(false, action.getDescription().equals("Maciej"));
    }
}