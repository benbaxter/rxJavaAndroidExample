package com.benjamingbaxter.android.rxjavaexample;

import com.benjamingbaxter.android.rxjavaexample.model.Person;
import com.benjamingbaxter.android.rxjavaexample.predicate.LastNameContainsPredicate;

import org.junit.Test;

import java.util.List;

import rx.Observable;

import static com.benjamingbaxter.android.rxjavaexample.internal.PersonTestDataFactory.createAndroidTeam;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by bb77872 on 7/7/15.
 */
public class CountingExampleTest
{

    @Test
    public void counting_oldWay() throws Exception
    {
        //filter for last names that contain an 'a'
        //Cat
        //Clark
        //Baxter
        //Kadam

        //exlude these
        //Roth
        //Gutter

        List<Person>  team = createAndroidTeam();
        int count = 0;
        for(Person p : team )
        {
            if( p.lastName.toLowerCase().contains("a") )
            {
                ++count;
            }
        }

        assertThat(count, is(equalTo(4)));
    }

    @Test
    public void counting_functionalWay() throws Exception
    {
        int count = Observable
                        .from(createAndroidTeam())
                        .filter(new LastNameContainsPredicate("a"))
                        .count()
                        .toBlocking()
                        .first();

        assertThat(count, is(equalTo(4)));
    }

}