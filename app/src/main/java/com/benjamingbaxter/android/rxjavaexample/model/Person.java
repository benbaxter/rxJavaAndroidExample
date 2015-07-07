package com.benjamingbaxter.android.rxjavaexample.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by bb77872 on 7/6/15.
 */
public class Person
{
    public String firstName;
    public String lastName;

    public Person(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int hashCode()
    {
        return HashCodeBuilder.reflectionHashCode(31, 17, this);
    }

    @Override
    public boolean equals(Object o)
    {
        return EqualsBuilder.reflectionEquals(this, o);
    }
}
