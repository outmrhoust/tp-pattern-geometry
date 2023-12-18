package org.acme.geometry;

public class GeometryWithCachedEnvelope implements Geometry, GeometryListener {
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
    public <T> T accept(GeometryVisitor<T> visitor) {

        return this.original.accept(visitor);
    }

    @Override
    public String asText() {
        return this.original.asText();
    }

    @Override
    public void onChange(Geometry geometry) {
        this.cachedEnvelope = null;
        this.cachedEnvelope = this.original.getEnvelope();
    }
    @Override
    public void addListener(GeometryListener listener) {
        this.original.addListener(listener);
    }


}
