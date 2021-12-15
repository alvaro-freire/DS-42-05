package e1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Destino implements Criterio {

    private final List<String> destinoList = new ArrayList<>();

    Destino(String... origen) {
        destinoList.addAll(Arrays.asList(origen));
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

    public void removeOrigen(String destino) {
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

}
