package e3;

import java.util.ArrayList;
import java.util.List;

public class NetworkManager1 implements NetworkManager {

    private final List<User> userList = new ArrayList<>();

    @Override
    public void addUser(String username, List<TopicOfInterest> topicsOfInterest) {

        if (username == null || topicsOfInterest == null) {
            throw new NullPointerException();
        }

        for (User u : userList) {
            if (u.getUsername().equals(username) || u.getTopicsOfInterest() == topicsOfInterest) {
                throw new IllegalArgumentException();
            }
        }

        User user = new User(username, topicsOfInterest);

        userList.add(user);
    }

    @Override
    public void removeUser(String username) {

        if (username == null) {
            throw new NullPointerException();
        }

        userList.removeIf(u -> u.getUsername().equals(username));

        throw new IllegalArgumentException();
    }

    @Override
    public void addInterest(String username, TopicOfInterest topicOfInterest) {

        if (username == null || topicOfInterest == null) {
            throw new NullPointerException();
        }

        for (User u : userList) {
            if (u.getUsername().equals(username)) {
                for (TopicOfInterest t : u.getTopicsOfInterest()) {
                    if (t.equals(topicOfInterest)) {
                        throw new IllegalArgumentException();
                    }
                }
                u.getTopicsOfInterest().add(topicOfInterest);
            }
        }
    }

    @Override
    public void removeInterest(String username, TopicOfInterest topicOfInterest) {

        if (username == null || topicOfInterest == null) {
            throw new NullPointerException();
        }

        for (User u : userList) {
            if (u.getUsername().equals(username)) {
                for (TopicOfInterest t : u.getTopicsOfInterest()) {
                    if (t.equals(topicOfInterest)) {
                        u.getTopicsOfInterest().remove(topicOfInterest);
                        return;
                    }
                }
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public List<String> getUsers() {
        List<String> userList = new ArrayList<>();

        for (User u : this.userList) {
            userList.add(u.getUsername());
        }
        return userList;
    }

    @Override
    public List<TopicOfInterest> getInterests() {
        List<TopicOfInterest> topiclist = new ArrayList<>();

        for (User u : userList) {
            for (TopicOfInterest topic : u.getTopicsOfInterest()) {
                if (!topiclist.contains(topic)) {
                    topiclist.add(topic);
                }
            }
        }

        return topiclist;
    }

    @Override
    public List<TopicOfInterest> getInterestsUser(String username) {

        if (username == null) {
            throw new NullPointerException();
        }

        for (User u : userList) {
            if (u.getUsername().equals(username)) {
                return u.getTopicsOfInterest();
            }
        }
        throw new IllegalArgumentException();
    }
}
