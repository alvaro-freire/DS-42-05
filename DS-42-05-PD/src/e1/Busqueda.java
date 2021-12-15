package e1;

import java.util.ArrayList;
import java.util.List;

public final class Busqueda {

    private final List<Billete> billetesList = new ArrayList<>();

    Busqueda (List<Billete> billetesList) {

        if (billetesList == null) {
            throw new NullPointerException();
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
        StringBuilder string = new StringBuilder();

        string.append("*************** Búsqueda ***************\n");
        string.append("Lista de billetes (sin filtros):\n");

        for (Billete b : billetesList) {
            string.append(b.toString());
        }

        return string.toString();
    }

    public String toString(Criterio... criterios) {
        List<Billete> filterList;
        StringBuilder string = new StringBuilder();
        int cnt = 1;

        filterList = filtrar(criterios);

        string.append("*************** Búsqueda ***************\n");
        string.append("Filtros: ");

        for (Criterio c : criterios) {
            if (cnt == criterios.length) {
                string.append(c.toString()).append(" ");
            } else {
                string.append(c.toString()).append(" || ");
                cnt++;
            }
        }
        string.append(":\n");

        for (Billete b : filterList) {
            string.append(b.toString());
        }

        return string.toString();
    }

}
