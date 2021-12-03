/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Plan;

import Medidores.*;
import Usuarios.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class SistemaFacturacion {
    private Medidor medidor;
    private LocalDateTime fecha_emision;
    private Usuario usuario;
    private Lectura anterior;
    private Lectura actual;
    private static ArrayList<SistemaFacturacion> facturas = new ArrayList<SistemaFacturacion>();

    public SistemaFacturacion(Medidor medidor, Usuario usuario, Lectura anterior, Lectura actual,LocalDateTime fecha_emision) {
        this.medidor = medidor;
        this.usuario = usuario;
        this.anterior = anterior;
        this.actual = actual;
        this.fecha_emision = fecha_emision;
    }
    
    public static void aregarfactura(SistemaFacturacion factura){
        facturas.add(factura);
    }

    
    
    
    public Medidor getMedidor() {
        return medidor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Lectura getAnterior() {
        return anterior;
    }

    public Lectura getActual() {
        return actual;
    }

    public static ArrayList<SistemaFacturacion> getFacturas() {
        return facturas;
    }

    
    
}
