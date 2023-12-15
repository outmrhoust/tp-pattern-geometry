package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    @Test
    public void testGetType() {
        Point p = new Point();
        Assert.assertEquals("Point", p.getType());
    }
    @Test
    public void testIsEmpty() {
        Point p = new Point();
        Assert.assertTrue(p.isEmpty());
    }
    @Test
    public void testGetCoordinate() {
        Point p = new Point(new Coordinate(3.0, 4.0));
        Assert.assertEquals(3.0, p.getCoordinate().getX(), 1.0e-15);
        Assert.assertEquals(4.0, p.getCoordinate().getY(), 1.0e-15);
    }
    @Test(expected = NullPointerException.class)
    public void testNullPoint() {
        Point p = new Point(null);
    }
    @Test
    public void testTranslate() {
        Point p = new Point(new Coordinate(3.0, 4.0));
        p.translate(1.0, 1.0);
        Assert.assertEquals(4.0, p.getCoordinate().getX(), 1.0e-15);
        Assert.assertEquals(5.0, p.getCoordinate().getY(), 1.0e-15);
    }
}
