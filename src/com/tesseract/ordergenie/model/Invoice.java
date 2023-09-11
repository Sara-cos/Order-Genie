package com.tesseract.ordergenie.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Invoice {
    private int invoiceId;
    private Date invoiceDate;
    private Order orderDetails=new Order();
    private Customer customerDetails=new Customer();
    private ArrayList<String>ProductList=new ArrayList<>();
    private String typeOfGst;
    private double totalGstAmount;
    private double totalInvoiceValue;
    private String invoiceStatus;
	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Invoice(int invoiceId, Date invoiceDate, Order orderDetails, Customer customerDetails,
			ArrayList<String> productList, String typeOfGst, double totalGstAmount, double totalInvoiceValue,
			String invoiceStatus) {
		super();
		this.invoiceId = invoiceId;
		this.invoiceDate = invoiceDate;
		this.orderDetails = orderDetails;
		this.customerDetails = customerDetails;
		ProductList = productList;
		this.typeOfGst = typeOfGst;
		this.totalGstAmount = totalGstAmount;
		this.totalInvoiceValue = totalInvoiceValue;
		this.invoiceStatus = invoiceStatus;
	}
	@Override
	public String toString() {
		return "Invoice [invoiceId=" + invoiceId + ", invoiceDate=" + invoiceDate + ", orderDetails=" + orderDetails
				+ ", customerDetails=" + customerDetails + ", ProductList=" + ProductList + ", typeOfGst=" + typeOfGst
				+ ", totalGstAmount=" + totalGstAmount + ", totalInvoiceValue=" + totalInvoiceValue + ", invoiceStatus="
				+ invoiceStatus + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(ProductList, customerDetails, invoiceDate, invoiceId, invoiceStatus, orderDetails,
				totalGstAmount, totalInvoiceValue, typeOfGst);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invoice other = (Invoice) obj;
		return Objects.equals(ProductList, other.ProductList) && Objects.equals(customerDetails, other.customerDetails)
				&& Objects.equals(invoiceDate, other.invoiceDate) && invoiceId == other.invoiceId
				&& Objects.equals(invoiceStatus, other.invoiceStatus)
				&& Objects.equals(orderDetails, other.orderDetails)
				&& Double.doubleToLongBits(totalGstAmount) == Double.doubleToLongBits(other.totalGstAmount)
				&& Double.doubleToLongBits(totalInvoiceValue) == Double.doubleToLongBits(other.totalInvoiceValue)
				&& Objects.equals(typeOfGst, other.typeOfGst);
	}
	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	public Date getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public Order getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(Order orderDetails) {
		this.orderDetails = orderDetails;
	}
	public Customer getCustomerDetails() {
		return customerDetails;
	}
	public void setCustomerDetails(Customer customerDetails) {
		this.customerDetails = customerDetails;
	}
	public ArrayList<String> getProductList() {
		return ProductList;
	}
	public void setProductList(ArrayList<String> productList) {
		ProductList = productList;
	}
	public String getTypeOfGst() {
		return typeOfGst;
	}
	public void setTypeOfGst(String typeOfGst) {
		this.typeOfGst = typeOfGst;
	}
	public double getTotalGstAmount() {
		return totalGstAmount;
	}
	public void setTotalGstAmount(double totalGstAmount) {
		this.totalGstAmount = totalGstAmount;
	}
	public double getTotalInvoiceValue() {
		return totalInvoiceValue;
	}
	public void setTotalInvoiceValue(double totalInvoiceValue) {
		this.totalInvoiceValue = totalInvoiceValue;
	}
	public String getInvoiceStatus() {
		return invoiceStatus;
	}
	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}
    
}
