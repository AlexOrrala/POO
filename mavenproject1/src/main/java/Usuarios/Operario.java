
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Usuarios;

import Medidores.Lectura;
import Medidores.Medidor;
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
            if(c.getCodigo()== codigo){
                System.out.println("Ingrese lectura actual del medidor:"+codigo);
                kv = sc.nextDouble();
                l = new Lectura(LocalDateTime.now(), kv);
                l.setOperario(this);
                c.agregarlectura(l);
            }
        }
    }
}