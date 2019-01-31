package software.entities;

import javax.persistence.Entity;

@Entity
public class ClientEntity extends AbstractBaseEntity {

    private String name;
    private String surname;
    private String address;
    private String phoneNumber;

    public static ClientEntity of(final String name, final String surname, final String address, final String phoneNumber){
        return new ClientEntity(name, surname, address, phoneNumber);
    }
    public ClientEntity(){}
    public ClientEntity(Long aId) {
        super(aId);
    }
    public ClientEntity(Long id, String name, String surname, String address, String phoneNumber) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public ClientEntity(String name, String surname, String address, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
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
}