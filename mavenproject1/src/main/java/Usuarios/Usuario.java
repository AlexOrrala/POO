/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuarios;

/**
 *
 * @author samu_
 */
public class Usuario {
    public String nombre;
    public String contrasenia;
    public Usuario(String nombre, String contrasenia){
        this.nombre=nombre;
        this.contrasenia=contrasenia;
    }
    public String getNombre(){
        return nombre;
    }
    public String getContrasenia(){
        return contrasenia;
    }
}