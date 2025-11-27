package utils;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import com.github.javafaker.Faker;

public class RandomUtils {
    private static final Faker faker = new Faker(new Locale("en"));



public String getRandomFirstName() {
    return faker.name().firstName();
    }
}

public String getRandomLastName() {
    return faker.;
}


    public static String getRandomEmail() {
        return getRandomString(10) + "@qa.guru";
    }

    public static String getRandomAddress() {
        return getRandomString(10) + " " + getRandomString(10) + " " + getRandomString(10);
    }

    public static String getRandomInt(int min, int max) {
        return String.valueOf(ThreadLocalRandom.current().nextInt(min, max + 1));
    }

    // +3 (263) 253 - 66 - 12
    public static String getRandomPhone() {
        return String.format("+%s (%s) %s - %s - %s", getRandomInt(1, 9), getRandomInt(111, 999),
                getRandomInt(111, 999), getRandomInt(11, 99), getRandomInt(11, 99));
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        return getRandomItemFromArray(genders);
    }

    public static String getRandomItemFromArray(String[] array) {
        int index = Integer.parseInt(getRandomInt(0, array.length - 1));

        return array[index];
    }

    public static String getRandomBirthDay() {
        return String.format(getRandomInt(1, 28));
    }

    public String getRandomBirthMonth() {

        return faker.options().option("January", "February", "March",
                "April", "May", "June",
                "July", "August", "September",
                "October", "November", "December");

    public static String getRandomBirthYear () {
        return String.valueOf(faker.number().numberBetween(1940, 2025)););

    }


    public static String getRandomSubject() {
        String[] subjects = {"Maths", "Chemistry", "Computer Science",
                "Commerce", "Economics"};

        return getRandomItemFromArray(subjects);
    }

    public String getRandomCity(String stateName) {
        return switch (stateName) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> throw new IllegalArgumentException("Некорректный штат");
        };
    }
}

