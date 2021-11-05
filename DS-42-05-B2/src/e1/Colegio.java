package e1;

import java.util.ArrayList;
import java.util.List;

public class Colegio {

    public String name;

    /* lista de integrantes del Colegio */
    List<Integrante> IntegrantesList = new ArrayList<>();

    /* constructor */
    public Colegio(String name) {
        this.name = name;
    }

    private boolean findSubject(Docente docente) {
        for (Integrante i : IntegrantesList) {
            if (i.getClass() == Docente.class && ((Docente) i).getAsignatura() == docente.getAsignatura()) {
                return true;
            }
        }
        return false;
    }

    public void addIntegrante(Integrante integrante) {

        if (integrante == null) {
            throw new IllegalArgumentException();
        }

        if (integrante.getClass() == Docente.class) {
            if (findSubject((Docente) integrante)) {
                throw new IllegalArgumentException();
            }
        }

        for (Integrante i : IntegrantesList) {
            if (i.equals(integrante)) {
                throw new IllegalArgumentException();
            }
        }

        IntegrantesList.add(integrante);
    }

    public void removeIntegrante(Integrante integrante) {

        for (Integrante i : IntegrantesList) {
            if (i.equals(integrante)) {
                IntegrantesList.remove(integrante);
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    public void clearList() {
        IntegrantesList.clear();
    }

    public String imprimirRecompensas() {
        float recompensaTotal = 0;
        String string = "";

        for (Integrante i : IntegrantesList) {
            string = string.concat(i.getNombre() + " " + i.getApellidos());
            if (i.getClass() == Estudiante.class) {
                string = string.concat("(Estudiante de " + ((Estudiante) i).getCasa());
            } else if (i.getClass() == Fantasma.class) {
                string = string.concat("(Fantasma de " + ((Fantasma) i).getCasa());
            } else if (i.getClass() == Guardabosques.class) {
                string = string.concat("(Guardabosques");
            } else if (i.getClass() == Docente.class) {
                string = string.concat("(Docente de " + ((Docente) i).getAsignatura());
            } else if (i.getClass() == Conserje.class) {
                string = string.concat("(Conserje");
            } else {
                // error ***********************
                throw new IllegalArgumentException();
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

        for (Integrante i : IntegrantesList) {
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

        string += "El gasto de " + name + " en personal es de " + salarioTotal + " galeones\n";

        return string;
    }
}
