import com.bst.BST;
import com.bst.Node;
import com.exceptions.BetweenLevelException;
import com.exceptions.DepthException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
/*
Casos Válidos: El nodo pasado está contenido en el árbol
Casos Inválidos: El nodo no está contenido en el árbol
                 El nodo es null
                 El BST es null
 */
class GetSubTreeTest {
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
    @CsvFileSource(resources = "/GetSubTreeTest.csv", numLinesToSkip = 1, delimiterString = "·")
    void subTreeTest(int content, String subTreeList)
    {
        try{
            Node expectedRoot = bst.search(content);
            BST<Integer> expectedTree = bst.getSubTree(expectedRoot);
            assertEquals(expectedTree.printBetweenLevel(1, expectedTree.depth()).toString(), subTreeList);
        }
        catch (IllegalArgumentException e){
            assertEquals("IllegalArgumentException", e.getClass().getSimpleName(),"Nodo no pertenece a árbol");
        } catch (BetweenLevelException e) {
            assertEquals("BetweenLevelException", e.getClass().getSimpleName());
        }
    }
    @Test
    void checkNullValue() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            bst.getSubTree(null);
        });
    }
    @Test
    void checkNullObject() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            BST<Integer> bst = null;
            Node node = bst.search(600);
            bst.getSubTree(node);
        });
    }
}