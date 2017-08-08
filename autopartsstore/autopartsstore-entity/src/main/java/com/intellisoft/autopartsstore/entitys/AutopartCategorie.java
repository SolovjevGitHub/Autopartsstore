package com.intellisoft.autopartsstore.entitys;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "autopart_categories")
public class AutopartCategorie implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;
    @OneToMany(fetch = FetchType.LAZY,targetEntity = Autopart.class,mappedBy = "autopartCategories")
    private List<Autopart> autoparts=new ArrayList<Autopart>();

    /**onstructor*/

    public AutopartCategorie() {
    }

    public AutopartCategorie(String name) {
        this.name = name;
    }



    /**getter and setter*/


    public List<Autopart> getAutoparts() {
        return autoparts;
    }

    public void setAutoparts(List<Autopart> autoparts) {
        this.autoparts = autoparts;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AutopartCategorie{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
