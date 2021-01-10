package com.springbootnew.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Note")
public class Note {

    @Id
    @GeneratedValue
    private int nId;
    private String note;
    private String uId;
    private int status;

    public int getStatus() {
        return this.status;
    }

    public int getNId() {
        return this.nId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
