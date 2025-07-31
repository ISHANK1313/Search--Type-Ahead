package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class TopKSuggestionsCache implements SuggestionCache{
    private final  SuggestionDataStructure dataStructure;

    @Autowired
    public TopKSuggestionsCache(SuggestionDataStructure dataStructure) {
        this.dataStructure = dataStructure;
    }

    @Override
    public List<Suggestion> getCachedSuggestions(String query) {
        return dataStructure.getTopSuggestions(query);
    }
}
