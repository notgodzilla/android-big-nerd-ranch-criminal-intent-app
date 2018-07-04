package com.notgodzilla.criminalintent;

import java.util.Date;
import java.util.UUID;

public class Crime {

    private UUID uuid;
    private String title;
    private Date date;
    private boolean solved;

    public Crime() {
        this.uuid = UUID.randomUUID();
        this.date = new Date();
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }
}
