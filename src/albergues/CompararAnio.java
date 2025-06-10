package albergues;

import java.util.Comparator;

public class CompararAnio implements Comparator<Albergue>{

    @Override
    public int compare(Albergue albergue1, Albergue albergue2) {
        int fecha1 = albergue1.getFechaApertura().getYear();
        int fecha2 = albergue2.getFechaApertura().getYear();
        int resultado = Integer.compare(fecha1, fecha2);

        if (resultado == 0) {
            resultado = albergue1.getNombre().compareToIgnoreCase(albergue2.getNombre());
        }
        return resultado;
    } 

}
