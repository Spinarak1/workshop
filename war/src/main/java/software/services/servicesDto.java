package software.services;

import software.entities.ClientEntity;
import software.entities.ServiceEntity;

import java.io.Serializable;
import java.time.LocalDate;

public class servicesDto implements Serializable {

    private Long id;
    private LocalDate dateOfAcceptance;
    private LocalDate endDate;
    private String description;
    private ClientEntity client;

    public servicesDto(){}
    public servicesDto(long aId) {
        id = aId;
    }

    public servicesDto(ClientEntity client, LocalDate dateOfAcceptance, LocalDate endDate, String description) {
        this.client = client;
        this.dateOfAcceptance = dateOfAcceptance;
        this.endDate = endDate;
        this.description = description;
    }

    public servicesDto(ServiceEntity servicesEntity) {
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

    public LocalDate getDateOfAcceptance() {
        return dateOfAcceptance;
    }

    public LocalDate getEndDate(){
        return endDate;
    }

    public String getDescription() {
        return description;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setDateOfAcceptance(LocalDate dateOfAcceptance) {
        this.dateOfAcceptance = dateOfAcceptance;
    }

    public void setEndDate(LocalDate endDate){
        this.endDate = endDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setClient(ClientEntity client){
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