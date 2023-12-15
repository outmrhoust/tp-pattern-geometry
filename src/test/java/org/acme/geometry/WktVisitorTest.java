package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;


import java.util.ArrayList;

public class WktVisitorTest {
    @Test
    public void testVisitPoint(){

        WktVisitor visitor = new WktVisitor();
        Geometry geometry = new Point(new Coordinate(3.0,4.0));
        geometry.accept(visitor);
        String result = visitor.getResult();
        Assert.assertEquals("POINT(3.0 4.0)", result);
    }

    @Test
    public void testVisitPointEmpty(){
        WktVisitor visitor = new WktVisitor();
        Geometry geometry = new Point(new Coordinate());
        geometry.accept(visitor);
        String result = visitor.getResult();
        Assert.assertEquals("POINT EMPTY", result);

    }

    @Test
    public void testVisitLineString() {
        Point p1 = new Point(new Coordinate(3.0, 4.0));
        Point p2 = new Point(new Coordinate(4.0, 5.0));
        ArrayList<Point> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        Geometry geometry = new LineString(points);
        WktVisitor visitor = new WktVisitor();
        geometry.accept(visitor);
        String result = visitor.getResult();
        Assert.assertEquals("LINESTRING(3.0 4.0,4.0 5.0)", result);

    }

    @Test
    public void testVisitLineStringEmpty(){

        ArrayList<Point> points = new ArrayList<>();
        Geometry geometry = new LineString(points);
        WktVisitor visitor = new WktVisitor();
        geometry.accept(visitor);
        String result = visitor.getResult();
        Assert.assertEquals("LINESTRING EMPTY", result);
    }

}


