package com.itlize.Joole.entity;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="project")
public class Project {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="project_id")
    private int id;

    @Column(name="project_name")
    private String projectName;

    @Column(name="time_update")
    private LocalDateTime timeUpdate;

    @Column(name="time_created")
    private LocalDateTime timeCreated;


    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="customer_id")
    private User user;
    @OneToMany(fetch=FetchType.LAZY,
            mappedBy="project",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private Set<ProjectProduct> projectProduct;


    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public LocalDateTime getTimeUpdate() {
        return timeUpdate;
    }

    public void setTimeUpdate(LocalDateTime timeUpdate) {
        this.timeUpdate = timeUpdate;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }


    public Set<ProjectProduct> getProjectProduct() {
        return projectProduct;
    }

    public void setProjectProduct(Set<ProjectProduct> projectProduct) {
        this.projectProduct = projectProduct;
    }


}
