package infrastructure.adapters;

import domain.IEntityGateway;
import domain.InputGateway;
import entities.WordsCount;

import java.util.*;

public class FileWordsAdapter {

    private final InputGateway input;
    private final IEntityGateway gateway;

    public FileWordsAdapter(InputGateway input, IEntityGateway gateway) {
        this.input = input;
        this.gateway = gateway;
    }


    public void insert(WordsCount wordCount) {
        StringBuilder builder = new StringBuilder();
        List<String> words = wordCount.words();
        builder.append(wordCount.count());
        for (String word : words) {
            builder.append(" ").append(word);
        }
        input.write(builder.toString());
    }

    public List<WordsCount> getData() {
        List<WordsCount> words = new ArrayList<>();
        List<String> lines = gateway.readLines();
        for (String line : lines) {
            int endPos = line.indexOf(" ");
            int count = Integer.parseInt(line.substring(0, endPos));
            words.add(new WordsCount(count, Arrays.asList(line.substring(endPos + 1).split(" "))));
        }
        return words;
    }




}
