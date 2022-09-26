import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jacky", "Sasha", "Avery", "Ari", "Jey", "Blake", "Emerson", "Harper", "Kai", "Skylar");
        List<String> families = Arrays.asList("Parker", "Lincoln", "River", "Wilson", "Davies", "Adamson", "Brown", "Hall", "Hunter", "Holland");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        /*
         * получение кол-ва несовершеннолетних.
         */
        persons.stream()
                .filter(person -> person.getAge() < 18)
                .count();

        /*
         * получениe списка фамилий призывников.
         */
        List<String> asList = persons.stream()
                .filter(person -> person.getAge() >= 18
                                  && person.getAge() < 27)
                .filter(person -> person.getSex() == Sex.MAN)
                .map(Person::getFamily)
                .collect(Collectors.toList());

        /*
         * получение отсортированного по фамилии списка
         * потенциально работоспособных людей с высшим образованием.
         */
        List<String> asList2 = persons.stream()
                .filter(person -> person.getEducation() == Education.HIGHER)
                .filter(person -> person.getAge() >= 18)
                .filter(person -> (person.getSex() == Sex.WOMAN && person.getAge() < 60)
                                  || (person.getSex() == Sex.MAN && person.getAge() < 65))
                .map(Person::getFamily)
                .collect(Collectors.toList());
    }
}
