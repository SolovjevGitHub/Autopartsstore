package com.intellisoft.autopartsstore.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "car_models")
public class CarModel implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "model")
    private String model;
    @Column(name = "body_code")
    private String bodyCode;
    @Column(name = "engine_type")
    private String engineType;
    @Column(name = "engine_capacit")
    private Float engineCapacit;
    @Column(name = "power")
    private Integer power;
    @Column(name = "year_from")
    private Integer yearFrom;
    @Column(name = "year_to")
    private Integer yearTo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="car_makes_id")
    private CarMaker carMaker;
    @OneToMany(fetch = FetchType.LAZY,targetEntity = Autopart.class,mappedBy = "carModel")
    private List<Autopart> autoparts=new ArrayList<Autopart>();

    /**constructor*/

    public CarModel() {}

    public CarModel(String model, String bodyCode, String engineType, float engineCapacit, Integer power, Integer yearFrom, Integer yearTo) {
        this.model = model;
        this.bodyCode = bodyCode;
        this.engineType = engineType;
        this.engineCapacit = engineCapacit;
        this.power = power;
        this.yearFrom = yearFrom;
        this.yearTo = yearTo;
    }

    /**getter and setter*/

    public Float getEngineCapacit() {
        return engineCapacit;
    }

    public List<Autopart> getAutoparts() {
        return autoparts;
    }

    public void setAutoparts(List<Autopart> autoparts) {
        this.autoparts = autoparts;
    }

    public void setEngineCapacit(Float engineCapacit) {
        this.engineCapacit = engineCapacit;
    }

    public CarMaker getCarMaker() {
        return carMaker;
    }

    public void setCarMaker(CarMaker carMaker) {
        this.carMaker = carMaker;
    }

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBodyCode() {
        return bodyCode;
    }

    public void setBodyCode(String bodyCode) {
        this.bodyCode = bodyCode;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }



    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getYearFrom() {
        return yearFrom;
    }

    public void setYearFrom(Integer yearFrom) {
        this.yearFrom = yearFrom;
    }

    public Integer getYearTo() {
        return yearTo;
    }

    public void setYearTo(Integer yearTo) {
        this.yearTo = yearTo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CarModel{");
        sb.append("id=").append(id);
        sb.append(", model='").append(model).append('\'');
        sb.append(", bodyCode='").append(bodyCode).append('\'');
        sb.append(", engineType='").append(engineType).append('\'');
        sb.append(", engineCapacit=").append(engineCapacit);
        sb.append(", power=").append(power);
        sb.append(", yearFrom=").append(yearFrom);
        sb.append(", yearTo=").append(yearTo);
        sb.append('}');
        return sb.toString();
    }
}
