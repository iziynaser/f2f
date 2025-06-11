package com.f2f.dao.acc.invoice;

import com.f2f.entity.acc.invoice.Invoice;
import com.f2f.dto.InvoiceDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository("InvoiceDao")
@Repository
public interface InvoiceDao extends CrudRepository<Invoice,Long>{

//    select i.id as invoiceId ,
//    i.invoice_code	as invoiceCode ,
//    i.date_created as dateCreated ,
//    i.title as invoiceTitle ,
//    i.from_person_id as fpersonId ,
//    fp.first_name as fpFirstName ,
//    fp.last_name as fpLastName ,
//    i.to_person_id as tpersonId,
//    tp.first_name as tpFirstName ,
//    tp.last_name as tpLastName,
//    i.invoice_type_id as invoiceTypeId,
//    it.name as invoiceTypeName,
//    i.description as invoiceDescription
//    from invoice as i
//    inner join person       as fp on  i.from_person_id = fp.id
//    inner join person       as tp on  i.to_person_id = tp.id
//    inner join invoice_type as it on  i.invoice_type_id = it.invoice_type_id
//


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
