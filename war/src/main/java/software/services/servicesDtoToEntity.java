package software.services;

import software.entities.ServiceEntity;

public class servicesDtoToEntity {

    public static ServiceEntity toEntity(servicesDto aEnt){
        ServiceEntity ret = new ServiceEntity(aEnt.getId());
        ret.setDateOfAcceptance(aEnt.getDateOfAcceptance());
        ret.setEndDate(aEnt.getEndDate());
        ret.setDescription(aEnt.getDescription());
        ret.setClient(aEnt.getClient());
        return ret;
    }
}