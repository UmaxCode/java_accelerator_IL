package org.umaxcode.advancedJavaFeatures.exercise6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("Maxwell", 12),
                new Person("Ebenezer", 30),
                new Person("Jeffery", 26)
        );

        // Custom comparator to sort by age, then by name
        Comparator<Person> customComparator = Comparator
                .comparing(Person::getAge)
                .thenComparing(Person::getName);

        // Step 1: Sort the collection
        List<Person> sortedPeople = people.stream()
                .sorted(customComparator)
                .toList();

        System.out.println("Sorted People:");
        System.out.println(sortedPeople);

        // Step 2: Filter people from a specific Name
        List<Person> filteredPeople = sortedPeople.stream()
                .filter(person -> "Maxwell".equals(person.getName()))
                .toList();

        System.out.println("\nFiltered People:");
        System.out.println(filteredPeople);

        // Step 3: Transform to only names of people above 25 years old
        List<String> namesAbove25 = sortedPeople.stream()
                .filter(person -> person.getAge() > 25)
                .map(Person::getName)
                .toList();

        System.out.println("\nNames of People Above 25:");
        System.out.println(namesAbove25);

        // Step 4: Process to calculate the average age
        double averageAge = sortedPeople.stream()
                .mapToInt(Person::getAge)
                .average()
                .orElse(0.0);

        System.out.println("\nAverage Age: " + averageAge);
    }
}
