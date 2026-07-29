package com.f2f.dto.accWiz;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ChartTemplate {

    private String businessType;

    private String name;

    private List<AccountTemplateNode> accounts;
}
