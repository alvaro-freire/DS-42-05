package e1;

import java.util.ArrayList;
import java.util.List;

public class Precio implements Criterio {

    private int precio;
    private PriceOrder priceOrder;

    public enum PriceOrder {

        LOWER("<") {

            @Override
            public boolean compare(int a, int b) {
                return a < b;
            }
        },
        LOWEREQ("<=") {
            @Override
            public boolean compare(int a, int b) {
                return a <= b;
            }
        },
        HIGHER(">") {
            @Override
            public boolean compare(int a, int b) {
                return a > b;
            }
        },
        HIGHEREQ(">=") {
            @Override
            public boolean compare(int a, int b) {
                return a >= b;
            }
        };

        private final String operation;

        PriceOrder(String c) {
            this.operation = c;
        }

        public String getOperation() {
            return operation;
        }

        public abstract boolean compare(int a, int b);
    }

    Precio(int precio, PriceOrder priceOrder) {

        if (precio < 0) {
            throw new IllegalArgumentException();
        }

        if (priceOrder == null) {
            throw new NullPointerException();
        }

        this.precio = precio;
        this.priceOrder = priceOrder;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPriceOrder(PriceOrder priceOrder) {
        this.priceOrder = priceOrder;
    }

    public PriceOrder getPriceOrder() {
        return priceOrder;
    }

    @Override
    public List<Billete> filter(List<Billete> list) {
        List<Billete> aux = new ArrayList<>();

        for (Billete b : list) {
            if (priceOrder.compare(b.getPrecio(), precio)) {
                aux.add(b);
            }
        }
        return aux;
    }

    @Override
    public String toString() {
        return "Precio (" + priceOrder.getOperation() + precio + ")";
    }
}
