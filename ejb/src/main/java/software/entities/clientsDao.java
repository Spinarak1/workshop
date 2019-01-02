package software.entities;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.*;

@Startup
@Singleton
public class clientsDao {

    final Set<clientsEntity> clients = new HashSet<>();

    public clientsDao() {}

    @PostConstruct
    void init(){
        clientsEntity cl1 = new clientsEntity(1l,"Pawel", "Grzegorkiewicz", "Polna 2", "777666555");
        clientsEntity cl2 = new clientsEntity(2l,"Adam", "Misiejuk", "Mickiewicza 12", "999888777");
        clientsEntity cl3 = new clientsEntity(3l,"Jan", "Kowalski", "Matejki 22", "888777666");
        clients.add(cl1);
        clients.add(cl2);
        clients.add(cl3);
    }

    public Optional<clientsEntity> getClientsById(long aId){
        return clients.stream().filter(e -> e.getId() == aId).findFirst();
    }

    public List<clientsEntity> getAll(){
        return new ArrayList(clients);
    }

    public clientsEntity addClients(clientsEntity aClients){
        aClients.setId((long) (clients.size()+1));
        clients.add(aClients);
        return aClients;
    }

    public clientsEntity editClients(clientsEntity aClients){
        clientsEntity fromDB = clients.stream().filter(e -> e.getId() == aClients.getId()).findFirst().get();
        fromDB.update(aClients);
        return fromDB;
    }

    public void remove(long aId) {
        clients.remove(new clientsEntity(aId));
    }

    public clientsEntity update(clientsEntity clientsEntity) {
        Optional<clientsEntity> clientsFromDatabase = clients.stream().filter(ent -> ent.getId().equals(clientsEntity.getId())).findFirst();
        clientsFromDatabase.ifPresent(fromDb -> fromDb.update(clientsEntity));
        return clientsFromDatabase.get();
    }
}