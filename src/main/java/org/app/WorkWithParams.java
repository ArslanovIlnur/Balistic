package org.app;

import java.util.ArrayList;
import java.util.List;

public class WorkWithParams {
    private final double v0;
    private final double angle;

    public WorkWithParams(double v0, double angle) {
        this.v0 = v0;
        this.angle = angle;
    }

    public double radians(){
        return Math.toRadians(angle);
    }

    public double xMax(){
        double xMax = (Math.pow(v0, 2) * Math.sin(2 * radians()))/9.8;
        return Math.ceil(xMax * 1000) / 1000;
    }

    public List<Double> getAllX(){
        List<Double> x = new ArrayList<>();

        for (double i=0; i<xMax(); i++){
            x.add(i);
        }
        x.add(xMax());
        return x;
    }

    public List<Double> getAllY(){
        List<Double> allY = new ArrayList<>();

        for (double x : getAllX()) {
            double y = x * Math.tan(radians()) -
                    ((9.8 * Math.pow(x, 2)) / (2 * Math.pow(v0, 2) * Math.pow(Math.cos(radians()), 2)));
            allY.add(Math.ceil(y * 1000) / 1000);
        }
        return allY;
    }
}
