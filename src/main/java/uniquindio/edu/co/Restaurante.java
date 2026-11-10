package uniquindio.edu.co;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restaurante {
    private String nombre;
    private int NIT;
    private String direccion;
    private List<Producto> menu;
    private List<Cliente> clientes;
    private List<Pedido> pedidos;

    public Restaurante(String nombre, int NIT, String direccion) {
        this.nombre = nombre;
        this.NIT = NIT;
        this.direccion = direccion;
        this.menu = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public boolean registrarProducto(Producto producto) {
        for (Producto p : menu) {
            if (p.getCodigoProducto() == producto.getCodigoProducto()) {
                return false;
            }
        }
        menu.add(producto);
        return true;
    }

    public boolean registrarCliente(Cliente cliente) {
        for (Cliente c : clientes) {
            if (c.getDocumento() == cliente.getDocumento()) {
                return false;
            }
        }
        clientes.add(cliente);
        return true;
    }

    public List<Producto> consultarProductosNoCumplenCalidad() {
        List<Producto> rechazados = new ArrayList<>();
        for (Producto p : menu) {
            if (!p.verificarCondicionesCalidad()) {
                rechazados.add(p);
            }
        }
        return rechazados;
    }

    public List<Producto> consultarProductosDisponibles() {
        List<Producto> disponibles = new ArrayList<>();
        for (Producto p : menu) {
            if (p.verificarCondicionesCalidad()) {
                disponibles.add(p);
            }
        }
        return disponibles;
    }

    public boolean confirmarPedido(Pedido pedido) {
        if (pedido == null || pedido.getEstadoPedido() != EstadoPedido.PENDIENTE) {
            return false;
        }
        for (Pedido p : pedidos) {
            if (p != pedido && p.getCodigoPedido() == pedido.getCodigoPedido()) {
                return false;
            }
        }

        if (pedido.getCliente() == null || !clientes.contains(pedido.getCliente())) {
            return false;
        }

        if (pedido.getDetalles().isEmpty()) {
            return false;
        }
        for (DetallePedido detalle : pedido.getDetalles()) {
            if (detalle.getCantidad() <= 0) {
                return false;
            }
            if (!menu.contains(detalle.getProducto())) {
                return false;
            }
            if (!detalle.getProducto().verificarCondicionesCalidad()) {
                return false;
            }
        }

        if (pedido.getModalidadEntrega() == ModalidadEntrega.DOMICILIO) {
            if (pedido.getIServicioDomicilio() == null ||
                    !pedido.getIServicioDomicilio().aceptaEntrega(pedido.getDistanciaKm())) {
                return false;
            }
        }

        pedido.setEstadoPedido(EstadoPedido.CONFIRMADO);
        if (!pedidos.contains(pedido)) {
            pedidos.add(pedido);
        }
        return true;
    }

    public boolean marcarPedidoEntregado(int codigoPedido) {
        for (Pedido p : pedidos) {
            if (p.getCodigoPedido() == codigoPedido) {
                if (p.getEstadoPedido() == EstadoPedido.CONFIRMADO) {
                    p.setEstadoPedido(EstadoPedido.ENTREGADO);
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public boolean cancelarPedido(int codigoPedido) {
        for (Pedido p : pedidos) {
            if (p.getCodigoPedido() == codigoPedido) {
                if (p.getEstadoPedido() != EstadoPedido.ENTREGADO) {
                    p.setEstadoPedido(EstadoPedido.CANCELADO);
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public List<Pedido> consultarPedidosPorCliente(int documentoCliente) {
        List<Pedido> historialCliente = new ArrayList<>();
        for (Pedido p : pedidos) {
            if (p.getCliente() != null && p.getCliente().getDocumento() == documentoCliente) {
                historialCliente.add(p);
            }
        }
        return historialCliente;
    }

    public double calcularIngresosNetos() {
        double ingresos = 0;
        for (Pedido p : pedidos) {
            if (p.getEstadoPedido() != EstadoPedido.CANCELADO) {
                ingresos += p.calcularTotalProductos();
            }
        }
        return ingresos;
    }

    public Producto obtenerProductoMasVendido() {
        Map<Producto, Integer> conteo = new HashMap<>();
        for (Pedido p : pedidos) {
            if (p.getEstadoPedido() != EstadoPedido.CANCELADO) {
                for (DetallePedido d : p.getDetalles()) {
                    conteo.put(d.getProducto(), conteo.getOrDefault(d.getProducto(), 0) + d.getCantidad());
                }
            }
        }

        Producto masVendido = null;
        int maxUnidades = -1;
        for (Map.Entry<Producto, Integer> entry : conteo.entrySet()) {
            if (entry.getValue() > maxUnidades) {
                maxUnidades = entry.getValue();
                masVendido = entry.getKey();
            }
        }
        return masVendido;
    }

    public String obtenerCategoriaMayoresIngresos() {
        double ingresosPlatos = 0;
        double ingresosBebidas = 0;
        double ingresosPostres = 0;

        for (Pedido p : pedidos) {
            if (p.getEstadoPedido() != EstadoPedido.CANCELADO) {
                for (DetallePedido d : p.getDetalles()) {
                    Producto prod = d.getProducto();
                    double subtotal = d.calcularSubtotal();
                    if (prod instanceof PlatoFuerte) {
                        ingresosPlatos += subtotal;
                    } else if (prod instanceof Bebidas) {
                        ingresosBebidas += subtotal;
                    } else if (prod instanceof Postre) {
                        ingresosPostres += subtotal;
                    }
                }
            }
        }

        if (ingresosPlatos >= ingresosBebidas && ingresosPlatos >= ingresosPostres && ingresosPlatos > 0) {
            return "Platos Fuertes ($" + ingresosPlatos + ")";
        } else if (ingresosBebidas >= ingresosPlatos && ingresosBebidas >= ingresosPostres && ingresosBebidas > 0) {
            return "Bebidas ($" + ingresosBebidas + ")";
        } else if (ingresosPostres > 0) {
            return "Postres ($" + ingresosPostres + ")";
        }
        return "Sin ventas registradas";
    }

    public boolean registrarPedido(Pedido pedido) {
        if (pedido == null || pedido.getCliente() == null) {
            return false;
        }
        for (Pedido p : pedidos) {
            if (p.getCodigoPedido() == pedido.getCodigoPedido()) {
                return false;
            }
        }
        pedidos.add(pedido);
        return true;
    }

    public boolean confirmarPedido(int codigoPedido) {
        for (Pedido p : pedidos) {
            if (p.getCodigoPedido() == codigoPedido) {
                return confirmarPedido(p);
            }
        }
        return false;
    }

    public EstadoPedido consultarEstadoPedido(int codigoPedido) {
        for (Pedido p : pedidos) {
            if (p.getCodigoPedido() == codigoPedido) {
                return p.getEstadoPedido();
            }
        }
        return null;
    }

    public double calcularIngresosDomicilios() {
        double total = 0;
        for (Pedido p : pedidos) {
            if (p.getModalidadEntrega() == ModalidadEntrega.DOMICILIO && p.getIServicioDomicilio() != null) {
                total += p.getIServicioDomicilio().calcularCostoDomicilio(p.getDistanciaKm());
            }
        }
        return total;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getNIT() { return NIT; }
    public void setNIT(int NIT) { this.NIT = NIT; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public List<Producto> getMenu() { return menu; }
    public List<Cliente> getClientes() { return clientes; }
    public List<Pedido> getPedidos() { return pedidos; }
}