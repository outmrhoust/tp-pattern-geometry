package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGeometry implements Geometry {

    private List<GeometryListener> listeners;

    @Override
    public String asText() {
        WktVisitor visitor = new WktVisitor();
        this.accept(visitor);
        return visitor.getResult();
    }

    @Override
    public abstract AbstractGeometry clone();

    @Override
    public Envelope getEnvelope() {
        EnvelopeBuilder envelopeBuilder = new EnvelopeBuilder();
        this.accept(envelopeBuilder);
        return envelopeBuilder.build();
    }

    @Override
    public void addListener(GeometryListener listener) {
        if (this.listeners == null) {
            this.listeners = new ArrayList<GeometryListener>();
        }
        this.listeners.add(listener);
    }


    public void triggerChange() {
        if (this.listeners != null) {
            for (GeometryListener listener : this.listeners) {
                listener.onChange(this);
            }
        }
    }
}

