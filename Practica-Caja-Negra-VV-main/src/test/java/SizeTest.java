import com.bst.BST;
import com.exceptions.DepthException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Inicializamos varios arboles de distino tamaño para comprobar si la función size
//trabaja correctamente.
public class SizeTest {

    ArrayList<BST<Integer>> pruebaSize;
    @org.junit.jupiter.api.BeforeEach
    void setUp() throws DepthException {

       pruebaSize  = new ArrayList<>();
       for(int i = 0; i < 10; i++)
       {
           pruebaSize.add(new BST<Integer>());
           for(int j = 0 ; j < i+1; j++)
           {
               pruebaSize.get(i).insert(42*j, true);
           }
       }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "SizePrueba.csv", numLinesToSkip = 1, delimiterString = ",")
    void sizePrueba(int arbolID, int expectedSize)
    {
        assertEquals(pruebaSize.get(arbolID).size(), expectedSize);
    }
}
