package software.services;

import software.entities.ClientEntity;
import software.entities.ServiceEntity;

import java.time.LocalDate;

public class servicesShortDto {

    private final Long id;
    private final LocalDate dateOfAcceptance;
    private final LocalDate endDate;
    private final String description;
    private final ClientEntity client;

    public servicesShortDto(Long id, ClientEntity client, LocalDate dateOfAcceptance, LocalDate endDate, String description) {
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

    public LocalDate getDateOfAcceptance() {
        return dateOfAcceptance;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getDescription() { return description; }

    public ClientEntity getClient() { return client; }

}