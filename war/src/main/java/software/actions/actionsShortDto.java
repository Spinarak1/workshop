package software.actions;


import software.entities.ActionEntity;

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
        kwota = aActionsDto.getAmount();
        opis = aActionsDto.getDescription();
    }

    public actionsShortDto(ActionEntity aEntity) {
        id = aEntity.getId();
        kwota = aEntity.getAmount();
        opis = aEntity.getDescription();
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