import application.WordsApplication;
import infrastructure.repositories.WordsRepository;

void main() {

    WordsRepository repository = new WordsRepository();
    repository.insert("Opa", 5, 1);
    repository.insert("Opa", 10, 5);
}
