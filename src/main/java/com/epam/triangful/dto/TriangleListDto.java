package com.epam.triangful.dto;

import java.util.ArrayList;

public class TriangleListDto {

    private ArrayList<TriangleDto> triangles;

    public TriangleListDto() {
     triangles = new ArrayList<>();
    }

    public ArrayList<TriangleDto> getTriangles() {
        return triangles;
    }
    public void addTriangle(TriangleDto triangle) {
        this.triangles.add(triangle);
    }
}