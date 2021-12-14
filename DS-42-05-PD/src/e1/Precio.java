package e1;

import java.util.ArrayList;
import java.util.List;

public class Precio implements Criterio {

    private final int precio;
    private final PriceOrder priceOrder;

    public enum PriceOrder {

        LOWER {
            @Override
            public boolean compare(int a, int b) {
                return a < b;
            }
        },
        LOWEREQ {
            @Override
            public boolean compare(int a, int b) {
                return a <= b;
            }
        },
        HIGHER {
            @Override
            public boolean compare(int a, int b) {
                return a > b;
            }
        },
        HIGHEREQ {
            @Override
            public boolean compare(int a, int b) {
                return a >= b;
            }
        };

        public abstract boolean compare(int a, int b);
    }

    Precio(int precio, PriceOrder priceOrder) {
        this.precio = precio;
        this.priceOrder = priceOrder;
    }

    public int getPrecio() {
        return precio;
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
}
