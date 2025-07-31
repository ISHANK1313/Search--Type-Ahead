package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SuggestionsManager {
    private final SuggestionCache suggestionCache;
    @Autowired
    public SuggestionsManager(SuggestionCache suggestionCache) {
        this.suggestionCache = suggestionCache;
    }

    public List<Suggestion>getSuggestions(String query){
        if(query.length()>Constants.MAX_QUERY_LIMIT)
            throw new RuntimeException("length out of limit");
        query=query.toLowerCase();
        return suggestionCache.getCachedSuggestions(query);
    }
}
