package software.actions;

import software.entities.ActionEntity;

public class actionsDtoToEntity {

    public static ActionEntity toEntity(actionsDto aEnt){
        ActionEntity ret = new ActionEntity(aEnt.getId());
        ret.setKwota(aEnt.getKwota());
        ret.setOpis(aEnt.getOpis());
        return ret;
    }
}