package albergues;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AlberguesDao {
    
    private String archivoAlbergues;
    private String archivoCapacidades;
    private Map<String, Albergue> mapaAlbergues;
    
    public AlberguesDao(String archivoAlbergues, String archivoCapacidades) {
        this.mapaAlbergues = new HashMap<>();
        this.archivoAlbergues = archivoAlbergues;
        this.archivoCapacidades = archivoCapacidades;
        cargaDatos();
        cargaCapacidad();
    }

    public void cargaDatos() {
        try (BufferedReader brAlbergue = new BufferedReader(new FileReader(archivoAlbergues))) {
            
            String linea = brAlbergue.readLine();
            while ((linea = brAlbergue.readLine()) != null) {

                String[] entrada = linea.split(";");
                String provincia = entrada[0];
                LocalDate fechaApertura = LocalDate.parse(entrada[1]);
                String nombre = entrada[2];
                String municipio = entrada[3];

                String calve = municipio.toLowerCase().trim() + nombre.toLowerCase().trim();

                mapaAlbergues.putIfAbsent(calve, new Albergue(provincia, fechaApertura, nombre, municipio, 0));

            }
            
        } catch (IOException e) {
            System.out.println("Error de carga de los ficheros");
        }
    }

    public Set<Albergue> cargaCapacidad() {
        try (BufferedReader brCapacidad = new BufferedReader(new FileReader(archivoCapacidades))) {
            
            String linea = brCapacidad.readLine();
            while ((linea = brCapacidad.readLine()) != null) {
                    
                String[] entrada = linea.split(";");
                String nombre = entrada[0];
                String municipio = entrada[1];
                int capacidad = Integer.parseInt(entrada[4]);

                String calve = municipio.toLowerCase().trim() + nombre.toLowerCase().trim();

                mapaAlbergues.get(calve).setCapacidad(capacidad);
                
            }
        } catch (IOException e) {
            System.out.println("Error de carga de los ficheros");
        }
        return new HashSet<>(mapaAlbergues.values());
    }

}
