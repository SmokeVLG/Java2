import java.util.*;

/**
 * Java 2 home work for Lesson 3
 * author Denisov Maxim
 * date 22/08/2018
 *
 * @link https://github.com/SmokeVLG/Java2/blob/master/HomeWork3.java
 */
public class HomeWork3 {
    public static void main(String[] args) {
        //task 1
        List<String> words = Arrays.asList("one", "two", "three", "three", "three", "three", "six", "seven", "seven", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen");
        System.out.printf("words - >%s", words.toString());
        //get unique words
        HashSet<String> uniqueWords = new HashSet<>(words);
        System.out.printf("\nunique words - >%s", uniqueWords.toString());
        //get count words
        for (String curWord : uniqueWords) {
            System.out.printf("\n%s->%s", curWord, Collections.frequency(words, curWord));
        }

        //task2
        References references = new References();
        references.add("Denisov", "8-988-959-85-08");
        references.add("Ivanov", "1-111-111-11-11");
        references.add("Petrov", "2-222-222-22-22");
        references.add("Petrov", "3-333-333-33-33");
        //get 1 number
        references.get("Ivanov");
        //get 2 number
        references.get("Petrov");

    }

    private static class References {
        HashMap<String, String> references = new HashMap<>();

        HashMap<String, String> getReferences() {
            return references;
        }

        void add(String surname, String phoneNumber) {
            getReferences().put(phoneNumber, surname);
        }

        void get(String surname) {
            Set<Map.Entry<String, String>> set = getReferences().entrySet();
            for (Map.Entry<String, String> o : set) {
                if (o.getValue().equals(surname)) {
                    System.out.printf("\n Phone number by surname %s->%s", surname, o.getKey());
                }
            }
            getReferences().get(surname);
        }
    }
}
