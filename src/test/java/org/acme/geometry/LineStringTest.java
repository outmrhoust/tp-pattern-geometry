package org.acme.geometry;

import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;

public class LineStringTest {
    // test lineString class
    @Test
    public void testLineString() {
        LineString l = new LineString();
        Assert.assertEquals("LineString", l.getType());
    }
    @Test
    public void testIsEmpty() {
        LineString l = new LineString();
        Assert.assertTrue(l.isEmpty());
    }
    @Test
    public void testAddPointGetNumPoints() {
        Point p1 = new Point(new Coordinate(3.0, 4.0));
        Point p2 = new Point(new Coordinate(4.0, 5.0));
        ArrayList<Point> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        LineString l = new LineString(points);
        Assert.assertEquals(2, l.getNumPoints());
    }
    @Test
    public void testGetPointN() {
        Point p1 = new Point(new Coordinate(3.0, 4.0));
        Point p2 = new Point(new Coordinate(4.0, 5.0));
        ArrayList<Point> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        LineString l = new LineString(points);

        Assert.assertEquals(3.0, l.getPointN(0).getCoordinate().getX(), 1.0e-15);
        Assert.assertEquals(4.0, l.getPointN(0).getCoordinate().getY(), 1.0e-15);
        Assert.assertEquals(4.0, l.getPointN(1).getCoordinate().getX(), 1.0e-15);
        Assert.assertEquals(5.0, l.getPointN(1).getCoordinate().getY(), 1.0e-15);
    }
    @Test(expected = NullPointerException.class)
    public void testNullLineString() {
        LineString l = new LineString(null);
    }
    @Test
    public void testTranslate() {
        Point p1 = new Point(new Coordinate(3.0, 4.0));
        Point p2 = new Point(new Coordinate(4.0, 5.0));
        ArrayList<Point> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        LineString l = new LineString(points);
        l.translate(1.0, 1.0);
        Assert.assertEquals(4.0, l.getPointN(0).getCoordinate().getX(), 1.0e-15);
        Assert.assertEquals(5.0,  l.getPointN(0).getCoordinate().getY(), 1.0e-15);
        Assert.assertEquals(5.0, l.getPointN(1).getCoordinate().getX(), 1.0e-15);
        Assert.assertEquals(6.0, l.getPointN(1).getCoordinate().getY(), 1.0e-15);
    }
    @Test
    public void testLineStringClone(){
        Point p1 = new Point(new Coordinate(3.0, 4.0));
        Point p2 = new Point(new Coordinate(4.0, 5.0));
        ArrayList<Point> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        LineString l = new LineString(points);
        LineString l2 = l.clone();
        Assert.assertEquals(3.0, l2.getPointN(0).getCoordinate().getX(), 1.0e-15);
        Assert.assertEquals(4.0, l2.getPointN(0).getCoordinate().getY(), 1.0e-15);
        Assert.assertEquals(4.0, l2.getPointN(1).getCoordinate().getX(), 1.0e-15);
        Assert.assertEquals(5.0, l2.getPointN(1).getCoordinate().getY(), 1.0e-15);
    }
    @Test
    public void testGetEnvelope() {
        Point p1 = new Point(new Coordinate(1.0, 2.0));
        Point p2 = new Point(new Coordinate(-4.0, 5.0));
        ArrayList<Point> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        LineString l = new LineString(points);
        Envelope e = l.getEnvelope();
        Assert.assertEquals(-4.0, e.getXmin(), 1.0e-15);
        Assert.assertEquals(2.0, e.getYmin(), 1.0e-15);
        Assert.assertEquals(1.0, e.getXmax(), 1.0e-15);
        Assert.assertEquals(5.0, e.getYmax(), 1.0e-15);
    }
    @Test
    public void testAsText() {
        Point p1 = new Point(new Coordinate(1.0, 2.0));
        Point p2 = new Point(new Coordinate(-4.0, 5.0));
        ArrayList<Point> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        LineString l = new LineString(points);
        Assert.assertEquals("LINESTRING(1.0 2.0,-4.0 5.0)", l.asText());
    }


}
