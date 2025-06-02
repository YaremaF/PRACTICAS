package com.akihabara.market.model;

public class ProductoOtaku {
	public int id;
	public String nombre;
	public String categoria;
	public double precio;
	public int stock;
	
	public ProductoOtaku() {
		
	}
	
	public ProductoOtaku(String nombre, String categoria, double precio, int stock) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.stock = stock;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public void setPrecio (double precio) {
		this.precio = precio;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public String toString() {
		return "ID: " + id + " | Nombre: " + nombre + " | Categoria: " + categoria + " | Precio: " + precio + " | Stock: " + stock;
	}
}
