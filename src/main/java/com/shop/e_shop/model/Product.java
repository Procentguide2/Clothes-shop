package com.shop.e_shop.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "img", length = 100)
    private String img;

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "price")
    private Float price;

    @Column(name = "gender", length = 5)
    private String gender;

    @Column(name = "size", length = 100)
    private String size;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_color")
    private Color idColor;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_category")
    private Category idCategory;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Color getIdColor() {
        return idColor;
    }

    public void setIdColor(Color idColor) {
        this.idColor = idColor;
    }

    public Category getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Category idCategory) {
        this.idCategory = idCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(img, product.img) && Objects.equals(title, product.title) && Objects.equals(description, product.description) && Objects.equals(price, product.price) && Objects.equals(gender, product.gender) && Objects.equals(size, product.size) && Objects.equals(idColor, product.idColor) && Objects.equals(idCategory, product.idCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, img, title, description, price, gender, size, idColor, idCategory);
    }
}