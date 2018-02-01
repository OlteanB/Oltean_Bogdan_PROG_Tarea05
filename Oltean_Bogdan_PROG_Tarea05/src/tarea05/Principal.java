/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea05;

import java.io.PrintStream;
import javax.xml.bind.DatatypeConverter;
import utilidades.Entrada;

/**
 *
 * @author bogdan
 */
public class Principal {

    public static void main(String[] args) {
        int menu;
        AlquilerVehiculos av = new AlquilerVehiculos();
        //los siguientes clientes y turismos han sido creados para hacer pruebas
        Cliente cliente1 = new Cliente("a", "11111111A", "Calle a", "Almeria", "04001");
        Cliente cliente2 = new Cliente("b", "22222222B", "Calle b ", "Almeria", "04002");
        av.addCliente(cliente1);
        av.addCliente(cliente2);
        Turismo turismo1 = new Turismo("1111BBB", "Seat", "Ibiza", 6);
        Turismo turismo2 = new Turismo("2222BBB", "Opel", "Opel", 8);
        av.addTurismo(turismo1);
        av.addTurismo(turismo2);
        System.out.println("******MENÚ******"
                + "\n1. Añadir cliente"
                + "\n2. Borrar Cliente"
                + "\n3. Listar clientes"
                + "\n4. Añadir turismo"
                + "\n5. Borrar turismo"
                + "\n6. Listar turismo"
                + "\n7. Abrir un alquiler"
                + "\n8. Cerrar un alquiler"
                + "\n9. Listar alquileres"
                + "\n0. Salir.");
        menu = Entrada.entero();
        while (menu != 0) {
            switch (menu) {
                case 1:
                    Cliente anadirCliente = null;
                    do {
                        System.out.println("---Añadir cliente---");
                        System.out.printf("Nombre: ");
                        String nombre = Entrada.cadena();
                        System.out.printf("DNI: ");
                        String dni = Entrada.cadena();
                        System.out.printf("Dirección: ");
                        String direccion = Entrada.cadena();
                        System.out.printf("Localidad: ");
                        String localidad = Entrada.cadena();
                        System.out.printf("Código postal: ");
                        String codigoPostal = Entrada.cadena();
                        try {
                            anadirCliente = new Cliente(nombre, dni, direccion, localidad, codigoPostal);
                            av.addCliente(anadirCliente);
                        } catch (ExcepcionAlquilerVehiculos e) {
                            System.out.println("ERROR al introducir los datos, intentalo de nuevo");
                        }
                    } while (anadirCliente == null);
                    try {
                        av.addCliente(anadirCliente);
                    } catch (ExcepcionAlquilerVehiculos a) {
                        System.out.println("Error añadir cliente");
                    }

                    break;
                case 2:
                    System.out.println("---Borrar cliente---");
                    System.out.println("introduce DNI del cliente a borrar: ");
                    String borrarDni = Entrada.cadena();
                    try {
                        av.delCliente(borrarDni);
                        System.out.println("Cliente borrado correctamente.");
                    } catch (ExcepcionAlquilerVehiculos b) {
                        System.out.println("Error al borrar el cliente.");
                    }
                    break;
                case 3:
                    System.out.println("---Listado de clientes----");
                    for (Cliente cliente : av.getClientes()) {
                        if (cliente != null) {
                            System.out.println(cliente);
                        }
                    }
                    System.out.println("");
                    break;
                case 4:
                    Turismo anadirTurismo = null;
                    do {
                        System.out.println("---Añadir turismo---");
                        System.out.printf("Matricula: ");
                        String matricula = Entrada.cadena();
                        System.out.printf("Marca: ");
                        String marca = Entrada.cadena();
                        System.out.printf("Modelo: ");
                        String modelo = Entrada.cadena();
                        System.out.printf("Cilindrada: ");
                        int cilindrada = Entrada.entero();
                        try {
                            anadirTurismo = new Turismo(matricula, marca, modelo, cilindrada);
                        } catch (ExcepcionAlquilerVehiculos e) {
                            System.out.println("ERROR al introducir los datos del turismo, intentalo de nuevo");
                        }
                    } while (anadirTurismo == null);
                    try {
                        av.addTurismo(anadirTurismo);
                    } catch (ExcepcionAlquilerVehiculos a) {
                        System.out.println("Error añadir turismo");
                    }
                    break;
                case 5:
                    System.out.println("---Borrar turismo---");
                    System.out.println("Introduce la matrícula del vehículo que quieres borrar: ");
                    String borrarMatricula = Entrada.cadena();
                    try {
                        av.delTurismo(borrarMatricula);
                        System.out.println("Turismo borrado correctamente.");
                    } catch (ExcepcionAlquilerVehiculos c) {
                        System.out.println("ERROR al borrar el turismo.");
                    }
                    break;
                case 6:
                    System.out.println("---Listar turismo---");
                    for (Turismo turismo : av.getTurismos()) {
                        if (turismo != null) {
                            System.out.println(turismo);
                        }
                    }
                    System.out.println("");
                    break;
                case 7:
                    System.out.println("---Abrir un alquiler---");
                    System.out.println("Introduce la matrícula del vehiculo: ");
                    String buscarMatricula = Entrada.cadena();
                    Turismo turismoBuscado = av.getTurismo(buscarMatricula);
                    System.out.println("Introduce DNI del cliente: ");
                    String buscarDNI = Entrada.cadena();
                    Cliente clienteBuscado = av.getCliente(buscarDNI);
                    if (turismoBuscado == null && clienteBuscado == null) {
                        System.out.println("Error, los datos introducidos no existen");
                    } else {
                        try {
                            av.openAlquiler(clienteBuscado, turismoBuscado);
                            System.out.println("Alquiler abierto correctamente.");
                        } catch (ExcepcionAlquilerVehiculos g) {
                            System.out.println("Error, alquiler no abierto");
                        }
                    }
                    break;
                case 8:
                    System.out.println("---Cerrar un alquiler---");
                    System.out.println("Introduce la matrícula del vehículo: ");
                    buscarMatricula = Entrada.cadena();
                    turismoBuscado = av.getTurismo(buscarMatricula);
                    System.out.println("Introduce DNI del cliente: ");
                    buscarDNI = Entrada.cadena();
                    clienteBuscado = av.getCliente(buscarDNI);
                    if (turismoBuscado == null && clienteBuscado == null) {
                        System.out.println("ERROR, los datos introducidos no existen");
                    } else {
                        try {
                            av.closeAlquiler(clienteBuscado, turismoBuscado);
                            System.out.println("Alquiler cerrado correctamente.");
                        } catch (ExcepcionAlquilerVehiculos e) {
                            System.out.printf("Error, alquiler no cerrado");
                        }
                    }
                    break;
                case 9:
                    System.out.println("---Listado de alquileres---");
                    for (Alquiler alquiler : av.getAlquileres()) {
                        if (alquiler != null) {
                            System.out.println(alquiler);
                        }
                    }
                    System.out.println("");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción erronea.");
                    break;

            }
            System.out.println("******MENÚ******"
                    + "\n1. Añadir cliente"
                    + "\n2. Borrar Cliente"
                    + "\n3. Listar clientes"
                    + "\n4. Añadir turismo"
                    + "\n5. Borrar turismo"
                    + "\n6. Listar turismo"
                    + "\n7. Abrir un alquiler"
                    + "\n8. Cerrar un alquiler"
                    + "\n9. Listar alquileres"
                    + "\n0. Salir.");
            menu = Entrada.entero();
        }
        System.out.println("FIN");
    }
}
