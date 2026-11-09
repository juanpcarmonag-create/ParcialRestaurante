package uniquindio.edu.co;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private String nombre;
    private int NIT;
    private String direccion;
    private List<Cliente> listaCliente;
    private List<Producto> listaProducto;


    public Restaurante(String nombre, int NIT, String direccion) {
        this.nombre = nombre;
        this.NIT = NIT;
        this.direccion = direccion;

        this.listaCliente=new ArrayList<>();
        this.listaProducto=new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNIT() {
        return NIT;
    }

    public void setNIT(int NIT) {
        this.NIT = NIT;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public int buscarCliente(int documento) {
        int posicion = -1;
        for (int i = 0; i < listaCliente.size(); i++) {
            if (listaCliente.get(i).getDocumento()==(documento)) {
                posicion = i;
            }
        }
        return posicion;
    }

    public boolean agregarCliente(Cliente cliente) {
        boolean agregado=false;
        int posicion=buscarCliente(cliente.getDocumento());
        if (posicion<0){
            listaCliente.add(cliente);
            agregado=true;
        }
        return agregado;

    }

    public int buscarProducto(int codigo){
        int posicion=-1;
        for (int i = 0; i < listaProducto.size(); i++) {
            if (listaProducto.get(i).getCodigoProducto()==(codigo)) {
                posicion = i;
            }
        }
        return posicion;
    }

    public boolean agregarProducto(Producto producto){
        boolean agregado=false;
        int posicion=buscarProducto(producto.getCodigoProducto());
        if (posicion<0){
            listaProducto.add(producto);
            agregado=true;
        }
        return agregado;
    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "nombre='" + nombre + '\'' +
                ", NIT=" + NIT +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
