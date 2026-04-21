package com.f2f.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAccountRequest {
    public String name;
    public Boolean postable;
    public Boolean active;
    public String color;
    public String description;
}
