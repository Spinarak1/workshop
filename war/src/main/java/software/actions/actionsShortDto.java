package software.actions;


import software.entities.ActionEntity;

public class actionsShortDto {

    private final Long id;
    private final int amount;
    private final String decription;

    public actionsShortDto(Long id, int amount, String description) {
        this.id = id;
        this.amount = amount;
        this.decription = description;
    }

    public actionsShortDto(actionsDto aActionsDto){
        id = aActionsDto.getId();
        amount = aActionsDto.getAmount();
        decription = aActionsDto.getDescription();
    }

    public actionsShortDto(ActionEntity aEntity) {
        id = aEntity.getId();
        amount = aEntity.getAmount();
        decription = aEntity.getDescription();
    }

    public Long getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public String getDecription() {
        return decription;
    }
}