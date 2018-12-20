package software.entities;

import java.io.Serializable;

public class actionsEntity implements Serializable {

    private Long id;
    private int kwota;
    private String opis;

    public actionsEntity() {

    }

    public actionsEntity(long aId) {
        id = aId;
    }

    public actionsEntity(Long id, int kwota, String opis) {
        this.id = id;
        this.kwota = kwota;
        this.opis = opis;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getKwota() {
        return kwota;
    }

    public String getOpis() {
        return opis;
    }

    public void setKwota(int kwota) {
        this.kwota = kwota;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        actionsEntity actionsDto = (actionsEntity) o;

        return id != null ? id.equals(actionsDto.id) : actionsDto.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public void update(actionsEntity aActions) {
        kwota = aActions.getKwota();
        opis = aActions.getOpis();
    }
}