package org.acme.geometry;
import org.junit.Test;
import org.junit.Assert;
public class EnvelopeBuilderTest {


    @Test
    public void testInsert() {
        EnvelopeBuilder builder = new EnvelopeBuilder();
        builder.insert(new Coordinate(3.0, 4.0));
        builder.insert(new Coordinate(5.0,2.0));
        builder.insert(new Coordinate(1.0, 5.0));
        Envelope e = builder.build();
        Assert.assertEquals(1.0, e.getXmin(), 1.0e-15);
        Assert.assertEquals(2.0, e.getYmin(), 1.0e-15);
        Assert.assertEquals(5.0, e.getXmax(), 1.0e-15);
        Assert.assertEquals(5.0, e.getYmax(), 1.0e-15);
    }

    @Test(expected = NullPointerException.class)
    public void testInsertNull() {
        EnvelopeBuilder builder = new EnvelopeBuilder();
        builder.insert(null);
    }

}