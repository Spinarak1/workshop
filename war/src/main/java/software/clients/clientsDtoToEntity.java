package software.clients;

import software.entities.ClientEntity;

public class clientsDtoToEntity {

    public static ClientEntity toEntity(clientsDto aEnt){
        ClientEntity ret = new ClientEntity(aEnt.getId());
        ret.setName(aEnt.getName());
        ret.setSurname(aEnt.getSurname());
        ret.setAddress(aEnt.getAdress());
        ret.setPhoneNumber(aEnt.getPhoneNumber());
        return ret;
    }
}