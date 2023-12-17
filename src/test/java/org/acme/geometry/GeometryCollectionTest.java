package org.acme.geometry;

import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GeometryCollectionTest {
    @Test
    public void testGetType() {
        Point p = new Point(new Coordinate(3.0, 4.0));
        Point p1 = new Point(new Coordinate(1.0, 2.0));
        Point p2 = new Point(new Coordinate(-4.0, 5.0));
        ArrayList<Point> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        LineString l = new LineString(points);
        List<Geometry> geometries = new ArrayList<>();
        geometries.add(p);
        geometries.add(l);
        GeometryCollection g = new GeometryCollection(geometries);
        assertEquals("GeometryCollection", g.getType());
    }

    @Test
    public void testGetNumGeometries() {
        Point p = new Point(new Coordinate(3.0, 4.0));
        Point p1 = new Point(new Coordinate(1.0, 2.0));
        Point p2 = new Point(new Coordinate(-4.0, 5.0));
        ArrayList<Point> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        LineString l = new LineString(points);
        List<Geometry> geometries = new ArrayList<>();
        geometries.add(p);
        geometries.add(l);
        GeometryCollection g = new GeometryCollection(geometries);
        assertEquals(2, g.getNumGeometries());
    }

    @Test
    public void testGetGeometryN() {
        Point p = new Point(new Coordinate(3.0, 4.0));
        Point p1 = new Point(new Coordinate(1.0, 2.0));
        Point p2 = new Point(new Coordinate(-4.0, 5.0));
        ArrayList<Point> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        LineString l = new LineString(points);
        List<Geometry> geometries = new ArrayList<>();
        geometries.add(p);
        geometries.add(l);
        GeometryCollection g = new GeometryCollection(geometries);
        assertEquals("Point", g.getGeometryN(0).getType());
        assertEquals("LineString", g.getGeometryN(1).getType());
    }

    @Test
    public void testGetEnvelope() {
        Point p = new Point(new Coordinate(3.0, 4.0));
        Point p1 = new Point(new Coordinate(1.0, 2.0));
        Point p2 = new Point(new Coordinate(-4.0, 5.0));
        ArrayList<Point> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        LineString l = new LineString(points);
        List<Geometry> geometries = new ArrayList<>();
        geometries.add(p);
        geometries.add(l);
        GeometryCollection g = new GeometryCollection(geometries);
        assertEquals(-4.0, g.getEnvelope().getXmin(), 1.0e-15);
        assertEquals(2.0, g.getEnvelope().getYmin(), 1.0e-15);
        assertEquals(3.0, g.getEnvelope().getXmax(), 1.0e-15);
        assertEquals(5.0, g.getEnvelope().getYmax(), 1.0e-15);
    }

    @Test
    public void testAsText() {
        Point p = new Point(new Coordinate(3.0, 4.0));
        Point p1 = new Point(new Coordinate(1.0, 2.0));
        Point p2 = new Point(new Coordinate(-4.0, 5.0));
        ArrayList<Point> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        LineString l = new LineString(points);
        List<Geometry> geometries = new ArrayList<>();
        geometries.add(p);
        geometries.add(l);
        GeometryCollection g = new GeometryCollection(geometries);
        assertEquals("GEOMETRYCOLLECTION(POINT(3.0 4.0),LINESTRING(1.0 2.0,-4.0 5.0))", g.asText());
    }

    @Test
    public void testTranslate() {
        Point p = new Point(new Coordinate(3.0, 4.0));
        Point p1 = new Point(new Coordinate(1.0, 2.0));
        Point p2 = new Point(new Coordinate(-4.0, 5.0));
        ArrayList<Point> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        LineString l = new LineString(points);
        List<Geometry> geometries = new ArrayList<>();
        geometries.add(p);
        geometries.add(l);
        GeometryCollection g = new GeometryCollection(geometries);
        g.translate(1.0, 2.0);
        assertEquals("GEOMETRYCOLLECTION(POINT(4.0 6.0),LINESTRING(2.0 4.0,-3.0 7.0))", g.asText());
    }

    @Test
    public void testClone() {
        Point p = new Point(new Coordinate(3.0, 4.0));
        Point p1 = new Point(new Coordinate(1.0, 2.0));
        Point p2 = new Point(new Coordinate(-4.0, 5.0));
        ArrayList<Point> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        LineString l = new LineString(points);
        List<Geometry> geometries = new ArrayList<>();
        geometries.add(p);
        geometries.add(l);
        GeometryCollection g = new GeometryCollection(geometries);
        GeometryCollection clone = g.clone();
        clone.translate(1.0, 2.0);
        assertEquals("GEOMETRYCOLLECTION(POINT(3.0 4.0),LINESTRING(1.0 2.0,-4.0 5.0))", g.asText());
        assertEquals("GEOMETRYCOLLECTION(POINT(4.0 6.0),LINESTRING(2.0 4.0,-3.0 7.0))", clone.asText());
}
//is empty
    @Test
    public void testIsEmpty() {
        GeometryCollection g = new GeometryCollection();
        assertTrue(g.isEmpty());
    }
}
