import com.bst.BST;
import com.exceptions.BetweenLevelException;
import com.exceptions.DepthException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.ArrayList;
//Aprovechando que ha sido comprobada correctamente el comportamiento de
//PrintBewtweenLevel y depth, usamos estas dos funciones para comprobar el
//desmepeño de esta.
import static org.junit.jupiter.api.Assertions.assertEquals;
public class ToListTest {

    ArrayList<BST<Integer>> pruebaToList;
    @org.junit.jupiter.api.BeforeEach
    void setUp() throws DepthException {

        pruebaToList  = new ArrayList<>();
        for(int i = 0; i < 10; i++)
        {
            pruebaToList.add(new BST<>());
            for(int j = 0 ; j < i+1; j++)
            {
                pruebaToList.get(i).insert(j+1, true);
            }
        }
    }

    @Test
    void toListPrueba() throws BetweenLevelException {
        for(BST<Integer> bst : pruebaToList) {
           assertEquals(bst.toList(), bst.printBetweenLevel(1, bst.depth()));
        }
    }
}
