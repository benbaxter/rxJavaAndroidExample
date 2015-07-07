package com.benjamingbaxter.android.rxjavaexample.predicate;

import com.benjamingbaxter.android.rxjavaexample.model.Person;

import rx.functions.Func1;

/**
 * Created by bb77872 on 7/6/15.
 */
public class LastNameContainsPredicate implements Func1<Person, Boolean>
{
    String snippet;

    public LastNameContainsPredicate(String snippet)
    {
        this.snippet = snippet;
    }


    @Override
    public Boolean call(Person person)
    {
        if( person == null && snippet == null )
        {
            return true;
        }
        else if( person != null && snippet == null )
        {
            return false;
        }
        else if( person == null && snippet != null )
        {
            return false;
        }

        return person.lastName.toLowerCase().contains(snippet);
    }
}
