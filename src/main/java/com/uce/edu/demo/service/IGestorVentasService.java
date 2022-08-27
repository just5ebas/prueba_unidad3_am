package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoCompra;
import com.uce.edu.demo.repository.modelo.ProductoStock;
import com.uce.edu.demo.repository.modelo.Reporte;

public interface IGestorVentasService {

	// Funcionalidad 1: insertar producto o actuslizar su stock
	public void insertarProducto(Producto p);

	// Funcionalidad 2: Realizar venta
	public void realizarVenta(List<ProductoCompra> productos, String cedulaCliente, String numVenta);

	// Funcionalidad 3: Reporte de ventas
	public List<Reporte> reporteVentas(LocalDateTime fecha, String categoria, Integer cantidad);

	// Funcionalidad 4: Consultar Stock
	public ProductoStock consultarStock(String codigoBarras);

}
