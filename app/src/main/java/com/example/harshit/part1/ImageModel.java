package com.example.harshit.part1;

import java.util.List;

/**
 * Created by Harshit on 1/21/2018.
 */

public class ImageModel
{
    private Worldpopulation[] worldpopulation;

    public Worldpopulation[] getWorldpopulation ()
    {
        return worldpopulation;
    }

    public void setWorldpopulation (Worldpopulation[] worldpopulation)
    {
        this.worldpopulation = worldpopulation;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [worldpopulation = "+worldpopulation+"]";
    }
}