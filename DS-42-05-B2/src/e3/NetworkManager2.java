package e3;

import java.util.*;

public class NetworkManager2 implements NetworkManager {

    Map<String, List<TopicOfInterest>> map = new HashMap<>();

    @Override
    public void addUser(String username, List<TopicOfInterest> topicsOfInterest) {
        Iterator<String> iter = map.keySet().iterator();

        if (username == null || topicsOfInterest == null || map.containsKey(username)) {
            throw new IllegalArgumentException();
        }

        while(iter.hasNext()){
            String key = iter.next();
            if (map.get(key) == topicsOfInterest) {
                throw new IllegalArgumentException();
            }
        }

        map.put(username, topicsOfInterest);
    }

    @Override
    public void removeUser(String username) {

        if (username == null) {
            throw new IllegalArgumentException();
        }

        if (map.remove(username) == null) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void addInterest(String username, TopicOfInterest topicOfInterest) {
        List<TopicOfInterest> list =  map.get(username);

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

        if (list == null) {
            throw new IllegalArgumentException();
        }

        return list;
    }
}
