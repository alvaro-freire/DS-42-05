package e1;

import e3.Melody;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.print.Doc;

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

        Fantasma Mindy = new Fantasma("Mindy", "fantasma", 143, 0, Residente.House.Ravenclaw);
        Hogwarts.addIntegrante(Mindy);

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
        assertEquals("Harry Potter(Estudiante de Gryffindor, 2 horrocruxes): 180.0 galeones\n" +
                "Mindy fantasma(Fantasma de Ravenclaw, 0 horrocruxes): 0.0 galeones\n" +
                "La recompensa total del Colegio Hogwarts es de 180.0 galeones\n", Hogwarts.imprimirRecompensas());
    }

    @Test
    public void imprimirRecompensa() {
        assertEquals(0, StringCount.countWords(null));
        assertEquals(1, StringCount.countWords("OneWord"));
        assertEquals(2, StringCount.countWords("Two words"));
        assertEquals(4, StringCount.countWords("spaces at the end     "));
        assertEquals(4, StringCount.countWords("    many    spaces   between      words   "));
        assertEquals(1, StringCount.countWords("words,separated-by.special$characters@"));
        assertEquals(10, StringCount.countWords("Normal text a little long with CAPITALS and lowercase letters"));
        assertEquals(7, StringCount.countWords("Oración en español con eñe y acentos"));
    }
}