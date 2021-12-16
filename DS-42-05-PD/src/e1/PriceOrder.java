package e1;

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
