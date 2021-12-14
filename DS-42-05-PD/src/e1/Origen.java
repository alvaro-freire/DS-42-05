package e1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Origen implements Criterio {

    private final List<String> origenList = new ArrayList<>();

    Origen(String... origen) {
        origenList.addAll(Arrays.asList(origen));
    }

    @Override
    public List<Billete> filter(List<Billete> list) {
        List<Billete> aux = new ArrayList<>();

        for (Billete b : list) {
            for (String s : origenList) {
                if (s.equals(b.getOrigen())) {
                    aux.add(b);
                }
            }
        }
        return aux;
    }
}
