package com.intellisoft.autopartsstore.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "autoparts")
public class Autopart implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "part_number")
    private String partNumber;
    @Column(name = "note")
    private String note;
    @Column(name = "quantity_sold")
    private String quantitySold;
    @Column(name = "warranty")
    private String warranty;
    @Column(name = "price")
    private Float price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autopart_brands_id")
    private AutopartBrand autopartBrand;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "part_categories_id")
    private AutopartCategorie autopartCategories;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_models_id")
    private CarModel carModel;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "autoparts")
    private List<Order> orders = new ArrayList<Order>();

    /**constructor*/
    public Autopart() {
    }



    /**getter and setter*/

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public AutopartBrand getAutopartBrand() {
        return autopartBrand;
    }

    public void setAutopartBrand(AutopartBrand autopartBrand) {
        this.autopartBrand = autopartBrand;
    }

    public AutopartCategorie getAutopartCategories() {
        return autopartCategories;
    }

    public void setAutopartCategories(AutopartCategorie autopartCategories) {
        this.autopartCategories = autopartCategories;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

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

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(String quantitySold) {
        this.quantitySold = quantitySold;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Autopart{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", partNumber='").append(partNumber).append('\'');
        sb.append(", note='").append(note).append('\'');
        sb.append(", quantitySold='").append(quantitySold).append('\'');
        sb.append(", warranty='").append(warranty).append('\'');
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
