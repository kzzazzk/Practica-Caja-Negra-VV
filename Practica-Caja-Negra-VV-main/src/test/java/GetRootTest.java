import com.bst.BST;
import com.exceptions.DepthException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;
/*
Casos Válidos: Todos los posibles valores de raíz [-2500, 2500)
Casos Inválidos: El BST está vacío y por ende no se puede conseguir el nodo raíz
                 El BST es null y por ende no se puede conseguir el nodo raíz
 */
public class GetRootTest {
    ArrayList<BST<Integer>> bstArrayList = new ArrayList<>();
    ArrayList<Set<Integer>> generatedNumbersList = new ArrayList<>();
    Random random = new Random(78);

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws DepthException {
        bstArrayList = new ArrayList<>();
        generatedNumbersList = new ArrayList<>();  // Initialize the list

        for (int i = -2500; i < 2500; i++) {
            Set<Integer> aux = new HashSet<>();
            aux.add(i);
            bstArrayList.add(new BST<>(i));
            generatedNumbersList.add(aux);// Add a new HashSet for each BST
        }

        for (int i = 0; i < 5000; i++) {
            Set<Integer> generatedNumbers = generatedNumbersList.get(i);
            for (int j = 0; j < 50; j++) {
                int randomNumber;
                do {
                    randomNumber = random.nextInt(5000) - 2500;
                } while (!generatedNumbers.add(randomNumber));

                bstArrayList.get(i).insert(randomNumber, false);
            }
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/GetRootTest.csv", numLinesToSkip = 1, delimiterString = ";")
    void getRootTest(int index,int root) {
        assertEquals(bstArrayList.get(index).getRoot().getContent(),root);
    }
    @Test
    void checkNull() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            BST<Integer> bst = null;
            bst.getRoot();
        });
    }
    @Test
    void checkEmpty(){
        BST<Integer> bst = new BST<>();
        assertEquals(bst.getRoot(), null);
    }
}
