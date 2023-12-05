import static org.junit.jupiter.api.Assertions.*;
import com.bst.BST;
import com.bst.Node;
import com.exceptions.DepthException;
public class SearchTest {

    //Deja insertar y buscar el valor 2500, que debería estar fuera del rango.
    BST<Integer> bst;
    @org.junit.jupiter.api.BeforeEach
    void setUp() throws DepthException {
        bst = new BST<>();
        bst.insert(-2500, true);
        bst.insert(-2499, true);
        bst.insert(5, true);
        bst.insert(2498, false);
        bst.insert(2499, false);
        bst.insert(2500, false);
        bst.insert(350, true);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.CsvSource(value={
            "-2501, false",
            "-2500, true",
            "-2499, true",
            "5, true",
            "2498, true",
            "2499, true",
            "2500, false"
    })
    void searchPrueba(int p, boolean result)
    {
        Node<Integer> v = bst.search(p);

        boolean obtenido = (v != null);

        assertEquals(result, obtenido);

    }
}
