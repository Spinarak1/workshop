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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDao clientDao = (ClientDao) o;
        return Objects.equals(em, clientDao.em);
    }

    @Override
    public int hashCode() {
        return Objects.hash(em);
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