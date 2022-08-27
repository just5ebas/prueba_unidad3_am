package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.DetalleVenta;

@Repository
@Transactional
public class DetalleVentaRepositoryImpl implements IDetalleVentaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<DetalleVenta> consultarDetalles(LocalDateTime fecha, String categoria, Integer cantidad) {
		// TODO Auto-generated method stub
		// SELECT h FROM Hotel h, Habitacion ha WHERE h = ha.hotel AND ha.tipo = :tipo
		TypedQuery<DetalleVenta> myQuery = this.entityManager.createQuery(
				"SELECT d FROM DetalleVenta d, Producto p, Venta v WHERE d.producto = p AND d.venta = v AND v.fecha > :fecha AND p.categoria = :categoria AND d.cantidad >= :cantidad",
				DetalleVenta.class);
		myQuery.setParameter("fecha", fecha);
		myQuery.setParameter("categoria", categoria);
		myQuery.setParameter("cantidad", cantidad);

		List<DetalleVenta> detalles = myQuery.getResultList();

		Consumer<DetalleVenta> demandaProducto = d -> d.getProducto().getStock();
		detalles.forEach(demandaProducto);

		return detalles;
	}

}
