package software.actions;


import software.entities.actionsEntity;

public class actionsShortDto {

    private final Long id;
    private final int kwota;
    private final String opis;

    public actionsShortDto(Long id, int kwota, String opis) {
        this.id = id;
        this.kwota = kwota;
        this.opis = opis;
    }

    public actionsShortDto(actionsDto aActionsDto){
        id = aActionsDto.getId();
        kwota = aActionsDto.getKwota();
        opis = aActionsDto.getOpis();
    }

    public actionsShortDto(actionsEntity aEntity) {
        id = aEntity.getId();
        kwota = aEntity.getKwota();
        opis = aEntity.getOpis();
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
}