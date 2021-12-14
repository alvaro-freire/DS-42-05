package e1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Fecha implements Criterio {

    List<Date> dateList = new ArrayList<>();

    Fecha (Date... dates) {
        dateList.addAll(Arrays.asList(dates));
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
}
