package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search_type_ahead")
public class SearchTypeAheadController {
private final SuggestionsManager suggestionsManager;
private final QueryUpdater queryUpdater;
    @Autowired
    public SearchTypeAheadController(SuggestionsManager suggestionsManager,QueryUpdater queryUpdater){
    this.queryUpdater=queryUpdater;
    this.suggestionsManager=suggestionsManager;
  }
  @RequestMapping(method = RequestMethod.GET,path = "/suggestions")
    public List<Suggestion> getSuggestionsForQuery(@RequestParam String query){
        if(query==null||query.length()==0){
            throw new RuntimeException();
        }
        return this.suggestionsManager.getSuggestions(query);
  }
  @RequestMapping(method = RequestMethod.POST,path="/update")
    public String updateQueries(@RequestParam String query){
        if(query==null||query.length()==0){
            throw new RuntimeException("Invalid query");
        }
        this.queryUpdater.update(query);
        return "Successfully updated";
  }

}
