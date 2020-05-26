package com.epam.triangful.triangle;

import java.util.ArrayList;

public class TriangleList {

    private ArrayList<Triangle> triangles;

    public TriangleList() {
     triangles = new ArrayList<>();
    }

    public ArrayList<Triangle> getTriangles() {
        return triangles;
    }
    public void addTriangle(Triangle triangle) {
        this.triangles.add(triangle);
    }
}