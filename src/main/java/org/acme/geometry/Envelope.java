package org.acme.geometry;

public class Envelope {
    private Coordinate bottomLeft;
    private Coordinate topRight;

    public Envelope() {
        this.bottomLeft = new Coordinate();
        this.topRight = new Coordinate();
    }

    public Envelope(Coordinate bottomLeft, Coordinate topRight) {
        if (bottomLeft == null || topRight == null) {
            throw new NullPointerException("coordinate cannot be null");
        }
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean isEmpty() {
        return this.bottomLeft.isEmpty() || this.topRight.isEmpty();
    }

    public double getXmin() {
        return this.bottomLeft.getX();
    }

    public double getYmin() {
        return this.bottomLeft.getY();
    }

    public double getXmax() {
        return this.topRight.getX();
    }

    public double getYmax() {
        return this.topRight.getY();
    }
    @Override
    public String toString() {
        return "[" + this.getXmin() + "," + this.getYmin() + "," + this.getXmax() + "," + this.getYmax() + "]";
    }
}
