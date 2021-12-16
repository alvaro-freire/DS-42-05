package e1;

import java.util.ArrayList;
import java.util.List;

public final class Busqueda {

    private final List<Billete> list;

    private Busqueda(Builder builder) {
        list = builder.list;
    }

    public List<Billete> getList() {
        return new ArrayList<>(list);
    }

    public static class Builder {

        private List<Billete> list = new ArrayList<>();

        Builder (List<Billete> billetesList) {

            if (billetesList == null) {
                throw new NullPointerException();
            }

            /* se añaden todos los billetes a la lista */
            list.addAll(billetesList);
        }

        public Busqueda build() {
            return new Busqueda(this);
        }

        public Builder origen(String... origenes) {
            List<Billete> aux = new ArrayList<>();

            for (Billete b : list) {
                for (String s : origenes) {
                    if (s.equals(b.getOrigen())) {
                        aux.add(b);
                    }
                }
            }
            list = aux;
            return this;
        }

        public Builder destino(String... destinos) {
            List<Billete> aux = new ArrayList<>();

            for (Billete b : list) {
                for (String s : destinos) {
                    if (s.equals(b.getDestino())) {
                        aux.add(b);
                    }
                }
            }
            list = aux;
            return this;
        }

        public Builder precio(int precio, PriceOrder priceOrder) {
            List<Billete> aux = new ArrayList<>();

            for (Billete b : list) {
                if (priceOrder.compare(b.getPrecio(), precio)) {
                    aux.add(b);
                }
            }
            list = aux;
            return this;
        }

        public Builder fecha(Date... fechas) {
            List<Billete> aux = new ArrayList<>();

            for (Billete b : list) {
                for (Date d : fechas) {
                    if (d.equals(b.getFecha())) {
                        aux.add(b);
                    }
                }
            }
            list = aux;
            return this;
        }

    }

}
