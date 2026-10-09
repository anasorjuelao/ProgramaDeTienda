package co.edu.uniquindio.poo.model;

import java.util.*;

public class Tienda {

    private final String nombre;
    private final String nit;// documentar
    private String telefono;

    private final ArrayList<Cliente> listaClientes = new ArrayList<>();
    private final List<Factura> listaFacturas = new LinkedList<>();
    private Map<String,Producto> listaProductos = new HashMap<>();


    public Tienda(String nombre, String nit,String telefono){
        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
    }

    // sets y gets

    public String getNombre() {
        return nombre;
    }

    public String getNit() {
        return nit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }



    public String registrarCliente2(Cliente cliente){
        Optional<Cliente> clienteEncontrado = buscarCliente(cliente.getDocumentoIdentidad());
        if(clienteEncontrado.isEmpty()){
            listaClientes.add(cliente);
            return "El cliente fue registrado exitosamente";
        }else return "No se puede registrar, ya existe un cliente con esa informacion registrado anteriormente.";
    }

    public Optional<Cliente> buscarCliente(String documentoIdentidad) {
        for (Cliente cliente :listaClientes){
            if (documentoIdentidad.equals(cliente.getDocumentoIdentidad())){
                return Optional.of(cliente);//guardo en la caja
            }
        }
        return Optional.empty();
    }

    public String cantidadDeUnProductoMayorADiez(ArrayList<Producto>listaProductos, int cantidadDisponible){
        String mensaje="";
        for(Producto a: listaProductos){
            if(cantidadDisponible >= 10){
                return mensaje+= Optional.of(a);
            }
        }
        return mensaje+=Optional.empty();
    }
    public ArrayList <String> cantidadMenorACiencuentaYMayorADiez( Map <String, Producto> listaProductos, int cantidadDisponible,int codigo){

        ArrayList <String> productosBuscados = new ArrayList<>();

        for(Producto b: listaProductos.values()){
            if(b.getCantidadDisponible() >= 10 && b.getCantidadDisponible() < 50){
                productosBuscados.add(b.getCodigo());
            }
        }
        return productosBuscados;
    }
    public ArrayList <Cliente> clientesQueCompraronEnUnaFecha(){

        ArrayList<Cliente> clientesEspecificos = new ArrayList<>();

        String fechaEspecifica= "7 de octubre de 2026";

        for(Factura c: listaFacturas){
            if(c.fecha().equals(fechaEspecifica)){
                clientesEspecificos.add(c.cliente());
            }
        }
        return clientesEspecificos;
    }
    public ArrayList <Factura> facturasCuyoClienteEmpieceConR(){

        ArrayList<Factura> facturasConLaR = new ArrayList<>();

        for(Factura d: listaFacturas){
            if(d.clienteConR()){
                facturasConLaR.add(d);
            }
        }
        return facturasConLaR;
    }
    public ArrayList <Factura> facturasQueTienenIPhone(){

        ArrayList <Factura> facturasConIPhone = new ArrayList <> ();

        for( Factura e: listaFacturas){
            if(e.facturasConIPhone()){
                facturasConIPhone.add(e);
            }
        }
        return facturasConIPhone;
    }
}
