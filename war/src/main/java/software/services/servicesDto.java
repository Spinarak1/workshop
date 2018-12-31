package software.services;

import software.entities.servicesEntity;
import software.entities.clientsEntity;

import java.io.Serializable;
import java.util.Date;

public class servicesDto implements Serializable {

    private Long id;
    private Date dateOfAcceptance;
    private Date endDate;
    private String description;
    private clientsEntity client;

    public servicesDto(){}
    public servicesDto(long aId) {
        id = aId;
    }

    public servicesDto(clientsEntity client, Date dateOfAcceptance, Date endDate, String description) {
        this.client = client;
        this.dateOfAcceptance = dateOfAcceptance;
        this.endDate = endDate;
        this.description = description;
    }

    public servicesDto(servicesEntity servicesEntity) {
        this.id = servicesEntity.getId();
        this.dateOfAcceptance = servicesEntity.getDateOfAcceptance();
        this.endDate = servicesEntity.getEndDate();
        this.description = servicesEntity.getDescription();
        this.client = servicesEntity.getClient();
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

    public Date getEndDate(){
        return endDate;
    }

    public String getDescription() {
        return description;
    }

    public clientsEntity getClient() {
        return client;
    }

    public void setDateOfAcceptance(Date dateOfAcceptance) {
        this.dateOfAcceptance = dateOfAcceptance;
    }

    public void setEndDate(Date endDate){
        this.endDate = endDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setClient(clientsEntity client){
        this.client = client;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        servicesDto servicesDto = (servicesDto) o;

        return id != null ? id.equals(servicesDto.id) : servicesDto.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}