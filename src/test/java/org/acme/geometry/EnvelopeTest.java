package org.acme.geometry;
import org.junit.Test;
import org.junit.Assert;
public class EnvelopeTest {
    @Test
    public void testEnvelopeEmpty() {
        Envelope e = new Envelope();
        Assert.assertTrue(e.isEmpty());
    }
    @Test
    public void testEnvelope() {
        Envelope e = new Envelope(new Coordinate(3.0, 4.0), new Coordinate(5.0, 6.0));
        Assert.assertEquals(3.0, e.getXmin(), 1.0e-15);
        Assert.assertEquals(4.0, e.getYmin(), 1.0e-15);
        Assert.assertEquals(5.0, e.getXmax(), 1.0e-15);
        Assert.assertEquals(6.0, e.getYmax(), 1.0e-15);
        Assert.assertEquals("[3.0,4.0,5.0,6.0]", e.toString());
    }
}
