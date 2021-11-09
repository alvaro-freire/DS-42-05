package e3;

import java.util.*;

public class NetworkManager2 implements NetworkManager {

    Map<String, List<TopicOfInterest>> map = new HashMap<>();

    @Override
    public void addUser(String username, List<TopicOfInterest> topicsOfInterest) {

        if (username == null || topicsOfInterest == null) {
            throw new NullPointerException();
        }

        if (map.containsKey(username)) {
            throw new IllegalArgumentException();
        }

        map.put(username, topicsOfInterest);
    }

    @Override
    public void removeUser(String username) {
        if (username == null) {
            throw new NullPointerException();
        }
        if (map.remove(username) == null) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void addInterest(String username, TopicOfInterest topicOfInterest) {
        List<TopicOfInterest> list =  map.get(username);

        if (username == null || topicOfInterest == null) {
            throw new NullPointerException();
        }

        if (list == null) {
            throw new IllegalArgumentException();
        }

        for (TopicOfInterest topic : list) {
            if (topic.equals(topicOfInterest)) {
                throw new IllegalArgumentException();
            }
        }

        list.add(topicOfInterest);
    }

    @Override
    public void removeInterest(String username, TopicOfInterest topicOfInterest) {
        List<TopicOfInterest> list =  map.get(username);

        if (username == null || topicOfInterest == null) {
            throw new NullPointerException();
        }

        if (list == null) {
            throw new IllegalArgumentException();
        }

        for (TopicOfInterest topic : list) {
            if (topic.equals(topicOfInterest)) {
                list.remove(topicOfInterest);
                return;
            }
        }

        throw new IllegalArgumentException();
    }

    @Override
    public List<String> getUsers() {
        return new ArrayList<>(map.keySet());
    }

    @Override
    public List<TopicOfInterest> getInterests() {
        List<TopicOfInterest> list = new ArrayList<>();

        for (String key : map.keySet()) {
            for (TopicOfInterest topic : map.get(key)) {
                if (!list.contains(topic)) {
                    list.add(topic);
                }
            }
        }

        return list;
    }

    @Override
    public List<TopicOfInterest> getInterestsUser(String username) {
        List<TopicOfInterest> list = map.get(username);

        if (username == null) {
            throw new NullPointerException();
        }

        if (list == null) {
            throw new IllegalArgumentException();
        }

        return list;
    }
}
