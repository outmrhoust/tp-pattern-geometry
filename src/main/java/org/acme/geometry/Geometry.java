package org.acme.geometry;

public interface Geometry {
    String getType();
    boolean isEmpty();
    void translate(double dx, double dy);
    Geometry clone();
    Envelope getEnvelope();
    <T> T accept(GeometryVisitor<T> visitor);
    void addListener(GeometryListener listener);

    String asText();
}
