package ge.tbc.testautomation.data;

import com.github.javafaker.Faker;

public class FakerDataGenerator {

    private static final Faker faker = new Faker();

    public static String randomEmail() {
        return faker.internet().emailAddress();
    }

    public static String randomSentence() {
        return faker.lorem().sentence();
    }
}