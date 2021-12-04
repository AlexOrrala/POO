/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Usuarios;

import Medidores.Lectura;
import Medidores.Medidor;
import Medidores.MedidorAnalogico;
import Medidores.MedidorDigital;
import Plan.PlanEnergia;
import Plan.SistemaFacturacion;
import java.time.LocalDate;
import java.time.LocalTime;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    

    public static ArrayList<Abonado> getAbonado() {
        return abonado;
    }
    public static void agregarAbonado(Abonado abo){
        abonado.add(abo);
    }
    public static String Duenomedidor(String codigo){
        String abonado_resultante = "";
        for(Abonado c : getAbonado()){
            for(Medidor m : c.getListasmedidor()){
                if(m.getCodigo().equals(codigo)){
                    abonado_resultante = c.getNombre();
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
    public void ConsultarHistoricoFacturado(){
        System.out.printf("%10s %10s %10s", "Codigo Medidor", "Tipo Medidor", "Nombre del plan");

        for (Medidor i: listasmedidor){
            if (i instanceof MedidorAnalogico){
                 System.out.printf("%10s %10s %10s",i.getCodigo(),"Analogico", i.getPlan().getNombre());
            }
            else{
                System.out.printf("%10s %10s %10s",i.getCodigo(),"Digital", i.getPlan().getNombre());
            }
        }
        System.out.print("Ingrese el codigo del medidor a consultar");
        String codmed=sc.nextLine();
        System.out.printf("%10s %10s %10s", "Numero Facturas", "Nombre del plan", "Codigo Medidor");
        int i=facturas.size();
        int cont=0;
        while(cont<3){
            if (i!=0){
                if(facturas.get(i-1).getMedidor().getCodigo().equals(codmed)){
                    System.out.printf("%10s %10s %10s",facturas.get(i-1).getCodigofac(),facturas.get(i=1).getMedidor().getPlan().getNombre(),codmed);    
                }
            }
            if (i==0){
                cont=3;
            }
            
        }
    }
    public void ConsultarConsumosporHora(){
        System.out.printf("%10s %10s %10s", "Codigo Medidor", "Tipo Medidor", "Nombre del plan");

        for (Medidor i: listasmedidor){
            if (i instanceof MedidorDigital){
                 System.out.printf("%10s %10s %10s",i.getCodigo(),"Digital", i.getPlan().getNombre());
            }
        }
        System.out.print("Ingrese el codigo: ");
        String codmed=sc.nextLine();
        String finicio="";
        do{
            System.out.print("Ingrese Fecha Inicio; ");
            finicio=sc.nextLine();
        }while(!finicio.contains("-"));
        String ffinal="";
        do{
            System.out.print("Ingrese fecha final: ");
            ffinal=sc.nextLine();
        }while(!ffinal.contains("-"));
        LocalDate fechai=LocalDate.parse(finicio);
        LocalDate fechaf=LocalDate.parse(ffinal);
        int cont=0;
        double prom01=0,prom12=0,prom23=0,prom34=0,prom45=0,prom56=0,prom67=0,prom78=0,prom89=0,prom910=0,prom1011=0,prom1112=0,prom1213=0,prom1314=0,prom1415=0,prom1516=0,prom1617=0,prom1718=0,prom1819=0,prom1920=0,prom2021=0,prom2122=0,prom2223=0,prom230=0;
        for (Medidor l: listasmedidor){
            if (l.getCodigo().equals(codmed)){
                for (Lectura a:l.getLectura()){
                    if(a.getFechaToma().toLocalDate().isAfter(fechai) & a.getFechaToma().toLocalDate().isBefore(fechaf)){
                        if(a.getFechaToma().toLocalTime().equals(LocalTime.of(0,0))& a.getFechaToma().toLocalTime().isBefore(LocalTime.of(1,0))){
                            prom01=prom01+a.getKilovatios();
                        }
                        else if(a.getFechaToma().toLocalTime().equals(LocalTime.of(1,0))& a.getFechaToma().toLocalTime().isBefore(LocalTime.of(2,0))){
                            prom12=prom12+a.getKilovatios();
                        }
                        else if(a.getFechaToma().toLocalTime().equals(LocalTime.of(2,0))& a.getFechaToma().toLocalTime().isBefore(LocalTime.of(3,0))){
                            prom23=prom23+a.getKilovatios();
                        }
                        else if (a.getFechaToma().toLocalTime().equals(LocalTime.of(3,0))& a.getFechaToma().toLocalTime().isBefore(LocalTime.of(4,0))){
                            prom34=prom34+a.getKilovatios();
                        }
                        else if(a.getFechaToma().toLocalTime().equals(LocalTime.of(4,0))& a.getFechaToma().toLocalTime().isBefore(LocalTime.of(5,0))){
                            prom45=prom45+a.getKilovatios();
                        }
                        else if(a.getFechaToma().toLocalTime().equals(LocalTime.of(5,0))& a.getFechaToma().toLocalTime().isBefore(LocalTime.of(6,0))){
                            prom56=prom56+a.getKilovatios();
                        }
                        else if(a.getFechaToma().toLocalTime().equals(LocalTime.of(6,0))& a.getFechaToma().toLocalTime().isBefore(LocalTime.of(7,0))){
                            prom67=prom67+a.getKilovatios();
                        }
                        else if(a.getFechaToma().toLocalTime().equals(LocalTime.of(7,0))& a.getFechaToma().toLocalTime().isBefore(LocalTime.of(8,0))){
                            prom78=prom78+a.getKilovatios();
                        }
                        else if(a.getFechaToma().toLocalTime().equals(LocalTime.of(8,0))& a.getFechaToma().toLocalTime().isBefore(LocalTime.of(9,0))){
                            prom89=prom89+a.getKilovatios();
                        }
                        else if(a.getFechaToma().toLocalTime().equals(LocalTime.of(9,0))& a.getFechaToma().toLocalTime().isBefore(LocalTime.of(10,0))){
                            prom910=prom910+a.getKilovatios();
                        }
                        else if(a.getFechaToma().toLocalTime().equals(LocalTime.of(10,0))& a.getFechaToma().toLocalTime().isBefore(LocalTime.of(11,0))){
                            prom1011=prom1011+a.getKilovatios();
                        }
                        else if(a.getFechaToma().toLocalTime().equals(LocalTime.of(11,0))& a.getFechaToma().toLocalTime().isBefore(LocalTime.of(12,0))){
                            prom1112=prom1112+a.getKilovatios();
                        }
                        else if(a.getFechaToma().toLocalTime().equals(LocalTime.of(12,0))& a.getFechaToma().toLocalTime().isBefore(LocalTime.of(13,0))){
                            prom1213=prom1213+a.getKilovatios();
                        }
                        else if(a.getFechaToma().toLocalTime().equals(LocalTime.of(13,0))& a.getFechaToma().toLocalTime().isBefore(LocalTime.of(14,0))){
                            prom1314=prom1314+a.getKilovatios();
                        }
                        else if(a.getFechaToma().toLocalTime().equals(LocalTime.of(14,0))& a.getFechaToma().toLocalTime().isBefore(LocalTime.of(15,0))){
                            prom1415=prom1415+a.getKilovatios();
                        }
                        else if(a.getFechaToma().toLocalTime().equals(LocalTime.of(15,0))& a.getFechaToma().toLocalTime().isBefore(LocalTime.of(16,0))){
                            prom1516=prom1516+a.getKilovatios();
                        }
                        else if(a.getFechaToma().toLocalTime().equals(LocalTime.of(16,0))& a.getFechaToma().toLocalTime().isBefore(LocalTime.of(17,0))){
                            prom1617=prom1617+a.getKilovatios();
                        }
                        else if(a.getFechaToma().toLocalTime().equals(LocalTime.of(17,0))& a.getFechaToma().toLocalTime().isBefore(LocalTime.of(18,0))){
                            prom1718=prom1718+a.getKilovatios();
                        }
                        else if(a.getFechaToma().toLocalTime().equals(LocalTime.of(18,0))& a.getFechaToma().toLocalTime().isBefore(LocalTime.of(19,0))){
                            prom1819=prom1819+a.getKilovatios();
                        }
                        else if(a.getFechaToma().toLocalTime().equals(LocalTime.of(19,0))& a.getFechaToma().toLocalTime().isBefore(LocalTime.of(20,0))){
                            prom1920=prom1920+a.getKilovatios();
                        }
                        else if(a.getFechaToma().toLocalTime().equals(LocalTime.of(20,0))& a.getFechaToma().toLocalTime().isBefore(LocalTime.of(21,0))){
                            prom2021=prom2021+a.getKilovatios();
                        }
                        else if(a.getFechaToma().toLocalTime().equals(LocalTime.of(21,0))& a.getFechaToma().toLocalTime().isBefore(LocalTime.of(22,0))){
                            prom2122=prom2122+a.getKilovatios();
                        }
                        else if(a.getFechaToma().toLocalTime().equals(LocalTime.of(22,0))& a.getFechaToma().toLocalTime().isBefore(LocalTime.of(23,0))){
                            prom2223=prom2223+a.getKilovatios();
                        }
                        else if(a.getFechaToma().toLocalTime().equals(LocalTime.of(23,0))& a.getFechaToma().toLocalTime().isBefore(LocalTime.of(0,0))){
                            prom230=prom230+a.getKilovatios();
                        }
                        cont=cont++;
                    }
                    
                }
            }
        }
        prom01=prom01/cont;
        prom12=prom12/cont;
        prom23=prom23/cont;
        prom34=prom34/cont;
        prom45=prom45/cont;
        prom56=prom56/cont;
        prom67=prom67/cont;
        prom78=prom78/cont;
        prom89=prom89/cont;
        prom910=prom910/cont;
        prom1011=prom1011/cont;
        prom1112=prom1112/cont;
        prom1213=prom1213/cont;
        prom1314=prom1314/cont;
        prom1415=prom1415/cont;
        prom1516=prom1516/cont;
        prom1617=prom1617/cont;
        prom1718=prom1718/cont;
        prom1819=prom1819/cont;
        prom1920=prom1920/cont;
        prom2021=prom2021/cont;
        prom2122=prom2122/cont;
        prom2223=prom2223/cont;
        prom230=prom230/cont;
        System.out.printf("00:00-00:59: %5.2f\n01:00-01:59: %5.2f\n02:00-02:59: %5.2f\n03:00-03:59: %5.2f\n04:00-04:59: %5.2f\n05:00-05:59: %5.2f\n06:00-06:59: %5.2f\n07:00-07:59: %5.2f\n08:00-08:59: %5.2f\n09:00-09:59: %5.2f\n10:00-10:59: %5.2f\n11:00-11:59: %5.2f\n12:00-12:59: %5.2f\n13:00-13:59: %5.2f\n14:00-14:59: %5.2f\n15:00-15:59: %5.2f\n16:00-16:59: %5.2f\n17:00-17:59: %5.2f\n18:00-18:59: %5.2f\n19:00-19:59: %5.2f\n20:00-20:59: %5.2f\n21:00-21:59: %5.2f\n22:00-22:59: %5.2f\n23:00-23:59: %5.2f\n",prom01,prom12,prom23,prom34,prom45,prom56,prom67,prom78,prom89,prom910,prom1011,prom1112,prom1213,prom1314,prom1415,prom1516,prom1617,prom1718,prom1819,prom1920,prom2021,prom2122,prom2223,prom230);
    }
    
        
}
