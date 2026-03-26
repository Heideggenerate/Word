package application;

import domain.IWordsRepository;
import domain.counter.IWordsApplication;
import infrastructure.adapters.FileWordsAdapter;

public class TempWordsApplication implements IWordsApplication {

    private final FileWordsAdapter adapter;
    private final IWordsRepository repository;

    public TempWordsApplication(FileWordsAdapter adapter, IWordsRepository repository) {
        this.adapter = adapter;
        this.repository = repository;
    }

    @Override
    public void fill(int n) {

    }
}
