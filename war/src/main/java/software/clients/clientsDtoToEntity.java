package software.clients;

import software.entities.clientsEntity;

public class clientsDtoToEntity {

    public static clientsEntity toEntity(clientsDto aEnt){
        clientsEntity ret = new clientsEntity();
        ret.setId(aEnt.getId());
        ret.setName(aEnt.getName());
        ret.setSurname(aEnt.getSurname());
        ret.setAdress(aEnt.getAdress());
        ret.setPhoneNumber(aEnt.getPhoneNumber());
        return ret;
    }
}