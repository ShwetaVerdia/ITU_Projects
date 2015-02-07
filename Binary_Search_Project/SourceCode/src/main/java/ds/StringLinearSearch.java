package ds;

import java.util.List;

/**
 * Created by shweta14 on 12/12/2014.
 */
public class StringLinearSearch {
    /**
     * <pre>
     * <a href="http://en.wikipedia.org/wiki/Linear_search">Linear Search On Wiki</a>
     * @param sortedStringList
     * @param key
     * @return return the index of the word if found, -1 otherwise
     * </pre>
     */
    public int getIndexOfTheKey(List<String> sortedStringList, String key){
        String[] source = new String[sortedStringList.size()];
        source = sortedStringList.toArray(source);

        int index = -1;

        for(int i = 0 ; i < source.length ; i++){
            if(source[i].equals(key)){
                return i;
            }
        }

        return index;
    }
}
