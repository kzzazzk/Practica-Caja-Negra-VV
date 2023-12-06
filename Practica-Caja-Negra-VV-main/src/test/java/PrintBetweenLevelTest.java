import com.bst.BST;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import com.exceptions.BetweenLevelException;
import com.exceptions.DepthException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*Para ambos valores a y b usamos:
+max=51, max = 50, -max = 49, nominal = 24, -min = 1, min = 0, +min = -1
*/

public class PrintBetweenLevelTest {
    BST<Integer> bst;
    @org.junit.jupiter.api.BeforeEach
    void setUp() throws DepthException {
        bst = new BST<>();

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
        bst.insert(1250, true);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "PrintBetweenPrueba.csv", numLinesToSkip = 1, delimiterString = ",")
    void PBLTest(int levelA, int levelB, int result) {
        try
        {
            List<Integer> esperado = new ArrayList<>();
            esperado.add(result);
            List<Integer> obtenido;
            obtenido = bst.printBetweenLevel(levelA, levelB);
            assertEquals(esperado, obtenido);

        } catch(BetweenLevelException betweenLevelException)
        {
            assertEquals("BetweenLevelException",
                    betweenLevelException.getClass().getSimpleName(),
                    "Excepcion entre niveles");
        }
    }
}
