package e3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class NetworkTest {

    private final Network network = new Network(new NetworkManager1());

    private final List<TopicOfInterest> list1 = new ArrayList<>();

    private final List<TopicOfInterest> list2 = new ArrayList<>();

    @Test
    public void testBasic() {
        List<String> userList = new ArrayList<>();
        List<TopicOfInterest> topicOfInterests = new ArrayList<>();


        list1.add(TopicOfInterest.Viajes);
        list1.add(TopicOfInterest.Libros);

        list2.add(TopicOfInterest.Comida);
        list2.add(TopicOfInterest.Deportes);

        network.addUser("user1", list1);

        network.addUser("user2", list2);

        network.addInterest("user1", TopicOfInterest.Comida);

        network.addInterest("user2", TopicOfInterest.Viajes);

        userList = network.getUsers();

        topicOfInterests = network.getInterests();

    }
}