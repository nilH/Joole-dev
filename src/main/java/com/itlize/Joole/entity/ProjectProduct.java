package com.itlize.Joole.entity;


import javax.persistence.*;

@Entity
@Table(name="project_product")
public class ProjectProduct {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="PR_id")
    private int id;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="product_id")
    private Integer productId;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="project_id")
    private Integer projectId;


}
