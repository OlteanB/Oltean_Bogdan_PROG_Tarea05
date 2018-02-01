/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea05;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author bogdan
 */
public class Alquiler {

    private Cliente cliente;
    private Turismo turismo;
    private Date fecha;
    private int dias;
    private final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("dd/MM/yy");
    private final int MS_DIA = 1000 * 60 * 60 * 24;
    private final double PRECIO_DIA = 30;

    public Alquiler(Cliente cliente, Turismo turismo) {
        this.cliente = cliente;
        this.turismo = turismo;
        fecha = new Date();
        dias = 0;
        turismo.setDisponible(false);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Turismo getTurismo() {
        return turismo;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getDias() {
        return dias;
    }

    public void close() {
        Date fechaFin = new Date();
        dias = difDias(fecha, fechaFin);
        turismo.setDisponible(true);
    }


    public int difDias(Date fechaInicio, Date fechaFin) {
        int milisegundos = (int) (fechaFin.getTime() - fechaInicio.getTime());
        dias = milisegundos / MS_DIA;
        return dias + 1;
    }

    @Override
    public String toString() {
        return "Alquiler{" + "Cliente=" + cliente + ", Turismo=" + turismo + ", fecha=" + fecha + ", dias=" + dias +'}';
    }
    
    

}
