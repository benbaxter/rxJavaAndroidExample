package com.benjamingbaxter.android.rxjavaexample;

import android.test.suitebuilder.annotation.SmallTest;

import com.benjamingbaxter.android.rxjavaexample.model.Person;
import com.benjamingbaxter.android.rxjavaexample.predicate.LastNameEqualPredicate;

import org.junit.Test;

import java.util.List;

import rx.Observable;

import static com.benjamingbaxter.android.rxjavaexample.internal.PersonTestDataFactory.createAndroidTeam;
import static com.benjamingbaxter.android.rxjavaexample.internal.PersonTestDataFactory.createGutter;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by bb77872 on 7/6/15.
 */
@SmallTest
public class FilterExampleTest
{

    @Test
    public void filterForLastName_oldWay() throws Exception
    {

        Person gutter = null;
        List<Person> people = createAndroidTeam();
        for (int i = 0; i < people.size(); ++i)
        {
            Person p = people.get(i);
            if (p != null && p.lastName.equals("Gutter"))
            {
                gutter = p;
            }
        }

        assertThat(gutter, is(equalTo(createGutter())));
    }

    @Test
    public void filterForLastName_currentWay() throws Exception
    {

        Person gutter = null;
        for (Person p : createAndroidTeam())
        {
            if (p != null && p.lastName.equals("Gutter"))
            {
                gutter = p;
            }
        }

        assertThat(gutter, is(equalTo(createGutter())));
    }

    @Test
    public void filterForLastName_functionalWay() throws Exception
    {
        Person gutter = Observable.from(createAndroidTeam())
                .filter(new LastNameEqualPredicate("Gutter"))
                .toBlocking()
                .first();

        assertThat(gutter, is(equalTo(createGutter())));
    }
}