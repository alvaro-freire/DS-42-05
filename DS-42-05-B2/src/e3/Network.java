package e3;

import java.util.List;

public class Network {

    private NetworkManager networkManager;

    /* constructor */
    public Network(NetworkManager networkManager) {
        this.networkManager = networkManager;
    }

    /* get & set */
    public void setNetworkManager(NetworkManager networkManager) {
        this.networkManager = networkManager;
    }
    public NetworkManager getNetworkManager() {
        return networkManager;
    }

    public void addUser(String user, List<TopicOfInterest> topicsOfInterest) {
        networkManager.addUser(user, topicsOfInterest);
    }

    public void removeUser(String user) {
        networkManager.removeUser(user);
    }

    public void addInterest(String user, TopicOfInterest topicOfInterest) {
        networkManager.addInterest(user, topicOfInterest);
    }

    public void removeInterest(String user, TopicOfInterest topicOfInterest) {
        networkManager.removeInterest(user, topicOfInterest);
    }

    public List<String> getUsers() {
        return networkManager.getUsers();
    }

    public List<TopicOfInterest> getInterests() {
        return networkManager.getInterests();
    }

    public List<TopicOfInterest> getInterestsUser(String user) {
        return networkManager.getInterestsUser(user);
    }
}
