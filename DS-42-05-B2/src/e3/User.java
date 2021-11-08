package e3;

import java.util.List;
import java.util.Objects;

public class User {

    private String username;

    private final List<TopicOfInterest> topicsOfInterest;

    public User(String username, List<TopicOfInterest> topicsOfInterest) {
        this.username = username;
        this.topicsOfInterest = topicsOfInterest;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<TopicOfInterest> getTopicsOfInterest() {
        return topicsOfInterest;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return (Objects.equals(username, user.getUsername()) &&
                topicsOfInterest == user.getTopicsOfInterest());
    }

}
