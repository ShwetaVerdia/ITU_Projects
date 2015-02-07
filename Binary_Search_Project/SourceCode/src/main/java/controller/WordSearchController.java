package controller;

import model.SearchResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import processor.WordFileProcessor;


import java.util.List;

/**
 * Created by shweta14 on 12/12/2014.
 */
@Controller
public class WordSearchController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody List<SearchResult> searchWord(@RequestParam String fileName, @RequestParam String wordToSearch){
        WordFileProcessor processor = new WordFileProcessor();
        return processor.getSearchResult(fileName, wordToSearch);
    }

}