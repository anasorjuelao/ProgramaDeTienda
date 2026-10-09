package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.ArrayList;

public record Factura(String codigo, LocalDate fecha, double total,
                      EstadoFactura estadoFactura, MetodoDePago metodoPago, Cliente cliente,
                      ArrayList<DetalleFactura> listaDetallesFactura, Tienda ownedByTienda) {
    public String calcularTotal(int subTotal){
        int suma=0;
        for(DetalleFactura total: listaDetallesFactura){
            suma+=subTotal;
        }
        return "El total de su factura es de: "+suma;
    }
    public boolean clienteConR(){

        boolean resultado = false;

        resultado = cliente.buscarNombreConR();

        return resultado;
    }
    public boolean facturasConIPhone(){
        boolean resultado= false;
        for(DetalleFactura iphone: listaDetallesFactura){
            if(iphone.buscarIPhone() != resultado){
                return true;
            }
        }
        return resultado;
    }
}
