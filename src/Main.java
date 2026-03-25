import domain.WordRepository;

void main() {

    WordRepository repository = new WordRepository();
    repository.insert("word", 1);
    repository.insert("Opa", 3);
    repository.insert("Opa", 4);
    repository.insert("o", 20);

    Set<String> keys = repository.getWordsKeys();
    for (String key : keys) {
        System.out.println(key + " " + repository.getCount(key));
    }
    Set<Integer> keysInt = repository.getCountKeys();
    for (Integer key : keysInt) {
        System.out.println(key + " " + repository.getWords(key));
    }
}
