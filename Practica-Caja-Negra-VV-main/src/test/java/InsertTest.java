import static org.junit.jupiter.api.Assertions.*;
import com.bst.BST;

import com.exceptions.DepthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class InsertTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/InsertTest.csv", numLinesToSkip = 1, delimiterString = ",")
    void testInsert(int content, boolean recursive, boolean expectedSuccess) {
        BST<Integer> bst = new BST<>();
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