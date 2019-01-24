package software.actions;


import software.entities.ActionEntity;

public class actionsShortDto {

    private final Long id;
    private final int amount;
    private final String description;

    public actionsShortDto(Long id, int amount, String description) {
        this.id = id;
        this.amount = amount;
        this.description = description;
    }

    public actionsShortDto(actionsDto aActionsDto){
        id = aActionsDto.getId();
        amount = aActionsDto.getAmount();
        description = aActionsDto.getDescription();
    }

    public actionsShortDto(ActionEntity aEntity) {
        id = aEntity.getId();
        amount = aEntity.getAmount();
        description = aEntity.getDescription();
    }

    public Long getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}