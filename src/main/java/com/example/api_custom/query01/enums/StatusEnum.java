package com.example.api_custom.query01.enums;

public enum StatusEnum {
    ONTIME("In tempo"),

    DELAYED("In ritardo"),

    CANCELLED("Cancellato");
    public String descrizione;

    StatusEnum(String descrizione) {
        this.descrizione=descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }
}
