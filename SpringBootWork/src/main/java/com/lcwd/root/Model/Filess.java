package com.lcwd.root.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "files")
public class Filess {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "files_seq")
    @SequenceGenerator(name = "files_seq", allocationSize = 1)
    private int id;
    private String fileName;

    public Filess() {
    }

    public Filess(int id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
