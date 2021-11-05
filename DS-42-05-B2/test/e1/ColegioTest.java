package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColegioTest {

    /* se crea un colegio */
    private final Colegio Hogwarts = new Colegio("Hogwarts");

    /* se crean los integrantes del colegio */
    private final Estudiante Harry = new Estudiante("Harry", "Potter",
            18, 3, Residente.House.Gryffindor);

    private final Estudiante Draco = new Estudiante("Draco", "Malfoy",
            19, 1, Residente.House.Slytherin);

    private final Estudiante Hermione = new Estudiante("Hermione", "Granger",
            21, 1, Residente.House.Gryffindor);

    private final Fantasma Baron = new Fantasma("Baron", "Sanguinario",
            143, 0, Residente.House.Slytherin);

    private final Conserje Argus = new Conserje("Argus", "Filch",
            56, 1);

    private final Guardabosques Hagrid = new Guardabosques("Rubeus",
            "Hagrid", 96, 2);

    private final Docente Snape = new Docente("Severus", "Snape",
            26, 1, Docente.Asignatura.Defensa);

    private final Docente Remus = new Docente("Remus", "Lupin",
            48, 1, Docente.Asignatura.Defensa);

    private final Docente Minerva = new Docente("Minerva", "McGonagall",
            13, 2, Docente.Asignatura.Tranformaciones);

    @BeforeEach
    void setUp() {
        Hogwarts.clearList();
    }

    @Test
    void testNullName() {
        assertThrows(IllegalArgumentException.class, () -> new Estudiante(null, "Granger",
                21, 1, Residente.House.Gryffindor));

        assertThrows(IllegalArgumentException.class, () -> new Fantasma(null, "Sanguinario",
                143, 0, Residente.House.Slytherin));

        assertThrows(IllegalArgumentException.class, () -> new Conserje(null, "Filch",
                56, 1));

        assertThrows(IllegalArgumentException.class, () -> new Guardabosques(null, "Hagrid",
                96, 2));

        assertThrows(IllegalArgumentException.class, () -> new Docente(null, "Snape",
                26, 1, Docente.Asignatura.Defensa));
    }

    @Test
    void testThrows() {

        /* se envía un parámetro no válido */
        assertThrows(IllegalArgumentException.class, () -> Hogwarts.addIntegrante(null));

        /* se añade el mismo integrante dos veces */
        Hogwarts.addIntegrante(Harry);
        assertThrows(IllegalArgumentException.class, () -> Hogwarts.addIntegrante(Harry));

        /* se añaden dos profesores de la misma asignatura */
        Hogwarts.addIntegrante(Snape);
        assertThrows(IllegalArgumentException.class, () -> Hogwarts.addIntegrante(Remus));

        /* se intenta borrar integrante inexistente */
        assertThrows(IllegalArgumentException.class, () -> Hogwarts.removeIntegrante(Minerva));


    }

    @Test
    void testEquals() {

        Docente Snape2 = new Docente("Severus", "Snape",
                26, 1, Docente.Asignatura.Defensa);
        assertEquals(Snape, Snape2);

        Estudiante Hermione2 = new Estudiante("Hermione", "Granger",
                21, 1, Residente.House.Gryffindor);
        assertEquals(Hermione, Hermione2);

        Fantasma Baron2 = new Fantasma("Baron", "Sanguinario",
                143, 0, Residente.House.Slytherin);
        assertEquals(Baron, Baron2);

        Conserje Argus2 = new Conserje("Argus", "Filch",
                56, 1);
        assertEquals(Argus, Argus2);

        Guardabosques Hagrid2 = new Guardabosques("Rubeus",
                "Hagrid", 96, 2);
        assertEquals(Hagrid, Hagrid2);

    }

    @Test
    void testImprimirSalarios() {

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
        Hogwarts.addIntegrante(Hermione);
        assertEquals(
                "El gasto de Hogwarts en personal es de 0 galeones\n",
                Hogwarts.imprimirSalarios()
        );
    }

    @Test
    public void testImprimirRecompensa() {

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
                        "Baron Sanguinario(Fantasma de Slytherin, 0 horrocruxes): 0.0 galeones\n" +
                        "La recompensa total del Colegio Hogwarts es de 450.0 galeones\n",
                Hogwarts.imprimirRecompensas()
        );

        Hogwarts.addIntegrante(Argus);
        assertEquals(
                "Harry Potter(Estudiante de Gryffindor, 3 horrocruxes): 270.0 galeones\n" +
                        "Draco Malfoy(Estudiante de Slytherin, 1 horrocruxes): 180.0 galeones\n" +
                        "Baron Sanguinario(Fantasma de Slytherin, 0 horrocruxes): 0.0 galeones\n" +
                        "Argus Filch(Conserje, 1 horrocruxes): 65.0 galeones\n" +
                        "La recompensa total del Colegio Hogwarts es de 515.0 galeones\n",
                Hogwarts.imprimirRecompensas()
        );
        Hogwarts.removeIntegrante(Argus);

        Hogwarts.addIntegrante(Hagrid);
        assertEquals(
                "Harry Potter(Estudiante de Gryffindor, 3 horrocruxes): 270.0 galeones\n" +
                        "Draco Malfoy(Estudiante de Slytherin, 1 horrocruxes): 180.0 galeones\n" +
                        "Baron Sanguinario(Fantasma de Slytherin, 0 horrocruxes): 0.0 galeones\n" +
                        "Rubeus Hagrid(Guardabosques, 2 horrocruxes): 150.0 galeones\n" +
                        "La recompensa total del Colegio Hogwarts es de 600.0 galeones\n",
                Hogwarts.imprimirRecompensas()
        );

        Hogwarts.addIntegrante(Snape);
        assertEquals(
                "Harry Potter(Estudiante de Gryffindor, 3 horrocruxes): 270.0 galeones\n" +
                        "Draco Malfoy(Estudiante de Slytherin, 1 horrocruxes): 180.0 galeones\n" +
                        "Baron Sanguinario(Fantasma de Slytherin, 0 horrocruxes): 0.0 galeones\n" +
                        "Rubeus Hagrid(Guardabosques, 2 horrocruxes): 150.0 galeones\n" +
                        "Severus Snape(Docente de Defensa, 1 horrocruxes): 37.5 galeones\n" +
                        "La recompensa total del Colegio Hogwarts es de 637.5 galeones\n",
                Hogwarts.imprimirRecompensas()
        );

        Hogwarts.addIntegrante(Minerva);
        assertEquals(
                "Harry Potter(Estudiante de Gryffindor, 3 horrocruxes): 270.0 galeones\n" +
                        "Draco Malfoy(Estudiante de Slytherin, 1 horrocruxes): 180.0 galeones\n" +
                        "Baron Sanguinario(Fantasma de Slytherin, 0 horrocruxes): 0.0 galeones\n" +
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
                        "Baron Sanguinario(Fantasma de Slytherin, 0 horrocruxes): 0.0 galeones\n" +
                        "Rubeus Hagrid(Guardabosques, 2 horrocruxes): 150.0 galeones\n" +
                        "Minerva McGonagall(Docente de Tranformaciones, 2 horrocruxes): 100.0 galeones\n" +
                        "La recompensa total del Colegio Hogwarts es de 520.0 galeones\n",
                Hogwarts.imprimirRecompensas()
        );

        Hogwarts.clearList();
        Hogwarts.addIntegrante(Hermione);
        assertEquals(
                "Hermione Granger(Estudiante de Gryffindor, 1 horrocruxes): 90.0 galeones\n" +
                        "La recompensa total del Colegio Hogwarts es de 90.0 galeones\n",
                Hogwarts.imprimirRecompensas()
        );
    }
}