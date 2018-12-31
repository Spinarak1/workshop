package software.entities;

import java.io.Serializable;

public class clientsEntity implements Serializable {

    private Long id;
    private String name;
    private String surname;
    private String adress;
    private String phoneNumber;

    public clientsEntity(){}
    public clientsEntity(long aId) {
        id = aId;
    }
    public clientsEntity(Long id, String name, String surname, String adress, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
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

    public String getAdress(){ return adress; }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        clientsEntity clientsDto = (clientsEntity) o;

        return id != null ? id.equals(clientsDto.id) : clientsDto.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public void update(clientsEntity aClients) {
        adress = aClients.getAdress();
        phoneNumber = aClients.getPhoneNumber();
    }
}