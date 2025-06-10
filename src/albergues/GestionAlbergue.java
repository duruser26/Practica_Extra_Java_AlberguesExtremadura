package albergues;

import java.util.Set;
import java.util.TreeSet;

public class GestionAlbergue {
    
    private AlberguesDao dao;

    public GestionAlbergue(AlberguesDao dao) {
        this.dao = dao;
    }
    
    public void informeAlberguesAnio(int anio){
        Set<Albergue> totaAlbergues = new TreeSet<>(new CompararAnio());
        totaAlbergues.addAll(dao.cargaCapacidad());

        for (Albergue albergue : totaAlbergues) {
            int albergueAnio = albergue.getFechaApertura().getYear();
            if (anio <= albergueAnio) {
                System.out.println(albergueAnio + "\t" + albergue.getNombre() + "\t" + albergue.getProvincia());
            }
        }
    }

    public void informeCapacidad() {
        Set<Albergue> totaAlbergues = new TreeSet<>(new CompararAnio());
        totaAlbergues.addAll(dao.cargaCapacidad());
        int contadorBadajoz = 0;
        int contadorCaceres = 0;
        for (Albergue albergue : totaAlbergues) {
            if (albergue.getProvincia().equals("Badajoz")) {
                contadorBadajoz = albergue.getCapacidad()+contadorBadajoz;
            }
            if (albergue.getProvincia().equals("Caceres")) {
                contadorCaceres = albergue.getCapacidad()+contadorCaceres;
            }
        }
        System.out.println("Badajoz\t"+contadorBadajoz+"\n"+"Caceres\t"+contadorCaceres);
    }

}
