package domain;

import java.util.List;
import java.util.Set;

public interface IWordsRepository {

    public void insert(String word, int prev, int count);

    public Integer getCount(String word);

    public List<String> getWords(int count);

    public Set<String> getWordsKeys();

    public Set<Integer> getCountKeys();

}
