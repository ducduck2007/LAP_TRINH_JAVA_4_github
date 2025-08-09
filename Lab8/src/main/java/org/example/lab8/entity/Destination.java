package org.example.lab8.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Destinations")
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "budget_est", nullable = false)
    private Integer budget_est;

    @Column(name = "is_visited", nullable = false)
    private Boolean is_visited;

    @Column(name = "country", length = 255)
    private String country;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBudget_est() {
        return budget_est;
    }

    public void setBudget_est(Integer budget_est) {
        this.budget_est = budget_est;
    }

    public Boolean getIs_visited() {
        return is_visited;
    }

    public void setIs_visited(Boolean is_visited) {
        this.is_visited = is_visited;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}