package com.itlize.Joole.entity;


import javax.persistence.*;

@Entity
@Table(name="project_product")
public class ProjectProduct {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="PR_id")
    private Integer id;

    @ManyToOne(cascade=CascadeType.DETACH)
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToOne(cascade=CascadeType.DETACH)
    @JoinColumn(name="project_id")
    private Project project;


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

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
