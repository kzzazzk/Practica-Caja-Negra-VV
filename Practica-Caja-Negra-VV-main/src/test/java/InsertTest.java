import static org.junit.jupiter.api.Assertions.*;
import com.bst.BST;
import com.exceptions.DepthException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
/*
    [-2500, 2500)
    min-:-2501
    min: -2500
    min+: -2499
    nominal: 1000
    max-: 2498
    max: 2499
    max+: 2500
    Falla con max+ (2500), supondremos que esto es porque en la implementación algo falla.
 */
class InsertTest {
    BST<Integer> bst = new BST<>();
    @ParameterizedTest
    @CsvFileSource(resources = "/InsertTest.csv", numLinesToSkip = 1, delimiterString = ",")
    void insertTest(int content, boolean recursive, boolean expectedSuccess) {
        try {
            bst.insert(content, recursive);
            assertTrue(expectedSuccess);
        } catch (DepthException e) {
            assertEquals("DepthException", e.getClass().getSimpleName());
        }
        catch (IllegalArgumentException e){
            assertEquals("IllegalArgumentException", e.getClass().getSimpleName());
        }
    }
}