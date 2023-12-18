package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;


public class GeometryCollection extends AbstractGeometry {
    private List<Geometry> geometries;

    public GeometryCollection() {
        this.geometries = new ArrayList<Geometry>();
    }

    public GeometryCollection(List<Geometry> geometries) {
        this.geometries = geometries;
    }

    public int getNumGeometries() {
        return this.geometries.size();
    }

    public Geometry getGeometryN(int n) {
        return this.geometries.get(n);
    }


    @Override
    public String asText() {
        String result = "GEOMETRYCOLLECTION(";
        for (int i = 0; i < this.geometries.size(); i++) {
            if (i > 0) {
                result += ",";
            }
            result += this.geometries.get(i).asText();
        }
        result += ")";
        return result;
    }

    @Override
    public GeometryCollection clone() {
        List<Geometry> newGeometries = new ArrayList<Geometry>();
        for (Geometry geometry : this.geometries) {
            newGeometries.add(geometry.clone());
        }
        return new GeometryCollection(newGeometries);
    }

    @Override
    public void translate(double dx, double dy) {
        for (Geometry geometry : this.geometries) {
            geometry.translate(dx, dy);
        }
    }

    @Override
    public <T> T accept(GeometryVisitor<T> visitor) {

        return visitor.visit(this);
    }

    @Override
    public boolean isEmpty() {
        return this.geometries.isEmpty();
    }

    @Override
    public String getType() {
        return "GeometryCollection";
    }

}
