package ir.verjik.reporting.invoice.repository;

import ir.verjik.dto.InvoiceDTO;
import ir.verjik.entity.Invoice;
import ir.verjik.reporting.common.DailySalesDTO;
import ir.verjik.reporting.invoice.dto.InvoicePaymentStatusReportDTO;
import ir.verjik.reporting.invoice.dto.InvoiceTypeCountReportDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface InvoiceReportRepository extends CrudRepository<Invoice,Long>{


//    @Query("SELECT new ir.verjik.dto.DailySalesDTO(CAST(i.invoiceDate AS LocalDate), SUM(i.totalAmount)) " +
//            "FROM Invoice i " +
//            "WHERE i.invoiceType.name = 'SALES' " +
//            "GROUP BY CAST(i.invoiceDate AS LocalDate) " +
//            "ORDER BY CAST(i.invoiceDate AS LocalDate) DESC")
//    List<DailySalesDTO> findDailySales();

    List<Invoice> findByOrderId(Long orderId);


    @Query("SELECT COALESCE(SUM(i.totalAmount), 0) FROM Invoice i " +
            "WHERE i.invoiceType.name = :type AND i.invoiceDate BETWEEN :start AND :end")
    Long getTotalAmountByTypeAndDateRange(@Param("type") String type,
                                          @Param("start") LocalDateTime start,
                                          @Param("end") LocalDateTime end);

    @Query("SELECT new ir.verjik.dto.report.InvoiceTypeCountReportDTO(it.name, COUNT(i)) " +
            "FROM Invoice i " +
            "JOIN i.invoiceType it " +
            "GROUP BY it.name")
    List<InvoiceTypeCountReportDTO> getInvoiceCountByType();

    @Query("SELECT new ir.verjik.dto.report.InvoicePaymentStatusReportDTO(i.paymentStatus, COUNT(i), SUM(i.totalAmount)) " +
            "FROM Invoice i GROUP BY i.paymentStatus")
    List<InvoicePaymentStatusReportDTO> getInvoicePaymentStatusReport();


    List<Invoice> findByPaymentStatus(String paymentStatus);


    @Query("SELECT new ir.verjik.dto.DailySalesDTO(CAST(i.invoiceDate AS LocalDate), SUM(i.totalAmount)) " +
            "FROM Invoice i " +
            "WHERE i.invoiceType.name = 'SALES' " +
            "GROUP BY CAST(i.invoiceDate AS LocalDate) " +
            "ORDER BY CAST(i.invoiceDate AS LocalDate) DESC")
    List<DailySalesDTO> findDailySales();



    @Query("select " +
            " i.id as invoiceId, " +
            " i.invoiceCode as invoiceCode, " +
            " i.invoiceDate as date, " +
            " i.title as title, " +
            " i.message as message, " +
            " i.description as description, " +
            " fp.firstName as fpFirstName, " +
            " fp.lastName as fpLastName, " +
            " tp.firstName as tpFirstName, " +
            " tp.lastName as tpLastName, " +
            " it.name as invoiceName " +
            " from Invoice i " +
            " inner join PersonEntity fp on i.fromPerson = fp " +
            " inner join PersonEntity tp on i.toPerson = tp " +
            " inner join InvoiceType it on i.invoiceType = it " +
            "")
    List<InvoiceDTO> findAllAvailableInvoice();

}
