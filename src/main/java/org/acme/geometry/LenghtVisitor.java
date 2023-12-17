package org.acme.geometry;

public class LenghtVisitor implements GeometryVisitor<Double>{
    private double lenght;
    public LenghtVisitor(){
        this.lenght = 0.0;
    }
    public double getLength(){
        return this.lenght;
    }

    @Override
    public Double visit(Point point) {
        return this.lenght;
    }

    @Override
    public Double visit(LineString lineString) {
        for (int i = 0; i < lineString.getNumPoints() - 1; i++) {
            this.lenght += this.distance(lineString.getPointN(i).getCoordinate(), lineString.getPointN(i + 1).getCoordinate());
        }
        return this.lenght;
    }

    @Override
    public Double visit(GeometryCollection geometryCollection) {
        for (int i = 0; i < geometryCollection.getNumGeometries(); i++) {
            geometryCollection.getGeometryN(i).accept(this);
        }
        return this.lenght;
    }

    private double distance(Coordinate c1, Coordinate c2){
        return Math.sqrt(Math.pow(c1.getX() - c2.getX(), 2) + Math.pow(c1.getY() - c2.getY(), 2));
    }
}
