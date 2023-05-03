/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasepersonacolaborativa;

import java.time.DateTimeException;
import java.time.LocalDate;

/**
 *
 * @author afaza
 */

    public class Persona {


    private String nombre;
  
    private String apellidos;
    
    private LocalDate fechaNacimiento;


    public Persona(String nombre, String apellidos, String fechaNacimiento) throws IllegalArgumentException {

        if ("".equals(nombre) || "".equals(apellidos)) {
            throw new IllegalArgumentException();
        } else {
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.fechaNacimiento = generarFecha(fechaNacimiento);
        }
    }


    public Persona(String nombre, String apellidos) {
        if ("".equals(nombre) || "".equals(apellidos)) {
            throw new IllegalArgumentException();
        } else {
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.fechaNacimiento = null;
        }
    }

private LocalDate generarFecha(String fechaNacimiento) {
        LocalDate fecha;
        int dia = 0;
        int mes = 0;
        int anio = 0;

        if (!fechaNacimiento.matches("[0-9]{2}[-][0-9]{2}[-][0-9]{4}") &&
                !fechaNacimiento.matches("[0-9]{2}[/][0-9]{2}[/][0-9]{4}")) {
            throw new IllegalArgumentException();
        } else {
            try { 
                dia = Integer.parseInt(fechaNacimiento.substring(0, 2));
                mes = Integer.parseInt(fechaNacimiento.substring(3, 5)); 
                anio = Integer.parseInt(fechaNacimiento.substring(6, fechaNacimiento.length()));
                fecha = LocalDate.of(anio, mes, dia);
            } catch (DateTimeException ex1) {
                throw new IllegalArgumentException();
            }
        }
        return fecha;
    }
}
