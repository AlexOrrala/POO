/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Usuarios;

import Medidores.Medidor;
import Plan.PlanEnergia;
import Plan.SistemaFacturacion;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Abonado extends Usuario{
    Scanner sc=new Scanner(System.in);
 
    private String correo;
    private ArrayList<Medidor> listasmedidor;
    private static ArrayList<Abonado> abonado = new ArrayList<Abonado>();
    private ArrayList<SistemaFacturacion> facturas = new ArrayList<SistemaFacturacion>();
    public Abonado(String nombre, String contrasenia) {
        super(nombre, contrasenia);
        listasmedidor = new ArrayList<Medidor>();
    }
    public void agregarmedidor(Medidor medidor){
        listasmedidor.add(medidor);
    }
    public String mensaje(){
    return "Usuario"+super.getNombre()+"\nContraseña:"+super.getContrasenia();
    }

    public ArrayList<Medidor> getListasmedidor() {
        return listasmedidor;
    }
    
    

    public static ArrayList<Abonado> getAbonado() {
        return abonado;
    }
    public static void agregarAbonado(Abonado abo){
        abonado.add(abo); 
    }
    public static Abonado Duenomedidor(String codigo){
        Abonado abonado_resultante = new Abonado("user", "cod");
        for(Abonado c : abonado){
            for(Medidor m : c.getListasmedidor()){
                if(m.getCodigo().equals(codigo)){
                    abonado_resultante = c;
                }
            }
        }
        return abonado_resultante;
    }
    public void aregarfactura(SistemaFacturacion factura){
        facturas.add(factura);
    }
    public ArrayList<SistemaFacturacion> getFacturasabo(){
        return facturas;
    }
    public void ConsultarFactura(){
        System.out.println("Facturas asociadas");
        System.out.printf("%10s %10s %10s", "Numero Facturas", "Fecha Emision", "Codigo Medidor");
        System.out.println();
        for (SistemaFacturacion i: facturas){
            System.out.printf("%10s %10s %10s",i.getCodigofac(),i.getFecha_emision().toLocalDate(),i.getMedidor().getCodigo());
            System.out.println();
            
        }
        System.out.print("Ingrese codigo factura: ");
        String codigoacomp=sc.nextLine();
        for (SistemaFacturacion i: facturas){
            if(i.getCodigofac().equals(codigoacomp)){
                System.out.printf("Medidor: %s\nNombredelplan: %s\nDesde: %c\nHasta: %c\nDias Facturas: %d\nLectura anterior: %d\nLectura nueva: %d\nConsumo: %d\nCargo Fijo: %5.2f\nTotal a pagar:%5.2f",i.getMedidor().getCodigo(),i.getMedidor().getPlan().getNombre(),i.getMedidor().getUltima_cobrada(),i.getFecha_emision(),i.getDias_fact(),i.getAnterior(),i.getActual(),i.getConsumokv(),i.getCargofijo(),i.getTotalpagar());
            }
        }
    }
    
}
