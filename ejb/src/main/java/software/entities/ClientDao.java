package software.entities;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Stateless
public class ClientDao {

    @PersistenceContext(unitName = "primary")
    protected EntityManager em;

    public ClientDao() {
    }

    public Optional<ClientEntity> getClientsById(long aId){
        return Optional.of(em.find(ClientEntity.class, aId));
    }

    public List<ClientEntity> getAll(){
        return em.createQuery("SELECT b FROM ClientEntity b", ClientEntity.class).getResultList();
    }

    public ClientEntity addClients(ClientEntity aClients){
        em.persist(aClients);
        return aClients;
    }

    public void remove(long aId) {
        ClientEntity aClient = getClientsById(aId).get();
        em.remove(aClient);
    }

    public ClientEntity update(ClientEntity aClient) {
        return em.merge(aClient);
    }
}