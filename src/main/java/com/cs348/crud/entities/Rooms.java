package com.cs348.crud.entities;

import org.springframework.data.annotation.Id;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Rooms")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(min = 2, max = 30)
    private String building;
    @number
    private int number;
    @maxCapacity
    private int maxCapacity;

    public Rooms(int id, String building, int number, int maxCapacity) {
        this.id = id;
        this.building = building;
        this.number = number;
        this.maxCapacity = maxCapacity;
    }

    public Student() {

    }


    @Override
    public String toString() {
        return "Rooms{" +
                "id=" + id +
                ", building='" + building + '\'' +
                ", number='" + number + '\'' +
                ", maxCapacity='" + maxCapacity + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rooms)) return false;

        Rooms rooms = (Rooms) o;

        if (getId() != rooms.getId()) return false;
        if (!getBuilding().equals(rooms.getBuilding())) return false;
        if (!getNumber().equals(rooms.getNumber())) return false;
        return getMaxCapacity().equals(rooms.getMaxCapacity());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getBuilding().hashCode();
        result = 31 * result + getNumber().hashCode();
        result = 31 * result + getMaxCapacity().hashCode();
        return result;
    }

    @javax.persistence.Id
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getBuilding(){
        return this.building;
    }
    public void setBuilding(String building){
        this.building = building;
    }
    public String getNumber(){
        return this.number;
    }
    public void setNumber(String number){
        this.number = number;
    }
    public String getMaxCapacity(){
        return this.maxCapacity;
    }
    public void setMaxCapacity(String maxCapacity){
        this.maxCapacity = maxCapacity;
    }
}
