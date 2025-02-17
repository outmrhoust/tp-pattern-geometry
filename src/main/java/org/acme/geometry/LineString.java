package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString extends AbstractGeometry {
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

    @Override
    public boolean isEmpty() {
        return points.isEmpty();
    }

    @Override
    public void translate(double dx, double dy) {
        for (Point point : points) {
            point.translate(dx, dy);
        }
    }
    @Override
    public LineString clone() {
        List<Point> newPoints = new ArrayList<Point>();
        for (Point point : points) {
            newPoints.add(point.clone());
        }
        return new LineString(newPoints);
    }
    @Override
    public <T> T accept(GeometryVisitor<T> visitor) {

        return visitor.visit(this);
    }
}

