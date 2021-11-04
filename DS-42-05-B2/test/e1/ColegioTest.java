package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColegioTest {

    private final Colegio Hogwarts = new Colegio("Hogwarts");

    Estudiante Harry = new Estudiante("Harry", "Potter",
            18, 3, Residente.House.Gryffindor);

    Estudiante Draco = new Estudiante("Draco", "Malfoy",
            19, 1, Residente.House.Slytherin);

    Fantasma Baron = new Fantasma("Baron", "Sanguinario",
            143, 0, Residente.House.Ravenclaw);

    Conserje Argus = new Conserje("Argus", "Filch",
            56, 1);

    Guardabosques Hagrid = new Guardabosques("Rubeus",
            "Hagrid", 96, 2);

    Docente Snape = new Docente("Severus", "Snape",
            26, 1, Docente.Asignatura.Defensa);

    Docente Minerva = new Docente("Minerva", "McGonagall",
            13, 2, Docente.Asignatura.Tranformaciones);

    @BeforeEach
    void setUp() {
        Hogwarts.clearList();
    }

    @Test
    void imprimirSalarios() {

        Hogwarts.addIntegrante(Harry);
        assertEquals(
                "El gasto de Hogwarts en personal es de 0 galeones\n",
                Hogwarts.imprimirSalarios()
        );

        Hogwarts.addIntegrante(Draco);
        assertEquals(
                "El gasto de Hogwarts en personal es de 0 galeones\n",
                Hogwarts.imprimirSalarios()
        );

        Hogwarts.addIntegrante(Baron);
        assertEquals(
                "El gasto de Hogwarts en personal es de 0 galeones\n",
                Hogwarts.imprimirSalarios()
        );

        Hogwarts.addIntegrante(Argus);
        assertEquals(
                "Argus Filch(Conserje): 160 galeones\n" +
                        "El gasto de Hogwarts en personal es de 160 galeones\n",
                Hogwarts.imprimirSalarios()
        );
        Hogwarts.removeIntegrante(Argus);

        Hogwarts.addIntegrante(Hagrid);
        assertEquals(
                "Rubeus Hagrid(Guardabosques): 180 galeones\n" +
                        "El gasto de Hogwarts en personal es de 180 galeones\n",
                Hogwarts.imprimirSalarios()
        );

        Hogwarts.addIntegrante(Snape);
        assertEquals(
                "Rubeus Hagrid(Guardabosques): 180 galeones\n" +
                        "Severus Snape(Docente de Defensa): 500 galeones\n" +
                        "El gasto de Hogwarts en personal es de 680 galeones\n",
                Hogwarts.imprimirSalarios()
        );

        Hogwarts.addIntegrante(Minerva);
        assertEquals(
                "Rubeus Hagrid(Guardabosques): 180 galeones\n" +
                        "Severus Snape(Docente de Defensa): 500 galeones\n" +
                        "Minerva McGonagall(Docente de Tranformaciones): 400 galeones\n" +
                        "El gasto de Hogwarts en personal es de 1080 galeones\n",
                Hogwarts.imprimirSalarios()
        );

        Hogwarts.removeIntegrante(Draco);
        Hogwarts.removeIntegrante(Snape);
        assertEquals(
                "Rubeus Hagrid(Guardabosques): 180 galeones\n" +
                        "Minerva McGonagall(Docente de Tranformaciones): 400 galeones\n" +
                        "El gasto de Hogwarts en personal es de 580 galeones\n",
                Hogwarts.imprimirSalarios()
        );

        Hogwarts.clearList();
        assertEquals(
                "El gasto de Hogwarts en personal es de 0 galeones\n",
                Hogwarts.imprimirSalarios()
        );
    }

    @Test
    public void imprimirRecompensa() {

        Hogwarts.addIntegrante(Harry);
        assertEquals(
                "Harry Potter(Estudiante de Gryffindor, 3 horrocruxes): 270.0 galeones\n" +
                        "La recompensa total del Colegio Hogwarts es de 270.0 galeones\n",
                Hogwarts.imprimirRecompensas()
        );

        Hogwarts.addIntegrante(Draco);
        assertEquals(
                "Harry Potter(Estudiante de Gryffindor, 3 horrocruxes): 270.0 galeones\n" +
                        "Draco Malfoy(Estudiante de Slytherin, 1 horrocruxes): 180.0 galeones\n" +
                        "La recompensa total del Colegio Hogwarts es de 450.0 galeones\n",
                Hogwarts.imprimirRecompensas()
        );


        Hogwarts.addIntegrante(Baron);
        assertEquals(
                "Harry Potter(Estudiante de Gryffindor, 3 horrocruxes): 270.0 galeones\n" +
                        "Draco Malfoy(Estudiante de Slytherin, 1 horrocruxes): 180.0 galeones\n" +
                        "Baron Sanguinario(Fantasma de Ravenclaw, 0 horrocruxes): 0.0 galeones\n" +
                        "La recompensa total del Colegio Hogwarts es de 450.0 galeones\n",
                Hogwarts.imprimirRecompensas()
        );

        Hogwarts.addIntegrante(Argus);
        assertEquals(
                "Harry Potter(Estudiante de Gryffindor, 3 horrocruxes): 270.0 galeones\n" +
                        "Draco Malfoy(Estudiante de Slytherin, 1 horrocruxes): 180.0 galeones\n" +
                        "Baron Sanguinario(Fantasma de Ravenclaw, 0 horrocruxes): 0.0 galeones\n" +
                        "Argus Filch(Conserje, 1 horrocruxes): 65.0 galeones\n" +
                        "La recompensa total del Colegio Hogwarts es de 515.0 galeones\n",
                Hogwarts.imprimirRecompensas()
        );
        Hogwarts.removeIntegrante(Argus);

        Hogwarts.addIntegrante(Hagrid);
        assertEquals(
                "Harry Potter(Estudiante de Gryffindor, 3 horrocruxes): 270.0 galeones\n" +
                        "Draco Malfoy(Estudiante de Slytherin, 1 horrocruxes): 180.0 galeones\n" +
                        "Baron Sanguinario(Fantasma de Ravenclaw, 0 horrocruxes): 0.0 galeones\n" +
                        "Rubeus Hagrid(Guardabosques, 2 horrocruxes): 150.0 galeones\n" +
                        "La recompensa total del Colegio Hogwarts es de 600.0 galeones\n",
                Hogwarts.imprimirRecompensas()
        );

        Hogwarts.addIntegrante(Snape);
        assertEquals(
                "Harry Potter(Estudiante de Gryffindor, 3 horrocruxes): 270.0 galeones\n" +
                        "Draco Malfoy(Estudiante de Slytherin, 1 horrocruxes): 180.0 galeones\n" +
                        "Baron Sanguinario(Fantasma de Ravenclaw, 0 horrocruxes): 0.0 galeones\n" +
                        "Rubeus Hagrid(Guardabosques, 2 horrocruxes): 150.0 galeones\n" +
                        "Severus Snape(Docente de Defensa, 1 horrocruxes): 37.5 galeones\n" +
                        "La recompensa total del Colegio Hogwarts es de 637.5 galeones\n",
                Hogwarts.imprimirRecompensas()
        );

        Hogwarts.addIntegrante(Minerva);
        assertEquals(
                "Harry Potter(Estudiante de Gryffindor, 3 horrocruxes): 270.0 galeones\n" +
                        "Draco Malfoy(Estudiante de Slytherin, 1 horrocruxes): 180.0 galeones\n" +
                        "Baron Sanguinario(Fantasma de Ravenclaw, 0 horrocruxes): 0.0 galeones\n" +
                        "Rubeus Hagrid(Guardabosques, 2 horrocruxes): 150.0 galeones\n" +
                        "Severus Snape(Docente de Defensa, 1 horrocruxes): 37.5 galeones\n" +
                        "Minerva McGonagall(Docente de Tranformaciones, 2 horrocruxes): 100.0 galeones\n" +
                        "La recompensa total del Colegio Hogwarts es de 737.5 galeones\n",
                Hogwarts.imprimirRecompensas()
        );

        Hogwarts.removeIntegrante(Draco);
        Hogwarts.removeIntegrante(Snape);
        assertEquals(
                "Harry Potter(Estudiante de Gryffindor, 3 horrocruxes): 270.0 galeones\n" +
                        "Baron Sanguinario(Fantasma de Ravenclaw, 0 horrocruxes): 0.0 galeones\n" +
                        "Rubeus Hagrid(Guardabosques, 2 horrocruxes): 150.0 galeones\n" +
                        "Minerva McGonagall(Docente de Tranformaciones, 2 horrocruxes): 100.0 galeones\n" +
                        "La recompensa total del Colegio Hogwarts es de 520.0 galeones\n",
                Hogwarts.imprimirRecompensas()
        );

        Hogwarts.clearList();
        assertEquals(
                "La recompensa total del Colegio Hogwarts es de 0.0 galeones\n",
                Hogwarts.imprimirRecompensas()
        );
    }
}