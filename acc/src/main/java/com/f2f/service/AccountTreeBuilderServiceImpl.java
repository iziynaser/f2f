package com.f2f.service;

import com.f2f.dto.AccountTreeNode;
import com.f2f.entity.AccountsChart;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountTreeBuilderServiceImpl implements AccountTreeBuilderService {

    @Override
    public List<AccountTreeNode> buildTree(List<AccountsChart> accounts) {

        Map<Long, AccountTreeNode> map = new HashMap<>();

        // مرحله ۱: Node ها
        for (AccountsChart acc : accounts) {
            map.put(acc.getId(), new AccountTreeNode(acc));
        }

        // مرحله ۲: Parent/Child linkage
        List<AccountTreeNode> roots = new ArrayList<>();

        for (AccountsChart acc : accounts) {
            AccountTreeNode node = map.get(acc.getId());

            if (acc.getParentAccount() == null) {
                roots.add(node);
            } else {
                AccountTreeNode parent = map.get(acc.getParentAccount().getId());
                parent.getChildren().add(node);
            }
        }

        // مرحله ۳: مرتب‌سازی اختیاری بر اساس accountCode
        roots.forEach(this::sortTree);

        return roots;
    }

    private void sortTree(AccountTreeNode node) {
        //node.getChildren().sort(Comparator.comparing(n -> n.getAccount().getAccountCode()));
        //node.getChildren().forEach(this::sortTree);
    }
}
