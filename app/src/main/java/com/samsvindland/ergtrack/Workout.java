package com.samsvindland.ergtrack;

import java.sql.Time;

/**
 * Created by Sam on 6/1/2017.
 */

public class Workout {
    private int interval;
    private Time time;
    private int distance;
    private int strokeRate;
    private Time rest;

    public Workout() {
        interval = 1;
        time = new Time(0, 0, 0);
        distance = 0;
        strokeRate = 0;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setStrokeRate(int strokeRate) {
        this.strokeRate = strokeRate;
    }

    public void setRest(Time rest) {
        this.rest = rest;
    }

    public String toString() {
        if(interval == 1 && distance > 0)
            return "Row: "  + distance + " m";
        else if(interval == 1 && time.getTime() > 0)
            return "Row: " + time.toString() + " minutes";
        else if(distance > 0)
            return "Row: " +  interval + " by " + distance + " m";
        else
            return "Row: " + interval + " by " + time.toString() + " minutes";
    }

}
