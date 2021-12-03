package Medidores;

import java.time.LocalDateTime;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Lectura{
    private Local Datetime FechaToma;
    private double kilovatios;
    public Lectura(LocalDateTime FechaTOma, double kilovatios){
        this.FechaToma=FechaToma;
        this.kilovatios=kilovatios;
    }
    public LocalDateTIm getFechaToma(){
        return FechaToma;
    }
    public double getkilovatios(){
        return kilovatios;
    }
}
