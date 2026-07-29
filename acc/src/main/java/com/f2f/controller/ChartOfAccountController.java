package com.f2f.controller;

import com.f2f.dto.chartOfAccount.AccountChartResponse;
import com.f2f.dto.chartOfAccount.AccountTreeNode;
import com.f2f.dto.chartOfAccount.CreateAccountRequest;
import com.f2f.dto.chartOfAccount.UpdateAccountRequest;
import com.f2f.entity.AccountingChart;
import com.f2f.service.ChartOfAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/*
تمام عملیات مربوط به درخت حسابها را انجام می دهد.
 */
@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class ChartOfAccountController {

    private final ChartOfAccountService chartOfAccountService;

    @PostMapping
    public ResponseEntity<AccountChartResponse> createAccount(@RequestBody CreateAccountRequest request) {
        AccountingChart result = chartOfAccountService.createAccount(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(mapAccountChartToAccountChartResponse(result));
    }

    private AccountChartResponse mapAccountChartToAccountChartResponse(AccountingChart result) {
        AccountChartResponse response = new AccountChartResponse();
        response.setName(result.getName());
        response.setDescription(result.getDescription());
        response.setAccountCode(result.getAccountCode());
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountChartResponse> updateAccount(
            @PathVariable Long id,
            @RequestBody UpdateAccountRequest request) {

        var AccountsChart = chartOfAccountService.updateAccount(id, request);
        return ResponseEntity.ok(mapAccountChartToAccountChartResponse(AccountsChart));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountChartResponse> getAccount(@PathVariable Long id) {
        AccountingChart result = chartOfAccountService.getById(id);
        return ResponseEntity.ok(mapAccountChartToAccountChartResponse(result));
    }

    @GetMapping
    public ResponseEntity<List<AccountChartResponse>> getAccountList() {

        List<AccountingChart> result = chartOfAccountService.getAll();

        List<AccountChartResponse> res = result.stream()
                .map(this::mapAccountChartToAccountChartResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(res);
    }


    @GetMapping("/tree")
    public ResponseEntity<List<AccountTreeNode>> getAccountTree() {
        List<AccountTreeNode> result = chartOfAccountService.getAccountTree();
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {

        chartOfAccountService.deleteAccount(id);

        return ResponseEntity.noContent().build();
    }


}
