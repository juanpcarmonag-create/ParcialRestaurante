package uniquindio.edu.co;

import java.lang.classfile.instruction.SwitchCase;
import java.util.Scanner;

public class Aplicacion {

    public static void main() {
        Scanner Scanner= new Scanner(System.in);

        Restaurante restaurante= new Restaurante("Sabor & Tradición", 1000, "calle 18 # 12-47, Armenia");

        int opcion;

        do{
            System.out.println("\n =====Sabor & Tradición=====");
            System.out.println("1. Agregar producto");
            System.out.println("2. Agregar cliente");
            System.out.println("3. realizar ventas");

            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = Scanner.nextInt();
            Scanner.nextLine();


            switch(opcion){
                case 1:{
                    System.out.println("1. Plato fuerte\n"+
                            "2. Bebida\n"+
                            "3. Postre\n");
                    System.out.println("Escoge el tiplo de producto que desea agregar: ");
                    int tipo= Scanner.nextInt();
                    Scanner.nextLine();
                    System.out.println("Código producto: ");
                    int codigoP= Scanner.nextInt();
                    Scanner.nextLine();
                    System.out.println("Nombre del producto: ");
                    String nombreP= Scanner.nextLine();
                    System.out.println("Descripcion: ");
                    String descripcion=Scanner.nextLine();
                    System.out.println("Precio base: ");
                    double precioBase= Scanner.nextDouble();
                    System.out.println("Tiempo de preparación: ");
                    int tiempoPreparacion=Scanner.nextInt();
                    Scanner.nextLine();
                    if(tipo==1){
                        System.out.println("Peso en gramos: ");
                        int pesoP=Scanner.nextInt();
                        Scanner.nextLine();
                        System.out.println("Coccion completa: ");
                        boolean coccionCompleta=Scanner.nextBoolean();
                        TipoPreparacion[] preparacion = TipoPreparacion.values();
                        for (int i = 0; i < preparacion.length; i++) {
                            System.out.println((i + 1) + ". " + preparacion[i]);
                        }
                        System.out.print("Categoría: ");
                        int numero = Scanner.nextInt();
                        Scanner.nextLine();
                        if (numero >= 1 && numero <= preparacion.length) {
                            Producto producto1 = new PlatoFuerte(codigoP, nombreP, descripcion, precioBase,tiempoPreparacion, pesoP, preparacion[numero - 1], coccionCompleta );
                            boolean existe= restaurante.agregarProducto(producto1);
                            if (existe) {
                                System.out.println("Plato fuerte registrado.");
                            } else {
                                System.out.println("Código repetido.");
                            }
                        } else {
                            System.out.println("Categoría incorrecta.");
                        }

                    } else if (tipo==2) {

                        System.out.println("Volumen en mililitros: ");
                        int volumenP=Scanner.nextInt();
                        Scanner.nextLine();
                        System.out.println("Temperatura: ");
                        int temperaturaP=Scanner.nextInt();
                        Scanner.nextLine();
                        System.out.println("Preparacion especial: ");
                        boolean preparacionEsp=Scanner.nextBoolean();
                        TipoBebida[] tipoBebidas = TipoBebida.values();
                        for (int i = 0; i < tipoBebidas.length; i++) {
                            System.out.println((i + 1) + ". " + tipoBebidas[i]);
                        }
                        System.out.print("Tipo de bebida: ");
                        int numero = Scanner.nextInt();
                        Scanner.nextLine();
                        if (numero >= 1 && numero <= tipoBebidas.length) {
                            Producto producto3 = new Postre(codigoP, nombreP, descripcion, precioBase,tiempoPreparacion, volumenP, temperaturaP, tipoBebidas[numero - 1], preparacionEsp );
                            boolean existe= restaurante.agregarProducto(producto3);
                            if (existe) {
                                System.out.println("Bebida registrada.");
                            } else {
                                System.out.println("Código repetido.");
                            }
                        } else {
                            System.out.println("Categoría incorrecta.");
                        }

                    }else {

                        System.out.println("Peso en gramos: ");
                        int pesoPostre=Scanner.nextInt();
                        Scanner.nextLine();
                        System.out.println("Temperatura de almacenamiento: ");
                        int temperaturaPostre=Scanner.nextInt();
                        Scanner.nextLine();
                        System.out.println("refrigeración: ");
                        boolean refrigeracion=Scanner.nextBoolean();
                        Producto producto3 = new Postre(codigoP, nombreP, descripcion, precioBase,tiempoPreparacion, pesoPostre, temperaturaPostre, refrigeracion );

                        boolean existe= restaurante.agregarProducto(producto3);
                        if (existe) {
                            System.out.println("Bebida registrada.");
                        } else {
                            System.out.println("Código repetido.");
                        }
                        }
                    break;
                    }
                case 2: {
                    System.out.println("documento: ");
                    int documento=Scanner.nextInt();
                    Scanner.nextLine();
                    System.out.println("Nombre completo: ");
                    String nombre =Scanner.nextLine();
                    System.out.println("Teléfono: ");
                    int telefono=Scanner.nextInt();
                    Scanner.nextLine();
                    System.out.println("Correo: ");
                    String correo= Scanner.nextLine();
                    System.out.println("Direción: ");
                    String direccion=Scanner.nextLine();

                    Cliente cliente=new Cliente(documento, nombre, telefono, correo, direccion);
                    boolean existe= restaurante.agregarCliente(cliente);
                    if(existe){
                        System.out.println("El cliente ha sido agregado con exito");
                    }else {
                        System.out.println("Documento invalido");
                    }
                }


            }
        }
    }
}
