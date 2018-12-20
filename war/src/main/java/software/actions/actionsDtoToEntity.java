package software.actions;

import software.entities.actionsEntity;

public class actionsDtoToEntity {

    public static actionsEntity toEntity(actionsDto aEnt){
        actionsEntity ret = new actionsEntity();
        ret.setKwota(aEnt.getKwota());
        ret.setOpis(aEnt.getOpis());
        ret.setId(aEnt.getId());
        return ret;
    }
}