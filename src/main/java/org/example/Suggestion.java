package org.example;

import java.util.Collection;

public class Suggestion  {
    public String getSuggestedText() {
        return suggestedText;
    }

    private final String suggestedText;

    public int getFrequency() {
        return frequency;
    }

    private final int frequency;

    public Suggestion(String suggest, int frequency) {
        this.suggestedText = suggest;
        this.frequency = frequency;
    }
}
