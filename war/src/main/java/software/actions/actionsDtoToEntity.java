package software.actions;

import software.entities.ActionEntity;

public class actionsDtoToEntity {

    public static ActionEntity toEntity(actionsDto aEnt){
        ActionEntity ret = new ActionEntity(aEnt.getId());
        ret.setAmount(aEnt.getAmount());
        ret.setDescription(aEnt.getDescription());
        return ret;
    }
}