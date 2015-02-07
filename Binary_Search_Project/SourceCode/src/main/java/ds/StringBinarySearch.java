package ds;

import java.util.List;

/**
 * Created by shweta14 on 12/12/2014.
 */
public class StringBinarySearch {
    /**
     *<pre>
     * @see <a href="http://en.wikipedia.org/wiki/Binary_search_algorithm">Binary Search On Wiki</a>
     * @param sortedStringList
     * @param key
     * @return index of the found key
     * </pre>
     */
    public int getIndexOfTheKey(List<String> sortedStringList, String key){
        String[] source = new String[sortedStringList.size()];// list to array conversion
        source = sortedStringList.toArray(source);

        int low = 0;
        int high = source.length - 1;
        int firstOccurrence = Integer.MIN_VALUE;

        while (low <= high) {
            int middle = low + ((high - low) >>> 1);

            if (source[middle].equals(key)) {
                // key found and we want to search an earlier occurrence
                firstOccurrence = middle;
                high = middle - 1;
            } else if (source[middle].compareTo(key) < 0) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        if (firstOccurrence != Integer.MIN_VALUE) {
            return firstOccurrence;
        }
        return -(low + 1);  // key not found
    }
}
