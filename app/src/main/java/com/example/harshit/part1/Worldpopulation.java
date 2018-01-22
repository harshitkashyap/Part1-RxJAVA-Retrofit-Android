package com.example.harshit.part1;

/**
 * Created by Harshit on 1/21/2018.
 */

public class Worldpopulation
{
    private String rank;

    private String flag;

    private String population;

    private String country;

    public String getRank ()
    {
        return rank;
    }

    public void setRank (String rank)
    {
        this.rank = rank;
    }

    public String getFlag ()
    {
        return flag;
    }

    public void setFlag (String flag)
    {
        this.flag = flag;
    }

    public String getPopulation ()
    {
        return population;
    }

    public void setPopulation (String population)
    {
        this.population = population;
    }

    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [rank = "+rank+", flag = "+flag+", population = "+population+", country = "+country+"]";
    }
}

