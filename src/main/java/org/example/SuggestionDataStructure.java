package org.example;

import java.util.List;

public interface SuggestionDataStructure {
    void init(int maxSuggestions);
    List<Suggestion> getTopSuggestions(String query);
    void reload();
}
