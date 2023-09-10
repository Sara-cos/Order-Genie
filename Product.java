package com.codeFury.product.dao;


import java.util.Objects;

public class Product {
	 private int productId;
	 private  String productName;
	 private double productPrice;
	 private int Category;
	 private double productGst;
	 private int productStock;
	 private int quantity;
	public Product(int productId, String productName, double productPrice, int category, double productGst,
			int productStock, int quantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		Category = category;
		this.productGst = productGst;
		this.productStock = productStock;
		this.quantity = quantity;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", Category=" + Category + ", productGst=" + productGst + ", productStock=" + productStock + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(Category, productGst, productId, productName, productPrice, productStock, quantity);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Category == other.Category
				&& Double.doubleToLongBits(productGst) == Double.doubleToLongBits(other.productGst)
				&& productId == other.productId && Objects.equals(productName, other.productName)
				&& Double.doubleToLongBits(productPrice) == Double.doubleToLongBits(other.productPrice)
				&& productStock == other.productStock && quantity == other.quantity;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getCategory() {
		return Category;
	}
	public void setCategory(int category) {
		Category = category;
	}
	public double getProductGst() {
		return productGst;
	}
	public void setProductGst(double productGst) {
		this.productGst = productGst;
	}
	public int getProductStock() {
		return productStock;
	}
	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}
}
