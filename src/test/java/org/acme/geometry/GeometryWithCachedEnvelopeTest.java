package org.acme.geometry;

import org.junit.Test;
import org.junit.Assert;



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
    // test clone and accept
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
}
