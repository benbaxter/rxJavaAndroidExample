package com.benjamingbaxter.android.rxjavaexample.predicate;

import com.benjamingbaxter.android.rxjavaexample.model.Person;

import rx.functions.Func1;

/**
 * Created by bb77872 on 7/6/15.
 */
public class LastNameEqualPredicate implements Func1<Person, Boolean>
{
    String lastName;

    public LastNameEqualPredicate(String lastName)
    {
        this.lastName = lastName;
    }


    @Override
    public Boolean call(Person person)
    {
        if( person == null && lastName == null )
        {
            return true;
        }
        else if( person != null && lastName == null )
        {
            return false;
        }
        else if( person == null && lastName != null )
        {
            return false;
        }

        return person.lastName.equals(lastName);
    }
}
