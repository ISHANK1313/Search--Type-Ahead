package org.example;

import java.util.ArrayList;
import java.util.List;

public class TrieNode {
    public boolean isEOW() {
        return isEOW;
    }

    public void setEOW(boolean EOW) {
        this.isEOW = EOW;
    }

    private  boolean isEOW;

    public List<TrieNode> getPointers() {
        return pointers;
    }

    private final List<TrieNode>pointers;

    public TrieNode() {
        this.isEOW = false;

        this.pointers=new ArrayList<>();
        for(int i=0;i<26;i++){
            this.pointers.add(null);
        }
        this.TopSuggestions=new ArrayList<>();
    }

    public List<Suggestion> getTopSuggestions() {
        return TopSuggestions;
    }

    public void setTopSuggestions(List<Suggestion> topSuggestions) {
        TopSuggestions = topSuggestions;
    }

    private List<Suggestion> TopSuggestions;


}
