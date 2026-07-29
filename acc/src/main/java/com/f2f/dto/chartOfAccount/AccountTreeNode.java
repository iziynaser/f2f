package com.f2f.dto.chartOfAccount;

import com.f2f.entity.AccountingChart;
import com.f2f.enums.AccountLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AccountTreeNode {
    public Long id;
    public String code;
    public String name;
    public int levelIndex;
    public AccountLevel accountLevel;
    public List<AccountTreeNode> children = new ArrayList<>();

    public AccountTreeNode(AccountingChart acc) {
        this.id = acc.getId();
        this.code = acc.getAccountCode();
        this.name = acc.getName();
        this.levelIndex = acc.getLevelIndex();
        this.accountLevel = acc.getAccountLevel();
    }
}
