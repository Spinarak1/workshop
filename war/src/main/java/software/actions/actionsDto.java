package software.actions;

import software.entities.ActionEntity;

import java.io.Serializable;

public class actionsDto implements Serializable {

    private Long id;
    private int kwota;
    private String opis;

    public actionsDto() {

    }

    public actionsDto(long aId) {
        id = aId;
    }

    public actionsDto(Long id, int kwota, String opis) {
        this.id = id;
        this.kwota = kwota;
        this.opis = opis;
    }

    public actionsDto(ActionEntity actionsEntity) {
        this.id = actionsEntity.getId();
        this.kwota = actionsEntity.getKwota();
        this.opis = actionsEntity.getOpis();
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

        actionsDto actionsDto = (actionsDto) o;

        return id != null ? id.equals(actionsDto.id) : actionsDto.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}