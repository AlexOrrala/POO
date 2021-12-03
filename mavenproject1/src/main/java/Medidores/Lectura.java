package Medidores;

import java.time.LocalDateTime;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Lectura {
    private LocalDateTime FechaToma;
    private double kilovatios;
    public Lectura(LocalDateTime FechaToma,double kilovatios){
        this.FechaToma=FechaToma;
        this.kilovatios=kilovatios;
    }
    public LocalDateTime getFechaToma(){
        return FechaToma;
    }
    public double getKilovatios(){
        return kilovatios;
    }
}
