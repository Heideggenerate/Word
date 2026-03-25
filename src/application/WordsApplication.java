package application;

import domain.IEntityGetaway;
import domain.counter.IWordsApplication;
import infrastructure.repositories.WordsRepository;

public class WordsApplication implements IWordsApplication {

    private final IEntityGetaway getaway;
    private final WordsRepository repository;

    public WordsApplication(IEntityGetaway getaway, WordsRepository repository) {
        this.getaway = getaway;
        this.repository = repository;
    }

    @Override
    public void fill() {
        String line;
        while ((line = getaway.readLine()) != null) {
            String[] words = extractWords(line);
            for (String word : words) {
                int insideCount = wordCountInsert(word, 1);
                repository.insert(word, insideCount, countWordsInsert(word, insideCount, 1));
            }
        }
    }

    public int wordCountInsert(String word, int count) {
        int sum = 0;
        if (repository.getCount(word) != null)
            sum += repository.getCount(word);
        return sum + count;
    }

    private int countWordsInsert(String word, int insideCount, int count) {
        int prevPos = insideCount - count;
        if (repository.getWords(prevPos) != null) {
            repository.getWords(prevPos).remove(word);
        }
        return prevPos;
    }

    private String[] extractWords(String line) {
        return line.split(" ");
    }
}
