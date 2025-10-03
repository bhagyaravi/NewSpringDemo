package com.mytest.springdemo.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {

    private Employee employee;

    @Before
    public void setUp() throws Exception {
        employee = new Employee();
        employee.setEmpId("1");
        employee.setName("emp1");
        employee.setDesignation("manager");
        employee.setSalary(3000);
    }

    @Test
    public void testGetters() {
        assertEquals("1", employee.getEmpId());
        assertEquals("emp1", employee.getName());
        assertEquals("manager", employee.getDesignation());
        assertEquals(3000, employee.getSalary(), 0);
    }

    @Test
    public void testSetters() {
        employee.setEmpId("2");
        employee.setName("emp2");
        employee.setDesignation("developer");
        employee.setSalary(4000);

        assertEquals("2", employee.getEmpId());
        assertEquals("emp2", employee.getName());
        assertEquals("developer", employee.getDesignation());
        assertEquals(4000, employee.getSalary(), 0);
    }
}