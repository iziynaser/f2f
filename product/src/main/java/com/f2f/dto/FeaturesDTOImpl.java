package com.f2f.dto;

public class FeaturesDTOImpl implements FeaturesDTO {

    private final String groupId;
    private final String groupName;
    private final String itemId;
    private final String itemName;
    private final String itemsId;
    private final String itemsName;
    private final String itemsValue;

    public FeaturesDTOImpl(Long groupId, String groupName,
                           Long itemId, String itemName,
                           Long itemsId, String itemsName,String itemsValue) {
        this.groupId = groupId != null ? groupId.toString() : null;
        this.groupName = groupName;
        this.itemId = itemId != null ? itemId.toString() : null;
        this.itemName = itemName;
        this.itemsId = itemsId != null ? itemsId.toString() : null;
        this.itemsName = itemsName;
        this.itemsValue = itemsValue;
    }

    @Override public String getGroupId() { return groupId; }

    @Override public String getGroupName() { return groupName; }

    @Override public String getItemId() { return itemId; }

    @Override public String getItemName() { return itemName; }

    @Override public String getItemsId() { return itemsId; }

    @Override public String getItemsName() { return itemsName; }

    @Override
    public String getItemsValue() { return itemsValue; }
}
