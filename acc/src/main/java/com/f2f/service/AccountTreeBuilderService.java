package com.f2f.service;

import com.f2f.dto.chartOfAccount.AccountTreeNode;
import com.f2f.entity.AccountingChart;

import java.util.List;

public interface AccountTreeBuilderService {
    List<AccountTreeNode> buildTree(List<AccountingChart> accounts);
}
