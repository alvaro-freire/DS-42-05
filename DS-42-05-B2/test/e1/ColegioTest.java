package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColegioTest {

    private Colegio Hogwarts;

    @BeforeEach
    public void setUp() {

        Hogwarts = new Colegio("Hogwarts");

        Estudiante Harry = new Estudiante("Harry", "Potter", 18, 3, Residente.House.Gryffindor);
        Hogwarts.addIntegrante(Harry);

        Estudiante Draco = new Estudiante("Draco", "Malfoy", 19, 1, Residente.House.Slytherin);
        Hogwarts.addIntegrante(Draco);

        Fantasma Baron = new Fantasma("Baron", "Sanguinario", 143, 0, Residente.House.Ravenclaw);
        Hogwarts.addIntegrante(Baron);

        Conserje Argus = new Conserje("Argus", "Filch", 56, 1);
        Hogwarts.addIntegrante(Argus);

        Guardabosques Hagrid = new Guardabosques("Rubeus", "Hagrid", 96, 2);
        Hogwarts.addIntegrante(Hagrid);

        Docente Snape = new Docente("Severus", "Snape", 26, 1, Docente.Asignatura.Defensa);
        Hogwarts.addIntegrante(Snape);

        Docente Minerva = new Docente("Minerva", "McGonagall", 13, 2, Docente.Asignatura.Tranformaciones);
        Hogwarts.addIntegrante(Minerva);

    }

    @Test
    void testBasic() {

        assertEquals(
                "Harry Potter(Estudiante de Gryffindor, 3 horrocruxes): 270.0 galeones\n" +
                "Draco Malfoy(Estudiante de Slytherin, 1 horrocruxes): 180.0 galeones\n" +
                "Baron Sanguinario(Fantasma de Ravenclaw, 0 horrocruxes): 0.0 galeones\n" + 
                "Argus Filch(Conserje, 1 horrocruxes): 65.0 galeones\n" +
                "Rubeus Hagrid(Guardabosques, 2 horrocruxes): 150.0 galeones\n" +
                "Severus Snape(Docente de Defensa, 1 horrocruxes): 37.5 galeones\n" +
                "Minerva McGonagall(Docente de Tranformaciones, 2 horrocruxes): 100.0 galeones\n" +
                "La recompensa total del Colegio Hogwarts es de 802.5 galeones\n"
                , Hogwarts.imprimirRecompensas());

        assertEquals(
                "Argus Filch(Conserje): 160 galeones\n" +
                "Rubeus Hagrid(Guardabosques): 180 galeones\n" +
                "Severus Snape(Docente de Defensa): 500 galeones\n" +
                "Minerva McGonagall(Docente de Tranformaciones): 400 galeones\n" +
                "El gasto de Hogwarts en personal es de 1240 galeones\n"
                , Hogwarts.imprimirSalarios());

    }

    @Test
    public void imprimirRecompensa() {

    }
}