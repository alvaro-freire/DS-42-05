package e1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fecha implements Criterio {

    private final List<Date> dateList = new ArrayList<>();

    Fecha (Date... dates) {
        dateList.addAll(Arrays.asList(dates));
    }

    public void addFecha(Date fecha) {
        if (fecha == null) {
            throw new NullPointerException();
        }

        if (dateList.contains(fecha)) {
            throw new IllegalArgumentException();
        }

        dateList.add(fecha);
    }

    public void removeFecha(Date fecha) {
        if (fecha == null) {
            throw new NullPointerException();
        }

        if (!dateList.contains(fecha)) {
            throw new IllegalArgumentException();
        }

        dateList.remove(fecha);
    }

    public void clearFecha() {
        dateList.clear();
    }

    @Override
    public List<Billete> filter(List<Billete> list) {
        List<Billete> aux = new ArrayList<>();

        for (Billete b : list) {
            for (Date d : dateList) {
                if (d.equals(b.getFecha())) {
                    aux.add(b);
                }
            }
        }
        return aux;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        int last = dateList.size() - 1;

        string.append("Fecha [ ");

        for (Date d : dateList) {
            if (d.equals(dateList.get(last))) {
                string.append(d).append(" ");
            } else {
                string.append(d).append(", ");
            }
        }

        string.append("]");

        return string.toString();
    }
}
