package com.example.demo.dao;

import com.example.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpalmpl implements EmployeeDAO{

    //define field for entitymanager
    private EntityManager entityManager;

    //set up constructor injection
    @Autowired
    public EmployeeDAOJpalmpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }




    @Override
    public List<Employee> findAll() {

        //create query
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);

        //execute query and get result
        List<Employee> employees = query.getResultList();

        //return the results
        return employees;

    }

    @Override
    public Employee findById(int theId) {
        Employee theEmployee = entityManager.find(Employee.class, theId);

        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee dbEmployee = entityManager.merge(theEmployee);

        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        Employee theEmployee = entityManager.find(Employee.class, theId);

        entityManager.remove(theEmployee);

    }
}
