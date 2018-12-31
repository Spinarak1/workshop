package software.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

public class servicesEntity implements Serializable {

    private Long id;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date dateOfAcceptance;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Date endDate;
    private String description;
    @ManyToOne
    private clientsEntity client;

    public servicesEntity(){}

    public servicesEntity(long aId) {
        id = aId;
    }

    public servicesEntity(Long id, clientsEntity client, Date dateOfAcceptance, Date endDate, String description) {
        this.id = id;
        this.client = client;
        this.dateOfAcceptance = dateOfAcceptance;
        this.endDate = endDate;
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Date getDateOfAcceptance() {
        return dateOfAcceptance;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getDescription(){ return description; }

    public clientsEntity getClient() { return client; }

    public void setDateOfAcceptance(Date dateOfAcceptance) {
        this.dateOfAcceptance = dateOfAcceptance;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setDescription(String description) { this.description = description; }

    public void setClient(clientsEntity client) { this.client = client; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        servicesEntity servicesDto = (servicesEntity) o;

        return id != null ? id.equals(servicesDto.id) : servicesDto.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public void update(servicesEntity aServices) {
        dateOfAcceptance = aServices.getDateOfAcceptance();
        endDate = aServices.getEndDate();
        description = aServices.getDescription();
    }
}