package e1;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

public class Colegio {

    public String name;

    /* lista de integrantes del Colegio */
    List<Integrante> IntegrantesList = new ArrayList<>();

    /* constructor */
    public Colegio(String name) { this.name = name; }

    public void addIntegrante(Integrante integrante) { IntegrantesList.add(integrante); }

    public String imprimirRecompensas() {
        int recompensaTotal = 0;
        String string = "";

        for (Integrante i : IntegrantesList) {
            string = string.concat(i.getNombre() + i.getApellidos());
            if (i.getClass() == Estudiante.class) {
                string = string.concat("(Estudiante de " + ((Estudiante) i).casa);
            } else if (i.getClass() == Fantasma.class) {
                string = string.concat("(Fantasma de " + ((Fantasma) i).casa);
            } else if (i.getClass() == Guardabosques.class) {
                string = string.concat("(Guardabosques ");
            } else if (i.getClass() == Docente.class) {
                string = string.concat("(Docente de " + ((Docente) i).asignatura);
            } else if (i.getClass() == Conserje.class) {
                string = string.concat("(Conserje ");
            } else {
                // error
            }
            string = string.concat(", " + i.getDestroyedHorrocruxes() + "horrocruxes): "
                    + i.recompensa() + "galeones\n");
            recompensaTotal += i.recompensa();
        }

        string += "La recompensa total del Colegio " + name + "es de " + recompensaTotal + "galeones\n";

        return string;
    }

    public String imprimirSalarios() {
        String string = "";

        return string;
    }
}
