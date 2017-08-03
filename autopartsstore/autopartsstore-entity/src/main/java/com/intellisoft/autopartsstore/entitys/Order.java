package com.intellisoft.autopartsstore.entitys;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "number")
    private Integer number;
    @Column(name = "date")
    private Date date;
    @Column(name = "price")
    private Float price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private User user;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "autoparts_has_orders",joinColumns = {@JoinColumn(name = "orders_id")},inverseJoinColumns = {@JoinColumn(name = "autoparts_id")})
    private List<Autopart> autoparts=new ArrayList<Autopart>();

    /**constructor*/
    public Order() {}

    public Order(Integer number, Date date, Float price) {
        this.number = number;
        this.date = date;
        this.price = price;
    }

    /**getter and setter*/

    public List<Autopart> getAutoparts() {
        return autoparts;
    }

    public void setAutoparts(List<Autopart> autoparts) {
        this.autoparts = autoparts;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("id=").append(id);
        sb.append(", number=").append(number);
        sb.append(", date=").append(date);
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
