package com.f2f.dto;

import java.io.Serializable;

public class ProductImageDTO implements Serializable {
    private String description;
    private boolean isUserImage;
    private String name ;
    private String type;
    private String url ;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isUserImage() {
        return isUserImage;
    }

    public void setUserImage(boolean userImage) {
        isUserImage = userImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
