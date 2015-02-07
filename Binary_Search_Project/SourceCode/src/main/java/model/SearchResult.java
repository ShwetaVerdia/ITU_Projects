package model;

/**
 * Created by shweta14 on 12/12/2014.
 */
public class SearchResult {
    private Integer lineNumber;
    private Long timeTaken;
    private String searchMethod;
    private Long mergeSortTime;
    private String timeComplexity;


    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer index) {
        this.lineNumber = index;
    }

    public Long getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(Long timeTaken) {
        this.timeTaken = timeTaken;
    }

    public String getSearchMethod() {
        return searchMethod;
    }

    public void setSearchMethod(String searchMethod) {
        this.searchMethod = searchMethod;
    }

    public Long getMergeSortTime() {
        return mergeSortTime;
    }

    public void setMergeSortTime(Long mergeSortTime) {
        this.mergeSortTime = mergeSortTime;
    }

    public String getTimeComplexity() {
        return timeComplexity;
    }

    public void setTimeComplexity(String timeComplexity) {
        this.timeComplexity = timeComplexity;
    }
}
