package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString implements Geometry {
    private List<Point> points;

    public LineString() {
        this.points = new ArrayList<Point>();
    }

    public LineString(List<Point> points) {
        for (Point point : points) {
            if (point.getCoordinate() == null) {
                throw new NullPointerException("points cannot be null");
            }
        }
        this.points = points;
    }


    public int getNumPoints() {
        return points.size();
    }

    public Point getPointN(int n) {
        return points.get(n);
    }

    @Override
    public String getType() {
        return "LineString";
    }


}

