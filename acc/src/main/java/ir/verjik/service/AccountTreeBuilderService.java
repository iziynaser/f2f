package ir.verjik.service;

import ir.verjik.dto.chartOfAccount.AccountTreeNode;
import ir.verjik.entity.AccountingChart;

import java.util.List;

public interface AccountTreeBuilderService {
    List<AccountTreeNode> buildTree(List<AccountingChart> accounts);
}
