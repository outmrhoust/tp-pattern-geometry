package org.acme.geometry;


public class WktVisitor implements GeometryVisitor {
    private StringBuilder buffer;
    public WktVisitor() {
        this.buffer = new StringBuilder();
    }
    public String getResult() {
        return this.buffer.toString();
    }
    @Override
    public void visit(Point point) {
        if (point.isEmpty()) {
            this.buffer.append("POINT EMPTY");
            return;
        }
        this.buffer.append("POINT(");
        this.buffer.append(point.getCoordinate().getX());
        this.buffer.append(" ");
        this.buffer.append(point.getCoordinate().getY());
        this.buffer.append(")");
    }
    @Override
    public void visit(LineString lineString) {
        if (lineString.isEmpty()) {
            this.buffer.append("LINESTRING EMPTY");
            return;
        }
        this.buffer.append("LINESTRING(");
        for (int i = 0; i < lineString.getNumPoints(); i++) {
            Point point = lineString.getPointN(i);
            this.buffer.append(point.getCoordinate().getX());
            this.buffer.append(" ");
            this.buffer.append(point.getCoordinate().getY());
            if (i < lineString.getNumPoints() - 1) {
                this.buffer.append(",");
            }
        }
        this.buffer.append(")");
    }

    @Override
    public void visit(GeometryCollection geometryCollection) {
        if (geometryCollection.isEmpty()) {
            this.buffer.append("GEOMETRYCOLLECTION EMPTY");
            return;
        }
        this.buffer.append("GEOMETRYCOLLECTION(");
        for (int i = 0; i < geometryCollection.getNumGeometries(); i++) {
            Geometry geometry = geometryCollection.getGeometryN(i);
            geometry.accept(this);
            if (i < geometryCollection.getNumGeometries() - 1) {
                this.buffer.append(",");
            }
        }
        this.buffer.append(")");
    }
}
