import com.bst.BST;
import com.exceptions.BetweenLevelException;
import com.exceptions.DepthException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
Casos Válidos: El BST tiene nodos y por ende devuelve el iterador en anchura
Casos Inválidos: El BST es null y por ende no se puede conseguir la un iterador
                 El BST está vacío y por ende la raíz es null y no podemos iterar por un
                 arbol vacío con nodo raíz null.
                 (Restricción de Tipado genérico -> Si es Integer y asignamos el nodo root
                  como null da NullPointerException)
 */
public class IteratorTest {
    BST<Integer> bst = new BST<>();
    Iterator iterator;
    ArrayList<Integer> elements = new ArrayList<>();

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws DepthException {
        elements.add(125);
        elements.add(50);
        elements.add(500);
        elements.add(-250);
        elements.add(100);
        elements.add(350);
        elements.add(700);
        elements.add(-125);
        elements.add(400);
        elements.add(600);
        elements.add(1000);
        elements.add(1200);
        bst.insert(125, true);
        bst.insert(500, true);
        bst.insert(50, true);
        bst.insert(-250, true);
        bst.insert(-125, false);
        bst.insert(100, false);
        bst.insert(350, true);
        bst.insert(700, true);
        bst.insert(1000, true);
        bst.insert(600, true);
        bst.insert(400, true);
        bst.insert(1200, true);
        iterator = bst.iterator();
    }


    @Test
    void iteratorTest()
    {
        for (Integer element : elements) {
            assertEquals(element, iterator.next());
        }
    }


    @Test
    void checkNull() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            bst = null;
            bst.iterator();
        });
    }
    @Test
    void checkEmpty(){
        Assertions.assertThrows(NullPointerException.class, () -> {
            bst = new BST<>();
            assertEquals(new ArrayList<>().toString(),bst.iterator().toString());
        });
    }
}
