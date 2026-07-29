package com.f2f.service.accWiz;

import com.f2f.dto.accWiz.AccountTemplateNode;
import com.f2f.dto.accWiz.ChartTemplate;
import com.f2f.entity.AccountingChart;
import com.f2f.enums.AccountNature;
import com.f2f.enums.DebitCreditType;
import com.f2f.repository.AccountsChartRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChartTemplateCreator {

    private final AccountsChartRepository repository;

    public ChartTemplateCreator(AccountsChartRepository repository) {
        this.repository = repository;
    }

    public void createChart(ChartTemplate template) {

        for (AccountTemplateNode node : template.getAccounts()) {

            createRecursive(node, null, 1);

        }
    }

    private AccountNature resolveNature(AccountTemplateNode node, AccountingChart parent){
        if(node.getNature()!=null) return node.getNature();
        if(parent!=null) return parent.getAccountNature();
        return AccountNature.ASSET;
    }

    private DebitCreditType resolveNormalBalance(AccountTemplateNode node, AccountingChart parent){
        if(node.getNormalBalance()!=null) return node.getNormalBalance();
        if(parent!=null) return parent.getNormalBalance();
        return DebitCreditType.CREDIT;
    }

    private void createRecursive(
            AccountTemplateNode node,
            AccountingChart parent,
            int levelIndex
    ) {

        AccountingChart acc = new AccountingChart();

        acc.setAccountCode(node.getCode());
        acc.setName(node.getName());
        acc.setDescription(node.getDescription());
        acc.setAccountLevel(node.getLevel());
        acc.setAccountNature(resolveNature(node,parent));
        acc.setNormalBalance(resolveNormalBalance(node,parent));
        acc.setPostable(node.getPostable());
        acc.setControlAccount(node.getControlAccount());

        acc.setParentAccount(parent);
        acc.setLevelIndex(levelIndex);

        repository.save(acc);

        if (node.getChildren() != null) {

            for (AccountTemplateNode child : node.getChildren()) {

                createRecursive(child, acc, levelIndex + 1);

            }

        }
    }
}
