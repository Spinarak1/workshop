package software.entities;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.*;

@Startup
@Singleton
public class actionsDao {

    private final Set<actionsEntity> actions = new HashSet<>();

    public actionsDao() {
    }


    @PostConstruct
    void init(){
        actions.add(new actionsEntity(1l, 200, "Olej"));
        actions.add(new actionsEntity(2l, 300, "Skrzynia"));
        actions.add(new actionsEntity(3l, 400, "Opony"));
    }

    public Optional<actionsEntity> getActionsById(long aId){
        return actions.stream().filter(e -> e.getId() == aId).findFirst();
    }

    public List<actionsEntity> getAll(){
        return new ArrayList(actions);
    }

    public actionsEntity addActions(actionsEntity aActions){
        aActions.setId((long) (actions.size()+1));
        actions.add(aActions);
        return aActions;
    }

    public actionsEntity editActions(actionsEntity aActions){
        actionsEntity fromDB = actions.stream().filter(e -> e.getId() == aActions.getId()).findFirst().get();
        fromDB.update(aActions);
        return fromDB;
    }

    public void remove(long aId) {
        actions.remove(new actionsEntity(aId));
    }

    public actionsEntity update(actionsEntity actionsEntity) {
        Optional<actionsEntity> actionsFromDatabase = actions.stream().filter(ent -> ent.getId().equals(actionsEntity.getId())).findFirst();
        actionsFromDatabase.ifPresent(fromDb -> fromDb.update(actionsEntity));
        return actionsFromDatabase.get();
    }
}