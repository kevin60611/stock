package com.example.portfolio.model.po;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Entity
@Immutable
@Subselect("SELECT ROW_NUMBER() OVER() AS id, p.investor_id as invid, c.name as name, SUM(p.amount * (s.price-p.cost)) as subtotal "
        + "FROM Classify c, Portfolio p, TStock s "
        + "WHERE p.t_stock_id = s.id AND s.classify_id = c.id "
        + "GROUP BY p.investor_id, c.name") // p.investor.id=:id AND 
@Getter
@Setter
public class Profit {
    @Id
    private Integer id;
    
    @Column
    private Integer invid;
    
    @Column
    private String name;
    
    @Column
    private Double subtotal;

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

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getInvid() {
        return invid;
    }

    public void setInvid(Integer invid) {
        this.invid = invid;
    }

    
}