import domain.EntityGetaway;
import domain.WordRepository;
import infrastructure.Reader;

void main() {

    WordRepository repository = new WordRepository();
    repository.insert("word", 1);

    Set<String> keys = repository.getKeys()
}
