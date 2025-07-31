package org.example;

import java.util.List;

public interface SuggestionCache {
    List<Suggestion> getCachedSuggestions(String query);
}
