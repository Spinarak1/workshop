package software.clients;

import software.entities.*;

import java.io.Serializable;

public class clientsDto implements Serializable {

    private Long id;
    private String name;
    private String surname;
    private String address;
    private String phoneNumber;

    public clientsDto(){}

    public clientsDto(long aId) {
        id = aId;
    }

    public clientsDto(Long id, String name, String surname, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public clientsDto(ClientEntity clientsEntity) {
        this.id = clientsEntity.getId();
        this.name = clientsEntity.getName();
        this.surname = clientsEntity.getSurname();
        this.address = clientsEntity.getAddress();
        this.phoneNumber = clientsEntity.getPhoneNumber();
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getAddress(){ return address; }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        software.clients.clientsDto clientsDto = (software.clients.clientsDto) o;

        return id != null ? id.equals(clientsDto.id) : clientsDto.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}