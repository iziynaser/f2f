package ir.verjik.dto;

public class OfficialJournalService {
//
//    private final AccountingTransactionRepository detailsRepository;
//
//    OfficialJournalService(AccountingTransactionRepository detailsRepository) {
//        this.detailsRepository = detailsRepository;
//    }
//
//    public List<OfficialJournalEntry> getOfficialJournal(LedgerFilter filter) {
//
//        List<AccountingTransaction> txs = detailsRepository.findJournal(filter);
//
//        List<OfficialJournalEntry> output = new ArrayList<>();
//
//        for (AccountingTransaction t : txs) {
//
//            List<OfficialJournalDetail> details = t.getAccountTransactionDetails().stream()
//                    .map(d -> new OfficialJournalDetail(
//                            d.getAccountsChart().getCode(),
//                            d.getAccountsChart().getTitle(),
//                            d.getDebitCreditType() == DebitCreditType.DEBIT ? d.getAmountFunctional() : BigDecimal.ZERO,
//                            d.getDebitCreditType() == DebitCreditType.CREDIT ? d.getAmountFunctional() : BigDecimal.ZERO
//                    ))
//                    .collect(Collectors.toList());
//
//            output.add(new OfficialJournalEntry(
//                    t.getTransactionNumber(),
//                    t.getTransactionDate(),
//                    t.getDescription(),
//                    details
//            ));
//        }
//
//        return output;
//    }

}
