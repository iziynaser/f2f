package com.f2f.dao.comment;

import java.util.ArrayList;

public class CommentDTOS {

    private String title;
    private ArrayList<String> benefits ;
    private ArrayList<String> upsets;
    private String content;
    private String productId ;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<String> getBenefits() {
        return benefits;
    }

    public void setBenefits(ArrayList<String> benefits) {
        this.benefits = benefits;
    }

    public ArrayList<String> getUpsets() {
        return upsets;
    }

    public void setUpsets(ArrayList<String> upsets) {
        this.upsets = upsets;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
