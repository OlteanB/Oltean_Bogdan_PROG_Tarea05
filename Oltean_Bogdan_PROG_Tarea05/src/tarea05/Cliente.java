/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author bogdan
 */
public class Cliente {

    private String nombre, dni, direccion, localidad, codigoPostal;
    private int identificador, numClientes;

    public Cliente(String nombre, String DNI, String direccion, String localidad, String codigoPostal) {
        this.nombre = nombre;
        //DNI
        if (compruebaDni(DNI)) {
            this.dni = DNI;
        } else {
            throw new ExcepcionAlquilerVehiculos("Error DNI.");
        }
        //direccion
        this.direccion=direccion;
        //localidad
        this.localidad = localidad;
        //Código postal
        if (compruebaCodigoPostal(codigoPostal)) {
            this.codigoPostal = codigoPostal;
        } else {
            throw new ExcepcionAlquilerVehiculos("Error código postal.");
        }

    }

    public Cliente(Cliente cliente) {
        this.nombre = cliente.nombre;
        this.dni = cliente.dni;
        this.direccion = cliente.direccion;
        this.localidad = cliente.localidad;
        this.codigoPostal = cliente.codigoPostal;
    }

    private boolean compruebaDni(String DNI) {
        Pattern comprueba = Pattern.compile("\\d{8}[A-HJ-NP-TV-Z]");
        Matcher matcher = comprueba.matcher(DNI);
        return matcher.matches();
    }

    private boolean compruebaCodigoPostal(String codigoPostal) {
        Pattern comprueba = Pattern.compile("0[1-9][0-9]{3}|[1-4][0-9]{4}|5[0-2][0-9]{3}");
        Matcher matcher = comprueba.matcher(codigoPostal);
        return matcher.matches();
    }
    
       public String getNombre() {
        return nombre;
    }

    public String getDNI() {
        return dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public int getIdentificador() {
        return identificador;
    }


}
