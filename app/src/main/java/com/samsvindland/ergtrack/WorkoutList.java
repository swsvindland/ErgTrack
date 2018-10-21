package com.samsvindland.ergtrack;

import java.sql.Time;
import java.util.ArrayList;

/**
 * Created by Sam on 6/1/2017.
 */

public class WorkoutList {
    private ArrayList<Workout> list;

    public WorkoutList() {
        list = new ArrayList<>();

        Workout workout00 = new Workout();
        workout00.setDistance(10000);
        list.add(workout00);

        Workout workout01 = new Workout();
        workout01.setDistance(500);
        workout01.setInterval(8);
        workout01.setRest(new Time(0,2,0));
        list.add(workout01);

        Workout workout02 = new Workout();
        workout02.setDistance(5000);
        workout02.setInterval(2);
        workout02.setRest(new Time(0,4,0));
        list.add(workout02);

        Workout workout03 = new Workout();
        workout03.setTime(new Time(0,3,0));
        workout03.setInterval(4);
        workout03.setRest(new Time(0,3,0));
        list.add(workout03);

        Workout workout04 = new Workout();
        workout04.setTime(new Time(0,20,0));
        workout04.setInterval(2);
        list.add(workout04);

        Workout workout05 = new Workout();
        workout05.setDistance(1000);
        workout05.setInterval(6);
        workout05.setRest(new Time(0,2,0));
        list.add(workout05);


    }

    public  ArrayList<Workout> getList() {
        return list;
    }
}
