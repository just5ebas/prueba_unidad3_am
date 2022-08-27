package com.uce.edu.demo.repository.modelo;

public class ProductoStock {

	private String codigoBarras;
	private String nombre;
	private String categoria;
	private Integer stock;

	@Override
	public String toString() {
		return "Stock del producto con: codigo de barras: " + codigoBarras + ", nombre: " + nombre + ", categoria: "
				+ categoria + " y stock: " + stock;
	}

	// GET & SET
	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

}
