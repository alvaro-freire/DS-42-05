package e1;

import java.util.ArrayList;
import java.util.List;

public final class Busqueda {

    private final List<Billete> list;

    private Busqueda(Criterios builder) {
        list = builder.list;
    }

    public List<Billete> getList() {
        return new ArrayList<>(list);
    }

    public static class Criterios {

        private List<Billete> list = new ArrayList<>();

        Criterios(List<Billete> billetesList) {

            if (billetesList == null) {
                throw new NullPointerException();
            }

            /* se añaden todos los billetes a la lista */
            list.addAll(billetesList);
        }

        public Busqueda build() {
            return new Busqueda(this);
        }

        public Criterios origen(String... origenes) {
            List<Billete> aux = new ArrayList<>();

            for (Billete b : list)
                for (String s : origenes)
                    if (s.equals(b.getOrigen()))
                        aux.add(b);
            list = aux;
            return this;
        }

        public Criterios destino(String... destinos) {
            List<Billete> aux = new ArrayList<>();

            for (Billete b : list)
                for (String s : destinos)
                    if (s.equals(b.getDestino()))
                        aux.add(b);
            list = aux;
            return this;
        }

        public Criterios precio(int precio, PriceOrder priceOrder) {
            List<Billete> aux = new ArrayList<>();

            for (Billete b : list)
                if (priceOrder.compare(b.getPrecio(), precio))
                    aux.add(b);
            list = aux;
            return this;
        }

        public Criterios fecha(Date... fechas) {
            List<Billete> aux = new ArrayList<>();

            for (Billete b : list)
                for (Date d : fechas)
                    if (d.equals(b.getFecha()))
                        aux.add(b);
            list = aux;
            return this;
        }

    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("* Lista de billetes:\n");

        for (Billete b : list) {
            string.append(b.toString());
        }

        return string.toString();
    }
}
