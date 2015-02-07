package processor;

import model.SearchResult;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by shweta14 on 12/13/2014.
 */
public class WordFileProcessorTest {
     @Test
     public void testWordSearch() {
        WordFileProcessor wfp = new WordFileProcessor();
        List<SearchResult> result = wfp.getSearchResult("C:\\Users\\shweta14\\Desktop\\DataStructureProject\\Data\\dictionary.txt", "zzzz");
        for(SearchResult myResult : result){
            assertNotNull(myResult.getTimeTaken());
            assertTrue(myResult.getLineNumber() > 0);
            if(myResult.getSearchMethod().equalsIgnoreCase("Binary Search")){
                assertEquals(myResult.getTimeComplexity(), "O ( log n )");
            }

            if(myResult.getSearchMethod().equalsIgnoreCase("Linear Search")){
                assertEquals(myResult.getTimeComplexity(), "O ( n )");
            }
        }
    }

    @Test
     public void testWordSearchWordNotPresentInTheFile() {
        WordFileProcessor wfp = new WordFileProcessor();
        List<SearchResult> result = wfp.getSearchResult("C:\\Users\\shweta14\\Desktop\\DataStructureProject\\Data\\dictionary.txt", "5979875kfhuhsvbjsbjbf ");
        for(SearchResult myResult : result){

            assertNotNull(myResult.getTimeTaken());
            assertTrue(myResult.getLineNumber() < 0);
            if(myResult.getSearchMethod().equalsIgnoreCase("Binary Search")){
                assertEquals(myResult.getTimeComplexity(), "O ( log n )");
            }

            if(myResult.getSearchMethod().equalsIgnoreCase("Linear Search")){
                assertEquals(myResult.getTimeComplexity(), "O ( n )");

            }
        }
    }
}
