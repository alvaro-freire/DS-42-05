/**
 * TITLE: Software Design B2
 * SUBTITLE: Exercise 1
 * @author Mateo Díaz Allegue @login mateo.diaz
 * @author Álvaro Freire Ares @login alvaro.freirea
 * GROUP: 4.2
 * DATE: 12 / 11 / 2021
 */

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

    public List<Integrante> getList() {
        return integrantesList;
    }

    /**
     * Checks if a teacher's subject has already a teacher .
     *
     * @param docente   The teacher of a subject
     * @return true if there is a teacher in integrantesList
     *         with that subject, false otherwise.
     */
    private boolean findSubject(Docente docente) {
        for (Integrante i : integrantesList) {
            if (i.getClass() == Docente.class && ((Docente) i).getAsignatura() == docente.getAsignatura()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds a member to the list of members.
     *
     * @param integrante                member to add to the list
     * @throws IllegalArgumentException if the member is a teacher and
     *                                  his/her subject has already a teacher
     * @throws IllegalArgumentException if integrante is already in the list
     * @throws NullPointerException     if integrante is null
     */
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

    /**
     * Removes a member from the list of members.
     *
     * @param integrante                member to remove from the list
     * @throws IllegalArgumentException if integrante is not found in the list
     * @throws NullPointerException     if integrante is null
     */
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

    /**
     * Clears the list of members.
     */
    public void clearList() {
        integrantesList.clear();
    }

    /**
     * Prints each of integrant's rewards.
     *
     * @return string with all the rewards
     */
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

    /**
     * Prints each of integrant's salaries.
     *
     * @return string with all the salaries
     */
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
