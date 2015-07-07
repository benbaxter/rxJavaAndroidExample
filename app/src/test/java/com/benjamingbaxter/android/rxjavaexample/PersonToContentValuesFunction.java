package com.benjamingbaxter.android.rxjavaexample;

import android.content.ContentValues;

import com.benjamingbaxter.android.rxjavaexample.model.Person;

import rx.functions.Func1;

/**
 * Created by bb77872 on 7/7/15.
 */
public class PersonToContentValuesFunction implements Func1<Person, ContentValues>
{
    @Override
    public ContentValues call(Person person)
    {
        ContentValues values = new ContentValues();
        values.put("firstName", person.firstName);
        values.put("lastName", person.lastName);
        return values;
    }
}
