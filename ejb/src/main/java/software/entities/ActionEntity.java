package software.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class ActionEntity extends AbstractBaseEntity {
    private int amount;
    private String description;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private ServiceEntity service;

    public ActionEntity() {
    }

    public ActionEntity(Long aId) {
        super(aId);
    }

    public ActionEntity(Long id, ServiceEntity service, int amount, String description) {
        this(id);
        this.amount = amount;
        this.description = description;
        this.service = service;
    }

    public ActionEntity(ServiceEntity service, int amount, String description) {
        this.amount = amount;
        this.description = description;
        this.service = service;
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

    public ServiceEntity getService() {
        return service;
    }

    public void setService(ServiceEntity service) {
        this.service = service;
    }

    public void update(ActionEntity aAction) {
        description = aAction.getDescription();
        amount = aAction.getAmount();
    }
}