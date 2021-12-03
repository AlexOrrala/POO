
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Usuarios;

import Medidores.Lectura;
import Medidores.Medidor;
import Medidores.MedidorAnalogico;
import Medidores.MedidorDigital;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Operario extends Usuario{

    public Operario(String nombre, String contrasenia) {
        super(nombre, contrasenia);
    }
    public void registrarmedicion(String codigo){
        Scanner sc = new Scanner(System.in);
        Lectura l; 
        Double kv;
        for(MedidorDigital c : MedidorDigital.getListasmedidor()){
            if(c.getCodigo().equals(codigo)){
                System.out.println("Medidor Digital a nombre de "+ Abonado.Duenomedidor(codigo) +":+codigo");
                System.out.println("Ultima lectura realizada: " +c.getListasmedidor().get(c.getListasmedidor().size()-1).getFechaToma() );
                System.out.println("Ultima lectura anterior: " +c.getListasmedidor().get(c.getListasmedidor().size()-1).getKilovatios());
                System.out.println("Lectura Actual:");
                do{
                kv = sc.nextDouble();
                }while(kv.equals(""));
                System.out.println("Kilovatios consumidos:"+  (c.getListasmedidor().get(c.getListasmedidor().size()-1).getKilovatios() - kv));
                l = new Lectura(LocalDateTime.now(), kv);
                l.setOperario(this);
                c.agregarlectura(l);
            }
        }
        for(MedidorAnalogico c : MedidorAnalogico.getListasmedidor()){
            if(c.getCodigo().equals(codigo)){
                System.out.println("Medidor Analógico a nombre de "+ Abonado.Duenomedidor(codigo) +":+codigo");
                System.out.println("Ultima lectura realizada: " +c.getListasmedidor().get(c.getListasmedidor().size()-1).getFechaToma() );
                System.out.println("Ultima lectura anterior: " +c.getListasmedidor().get(c.getListasmedidor().size()-1).getKilovatios());
                System.out.println("Lectura Actual:");
                do{
                kv = sc.nextDouble();
                }while(kv.equals(""));
                System.out.println("Kilovatios consumidos:"+  (c.getListasmedidor().get(c.getListasmedidor().size()-1).getKilovatios() - kv));
                l = new Lectura(LocalDateTime.now(), kv);
                l.setOperario(this);
                c.agregarlectura(l);
            }
        }
    }
    
}