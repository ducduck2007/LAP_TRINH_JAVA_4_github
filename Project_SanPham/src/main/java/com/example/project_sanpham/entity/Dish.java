package com.example.project_sanpham.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Dishes")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "calories", nullable = false)
    private Integer calories;

    @Column(name = "is_vegan", nullable = false)
    private Boolean isVegan;

    @Column(name = "description", length = 255)
    private String description;

    // getters/setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getCalories() { return calories; }
    public void setCalories(Integer calories) { this.calories = calories; }

    public Boolean getIsVegan() { return isVegan; }
    public void setIsVegan(Boolean vegan) { isVegan = vegan; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}