package e1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Destino implements Criterio {

    private final List<String> destinoList = new ArrayList<>();

    Destino(String... origen) {
        destinoList.addAll(Arrays.asList(origen));
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
