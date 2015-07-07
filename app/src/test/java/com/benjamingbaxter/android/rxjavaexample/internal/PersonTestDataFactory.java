package com.benjamingbaxter.android.rxjavaexample.internal;

import com.benjamingbaxter.android.rxjavaexample.model.Person;

import java.util.Arrays;
import java.util.List;

/**
 * Created by bb77872 on 7/7/15.
 */
public class PersonTestDataFactory
{
    public static List<Person> createAndroidTeam()
    {
        return Arrays.asList(
                createGrumpyCat(),
                createClark(),
                createBaxter(),
                createSampada(),
                createRoth(),
                createGutter());
    }

    public static Person createRoth()
    {
        return createPerson("Eric", "Roth");
    }

    public static Person createClark()
    {
        return createPerson("Michael", "Clark");
    }

    public static Person createGrumpyCat()
    {
        return createPerson("Grumpy", "Cat");
    }

    public static Person createGutter()
    {
        return createPerson("Steve", "Gutter");
    }

    public static Person createSampada()
    {
        return createPerson("Sampada", "Kadam");
    }

    public static Person createBaxter()
    {
        return createPerson("Benjamin", "Baxter");
    }

    public static Person createPerson(String firstName, String lastName)
    {
        return new Person(firstName, lastName);
    }
}
