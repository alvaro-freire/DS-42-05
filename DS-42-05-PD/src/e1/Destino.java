package e1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Destino implements Criterio {

    private final List<String> destinoList = new ArrayList<>();

    Destino(String... destino) {
        destinoList.addAll(Arrays.asList(destino));
    }

    public void addDestino(String destino) {
        if (destino == null) {
            throw new NullPointerException();
        }

        if (destinoList.contains(destino)) {
            throw new IllegalArgumentException();
        }

        destinoList.add(destino);
    }

    public void removeDestino(String destino) {
        if (destino == null) {
            throw new NullPointerException();
        }

        if (!destinoList.contains(destino)) {
            throw new IllegalArgumentException();
        }

        destinoList.remove(destino);
    }

    public void clearDestino() {
        destinoList.clear();
    }

    @Override
    public List<Billete> filter(List<Billete> list) {
        List<Billete> aux = new ArrayList<>();

        for (Billete b : list) {
            for (String s : destinoList) {
                if (s.equals(b.getDestino())) {
                    aux.add(b);
                }
            }
        }
        return aux;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        string.append("Destino [ ");

        for (String s : destinoList) {
            if (s.equals(destinoList.get(destinoList.size() - 1))) {
                string.append(s).append(" ");
            } else {
                string.append(s).append(", ");
            }
        }

        string.append("]");

        return string.toString();
    }

}
