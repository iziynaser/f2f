package com.f2f.controller.product;

public class PTree {

    ProductFeatureTreeDTO treeData;
    String productId ;

    public ProductFeatureTreeDTO getTreeData() {
        return treeData;
    }

    public void setTreeData(ProductFeatureTreeDTO treeData) {
        this.treeData = treeData;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
