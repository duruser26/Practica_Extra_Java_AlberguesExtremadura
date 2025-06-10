package albergues;

import java.time.LocalDate;

public class Albergue {
    
    private String provincia;
    private LocalDate fechaApertura;
    private String nombre;
    private String municipio;
    private int capacidad;
    
    public Albergue(String provincia, LocalDate fechaApertura, String nombre, String municipio, int capacidad) {
        this.provincia = provincia;
        this.fechaApertura = fechaApertura;
        this.nombre = nombre;
        this.municipio = municipio;
        this.capacidad = capacidad;
    }
    
    public String getProvincia() {
        return provincia;
    }
    
    public LocalDate getFechaApertura() {
        return fechaApertura;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getCapacidad() {
        return capacidad;
    }
    
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
}
