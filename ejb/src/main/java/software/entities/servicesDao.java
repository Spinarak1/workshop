package software.entities;

import software.entities.clientsDao;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.*;

@Startup
@Singleton
public class servicesDao{

    private final Set<servicesEntity> services = new HashSet<>();

    public servicesDao(){}

    @PostConstruct
    void init(){
        services.add(new servicesEntity(1l, new clientsEntity(1l, "Jaroslaw", "Banaszak", "Grunwaldzka Poznan", "7766655511"),new Date(2018, 12, 12, 13, 12, 11), new Date(2018, 12, 13, 14, 20, 11), "Olej"));
        services.add(new servicesEntity(2l, new clientsEntity(2l, "Andrzej", "Mierzejewski", "Wioslarska Poznan", "9988443223"),new Date(2018, 12, 14, 13, 30, 11), new Date(2018, 12, 15, 15, 20, 11), "Skrzynia"));
        services.add(new servicesEntity(3l, new clientsEntity(3l, "Maciej", "Mieleszko", "Kurpinskiego Poznan", "2233445566"),new Date(2018, 12, 16, 17, 11, 11), new Date(2018, 12, 20, 18, 20, 11), "Opony"));
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