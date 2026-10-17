package ir.verjik.repository;

import ir.verjik.dto.JournalEntryDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class JournalReportRepositoryImpl implements JournalReportRepository {

    @PersistenceContext
    private EntityManager em;

    // --------------------------------------------------------------------
    // 1. دفتر روزنامه بین دو تاریخ
    // --------------------------------------------------------------------
    @Override
    public List<JournalEntryDTO> getJournal(LocalDate from, LocalDate to) {

        String jpql = """
            SELECT new com.f2f.dto.JournalEntryDTO(
                t.id,
                t.transactionNumber,
                t.transactionDate,
                t.description,
                d.id,
                a.id,
                a.accountCode,
                a.accountName,
                CASE WHEN d.debitCreditType = com.f2f.enums.DebitCreditType.DEBIT
                     THEN d.amountFunctional ELSE 0 END,
                CASE WHEN d.debitCreditType = com.f2f.enums.DebitCreditType.CREDIT
                     THEN d.amountFunctional ELSE 0 END
            )
            FROM AccountingTransaction t
            JOIN t.accountTransactionDetails d
            JOIN d.accountingChart a
            WHERE t.transactionDate >= :from
              AND t.transactionDate <= :to
            ORDER BY t.transactionDate ASC, t.transactionNumber ASC, d.id ASC
        """;

        TypedQuery<JournalEntryDTO> q = em.createQuery(jpql, JournalEntryDTO.class);
        q.setParameter("from", from);
        q.setParameter("to", to);

        return q.getResultList();
    }

    // --------------------------------------------------------------------
    // 2. دفتر روزنامه بر اساس دوره حسابداری
    // --------------------------------------------------------------------
    @Override
    public List<JournalEntryDTO> getJournalByPeriod(Long periodId) {

        String jpql = """
            SELECT new com.f2f.dto.JournalEntryDTO(
                t.id,
                t.transactionNumber,
                t.transactionDate,
                t.description,
                d.id,
                a.id,
                a.accountCode,
                a.name,
                CASE WHEN d.debitCreditType = com.f2f.enums.DebitCreditType.DEBIT
                     THEN d.amountFunctional ELSE 0 END,
                CASE WHEN d.debitCreditType = com.f2f.enums.DebitCreditType.CREDIT
                     THEN d.amountFunctional ELSE 0 END
            )
            FROM AccountingTransaction t
            JOIN t.accountTransactionDetails d
            JOIN d.accountingChart a
            WHERE t.accountingPeriod.id = :pid
            ORDER BY t.transactionDate ASC, t.transactionNumber ASC, d.id ASC
        """;

        TypedQuery<JournalEntryDTO> q = em.createQuery(jpql, JournalEntryDTO.class);
        q.setParameter("pid", periodId);

        return q.getResultList();
    }

    // --------------------------------------------------------------------
    // 3. دفتر روزنامه یک سند خاص
    // --------------------------------------------------------------------
    @Override
    public List<JournalEntryDTO> getJournalByTransactionId(Long transactionId) {

        String jpql = """
            SELECT new com.f2f.dto.JournalEntryDTO(
                t.id,
                t.transactionNumber,
                t.transactionDate,
                t.description,
                d.id,
                a.id,
                a.accountCode,
                a.name,
                CASE WHEN d.debitCreditType = com.f2f.enums.DebitCreditType.DEBIT
                     THEN d.amountFunctional ELSE 0 END,
                CASE WHEN d.debitCreditType = com.f2f.enums.DebitCreditType.CREDIT
                     THEN d.amountFunctional ELSE 0 END
            )
            FROM AccountingTransaction t
            JOIN t.accountTransactionDetails d
            JOIN d.accountingChart a
            WHERE t.id = :txId
            ORDER BY d.id ASC
        """;

        TypedQuery<JournalEntryDTO> q = em.createQuery(jpql, JournalEntryDTO.class);
        q.setParameter("txId", transactionId);

        return q.getResultList();
    }
}
