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

    @Test
    public void testVisitGeometryCollection(){
        Point p = new Point(new Coordinate(3.0, 4.0));
        Point p1 = new Point(new Coordinate(1.0, 2.0));
        Point p2 = new Point(new Coordinate(-4.0, 5.0));
        ArrayList<Point> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        LineString l = new LineString(points);
        ArrayList<Geometry> geometries = new ArrayList<>();
        geometries.add(p);
        geometries.add(l);
        Geometry geometry = new GeometryCollection(geometries);
        WktVisitor visitor = new WktVisitor();
        geometry.accept(visitor);
        String result = visitor.getResult();
        Assert.assertEquals("GEOMETRYCOLLECTION(POINT(3.0 4.0),LINESTRING(1.0 2.0,-4.0 5.0))", result);
    }
    @Test
    public void testVisitGeometryCollectionEmpty(){
        Geometry geometry = new GeometryCollection();
        WktVisitor visitor = new WktVisitor();
        geometry.accept(visitor);
        String result = visitor.getResult();
        Assert.assertEquals("GEOMETRYCOLLECTION EMPTY", result);
    }

}


