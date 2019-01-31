import junit.framework.Assert;
import org.junit.Test;
import software.entities.ClientEntity;

public class ClientTest {

    @Test
    public void testCreate() {
        String name = "Franciszek";
        String surname = "Szczepaniak";
        String address = "Willowa 8";
        String phoneNumber = "777322111";
        ClientEntity client = new ClientEntity(name, surname, address, phoneNumber);
        Assert.assertNotNull(client);
    }


        @Test
        public void testSetValue() {
            ClientEntity client1 = new ClientEntity("Jan", "Grzelczyk", "Winna góra 11", "4422112233");
            client1.setAddress("Akacjowa 7");
            Assert.assertEquals(true, client1.getAddress().equals("Akacjowa 7"));
            client1.setName("Jacek");
            Assert.assertEquals(true, client1.getName().equals("Jacek"));
            client1.setSurname("Mierzejewski");
            Assert.assertEquals(true, client1.getSurname().equals("Mierzejewski"));
            client1.setPhoneNumber("111199922");
            Assert.assertEquals(true, client1.getPhoneNumber().equals("111199922"));
        }
        @Test
        public void testSetWrongValue(){
            ClientEntity client1 = new ClientEntity("Jan", "Grzelczyk", "Winna góra 11", "4422112233");
            client1.setAddress("Akacjowa 7");
            Assert.assertEquals(false, client1.getAddress().equals("Morelowa 7"));
            client1.setName("Jacek");
            Assert.assertEquals(false, client1.getName().equals("Maciej"));
            client1.setSurname("Mierzejewski");
            Assert.assertEquals(false, client1.getSurname().equals("Maciejewicz"));
            client1.setPhoneNumber("111199922");
            Assert.assertEquals(false, client1.getPhoneNumber().equals("2211"));
    }
}