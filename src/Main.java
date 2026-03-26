import entities.WordsCount;
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

    List<WordsCount> wordss = new ArrayList<>();
    wordss.add(new WordsCount(5, tempWords));
    wordss.add(new WordsCount(6, tempWords2));

    try (Reader reader = new Reader("D:/programming/Words/write.txt");
    Writer writer = new Writer("D:/programming/Words/write.txt")) {



    } catch (IOException ex) {
    }
}
