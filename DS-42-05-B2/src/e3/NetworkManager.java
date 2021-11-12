/**
 * TITLE: Software Design B2
 * SUBTITLE: Exercise 3
 * @author Mateo Díaz Allegue @login mateo.diaz
 * @author Álvaro Freire Ares @login alvaro.freirea
 * GROUP: 4.2
 * DATE: 12 / 11 / 2021
 */

package e3;

import java.util.List;

public interface NetworkManager {

    void addUser(String username, List<TopicOfInterest> topicsOfInterest);

    void removeUser(String username);

    void addInterest(String username, TopicOfInterest topicOfInterest);

    void removeInterest(String username, TopicOfInterest topicOfInterest);

    List<String> getUsers();

    List<TopicOfInterest> getInterests();

    List<TopicOfInterest> getInterestsUser(String username);

}
