package infrastructure.repositories;

import domain.IEntityGateway;
import domain.InputGateway;
import entities.WordsCount;

import java.util.*;

public class FileWordsRepository {

    private final InputGateway input;
    private final IEntityGateway gateway;

    public FileWordsRepository(InputGateway input, IEntityGateway gateway) {
        this.input = input;
        this.gateway = gateway;
    }


    public void insert(List<WordsCount> wordsCounts) {
        for (WordsCount wordCount : wordsCounts) {
            StringBuilder builder = new StringBuilder();
            List<String> words = wordCount.words();
            builder.append(wordCount.count());
            for (String word : words) {
                builder.append(" ").append(word);
            }
        }
    }

    public Set<Integer> getCountKeys() {
        Set<Integer> keys = new HashSet<>();
        List<String> lines = gateway.readLines();
        for (String line : lines) {
            keys.add(Integer.parseInt(line.substring(0, line.indexOf(" "))));
        }
        gateway.reset();
        return keys;
    }

    public List<String> getWords(int count) {
        List<String> lines = gateway.readLines();
        List<String> words = null;
        for (String line : lines) {
            int countEndPos = line.indexOf(" ");
            if (Integer.parseInt(line.substring(0, countEndPos)) == count)
                words = Arrays.asList(line.substring(countEndPos + 1).split(" "));
        }
        return words;
    }



}
