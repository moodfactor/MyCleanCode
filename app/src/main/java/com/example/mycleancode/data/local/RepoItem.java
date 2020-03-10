package com.example.mycleancode.data.local;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class RepoItem {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private String description;
    private String language;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
