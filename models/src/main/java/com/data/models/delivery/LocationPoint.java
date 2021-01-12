package com.data.models.delivery;

import org.springframework.data.geo.Point;

/**
 * @author: mohamed Imam
 * Email : mohamed.imam@tirhal.net
 * Date : on 01/03/2021  : 10:52
 */
public class LocationPoint {
    double x;
    double y;

    public LocationPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    public Point toPoint(){
        return new Point(getX(),getY());

    }
}
