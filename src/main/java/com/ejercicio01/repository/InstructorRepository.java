package com.ejercicio01.repository;

import com.ejercicio01.model.Instructor;

import java.util.Collection;

public interface InstructorRepository {
    public abstract void insert(Instructor instructor);
    public abstract void update(Instructor instructor);
    public abstract void delete(Instructor instructor);
    public abstract Instructor findById(Integer id);
    public abstract Collection<Instructor> findAll();
}
