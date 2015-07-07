package com.benjamingbaxter.android.rxjavaexample;

import android.content.ContentValues;
import android.test.suitebuilder.annotation.SmallTest;

import com.benjamingbaxter.android.rxjavaexample.model.Person;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

import static com.benjamingbaxter.android.rxjavaexample.internal.PersonTestDataFactory.createAndroidTeam;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

/**
 * Created by bb77872 on 7/7/15.
 */
@SmallTest
public class MappingExampleTest
{

    @Test
    public void mapping_oldWay() throws Exception
    {
        List<ContentValues> values = convertPeopleToContentValues(createAndroidTeam());

        assertThat(values, is(not(empty())));
        assertThat(values, hasSize(6));
    }

    public static List<ContentValues> convertPeopleToContentValues(List<Person> people)
    {
        List<ContentValues> values = new ArrayList<>();
        for(Person p : people )
        {
            values.add(convertPersonToContentValues(p));
        }
        return values;
    }

    public static ContentValues convertPersonToContentValues(Person person)
    {
        ContentValues values = new ContentValues();
        values.put("firstName", person.firstName);
        values.put("lastName", person.lastName);
        return values;
    }

    @Test
    public void mapping_functionalWay() throws Exception
    {
        List<ContentValues> values =
                Observable
                        .from(createAndroidTeam())
                        .map(new PersonToContentValuesFunction())
                        .toList()
                        .toBlocking()
                        .first();


        assertThat(values, is(not(empty())));
        assertThat(values, hasSize(6));
    }
}