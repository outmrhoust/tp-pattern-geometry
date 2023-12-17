package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class LogGeometryVisitorTest {
    @Test
    public void testVisitPoint() throws UnsupportedEncodingException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(os);
        LogGeometryVisitor visitor = new LogGeometryVisitor(out);
        Geometry geometry = new Point(new Coordinate(3.0,4.0));
        geometry.accept(visitor);
        String result = os.toString("UTF8");
        Assert.assertEquals("Je suis un point avec x=3.0 et y=4.0.", result);
    }

    @Test
    public void testVisitPointEmpty() throws UnsupportedEncodingException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(os);
        LogGeometryVisitor visitor = new LogGeometryVisitor(out);
        Geometry geometry = new Point(new Coordinate());
        geometry.accept(visitor);
        String result = os.toString("UTF8");
        Assert.assertEquals("Je suis un point vide.", result);


    }

    @Test
    public void testVisitLineString() throws UnsupportedEncodingException {
        Point p1 = new Point(new Coordinate(3.0, 4.0));
        Point p2 = new Point(new Coordinate(4.0, 5.0));
        ArrayList<Point> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(os);
        Geometry geometry = new LineString(points);
        LogGeometryVisitor visitor = new LogGeometryVisitor(out);
        geometry.accept(visitor);
        String result = os.toString("UTF8");

        Assert.assertEquals("Je suis une polyligne définie par 2 point(s).", result);

    }

    @Test
    public void testVisitLineStringEmpty() throws UnsupportedEncodingException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(os);
        LogGeometryVisitor visitor = new LogGeometryVisitor(out);

        ArrayList<Point> points = new ArrayList<>();
        Geometry geometry = new LineString(points);
        geometry.accept(visitor);
        String result = os.toString("UTF8");


        Assert.assertEquals("Je suis une polyligne vide.", result);

    }
    @Test
    public void testLogGeometryVisitor() throws UnsupportedEncodingException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        LogGeometryVisitor visitor = new LogGeometryVisitor();
        Geometry geometry = new Point(new Coordinate(3.0,4.0));
        geometry.accept(visitor);
        String result = os.toString("UTF8");
        Assert.assertEquals("", result);
    }

}


