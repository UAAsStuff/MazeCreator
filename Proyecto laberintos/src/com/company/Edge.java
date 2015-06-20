package com.company;

import java.util.ArrayList;

public class Edge {
    public Edge(int x1, int x2, int y1, int y2, int distance) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.distance = distance;
    }

    public int  x1,
                x2,
                y1,
                y2;
    public int distance;

    @Override
    public String toString(){
        String s;
        s = "";
        s += Integer.toString(x1) + "," + Integer.toString(y1) + "-"
                + Integer.toString(x2) + "," + Integer.toString(y2);
        s += " ->" + Integer.toString(distance);
        return s;
    }
}
