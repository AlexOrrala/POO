/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Plan;

import java.time.LocalTime;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class HorarioPico {
    private LocalTime horarioinicio;
    private LocalTime horaFin;
    public HorarioPico(LocalTime horarioinicio,LocalTime horafin){
        this.horarioinicio=horarioinicio;
        this.horaFin=horafin;
    }
    public LocalTime getHorarioinicio(){
        return horarioinicio;
    }
    public LocalTime getHorafin(){
        return horaFin;
    }
        
}
