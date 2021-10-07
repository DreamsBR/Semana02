package com.ejercicio01.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@AllArgsConstructor
@Data
public class Instructor implements Serializable {

    private static final long serialVersionUID= 1L;
    private Integer instructorId;
    private String nombre;
    private String apellido;
    private String password;
    private String email;
    private Date fregistro;


    public Instructor (Instructor instructor){
        this(instructor.getInstructorId(), instructor.getNombre(), instructor.getApellido(),
                instructor.getPassword(), instructor.getEmail(), instructor.getFregistro());
    }


}
