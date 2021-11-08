package e3;

public enum TopicOfInterest {

    Viajes(1),
    Deportes(2),
    Libros(3),
    Ropa(4),
    Comida(5);

    private final int topic;

    TopicOfInterest(int topic) {
        this.topic = topic;
    }

    public int getTopicNumber() {
        return topic;
    }

}
