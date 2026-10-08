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

    public Optional <Producto> cantidadDeUnProductoMayorADiez(ArrayList<Producto>listaProductos, int cantidadDisponible){
        String mensaje="";
        for(Producto a: listaProductos){
            if(cantidadDisponible == (a.getCantidadDisponible())){
                return Optional.of(a);
            }
        }
        return Optional.empty();
    }
}
