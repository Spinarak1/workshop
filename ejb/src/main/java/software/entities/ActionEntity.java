package software.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table
public class ActionEntity extends AbstractBaseEntity {

    private Long id;
    private int kwota;
    private String opis;

    public ActionEntity() {
    }

    public ActionEntity(long aId) {
        super(aId);
    }

    public ActionEntity(Long id, int kwota, String opis) {
        this(id);
        this.kwota = kwota;
        this.opis = opis;
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

    public void update(ActionEntity aAction) {
        opis = aAction.getOpis();
        kwota = aAction.getKwota();
    }
}