package org.acme.geometry;

public class Point implements Geometry {
    private Coordinate coordinate;

    public Point() {
        this.coordinate = new Coordinate();
    }

    public Point(Coordinate coordinate) {
        if (coordinate == null) {
            throw new NullPointerException("coordinate cannot be null");
        }
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public String getType() {
        return "Point";
    }

    @Override
    public boolean isEmpty() {
        return coordinate.isEmpty();
    }

    @Override
    public void translate(double dx, double dy) {
        this.coordinate =  new Coordinate(this.coordinate.getX() + dx, this.coordinate.getY() + dy);
    }
    @Override
    public Point clone() {
        return new Point(this.coordinate);
    }
    @Override
    public Envelope getEnvelope() {
        EnvelopeBuilder envelopeBuilder = new EnvelopeBuilder();
        envelopeBuilder.insert(this.coordinate);
        return envelopeBuilder.build();
    }
}
