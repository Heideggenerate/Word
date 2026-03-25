package application;

import domain.IEntityGateway;
import domain.IWordsRepository;
import domain.counter.IWordsApplication;

import java.util.List;

public class WordsApplication implements IWordsApplication {

    private final IEntityGateway getaway;
    private final IWordsRepository repository;

    public WordsApplication(IEntityGateway getaway, IWordsRepository repository) {
        this.getaway = getaway;
        this.repository = repository;
    }

    @Override
    public void fill() {
        List<String> lines = getaway.readLines();
        for (String line : lines) {
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
        return prevPos;
    }

    private String[] extractWords(String line) {
        return line.split(" ");
    }
}
