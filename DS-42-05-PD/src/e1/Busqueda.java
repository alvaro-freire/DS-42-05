package e1;

import java.util.ArrayList;
import java.util.List;

public final class Busqueda {

    private final List<Billete> billetesList = new ArrayList<>();

    Busqueda (List<Billete> billetesList) {
        if (billetesList == null) {
            throw new IllegalArgumentException();
        }

        /* se añaden todos los billetes a la lista */
        this.billetesList.addAll(billetesList);
    }

    public List<Billete> getBilletesList() {
        return new ArrayList<>(billetesList);
    }

    public List<Billete> filtrar(Criterio... criterios) {
        List<Billete> modList = new ArrayList<>(billetesList);

        for (Criterio criterio : criterios) {
            modList = criterio.filter(modList);
        }
        return modList;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("");

        string.append("Búsqueda {\n\tLista de billetes = {\n");

        for (Billete b : billetesList) {
            string.append(b.toString()).append("\n");
        }

        string.append("\t}\n}");

        return string.toString();
    }
}
