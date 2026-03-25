package domain;

import java.util.*;

public class WordRepository {

    private final TreeMap<String, Integer> wordCount = new TreeMap<>();
    private final TreeMap<Integer, List<String>> countWords = new TreeMap<>(COMPARE_BY_SIZE);

    public void insert(String word, int count) {
        wordCountInsert(word, count);
        countWordsInsert(word, count);
    }

    private void countWordsInsert(String word, int count) {
        int insideCount = getCount(word);
        int prevPos = insideCount - count;
        if (countWords.get(insideCount) == null)
            countWords.put(insideCount, new ArrayList<>());
        if (countWords.get(prevPos) != null) {
            countWords.get(prevPos).remove(word);
            if (countWords.get(prevPos).isEmpty())
                countWords.remove(prevPos);
        }
        countWords.get(insideCount).add(word);
    }

    private void wordCountInsert(String word, int count) {
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

    public List<String> getWords(int count) {
        return countWords.get(count);
    }

    public Set<String> getWordsKeys() {
        return wordCount.keySet();
    }

    public Set<Integer> getCountKeys() {
        return countWords.keySet();
    }

    public static Comparator<Integer> COMPARE_BY_SIZE = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    };
}
