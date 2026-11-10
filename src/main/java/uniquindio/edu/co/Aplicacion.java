package uniquindio.edu.co;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Aplicacion {

    private final Scanner scanner = new Scanner(System.in);
    private final Restaurante restaurante;

    public Aplicacion() {
        restaurante = new Restaurante("Sabor & Tradición", 900123456, "Calle 18 # 12-47, Armenia");
    }

    public static void main(String[] args) {
        new Aplicacion().iniciar();
    }


    public void iniciar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Opción: ");
            switch (opcion) {
                case 1:
                    registrarProducto();
                    break;
                case 2:
                    registrarCliente();
                    break;
                case 3:
                    consultarProductosDisponibles();
                    break;
                case 4:
                    consultarProductosRechazados();
                    break;
                case 5:
                    crearPedido();
                    break;
                case 6:
                    confirmarPedido();
                    break;
                case 7:
                    actualizarEstadoPedido();
                    break;
                case 8:
                    consultarEstadoPedido();
                    break;
                case 9:
                    consultarPedidosPorCliente();
                    break;
                case 10:
                    mostrarReportes();
                    break;
                case 0:
                    System.out.println("Gracias por usar Sabor & Tradición.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void mostrarMenu() {
        System.out.println("\n========== " + restaurante.getNombre() + " ==========");
        System.out.println(" 1. Registrar producto (plato fuerte, bebida o postre)");
        System.out.println(" 2. Registrar cliente");
        System.out.println(" 3. Consultar productos disponibles y precio de venta");
        System.out.println(" 4. Consultar productos que no cumplen calidad");
        System.out.println(" 5. Crear pedido");
        System.out.println(" 6. Confirmar pedido");
        System.out.println(" 7. Entregar o cancelar pedido");
        System.out.println(" 8. Consultar estado de un pedido");
        System.out.println(" 9. Consultar pedidos de un cliente");
        System.out.println("10. Reportes de ventas");
        System.out.println(" 0. Salir");
    }


    private void registrarProducto() {
        System.out.println("\nTipo de producto:");
        System.out.println("1. Plato fuerte");
        System.out.println("2. Bebida");
        System.out.println("3. Postre");
        int tipo = leerEnteroEnRango("Seleccione: ", 1, 3);

        int codigo = leerEntero("Código del producto: ");
        String nombre = leerTextoNoVacio("Nombre: ");
        String descripcion = leerTextoNoVacio("Descripción: ");
        double precioBase = leerDoublePositivo("Precio base: ");
        int tiempoEstimado = leerEnteroPositivo("Tiempo estimado de preparación (minutos): ");

        Producto producto;
        if (tipo == 1) {
            int peso = leerEnteroPositivo("Peso en gramos: ");
            TipoPreparacion preparacion = seleccionarEnum(TipoPreparacion.values(), "Tipo de preparación");
            boolean coccion = leerBooleano("¿Superó el control de cocción?");
            producto = new PlatoFuerte(codigo, nombre, descripcion, precioBase, tiempoEstimado,
                    peso, preparacion, coccion);
        } else if (tipo == 2) {
            int volumen = leerEnteroPositivo("Volumen en mililitros: ");
            int temperatura = leerEntero("Temperatura de servicio (°C): ");
            TipoBebida tipoBebida = seleccionarEnum(TipoBebida.values(), "Tipo de bebida");
            boolean especial = leerBooleano("¿Requiere preparación especial?");
            producto = new Bebidas(codigo, nombre, descripcion, precioBase, tiempoEstimado,
                    volumen, temperatura, tipoBebida, especial);
        } else {
            int peso = leerEnteroPositivo("Peso en gramos: ");
            int temperatura = leerEntero("Temperatura de almacenamiento (°C): ");
            boolean refrigeracion = leerBooleano("¿Requiere refrigeración?");
            producto = new Postre(codigo, nombre, descripcion, precioBase, tiempoEstimado,
                    peso, temperatura, refrigeracion);
        }

        if (restaurante.registrarProducto(producto)) {
            System.out.printf("Producto registrado. Precio de venta: $%,.2f | Calidad: %s%n",
                    producto.precioFinal(),
                    producto.verificarCondicionesCalidad() ? "CUMPLE" : "NO CUMPLE");
        } else {
            System.out.println("No se registró: ya existe un producto con el código " + codigo + ".");
        }
    }

    private void registrarCliente() {
        int identificacion = leerEntero("Número de documento: ");
        String nombre = leerTextoNoVacio("Nombre completo: ");
        int telefono = leerEntero("Teléfono: ");
        String correo = leerTextoNoVacio("Correo electrónico: ");
        String direccion = leerTextoNoVacio("Dirección de residencia: ");

        Cliente cliente = new Cliente(identificacion, nombre, telefono, correo, direccion);
        if (restaurante.registrarCliente(cliente)) {
            System.out.println("Cliente registrado correctamente.");
        } else {
            System.out.println("No se registró: ya existe un cliente con el documento " + identificacion + ".");
        }
    }


    private void consultarProductosDisponibles() {
        mostrarProductos("PRODUCTOS DISPONIBLES (cumplen calidad)", restaurante.consultarProductosDisponibles());
    }

    private void consultarProductosRechazados() {
        mostrarProductos("PRODUCTOS RECHAZADOS (no cumplen calidad)", restaurante.consultarProductosNoCumplenCalidad());
    }

    private void mostrarProductos(String titulo, List<Producto> productos) {
        System.out.println("\n--- " + titulo + " ---");
        if (productos.isEmpty()) {
            System.out.println("No hay productos para mostrar.");
            return;
        }
        for (Producto producto : productos) {
            imprimirProducto(producto);
        }
    }

    private void imprimirProducto(Producto p) {
        System.out.printf("#%d | %s | %s | %s | prep.: %s min | base: $%,.2f | VENTA: $%,.2f",
                p.getCodigo(), p.getNombre(), p.getClass().getSimpleName(), p.getDescripcion(),
                p.getTiempoEstimado(), p.getPrecioBase(), p.precioFinal());
        if (p instanceof PlatoFuerte plato) {
            System.out.printf(" | %.0f g | %s | cocción superada: %s",
                    plato.getPeso(), plato.getTipoPreparacion(), siNo(plato.getCoccionSuperada()));
        } else if (p instanceof Bebidas bebida) {
            System.out.printf(" | %.0f ml | %.1f °C | %s | prep. especial: %s",
                    bebida.getVolumenML(), bebida.getTemperatura(), bebida.getTipoBebida(),
                    siNo(bebida.getPreparacionEspecial()));
        } else if (p instanceof Postre postre) {
            System.out.printf(" | %.0f g | almacenado a %.1f °C | refrigeración: %s",
                    postre.getPeso(), postre.getTempAlmacenamiento(), siNo(postre.getRefrigeracion()));
        }
        System.out.println();
    }


    private void crearPedido() {
        Cliente cliente = buscarCliente(leerEntero("Documento del cliente: "));
        if (cliente == null) {
            System.out.println("No existe un cliente registrado con ese documento.");
            return;
        }
        int codigo = leerEntero("Código del pedido: ");
        if (buscarPedido(codigo) != null) {
            System.out.println("Ya existe un pedido con el código " + codigo + ".");
            return;
        }
        if (restaurante.getMenu().isEmpty()) {
            System.out.println("El menú está vacío. Registre productos primero.");
            return;
        }

        System.out.println("Modalidad de entrega:");
        System.out.println("1. Consumo en restaurante");
        System.out.println("2. Domicilio");
        int modalidad = leerEnteroEnRango("Seleccione: ", 1, 2);

        Pedido pedido;
        if (modalidad == 1) {
            pedido = new Pedido(codigo, LocalDate.now(), cliente);
        } else {
            pedido = crearDomicilio(codigo, cliente);
            if (pedido == null) {
                System.out.println("Pedido cancelado: no se definió un domicilio válido.");
                return;
            }
        }

        agregarProductos(pedido);
        if (pedido.getDetalles().isEmpty()) {
            System.out.println("El pedido no tiene productos; no se registró.");
            return;
        }

        if (restaurante.registrarPedido(pedido)) {
            System.out.printf("Pedido #%d registrado en estado %s. Total actual: $%,.2f%n",
                    codigo, pedido.getEstado(), pedido.calcularTotal());
            System.out.println("Use la opción 6 para confirmarlo.");
        } else {
            System.out.println("No fue posible registrar el pedido.");
        }
    }


    private Domicilio crearDomicilio(int codigo, Cliente cliente) {
        while (true) {
            System.out.println("Empresa de transporte (0 para cancelar):");
            EmpresaDomicilio[] empresas = EmpresaDomicilio.values();
            for (int i = 0; i < empresas.length; i++) {
                System.out.println((i + 1) + ". " + empresas[i]);
            }
            int opcion = leerEnteroEnRango("Seleccione: ", 0, empresas.length);
            if (opcion == 0) {
                return null;
            }
            int distancia = leerEnteroPositivo("Distancia en kilómetros: ");
            Domicilio domicilio = new Domicilio(codigo, LocalDate.now(), cliente, distancia, empresas[opcion - 1]);

            if (domicilio.aceptarPedido()) {
                System.out.printf("%s acepta el recorrido. Costo del domicilio: $%,.2f%n",
                        domicilio.getEmpresa(), domicilio.calcularCostoDistancia());
                return domicilio;
            }
            System.out.println(domicilio.getEmpresa() + " no acepta ese recorrido. Intente con otra empresa o distancia.");
        }
    }

    private void agregarProductos(Pedido pedido) {
        mostrarProductos("MENÚ", restaurante.getMenu());
        while (true) {
            int codigo = leerEntero("Código de producto a agregar (0 para terminar): ");
            if (codigo == 0) {
                return;
            }
            Producto producto = buscarProducto(codigo);
            if (producto == null) {
                System.out.println("Ese código no pertenece al menú.");
                continue;
            }
            int cantidad = leerEnteroPositivo("Cantidad: ");
            pedido.agregarDetalle(producto, cantidad);
            System.out.println("Agregado: " + producto.getNombre() + " x" + cantidad
                    + (producto.verificarCondicionesCalidad() ? ""
                    : "  (ADVERTENCIA: no cumple calidad, el pedido no podrá confirmarse)"));
        }
    }


    private void confirmarPedido() {
        int codigo = leerEntero("Código del pedido a confirmar: ");
        Pedido pedido = buscarPedido(codigo);
        if (pedido == null) {
            System.out.println("No existe un pedido con ese código.");
            return;
        }
        if (restaurante.confirmarPedidoPorCodigo(codigo)) {
            System.out.printf("Pedido #%d CONFIRMADO. Valor total: $%,.2f%n", codigo, pedido.calcularTotal());
        } else {
            System.out.println("No se pudo confirmar el pedido #" + codigo + ". Estado actual: " + pedido.getEstado());
            System.out.println("Verifique: cliente registrado, productos del menú con calidad aprobada,"
                    + " cantidades válidas, domicilio aceptado y que no esté ya confirmado.");
        }
    }

    private void actualizarEstadoPedido() {
        int codigo = leerEntero("Código del pedido: ");
        System.out.println("1. Marcar como ENTREGADO");
        System.out.println("2. CANCELAR");
        int opcion = leerEnteroEnRango("Seleccione: ", 1, 2);
        boolean exito = opcion == 1 ? restaurante.marcarPedidoEntregado(codigo) : restaurante.cancelarPedido(codigo);
        if (exito) {
            System.out.println("Estado actualizado: " + restaurante.consultarEstadoPedido(codigo));
        } else {
            System.out.println("No se pudo actualizar: el pedido no existe o su estado no lo permite"
                    + " (solo se entregan los CONFIRMADOS y no se entregan los CANCELADOS).");
        }
    }

    private void consultarEstadoPedido() {
        int codigo = leerEntero("Código del pedido: ");
        EstadoPedido estado = restaurante.consultarEstadoPedido(codigo);
        System.out.println(estado == null ? "No existe un pedido con ese código." : "Estado del pedido #" + codigo + ": " + estado);
    }


    private void consultarPedidosPorCliente() {
        int identificacion = leerEntero("Documento del cliente: ");
        Cliente cliente = buscarCliente(identificacion);
        if (cliente == null) {
            System.out.println("No existe un cliente registrado con ese documento.");
            return;
        }
        List<Pedido> pedidos = restaurante.consultarPedidosPorCliente(identificacion);
        System.out.println("\n--- Pedidos de " + cliente.getNombre() + " ---");
        if (pedidos.isEmpty()) {
            System.out.println("El cliente no tiene pedidos.");
            return;
        }
        for (Pedido pedido : pedidos) {
            imprimirPedido(pedido);
        }
    }

    private void imprimirPedido(Pedido pedido) {
        System.out.printf("%nPedido #%d | %s | %s | Estado: %s%n",
                pedido.getCodigo(), pedido.getFecha(), pedido.getModalidadEntrega(), pedido.getEstado());
        for (DetallePedido d : pedido.getDetalles()) {
            System.out.printf("   %s x%d @ $%,.2f = $%,.2f%n", d.getProducto().getNombre(),
                    d.getCantidad(), d.getPrecioUnitario(), d.calcularSubtotal());
        }
        if (pedido instanceof Domicilio domicilio) {
            String costo = domicilio.aceptarPedido()
                    ? String.format("$%,.2f", domicilio.calcularCostoDistancia()) : "no aceptado";
            System.out.printf("   Domicilio: %s | %d km | costo: %s%n",
                    domicilio.getEmpresa(), domicilio.getDistancia(), costo);
        }
        System.out.printf("   TOTAL DEL PEDIDO: $%,.2f%n", pedido.calcularTotal());
    }



    private void mostrarReportes() {
        System.out.println("\n========== REPORTES DE VENTAS ==========");
        System.out.printf("Ingresos del restaurante (sin domicilios): $%,.2f%n", restaurante.calcularIngresosNetos());
        System.out.printf("Valores cobrados por domicilios (aparte):  $%,.2f%n", restaurante.calcularIngresosDomicilios());
        Producto masVendido = restaurante.obtenerProductoMasVendido();
        System.out.println("Producto más vendido: "
                + (masVendido == null ? "sin ventas registradas" : masVendido.getNombre()
                + " (código " + masVendido.getCodigo() + ")"));
        System.out.println("Categoría con mayores ingresos: " + restaurante.obtenerCategoriaMayoresIngresos());
    }


    private Cliente buscarCliente(int identificacion) {
        for (Cliente c : restaurante.getClientes()) {
            if (c.getIdentificacion() == identificacion) {
                return c;
            }
        }
        return null;
    }

    private Producto buscarProducto(int codigo) {
        for (Producto p : restaurante.getMenu()) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }

    private Pedido buscarPedido(int codigo) {
        for (Pedido p : restaurante.getPedidos()) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }


    private String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }

    private String leerTextoNoVacio(String mensaje) {
        while (true) {
            String texto = leerTexto(mensaje);
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("El texto no puede quedar vacío.");
        }
    }

    private int leerEntero(String mensaje) {
        while (true) {
            try {
                return Integer.parseInt(leerTexto(mensaje));
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número entero válido.");
            }
        }
    }

    private int leerEnteroEnRango(String mensaje, int minimo, int maximo) {
        while (true) {
            int valor = leerEntero(mensaje);
            if (valor >= minimo && valor <= maximo) {
                return valor;
            }
            System.out.printf("Ingrese un valor entre %d y %d.%n", minimo, maximo);
        }
    }

    private int leerEnteroPositivo(String mensaje) {
        while (true) {
            int valor = leerEntero(mensaje);
            if (valor > 0) {
                return valor;
            }
            System.out.println("El valor debe ser mayor que cero.");
        }
    }

    private double leerDouble(String mensaje) {
        while (true) {
            try {
                double valor = Double.parseDouble(leerTexto(mensaje).replace(',', '.'));
                if (Double.isFinite(valor)) {
                    return valor;
                }
            } catch (NumberFormatException ignorada) {
            }
            System.out.println("Ingrese un número válido.");
        }
    }

    private double leerDoublePositivo(String mensaje) {
        while (true) {
            double valor = leerDouble(mensaje);
            if (valor > 0) {
                return valor;
            }
            System.out.println("El valor debe ser mayor que cero.");
        }
    }

    private boolean leerBooleano(String mensaje) {
        while (true) {
            String r = leerTexto(mensaje + " (s/n): ");
            if (r.equalsIgnoreCase("s") || r.equalsIgnoreCase("si") || r.equalsIgnoreCase("sí")) {
                return true;
            }
            if (r.equalsIgnoreCase("n") || r.equalsIgnoreCase("no")) {
                return false;
            }
            System.out.println("Responda s o n.");
        }
    }

    private <T extends Enum<T>> T seleccionarEnum(T[] valores, String titulo) {
        System.out.println(titulo + ":");
        for (int i = 0; i < valores.length; i++) {
            System.out.println((i + 1) + ". " + valores[i]);
        }
        return valores[leerEnteroEnRango("Seleccione: ", 1, valores.length) - 1];
    }

    private String siNo(boolean valor) {
        return valor ? "sí" : "no";
    }
}