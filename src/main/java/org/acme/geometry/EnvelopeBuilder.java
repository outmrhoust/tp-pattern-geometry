package org.acme.geometry;


public class EnvelopeBuilder {
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
}
