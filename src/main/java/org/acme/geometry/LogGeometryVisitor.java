package org.acme.geometry;

import java.io.PrintStream;

public class LogGeometryVisitor implements GeometryVisitor {
    private PrintStream out;
    public LogGeometryVisitor(PrintStream out) {
        this.out = out;
    }
    public LogGeometryVisitor() {
        this.out = System.out;
    }

    @Override
    public void visit(Point point) {
        if (point.isEmpty()) {
            this.out.print("Je suis un point vide.");
        } else {
            this.out.print("Je suis un point avec x=" + point.getCoordinate().getX() + " et y=" + point.getCoordinate().getY() + ".");
        }
    }
    @Override
    public void visit(LineString lineString) {
        if (lineString.isEmpty()) {
            this.out.print("Je suis une polyligne vide.");
        } else {
            this.out.print("Je suis une polyligne définie par " + lineString.getNumPoints() + " point(s).");
        }
    }
}
