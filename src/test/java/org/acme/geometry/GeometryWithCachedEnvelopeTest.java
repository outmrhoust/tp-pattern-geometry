package org.acme.geometry;

import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;


public class GeometryWithCachedEnvelopeTest {
    @Test
    public void testGetEnvelope() {
        Geometry g = new Point(new Coordinate(3.0, 4.0));
        Geometry g2 = new GeometryWithCachedEnvelope(g);
        Assert.assertEquals(g.getEnvelope().toString(), g2.getEnvelope().toString());
    }
    @Test
    public void testGetEnvelope2() {
        Geometry g = new Point(new Coordinate(3.0, 4.0));
        Geometry g2 = new GeometryWithCachedEnvelope(g);
        g2.translate(1.0, 1.0);
        Assert.assertEquals(g.getEnvelope().toString(), g2.getEnvelope().toString());
    }
    @Test
    public void testGetEnvelope3() {
        Geometry g = new Point(new Coordinate(3.0, 4.0));
        Geometry g2 = new GeometryWithCachedEnvelope(g);
        Assert.assertEquals(g.getType(), g2.getType());
    }
    @Test
    public void testGetEnvelope4() {
        Geometry g = new Point(new Coordinate());
        Geometry g2 = new GeometryWithCachedEnvelope(g);
        Assert.assertEquals(g.isEmpty(), g2.isEmpty());
    }
    @Test
    public void testGetEnvelope5() {
        Geometry g = new Point(new Coordinate(3.0, 4.0));
        Geometry g2 = new GeometryWithCachedEnvelope(g);
        Geometry g3 = g2.clone();
        Assert.assertEquals(g.getEnvelope().toString(), g3.getEnvelope().toString());
    }
    @Test
    public void testGetEnvelope6() {
        Geometry g = new Point(new Coordinate(3.0, 4.0));
        Geometry g2 = new GeometryWithCachedEnvelope(g);
        EnvelopeBuilder envelopeBuilder = new EnvelopeBuilder();
        g2.accept(envelopeBuilder);
        Assert.assertEquals(g.getEnvelope().toString(), envelopeBuilder.build().toString());
    }
    @Test
    public void testGetEnvelope7() {
        Geometry g = new Point(new Coordinate(3.0,3.0));
        g = new GeometryWithCachedEnvelope(g);
        Envelope a = g.getEnvelope() ; // calcul et stockage dans cachedEnvelope
        Envelope b = g.getEnvelope() ; // renvoi de cachedEnvelope
        Assert.assertSame(a,b);
    }
    @Test
    public void testPointAddListener() {
        Point p = new Point(new Coordinate(3.0, 4.0));
        GeometryWithCachedEnvelope e = new GeometryWithCachedEnvelope(p);
        e.addListener(e);;
        p.translate(1.0, 1.0);
        Assert.assertEquals(4.0, p.getEnvelope().getXmax(), 1.0e-15);
        Assert.assertEquals(5.0, p.getEnvelope().getYmax(), 1.0e-15);
    }
    @Test
    public void testLineStringAddListener() {
        Point p1 = new Point(new Coordinate(1.0, 2.0));
        Point p2 = new Point(new Coordinate(-4.0, 5.0));
        ArrayList<Point> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        LineString l = new LineString(points);
        GeometryWithCachedEnvelope e = new GeometryWithCachedEnvelope(l);
        e.addListener(e);
        l.translate(1.0, 1.0);
        Assert.assertEquals(6.0, e.getEnvelope().getYmax(), 1.0e-15);
    }
    @Test
    public void testAsText() {
        Geometry g = new Point(new Coordinate(3.0, 4.0));
        Geometry g2 = new GeometryWithCachedEnvelope(g);
        Assert.assertEquals(g.asText(), g2.asText());
    }
}
