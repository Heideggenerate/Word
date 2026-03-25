package infrastructure.repositories;

import domain.IWordsRepository;

import java.util.*;

public class WordsRepository implements IWordsRepository {

    private final TreeMap<String, Integer> wordCount = new TreeMap<>();
    private final TreeMap<Integer, List<String>> countWords = new TreeMap<>(COMPARE_BY_SIZE);

    public static Comparator<Integer> COMPARE_BY_SIZE = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    };

    public void insert(String word, int count, int prev) {
        wordCountInsert(word, count);
        countWordsInsert(word, prev, count);
    }


    private void countWordsInsert(String word, int prev, int cur) {
        if (countWords.get(cur) == null)
            countWords.put(cur, new ArrayList<>());
        if (countWords.get(prev) != null &&
                countWords.get(prev).isEmpty())
            countWords.remove(prev);
        countWords.get(cur).add(word);
    }


    private void wordCountInsert(String word, int count) {
        wordCount.put(word, count);
    }

    public void removeWord(int pos, String word) {
        countWords.get(pos).remove(word);
    }

     @Override
     public Integer getCount(String word) {
        return wordCount.get(word);
    }

     @Override
     public List<String> getWords(int count) {
        return countWords.get(count);
    }

     @Override
     public Set<String> getWordsKeys() {
        return wordCount.keySet();
    }

     @Override
     public Set<Integer> getCountKeys() {
        return countWords.keySet();
    }

}
