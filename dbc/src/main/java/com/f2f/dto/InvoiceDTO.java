package com.f2f.dto;

import java.time.LocalDateTime;
import java.util.List;

public class InvoiceDTO {

 private Long id;
 private String invoiceNumber;
 private String invoiceType;
 private LocalDateTime invoiceDate;
 private LocalDateTime dueDate;
 private Long totalAmount;
 private Long paidAmount;
 private String paymentStatus;
 private String paymentMethod;
 private String remarks;
 private Long orderId;
 private Long partyId;
 private List<InvoiceItemDTO> items;

 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public String getInvoiceNumber() {
  return invoiceNumber;
 }

 public void setInvoiceNumber(String invoiceNumber) {
  this.invoiceNumber = invoiceNumber;
 }

 public String getInvoiceType() {
  return invoiceType;
 }

 public void setInvoiceType(String invoiceType) {
  this.invoiceType = invoiceType;
 }

 public LocalDateTime getInvoiceDate() {
  return invoiceDate;
 }

 public void setInvoiceDate(LocalDateTime invoiceDate) {
  this.invoiceDate = invoiceDate;
 }

 public LocalDateTime getDueDate() {
  return dueDate;
 }

 public void setDueDate(LocalDateTime dueDate) {
  this.dueDate = dueDate;
 }

 public Long getTotalAmount() {
  return totalAmount;
 }

 public void setTotalAmount(Long totalAmount) {
  this.totalAmount = totalAmount;
 }

 public Long getPaidAmount() {
  return paidAmount;
 }

 public void setPaidAmount(Long paidAmount) {
  this.paidAmount = paidAmount;
 }

 public String getPaymentStatus() {
  return paymentStatus;
 }

 public void setPaymentStatus(String paymentStatus) {
  this.paymentStatus = paymentStatus;
 }

 public String getPaymentMethod() {
  return paymentMethod;
 }

 public void setPaymentMethod(String paymentMethod) {
  this.paymentMethod = paymentMethod;
 }

 public String getRemarks() {
  return remarks;
 }

 public void setRemarks(String remarks) {
  this.remarks = remarks;
 }

 public Long getOrderId() {
  return orderId;
 }

 public void setOrderId(Long orderId) {
  this.orderId = orderId;
 }

 public Long getPartyId() {
  return partyId;
 }

 public void setPartyId(Long partyId) {
  this.partyId = partyId;
 }

 public List<InvoiceItemDTO> getItems() {
  return items;
 }

 public void setItems(List<InvoiceItemDTO> items) {
  this.items = items;
 }
}

