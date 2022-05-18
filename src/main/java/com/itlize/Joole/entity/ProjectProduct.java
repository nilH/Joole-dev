package com.itlize.Joole.entity;


import javax.persistence.*;

@Entity
@Table(name="project_product")
public class ProjectProduct {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="PR_id")
    private int id;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="project_id")
    private Project project;


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }


}
