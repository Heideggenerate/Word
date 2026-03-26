package domain.counter;

import java.util.ArrayList;
import java.util.List;

public class WordsCounter {

    public List<String> correctWords(String[] words) {
        List<String> correctWords = new ArrayList<>(words.length);
        for (String word : words) {
            char lastCh = word.charAt(word.length() - 1);
            if (lastCh == ' ' || lastCh == ',' || lastCh == '.') {
                if (word.length() == 1)
                    continue;
                word = word.substring(0, word.length() - 1);
            }
            correctWords.add(word);
        }
        return correctWords;
    }

}
