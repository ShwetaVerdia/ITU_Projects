package processor;

import ds.StringBinarySearch;
import ds.StringLinearSearch;
import ds.StringMergeSort;
import model.SearchResult;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shweta14 on 12/12/2014.
 */
public class WordFileProcessor {
       /**<pre>
     * Description:
     * Read the given file and populate the list out of it.
     * @param fileName
     * @return List of words in the file (Pre condition: One word per line)
     * </pre>
     */
    private List<String> getLinesIfFileExists(String fileName) {
        List<String> list = new ArrayList<>();
        File file = new File(fileName);
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;

            while ((text = reader.readLine()) != null) {
                list.add(text);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }
        return list;
    }

    /**
     * <pre>
     * Does all the tasks in order to populate the response.
     * Following are the tasks:
     * 1. Read file
     * 2. If file has words, processing happens, nothing returned otherwise.
     * 3. For Binary Search, sorted input is needed.
     *    - The file is sorted first and then handed of to search the word from sorted list to the search method.
     * 4. For Linear Search, no such requirement is there,
     *    It can perform based on the input file y'ou have entered and also depends on whether the entries are sorted.
     * @param fileName
     * @param key
     * @return List of search results
     * </pre>
     */
    public List<SearchResult> getSearchResult(String fileName, String key) {
        List<SearchResult> results = new ArrayList<>();

        long start = 0L;
        SearchResult binarySearchResult = new SearchResult();
        SearchResult linearSearchResult = new SearchResult();
        //1
        List<String> fileLines = getLinesIfFileExists(fileName);

        if(fileLines.size() > 0){
            //2
            // Sort the file
            start = System.nanoTime();// clock starts
            List<String> sortedFile = StringMergeSort.mergeSort(fileLines);// merge sort happens
            long mergeSortTime = System.nanoTime() - start; //calculate total time


            //Binary search result
            StringBinarySearch stringBinarySearch = new StringBinarySearch();
            start = System.nanoTime();
            binarySearchResult.setLineNumber(stringBinarySearch.getIndexOfTheKey(sortedFile, key));
            binarySearchResult.setTimeTaken(System.nanoTime() - start);
            binarySearchResult.setSearchMethod("Binary Search");
            binarySearchResult.setTimeComplexity("O ( log n )");
            binarySearchResult.setMergeSortTime(mergeSortTime);
            results.add(binarySearchResult);

            //Linear search result
            StringLinearSearch stringLinearSearch = new StringLinearSearch();
            start = System.nanoTime();
            linearSearchResult.setLineNumber(stringLinearSearch.getIndexOfTheKey(fileLines, key));
            linearSearchResult.setTimeTaken(System.nanoTime() - start);
            linearSearchResult.setSearchMethod("Linear Search");
            linearSearchResult.setTimeComplexity("O ( n )");
            linearSearchResult.setMergeSortTime(mergeSortTime);
            results.add(linearSearchResult);
        }

        return results;
    }
}
