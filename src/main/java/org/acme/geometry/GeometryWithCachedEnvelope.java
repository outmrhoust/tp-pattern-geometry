package org.acme.geometry;

public class GeometryWithCachedEnvelope implements Geometry {
    private Geometry original;
    private Envelope cachedEnvelope;

    public GeometryWithCachedEnvelope(Geometry original) {
        this.original = original;
    }

    @Override
    public String getType() {
        return this.original.getType();
    }

    @Override
    public boolean isEmpty() {
        return this.original.isEmpty();
    }

    @Override
    public void translate(double dx, double dy) {
        this.original.translate(dx, dy);
    }

    @Override
    public Geometry clone() {
        return this.original.clone();
    }

    @Override
    public Envelope getEnvelope() {
        if (this.cachedEnvelope == null) {
            this.cachedEnvelope = this.original.getEnvelope();
        }
        return this.cachedEnvelope;
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        this.original.accept(visitor);
    }


}
