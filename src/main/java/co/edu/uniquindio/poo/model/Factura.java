package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.ArrayList;

public record Factura(String codigo, LocalDate fecha, double total,
                      EstadoFactura estadoFactura, MetodoDePago metodoPago, Cliente cliente,
                      ArrayList<DetalleFactura> listaDetallesFactura, Tienda ownedByTienda) {
}
