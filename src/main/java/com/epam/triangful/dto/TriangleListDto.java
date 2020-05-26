package com.epam.triangful.dto;

import com.epam.triangful.triangle.Triangle;

import java.util.ArrayList;

public class TriangleListDto {

    private ArrayList<Triangle> triangles;

    public TriangleListDto() {
     triangles = new ArrayList<>();
    }

    public ArrayList<Triangle> getTriangles() {
        return triangles;
    }
    public void addTriangle(Triangle triangle) {
        this.triangles.add(triangle);
    }
}