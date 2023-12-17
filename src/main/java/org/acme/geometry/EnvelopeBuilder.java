package org.acme.geometry;


public class EnvelopeBuilder implements GeometryVisitor<Void> {
    private Coordinate bottomLeft;
    private Coordinate topRight;

    public EnvelopeBuilder(){
        this.bottomLeft = new Coordinate();
        this.topRight = new Coordinate();
    }

    public void insert(Coordinate coordinate){
        if (coordinate == null) {
            throw new NullPointerException("coordinate cannot be null");
        }
        if (this.bottomLeft.isEmpty() || this.topRight.isEmpty()) {
            this.bottomLeft = coordinate;
            this.topRight = coordinate;
        } else {
            this.bottomLeft = new Coordinate(Math.min(this.bottomLeft.getX(), coordinate.getX()), Math.min(this.bottomLeft.getY(), coordinate.getY()));
            this.topRight = new Coordinate(Math.max(this.topRight.getX(), coordinate.getX()), Math.max(this.topRight.getY(), coordinate.getY()));
        }
    }

    public Envelope build(){
        return new Envelope(this.bottomLeft, this.topRight);
    }

    @Override
    public Void visit(Point point) {
        this.insert(point.getCoordinate());
        return null;
    }

    @Override
    public Void visit(LineString lineString) {
        for (int i = 0; i < lineString.getNumPoints(); i++) {
            this.insert(lineString.getPointN(i).getCoordinate());
        }
        return null;
    }
    @Override
    public Void visit(GeometryCollection geometryCollection) {
        for (int i = 0; i < geometryCollection.getNumGeometries(); i++) {
            geometryCollection.getGeometryN(i).accept(this);
        }
        return null;
    }
}
