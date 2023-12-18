package org.acme.geometry;

import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class LenghtVisitorTest {
    @Test
    public void testVisitPoint(){
        LenghtVisitor visitor = new LenghtVisitor();
        Point geometry = new Point(new Coordinate(3.0,4.0));
        geometry.accept(visitor);
        double result = visitor.getLength();
        Assert.assertEquals(0.0, result, 1.0e-15);
    }
    @Test
    public void testVisitLineString(){
        LenghtVisitor visitor = new LenghtVisitor();
        Point p1 = new Point(new Coordinate(1.0, 0.0));
        Point p2 = new Point(new Coordinate(4.0, 0.0));
        ArrayList<Point> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        LineString l = new LineString(points);
        l.accept(visitor);
        double result = visitor.getLength();
        Assert.assertEquals(3.0, result, 1.0e-15);
    }
    @Test
    public void testVisitGeometryCollection(){
        LenghtVisitor visitor = new LenghtVisitor();
        Point p = new Point(new Coordinate(3.0, 4.0));
        Point p1 = new Point(new Coordinate(1.0, 0.0));
        Point p2 = new Point(new Coordinate(4.0, 0.0));
        ArrayList<Point> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        LineString l = new LineString(points);
        List<Geometry> geometries = new ArrayList<>();
        geometries.add(p);
        geometries.add(l);
        GeometryCollection g = new GeometryCollection(geometries);
        double result = g.accept(visitor);

        Assert.assertEquals(3.0, result, 1.0e-15);
    }
}
