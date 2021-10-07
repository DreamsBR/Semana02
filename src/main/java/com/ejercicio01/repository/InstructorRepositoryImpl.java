package com.ejercicio01.repository;

import com.ejercicio01.model.Instructor;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

@Repository
public class InstructorRepositoryImpl implements InstructorRepository{

    private static Collection<Instructor> itemsInstructor = new ArrayList<>();

    @PostConstruct
    public void initData(){
        Instructor instructor = new Instructor(1,"Marcos","Basurto","123","marcosbr301@gmail.com",new Date());
        Instructor instructor1 = new Instructor(2,"Marcos","Basurto","123","marcosbr301@gmail.com",new Date());
        Instructor instructor2 = new Instructor(3,"Marcos","Basurto","123","marcosbr301@gmail.com",new Date());
        itemsInstructor.add(instructor);
        itemsInstructor.add(instructor1);
        itemsInstructor.add(instructor2);
    }
    @Override
    public void insert(Instructor instructor) {

        itemsInstructor.add(instructor);
    }

    @Override
    public void update(Instructor instructor) {
        Instructor oldInstructor = findById(instructor.getInstructorId());

        itemsInstructor.remove(oldInstructor);

        itemsInstructor.add(instructor);
    }

    @Override
    public void delete(Instructor instructor) {
        Instructor delInstructor = findById(instructor.getInstructorId());
        itemsInstructor.remove(delInstructor);
    }

    @Override
    public Instructor findById(Integer id) {
        Optional<Instructor> instructor =
                itemsInstructor.stream().filter(p-> p.getInstructorId()==id).findFirst();
        return instructor.orElse(null);
    }

    @Override
    public Collection<Instructor> findAll() {
        return itemsInstructor;
    }
}
