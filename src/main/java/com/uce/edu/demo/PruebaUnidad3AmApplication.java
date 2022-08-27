package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoCompra;
import com.uce.edu.demo.repository.modelo.Reporte;
import com.uce.edu.demo.service.IGestorVentasService;
import com.uce.edu.demo.service.IProductoService;

@SpringBootApplication
public class PruebaUnidad3AmApplication implements CommandLineRunner {

	private static final Logger LOG = Logger.getLogger(PruebaUnidad3AmApplication.class);

	@Autowired
	private IGestorVentasService gestorVentasService;

	@Autowired
	private IProductoService iProductoService;

	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad3AmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Insertar un producto dos veces
		Producto p = new Producto();
		p.setCodigoBarras("000111");
		p.setNombre("Coca Cola 3L");
		p.setCategoria("Bebidas");
		p.setPrecio(new BigDecimal(3.50));
		p.setStock(75);

		this.gestorVentasService.insertarProducto(p);
		this.gestorVentasService.insertarProducto(p);

		// Venta de un producto
		List<ProductoCompra> compras = new ArrayList<>();

		ProductoCompra pc = new ProductoCompra();
		pc.setCodigoBarras(p.getCodigoBarras());
		pc.setCantidad(10);

		compras.add(pc);

		this.gestorVentasService.realizarVenta(compras, "1750844787", "001-001-000000001");

		// Consultar un producto por su codigo de barras
		Producto pBuscado = this.iProductoService.buscarPorCodigoBarras("000111");

		// Imprimir reportes
		List<Reporte> reportes = this.gestorVentasService.reporteVentas(LocalDateTime.of(2022, 7, 15, 8, 15), "Bebidas",
				6);
		reportes.forEach(r -> LOG.info("Reporte: " + r));

	}

}
