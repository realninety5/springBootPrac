package com.eplat.web.model;


import javax.persistence.*;


@Entity
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;
    private boolean married;
    protected UserModel() {};
    protected UserModel(String name, int age, boolean married) {
        this.name = name;
        this.age = age;
        this.married = married;
    }

    public String getName() { return this.name; }
    public int getAge() { return this.age; }
    public boolean isMarried() { return this.married; }
    public Long getId() { return this.id; }

    /*
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setMarried(boolean married) { this.married = married; }
     */
    
    @Override
    public String toString() {
        return String.format("User [id=%s, name=%s, age=%d, married=%b]", id, name, age, married);
    }
}
