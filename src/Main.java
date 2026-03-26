import application.WordsApplication;
import entities.WordsCount;
import infrastructure.repositories.FileWordsRepository;
import infrastructure.repositories.WordsRepository;
import infrastructure.sequencedaccess.*;

void main() {

    List<String> tempWords = new ArrayList<>();
    tempWords.add("Opa");
    tempWords.add("Test");
    tempWords.add("Jopa");

    List<String> tempWords2 = new ArrayList<>();
    tempWords2.add("Hoba");
    tempWords2.add("Boba");
    tempWords2.add("Test");

    List<WordsCount> words = new ArrayList<>();
    words.add(new WordsCount(5, tempWords));
    words.add(new WordsCount(6, tempWords2));

    try (Reader reader = new Reader("D:/programming/Words/read.txt");
    Writer writer = new Writer("D:/programming/Words/write.txt")) {
        FileWordsRepository repo = new FileWordsRepository(writer, reader);
        repo.insert(words);


        List<String> countWords = repo.getWords(5);
        for (String countWord : countWords)
            System.out.println(countWord);
    } catch (IOException ex) {
    }
}
