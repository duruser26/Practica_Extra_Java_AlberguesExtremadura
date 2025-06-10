package albergues;

import java.util.Scanner;

public class PruebaAlbergue {
        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            // El albergue se pasa por parametros en la linea de comandos
            AlberguesDao dao = new AlberguesDao(args[0], args[1]);

            GestionAlbergue gestor = new GestionAlbergue(dao);

            int anio = sc.nextInt();

            gestor.informeAlberguesAnio(anio);
            gestor.informeCapacidad();

            sc.close();
    }

}
