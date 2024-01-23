package com.example.stock.model.entity;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "purchase")
@Getter
@Setter
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 採購單序號

    @Column
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date; // 採購日期

    @Column(name = "expected_arrival_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expectedArrivalDate; // 預計到貨日

    @JoinColumn(name = "supplier_id") // 供應商序號(外鍵)
    @ManyToOne
    private Supplier supplier;

    @JoinColumn(name = "employee_id") // 員工序號(外鍵)
    @ManyToOne
    private Employee employee;

    @OneToMany(mappedBy = "purchase")
    @OrderBy("id ASC")
    private Set<PurchaseItem> purchaseItems = new LinkedHashSet<>();

    @Override
	public String toString() {
		return "Purchase [id=" + id + ", date=" + date + ", expectedArrivalDate=" + expectedArrivalDate + ", supplier="
				+ supplier + ", employee=" + employee + "]";
	}

	
}
