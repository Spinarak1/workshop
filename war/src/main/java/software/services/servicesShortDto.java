package software.services;

import software.entities.ServiceEntity;
import software.entities.ClientEntity;

import java.util.Date;

public class servicesShortDto {

    private final Long id;
    private final Date dateOfAcceptance;
    private final Date endDate;
    private final String description;
    private final ClientEntity client;

    public servicesShortDto(Long id, ClientEntity client, Date dateOfAcceptance, Date endDate, String description) {
        this.id = id;
        this.client = client;
        this.dateOfAcceptance = dateOfAcceptance;
        this.endDate = endDate;
        this.description = description;
    }

    public servicesShortDto(servicesDto aServicesDto){
        id = aServicesDto.getId();
        dateOfAcceptance = aServicesDto.getDateOfAcceptance();
        endDate = aServicesDto.getEndDate();
        description = aServicesDto.getDescription();
        client = aServicesDto.getClient();
    }

    public servicesShortDto(ServiceEntity aEntity) {
        id = aEntity.getId();
        dateOfAcceptance = aEntity.getDateOfAcceptance();
        endDate = aEntity.getEndDate();
        description = aEntity.getDescription();
        client = aEntity.getClient();
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

    public String getDescription() { return description; }

    public ClientEntity getClient() { return client; }

}