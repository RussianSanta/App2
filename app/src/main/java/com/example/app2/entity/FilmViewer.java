package com.example.app2.entity;

import java.io.Serializable;

public class FilmViewer implements Serializable {
    private String name;
    private String description;
    private int iconResource;

    public FilmViewer(String name, String description, int iconResource) {
        this.name = name;
        this.iconResource = iconResource;
        this.description = description;
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

    public int getIconResource() {
        return iconResource;
    }

    public void setIconResource(int iconResource) {
        this.iconResource = iconResource;
    }
}
