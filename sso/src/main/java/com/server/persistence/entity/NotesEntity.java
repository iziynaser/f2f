package com.revengemission.sso.oauth2.server.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table
public class NotesEntity extends BaseEntity{

    //private static final long serialVersionUID = ;

    private String noteTitle;

    private String noteDescription;

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteDescription() {
        return noteDescription;
    }

    public void setNoteDescription(String noteDescription) {
        this.noteDescription = noteDescription;
    }
}
