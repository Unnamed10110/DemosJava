package com.unnamed.cruddemo.DTOs;

public class StudentIdApellidoDTO {

    private final int id;
    private final String apellido;

    public int getId() {
        return id;
    }

    public String getApellido() {
        return apellido;
    }

    public StudentIdApellidoDTO(int id, String apellido) {
        this.id = id;
        this.apellido = apellido;
    }
}
