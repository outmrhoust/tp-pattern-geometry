package org.acme.geometry;

public interface Geometry {
    String getType();
    boolean isEmpty();
    void translate(double dx, double dy);
    Geometry clone();
    Envelope getEnvelope();
    void accept(GeometryVisitor visitor);
    void addListener(GeometryListener listener);
}
