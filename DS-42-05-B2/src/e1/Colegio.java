package e1;

import java.util.ArrayList;
import java.util.List;

public class Colegio {

    private final String name;

    /* lista de integrantes del Colegio */
    private final List<Integrante> integrantesList = new ArrayList<>();

    /* constructor */
    public Colegio(String name) {
        this.name = name;
    }

    public String getNombre() {
        return name;
    }

    public List<Integrante> getList() { return integrantesList; }

    private boolean findSubject(Docente docente) {
        for (Integrante i : integrantesList) {
            if (i.getClass() == Docente.class && ((Docente) i).getAsignatura() == docente.getAsignatura()) {
                return true;
            }
        }
        return false;
    }

    public void addIntegrante(Integrante integrante) {

        if (integrante == null) {
            throw new NullPointerException();
        }

        if (integrante.getClass() == Docente.class) {
            if (findSubject((Docente) integrante)) {
                throw new IllegalArgumentException();
            }
        }

        for (Integrante i : integrantesList) {
            if (i.equals(integrante)) {
                throw new IllegalArgumentException();
            }
        }

        integrantesList.add(integrante);
    }

    public void removeIntegrante(Integrante integrante) {

        if (integrante == null) {
            throw new NullPointerException();
        }

        for (Integrante i : integrantesList) {
            if (i.equals(integrante)) {
                integrantesList.remove(integrante);
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    public void clearList() {
        integrantesList.clear();
    }

    public String imprimirRecompensas() {
        float recompensaTotal = 0;
        String string = "";

        for (Integrante i : integrantesList) {
            string = string.concat(i.getNombre() + " " + i.getApellidos());
            if (i.getClass() == Estudiante.class) {
                string = string.concat("(Estudiante de " + ((Estudiante) i).getCasa());
            } else if (i.getClass() == Fantasma.class) {
                string = string.concat("(Fantasma de " + ((Fantasma) i).getCasa());
            } else if (i.getClass() == Guardabosques.class) {
                string = string.concat("(Guardabosques");
            } else if (i.getClass() == Docente.class) {
                string = string.concat("(Docente de " + ((Docente) i).getAsignatura());
            } else {
                string = string.concat("(Conserje");
            }

            string = string.concat(", " + i.getDestroyedHorrocruxes() + " horrocruxes): "
                    + i.recompensa() + " galeones\n");
            recompensaTotal += i.recompensa();
        }

        string += "La recompensa total del Colegio " + name + " es de " + recompensaTotal + " galeones\n";

        return string;
    }

    public String imprimirSalarios() {
        int salarioTotal = 0;
        String string = "";

        for (Integrante i : integrantesList) {
            if (i.getClass() != Estudiante.class && i.getClass() != Fantasma.class) {
                string = string.concat(i.getNombre() + " " + i.getApellidos());
                if (i.getClass() == Guardabosques.class) {
                    string = string.concat("(Guardabosques): ");
                } else if (i.getClass() == Docente.class) {
                    string = string.concat("(Docente de " + ((Docente) i).getAsignatura() + "): ");
                } else if (i.getClass() == Conserje.class) {
                    string = string.concat("(Conserje): ");
                }
                string = string.concat(((Personal) i).salario() + " galeones\n");
                salarioTotal += ((Personal) i).salario();
            }
        }

        string += "El gasto de " + getNombre() + " en personal es de " + salarioTotal + " galeones\n";

        return string;
    }
}
