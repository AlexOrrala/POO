/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Main;
import Medidores.*;
import Plan.*;
import Usuarios.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class main {
    private static ArrayList<Administrador> Admins = new ArrayList<Administrador>();
    private static ArrayList<Operario> Operarios = new ArrayList<Operario>();
    public static void main(String[] args){
        int menu0=0;
        Scanner sc;
        int salida;
        inicio();
        do{
            salida=0;
            sc = new Scanner(System.in);
            menu0=0;
            System.out.println("1)Iniciar Sesión.");
            
            System.out.println("2)Salir.\n");
            menu0 = sc.nextInt();
        switch(menu0){
            case 1:
                Login();
                break;
            case 2:
                System.exit(salida);
                break;
            default:
                break;
        }
        }while(salida!=2);
        
    }

    private static void inicio() {        
        Admins.add(new Administrador("admin", "superadmin"));
        Operarios.add(new Operario("operario1", "contraseña1"));
        Operarios.add(new Operario("operario2", "contraseña2"));
        ArrayList<Provincias> provincias1 = new ArrayList<Provincias>();
        provincias1.add(Provincias.Azuay);
        provincias1.add(Provincias.Guayas);
        provincias1.add(Provincias.Galápagos);
        HorarioPico horarios = new HorarioPico(LocalTime.of(10, 0), LocalTime.of(12,0));
        ArrayList<HorarioPico> horaspicos= new ArrayList<HorarioPico>();
        PlanEnergia.Agregarplan(new PlanEnergia("Plan1",5.5,500.0,provincias1,horaspicos));
        PlanEnergia.Agregarplan(new PlanEnergia("Plan2",4.5,300.0,provincias1,horaspicos));
        Abonado abo1  = new Abonado("Abonado1","1234");
        abo1.setCorreo("alex_orrala@hotmail.com");
        Abonado.agregarAbonado(abo1);
        Abonado abo2 = new Abonado("Abonado2","1201");
        abo2.setCorreo("zixjissuijju@gmail.com");
        Abonado.agregarAbonado(abo2);
        int contador =0;
        for(Abonado c: Abonado.getAbonado()){
            if(contador==0){
            MedidorAnalogico m1 = new MedidorAnalogico(PlanEnergia.getListas().get(0),"direccion",LocalDateTime.now(),210.0);
            c.agregarmedidor(m1);
            MedidorAnalogico.agregarMedidor(m1);
            MedidorDigital d1 = new  MedidorDigital(PlanEnergia.getListas().get(1),"direccion2");
            c.agregarmedidor(d1);
            MedidorDigital.agregarMedidor(d1);
            }else if(contador ==1){
                MedidorAnalogico m3 =new MedidorAnalogico(PlanEnergia.getListas().get(0),"direccion3",LocalDateTime.now(),120);
            c.agregarmedidor(m3);
            
            MedidorAnalogico.agregarMedidor(m3);
            }
            contador++;
        }
        Operarios.get(0).registrarmedicion(Medidor.getCodesmedidores().get(0),120.0,Operarios.get(0));
        Operarios.get(0).registrarmedicion(Medidor.getCodesmedidores().get(0),100.0,Operarios.get(0));
        Operarios.get(0).registrarmedicion(Medidor.getCodesmedidores().get(1),120.0,Operarios.get(0));
        Operarios.get(0).registrarmedicion(Medidor.getCodesmedidores().get(1),100.0,Operarios.get(0));
        Operarios.get(0).registrarmedicion(Medidor.getCodesmedidores().get(2),120.0,Operarios.get(0));
        Operarios.get(0).registrarmedicion(Medidor.getCodesmedidores().get(2),100.0,Operarios.get(0));
        
        
        
        
        
        
    }
    private static void ob_Usuarios(String nombre,String contrasenia){
        ArrayList<String> listaf= new ArrayList<String>();
        boolean inicio = false;
        for(Abonado c: Abonado.getAbonado()){
            if(c.getNombre().equals(nombre) && c.getContrasenia().equals(contrasenia)){
            inicio = true;
            Abonado(c);
        }
            listaf.add(c.getNombre());
       }
        for(Administrador c: Admins){
            if(c.getNombre().equals(nombre) && c.getContrasenia().equals(contrasenia)){
                inicio = true;
                Admin(c);
        }
       }
        for(Operario c: Operarios){
            if(c.getNombre().equals(nombre) && c.getContrasenia().equals(contrasenia)){
                inicio = true;
                Operarios(c);
        }
       }
        if(inicio == false){
            System.out.println("Error el usuario y contraseña no coinciden con ninguna cuenta.");
        }
    }

    private static void Admin(Administrador c) {
        int menu=0;
        Scanner sc = new Scanner(System.in);
        String n_cedula = "";
        do{
            System.out.println("0)Salir\n1)RegistrarPlan\n2)Agregar Medidor\n3)Simular mediciones\n4)Generar Facturas");
            menu = sc.nextInt();
            switch(menu){
                case 0:
                    break;
                case 1:
                    c.RegistrarPlan();
                    break;
                case 2:
                    do{
                        sc.nextLine();
                        System.out.println("Numero cedula abonado");
                        n_cedula= sc.nextLine();
                    
                    }while(n_cedula=="");
                    c.RegistrarMedidor(n_cedula);
                    break;
                case 3:
                    adminccaso3(c);
                    break;
                case 4:
                    c.Facturacion();   
                    break;
            }
        }while(menu!=0);
    }

    private static void adminccaso3(Administrador c) {
        Scanner sc = new Scanner(System.in);
        int ano1=0,mes1=0,dia1=0,hora1=0,min1=0;
                    int ano=0,mes=0,dia=0,hora=0,min=0;
                    int comprobar =0;
                    do{
                    do{
                        System.out.println("Ingrese año Inicio:");
                        ano = sc.nextInt();
                    }while(ano<2000);
                    do{
                        System.out.println("Ingrese mes Inicio:");
                        mes = sc.nextInt();
                    }while(!(mes>0 && mes<13));
                    do{
                        System.out.println("Ingrese dia Inicio:");
                        dia = sc.nextInt();
                    }while(!(dia>0 && dia<31));
                    do{
                        System.out.println("Ingrese hora Inicio:");
                        hora = sc.nextInt();
                    }while(!(hora>=0 && hora<24));
                    do{
                        System.out.println("Ingrese min Inicio:");
                        min = sc.nextInt();
                    }while(!(min>=0 && min<60));
                    do{
                        System.out.println("Ingrese año Fin:");
                        ano1 = sc.nextInt();
                    }while(ano1<2000);
                    do{
                        System.out.println("Ingrese mes Fin:");
                        mes1 = sc.nextInt();
                    }while(!(mes1>0 && mes1<13));
                    do{
                        System.out.println("Ingrese dia Fin:");
                        dia1 = sc.nextInt();
                    }while(!(dia1>0 && dia1<31));
                    do{
                        System.out.println("Ingrese hora Fin:");
                        hora1 = sc.nextInt();
                    }while(!(hora1>=0 && hora1<24));
                    do{
                        System.out.println("Ingrese min Fin:");
                        min1 = sc.nextInt();
                    }while(!(min1>=0 && min1<60));
                    if(LocalDateTime.of(ano, mes, dia, hora, min).isBefore(LocalDateTime.of(ano1, mes1, dia1, hora1, min1))){
                        comprobar=5;
                    }
                    }while(comprobar==0);
                    c.lecturas(LocalDateTime.of(ano, mes, dia, hora, min),LocalDateTime.of(ano1, mes1, dia1, hora1, min1) );
    }

    private static void Login() {
        Scanner sc = new Scanner(System.in);
        String usuario,contrasena;
        System.out.println("Usuario:");
        usuario = sc.nextLine();
        System.out.println("Contraseña:");
        contrasena = sc.nextLine();
        ob_Usuarios(usuario, contrasena);
    }

    private static void Operarios( Operario c) {
        int menu=0;
        Scanner sc = new Scanner(System.in);
        String codigo = "";
        Double lectura = 0.0;
        do{
            System.out.println("0)Salir\n1)RegistrarMedicion");
            menu = sc.nextInt();
            switch(menu){
                case 0:
                    break;
                case 1:
                    do{
                    System.out.println("Ingrese codigo");
                    codigo=sc.nextLine();
                    }while(codigo=="");
                    do{
                    System.out.println("Ingrese Lectura actual");
                    lectura=sc.nextDouble();
                    }while(lectura==0.0);
                    c.registrarmedicion(codigo, lectura, c);
                    break;
            }
        }while(menu!=0);
    }

    private static void Abonado(Abonado c) {
        int menu=0;
        Scanner sc = new Scanner(System.in);
        String codigo = "";
        Double lectura = 0.0;
        do{
            System.out.println("0)Salir\n1)Consultar Factura\n2)ConsultarHistoricoFacturado\n3)Consultar consumos por hora");
            menu = sc.nextInt();
            switch(menu){
                case 0:
                    break;
                    case 1:
                        c.ConsultarFactura();
                    break;
                    case 2:
                        c.ConsultarHistoricoFacturado();
                    
                    break;
                    case 3:
                        c.ConsultarConsumosporHora();
                    break;
            }
        }while(menu!=0);
    }

}
