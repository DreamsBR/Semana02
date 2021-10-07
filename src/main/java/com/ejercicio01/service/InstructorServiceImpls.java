package com.ejercicio01.service;

import com.ejercicio01.model.Instructor;
import com.ejercicio01.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class InstructorServiceImpls implements InstructorService {
   @Autowired
   private InstructorRepository repo;


    @Override
    public void insert(Instructor instructor) {
        repo.insert(instructor);
    }

    @Override
    public void update(Instructor instructor) {
        repo.update(instructor);
    }

    @Override
    public void delete(Instructor instructor) {
        repo.delete(instructor);
    }

    @Override
    public Instructor findById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Collection<Instructor> findAll() {
        return repo.findAll();
    }
}
