package org.acme.geometry;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class WktWriterTest {
    @Test
    public void testWritePoint() {
        Geometry g1 = new Point(new Coordinate(3.0, 4.0));
        Geometry g2 = new Point();
        WktWriter writer = new WktWriter();
        Assert.assertEquals("POINT(3.0 4.0)", writer.write(g1));
        Assert.assertEquals("POINT EMPTY", writer.write(g2));
    }
    @Test
    public void testWriteLineString() {
        Point p1 = new Point(new Coordinate(3.0, 4.0));
        Point p2 = new Point(new Coordinate(4.0, 5.0));
        ArrayList<Point> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        Geometry g1 = new LineString(points);
        Geometry g2 = new LineString();
        WktWriter writer = new WktWriter();
        Assert.assertEquals("LINESTRING(3.0 4.0,4.0 5.0)", writer.write(g1));
        Assert.assertEquals("LINESTRING EMPTY", writer.write(g2));
    }
}