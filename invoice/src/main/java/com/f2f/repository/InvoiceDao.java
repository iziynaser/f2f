package com.f2f.repository;

import com.f2f.dto.InvoiceDTO;
import com.f2f.entity.Invoice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceDao extends CrudRepository<Invoice,Long>{

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
