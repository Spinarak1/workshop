package software.actions;

import software.entities.ActionEntity;

import java.io.Serializable;

public class actionsDto implements Serializable {

    private Long id;
    private int amount;
    private String description;

    public actionsDto() {

    }

    public actionsDto(long aId) {
        id = aId;
    }

    public actionsDto(Long id, int amount, String description) {
        this.id = id;
        this.amount = amount;
        this.description = description;
    }

    public actionsDto(ActionEntity actionsEntity) {
        this.id = actionsEntity.getId();
        this.amount = actionsEntity.getAmount();
        this.description = actionsEntity.getDescription();
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        actionsDto actionsDto = (actionsDto) o;

        return id != null ? id.equals(actionsDto.id) : actionsDto.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}