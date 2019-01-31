package software.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table
public class ServiceEntity extends AbstractBaseEntity  {

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dateOfAcceptance;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate endDate;
    private String description;
    @ManyToOne
    private ClientEntity client;

    public ServiceEntity(){}

    public ServiceEntity(Long aId) {
        super(aId);
    }

    public ServiceEntity(Long id, ClientEntity client, LocalDate dateOfAcceptance, LocalDate endDate, String description) {
        super(id);
        this.client = client;
        this.dateOfAcceptance = dateOfAcceptance;
        this.endDate = endDate;
        this.description = description;
    }

    public ServiceEntity(ClientEntity client, LocalDate dateOfAcceptance, LocalDate endDate, String description) {
        this.client = client;
        this.dateOfAcceptance = dateOfAcceptance;
        this.endDate = endDate;
        this.description = description;
    }

    public LocalDate getDateOfAcceptance() {
        return dateOfAcceptance;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getDescription(){ return description; }

    public ClientEntity getClient() { return client; }

    public void setDateOfAcceptance(LocalDate dateOfAcceptance) {
        this.dateOfAcceptance = dateOfAcceptance;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setDescription(String description) { this.description = description; }

    public void setClient(ClientEntity client) { this.client = client; }
}