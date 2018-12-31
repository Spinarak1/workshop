package software.entities;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Stateless
public class ActionDao {

    @PersistenceContext(unitName = "primary")
    protected EntityManager em;

    public ActionDao() {
    }

    public Optional<ActionEntity> getActionsById(long aId){
        return Optional.of(em.find(ActionEntity.class, aId));
    }

    public List<ActionEntity> getAll(){
        return em.createQuery("SELECT b FROM ActionEntity b", ActionEntity.class).getResultList();
    }

    public ActionEntity addActions(ActionEntity aActions){
        em.persist(aActions);
        return aActions;
    }

    public void remove(long aId) {
        ActionEntity aAction = getActionsById(aId).get();
        em.remove(aAction);
    }

    public ActionEntity update(ActionEntity aActions) {
        ActionEntity dbBook = getActionsById(aActions.getId()).get();
        aActions.update(aActions);
        ActionEntity ret = em.merge(aActions);
        return ret;
    }
}