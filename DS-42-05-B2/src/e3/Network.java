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

public class Network {

    private NetworkManager networkManager;

    /* constructor */
    public Network(NetworkManager networkManager) {
        if (networkManager == null) {
            throw new NullPointerException();
        }
        this.networkManager = networkManager;
    }

    /* get & set */
    public void setNetworkManager(NetworkManager networkManager) {
        this.networkManager = networkManager;
    }

    public NetworkManager getNetworkManager() {
        return networkManager;
    }

    public void addUser(String username, List<TopicOfInterest> topicsOfInterest) {
        networkManager.addUser(username, topicsOfInterest);
    }

    public void removeUser(String username) {
        networkManager.removeUser(username);
    }

    public void addInterest(String username, TopicOfInterest topicOfInterest) {
        networkManager.addInterest(username, topicOfInterest);
    }

    public void removeInterest(String username, TopicOfInterest topicOfInterest) {
        networkManager.removeInterest(username, topicOfInterest);
    }

    public List<String> getUsers() {
        return networkManager.getUsers();
    }

    public List<TopicOfInterest> getInterests() {
        return networkManager.getInterests();
    }

    public List<TopicOfInterest> getInterestsUser(String username) {
        return networkManager.getInterestsUser(username);
    }

    /**
     * Prints the data of the network.
     *
     * @return string with all the data of the network
     */
    public String toString() {
        String string = "";
        List<String> userList = getUsers();
        List<TopicOfInterest> topicsList;

        for (String s : userList) {
            topicsList = getInterestsUser(s);
            string = string.concat(s + " -> Topics { ");
            for (TopicOfInterest topic : topicsList) {
                string = string.concat(topic + " ");
            }
            string = string.concat("}\n");
        }

        return string;
    }

}
