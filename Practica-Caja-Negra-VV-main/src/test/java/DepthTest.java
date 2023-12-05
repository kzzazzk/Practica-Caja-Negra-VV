import com.bst.BST;
import com.exceptions.BetweenLevelException;
import com.exceptions.DepthException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Casos Válidos: El BST está dentro del rango de profundidad 1-50
               El BST está vacío
Casos Inválidos: El BST es null y por ende no se puede conseguir la profundidad
 */
public class DepthTest {
    ArrayList<BST<Integer>> bstArrayList = new ArrayList<>();
    @org.junit.jupiter.api.BeforeEach
    void setUp() throws DepthException {
        bstArrayList = new ArrayList<>();

        for (int i = 0; i <= 50; i++) {
            bstArrayList.add(new BST<>());
        }

        for (int i = 0; i <= 50; i++) {
            for (int j = 1; j < i+1; j++) {
                bstArrayList.get(i).insert(j, false);
            }
        }
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/DepthTest.csv", numLinesToSkip = 1, delimiterString = ",")
    void depthTest(int content, int depth)
    {
        assertEquals(bstArrayList.get(content).depth(),depth);
    }
    @Test
    void checkNull() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            BST<Integer> bst = null;
            bst.depth();
        });
    }
    @Test
    void checkEmpty(){
        BST<Integer> bst = new BST<>();
        assertEquals(0,bst.depth());
    }
}
