package domain;

import java.util.Set;
import java.util.TreeMap;

public class WordRepository {

    private final TreeMap<String, Integer> wordCount = new TreeMap<>();

    public void insert(String word, int count) {
        int sum = 0;
        if (wordCount.get(word) != null)
            sum += wordCount.get(word);
        wordCount.put(word, sum + count);
    }

    public void remove(String word) {
        wordCount.remove(word);
    }

    public int getCount(String word) {
        return wordCount.get(word);
    }

    public Set<String> getKeys() {
        return wordCount.keySet();
    }

}
