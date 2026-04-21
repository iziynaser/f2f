package com.f2f.service;

import com.f2f.dto.AccountTreeNode;
import com.f2f.entity.AccountsChart;

import java.util.List;

public interface AccountTreeBuilderService {
    List<AccountTreeNode> buildTree(List<AccountsChart> accounts);
}
