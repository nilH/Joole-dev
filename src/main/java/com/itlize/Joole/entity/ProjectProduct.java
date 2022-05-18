package com.itlize.Joole.entity;


import javax.persistence.*;

@Entity
@Table(name="project_product")
public class ProjectProduct {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="PR_id")
    private Integer PR_id;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="product_id")
    private Product product;


    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="project_id")
    private Project project;



    @Column(name="time_created")
    private Date time_created;

    public ProjectProduct( Date time_created/*, Date time_updated*/) {
        this.time_created = time_created;
        //this.time_updated = time_updated;
    }

    public ProjectProduct() {

    }

    public Date getTime_created(){ return time_created;}

    public void setTime_created(){this.time_created = time_created;}

    public Product getProducts() {
        return product;
    }

    public void setProducts(Product product) {
        this.product = product;
    }


    public Project getProjects() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }



}
