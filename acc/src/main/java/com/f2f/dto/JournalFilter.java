package com.f2f.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * فیلتر استاندارد برای گزارش‌های دفتر روزنامه، خلاصه روزنامه و دفتر حساب
 */
@Setter
@Getter
public class JournalFilter{
    private LocalDate fromDate;
    private LocalDate toDate;

    private Long periodId;

    private Long accountId;
    private Long subsidiaryAccountId;

    private Long transactionId;
    private Long minTransactionNumber;
    private Long maxTransactionNumber;

    private Boolean includeDraft;
    private Boolean includeApproved;
    private Boolean includeReversed;

}
