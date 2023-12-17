package org.acme.geometry;

public interface GeometryVisitor<T> {
    T visit(Point point);
    T visit(LineString lineString);

    T visit(GeometryCollection geometryCollection);
}
