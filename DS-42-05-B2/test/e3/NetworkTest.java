package e3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class NetworkTest {

    private final Network network1 = new Network(new NetworkManager1());

    private final Network network2 = new Network(new NetworkManager2());

    private final List<TopicOfInterest> list1 = new ArrayList<>();

    private final List<TopicOfInterest> list2 = new ArrayList<>();

    private final List<TopicOfInterest> list3 = new ArrayList<>();

    @BeforeEach
    public void setUp() {

        /* se añaden topics la lista1 */
        list1.add(TopicOfInterest.Viajes);
        list1.add(TopicOfInterest.Libros);

        /* se añaden topics a la lista2 */
        list2.add(TopicOfInterest.Comida);
        list2.add(TopicOfInterest.Deportes);

        /* se añaden topics a la lista3 */
        list3.add(TopicOfInterest.Ropa);
        list3.add(TopicOfInterest.Libros);

    }

    @Test
    public void testAddAndRemove() {
        /* lista auxiliar de usuarios de la red */
        List<String> userList = new ArrayList<>();

        /* lista vacía */
        assertEquals(userList, network1.getUsers());
        assertEquals(userList, network2.getUsers());

        /* se añaden usuarios */
        network1.addUser("user1", list1);
        network1.addUser("user2", list2);
        network1.addUser("user3", list3);

        network2.addUser("user1", list1);
        network2.addUser("user2", list2);
        network2.addUser("user3", list3);

        /* se añaden los usuarios en la lista
         * auxiliar en el orden correspondiente */
        userList.add("user1");
        userList.add("user2");
        userList.add("user3");

        assertEquals(userList, network1.getUsers());
        assertEquals(userList, network2.getUsers());

        /* se intenta añadir un usuario existente */
        assertThrows(IllegalArgumentException.class, () -> network1.addUser("user1", list1));
        assertThrows(IllegalArgumentException.class, () -> network2.addUser("user1", list1));

        /* se elimina al user1 */
        network1.removeUser("user1");
        network2.removeUser("user1");
        userList.remove("user1");

        assertEquals(userList, network1.getUsers());
        assertEquals(userList, network2.getUsers());

        /* se elimina al user2 */
        network1.removeUser("user2");
        network2.removeUser("user2");
        userList.remove("user2");

        assertEquals(userList, network1.getUsers());
        assertEquals(userList, network2.getUsers());

        /* se elimina al user3 */
        network1.removeUser("user3");
        network2.removeUser("user3");
        userList.remove("user3");

        assertEquals(userList, network1.getUsers());
        assertEquals(userList, network2.getUsers());

        /* se intenta eliminar un usuario inexistente */
        assertThrows(IllegalArgumentException.class, () -> network1.removeUser("user3"));
        assertThrows(IllegalArgumentException.class, () -> network2.removeUser("user3"));

    }

    @Test
    public void testBasic() {
        List<String> userList = new ArrayList<>();
        List<TopicOfInterest> topicOfInterests = new ArrayList<>();

        network1.addUser("user1", list1);

        network1.addUser("user2", list2);

        network1.addInterest("user1", TopicOfInterest.Comida);

        network1.addInterest("user2", TopicOfInterest.Viajes);

        network1.addInterest("user2", TopicOfInterest.Libros);

        network1.addInterest("user2", TopicOfInterest.Ropa);

        userList = network1.getUsers();

        topicOfInterests = network1.getInterests();

        assertEquals("", network1.toString());

    }
}