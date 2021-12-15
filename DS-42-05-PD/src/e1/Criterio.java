package e1;

import java.util.List;

public interface Criterio {

    List <Billete> filter(List<Billete> list);

    String toString();

}
