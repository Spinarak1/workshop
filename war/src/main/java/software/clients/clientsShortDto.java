package software.clients;

import software.entities.ClientEntity;

public class clientsShortDto {

    private final Long id;
    private final String name;
    private final String surname;
    private final String address;
    private final String phoneNumber;

    public clientsShortDto(Long id, String name, String surname, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public clientsShortDto(clientsDto aClientsDto){
        id = aClientsDto.getId();
        name = aClientsDto.getName();
        surname = aClientsDto.getSurname();
        address = aClientsDto.getAddress();
        phoneNumber = aClientsDto.getPhoneNumber();
    }

    public clientsShortDto(ClientEntity aEntity) {
        id = aEntity.getId();
        name = aEntity.getName();
        surname = aEntity.getSurname();
        address = aEntity.getAddress();
        phoneNumber = aEntity.getPhoneNumber();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() { return address; }

    public String getPhoneNumber() { return phoneNumber; }

}