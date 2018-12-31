package software.services;

import software.entities.servicesEntity;
import software.entities.clientsEntity;

public class servicesDtoToEntity {

    public static servicesEntity toEntity(servicesDto aEnt){
        servicesEntity ret = new servicesEntity();
        ret.setId(aEnt.getId());
        ret.setDateOfAcceptance(aEnt.getDateOfAcceptance());
        ret.setEndDate(aEnt.getEndDate());
        ret.setDescription(aEnt.getDescription());
        ret.setClient(aEnt.getClient());
        return ret;
    }
}