package infrastructure.repositories;

import domain.IWordsRepository;

import java.util.List;
import java.util.Set;

public class FileWordsRepository implements IWordsRepository {


    @Override
    public void insert(String word, int prev, int count) {

    }

    @Override
    public Integer getCount(String word) {
        return 0;
    }

    @Override
    public List<String> getWords(int count) {
        return List.of();
    }

    @Override
    public Set<String> getWordsKeys() {
        return Set.of();
    }

    @Override
    public Set<Integer> getCountKeys() {
        return Set.of();
    }
}
