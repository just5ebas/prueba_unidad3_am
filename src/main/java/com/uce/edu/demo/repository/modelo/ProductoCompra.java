package com.uce.edu.demo.repository.modelo;

// Producto Sencillo para compra
public class ProductoCompra {

	private String codigoBarras;
	private Integer cantidad;

	@Override
	public String toString() {
		return "ProductoCompra [codigoBarras=" + codigoBarras + ", cantidad=" + cantidad + "]";
	}

	// GET & SET
	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

}
