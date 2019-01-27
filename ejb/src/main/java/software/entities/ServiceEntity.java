package software.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
public class ServiceEntity extends AbstractBaseEntity  {

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateOfAcceptance;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date endDate;
    private String description;
    @ManyToOne
    private ClientEntity client;

    public ServiceEntity(){}

    public ServiceEntity(Long aId) {
        super(aId);
    }

    public ServiceEntity(Long id, ClientEntity client, Date dateOfAcceptance, Date endDate, String description) {
        super(id);
        this.client = client;
        this.dateOfAcceptance = dateOfAcceptance;
        this.endDate = endDate;
        this.description = description;
    }

    public ServiceEntity(ClientEntity client, Date dateOfAcceptance, Date endDate, String description) {
        this.client = client;
        this.dateOfAcceptance = dateOfAcceptance;
        this.endDate = endDate;
        this.description = description;
    }

    public Date getDateOfAcceptance() {
        return dateOfAcceptance;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getDescription(){ return description; }

    public ClientEntity getClient() { return client; }

    public void setDateOfAcceptance(Date dateOfAcceptance) {
        this.dateOfAcceptance = dateOfAcceptance;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setDescription(String description) { this.description = description; }

    public void setClient(ClientEntity client) { this.client = client; }
}