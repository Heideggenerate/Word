package domain;

import java.util.Set;
import java.util.TreeMap;

public class WordRepository {

    private final TreeMap<String, Integer> wordCount = new TreeMap<>();

    public void insert(String word, int count) {
        wordCount.put(word, count);
    }

    public void remove(String word) {
        wordCount.remove(word);
    }

    public int getCount(String word) {
        return wordCount.get(word);
    }

    public Set<String> getKeys(String word) {
        return wordCount.keySet();
    }

}
