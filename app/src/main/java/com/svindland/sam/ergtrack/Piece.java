package com.svindland.sam.ergtrack;

import android.widget.Switch;

/**
 * Created by Sam on 5/24/2017.
 */

public class Piece {
    private int type;
    private int interval;
    private String time;
    private int distance;
    private String split;
    private int watts;
    private int cals;
    private int strokeRate;
    private int heartRate = 0;

    public Piece(int interval, String time, int distance, String split, int watts, int cals, int strokeRate, int heartRate) {
        this.interval = interval;
        this.time = time;
        this.distance = distance;
        this.split = split;
        this.watts = watts;
        this.cals = cals;
        this.strokeRate = strokeRate;
        this.heartRate = heartRate;
    }


    public String topLine() {
        switch(type) {
            case 0: return distance + "m " + time;
            case 1: return time + " " + distance + "m";

        }
        return "";
    }

    public String bottomLine() {
        return split + " - " + watts + "watts - " + cals + "cal";
    }
}
