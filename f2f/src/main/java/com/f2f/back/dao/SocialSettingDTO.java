package com.f2f.back.dao;

import com.sun.org.apache.xpath.internal.operations.Bool;

public interface SocialSettingDTO {
    public String getLinkedInAddress();
    public Bool    getLinkedInAddressEnabled();

    public String getAparatAddress();
    public Bool getAparatAddressEnabled();


    public String getInstaAddress();
    public Bool   getInstaAddressEnabled();

    public String getTwitterAddress();
    public Bool getTwitterAddressEnabled();
}
