package com.itlize.Joole.entity;

import javax.persistence.*;
import java.util.Objects;


@Table(name = "product_type")
@Entity
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_type_id")
    private int productTypeId;
    @Column(name = "attribute_name")
    private String attributeName;
    private String value;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    public int getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==this){
            return true;
        }
        if(!(obj instanceof ProductType)){
            return false;
        }
        ProductType productType=(ProductType) obj;
        return productTypeId==productType.productTypeId && value==productType.value && attributeName.equals(productType.attributeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productTypeId,attributeName,value);
    }
}
