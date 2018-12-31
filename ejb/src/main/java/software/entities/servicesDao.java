package software.entities;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.*;

@Startup
@Singleton
public class servicesDao {

    private final Set<servicesEntity> services = new HashSet<>();

    public servicesDao(){}


    @PostConstruct
    void init(){
        services.add(new servicesEntity(1, cl1, "2018-12-12 12:22:32", "2018-12-13 13:30:11", "Olej"));
        services.add(new servicesEntity(2, cl2, "2018-12-12 12:22:32", "2018-12-12 12:22:32", "Skrzynia"));
        services.add(new servicesEntity(3, cl3, "2018-12-12 12:22:32", "2018-12-12 12:22:32", "Opony"));
    }

    public Optional<servicesEntity> getServicesById(long aId){
        return services.stream().filter(e -> e.getId() == aId).findFirst();
    }

    public List<servicesEntity> getAll(){
        return new ArrayList(services);
    }

    public servicesEntity addservices(servicesEntity aServices){
        aServices.setId((long) (services.size()+1));
        services.add(aServices);
        return aServices;
    }

    public servicesEntity editServices(servicesEntity aServices){
        servicesEntity fromDB = services.stream().filter(e -> e.getId() == aServices.getId()).findFirst().get();
        fromDB.update(aServices);
        return fromDB;
    }

    public void remove(long aId) {
        services.remove(new servicesEntity(aId));
    }

    public servicesEntity update(servicesEntity servicesEntity) {
        Optional<servicesEntity> servicesFromDatabase = services.stream().filter(ent -> ent.getId().equals(servicesEntity.getId())).findFirst();
        servicesFromDatabase.ifPresent(fromDb -> fromDb.update(servicesEntity));
        return servicesFromDatabase.get();
    }
}