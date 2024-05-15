package com.example.invoice;

import java.time.LocalDate;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.example.Users.Users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
import jakarta.persistence.Table;


@Entity

@Table(name = "Invoices")
public class Invoices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "clientName")
    private String clientName;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "amount")
    private int amount;
    @Column(name = "userId")
    private Users userId;
   
    @JdbcTypeCode(SqlTypes.JSON)
    @ManyToOne
    @JoinColumn(name = "userId")
    private Users user;
    
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int d) {
        this.amount =  d;
    }
    
//    public Users getUser() {
//        return userName;
//    }
//
//    public void setUser(Users name) {
//        this.userName = name;
//    }
//    
   
//    // Method to update
//    public void update(Invoices updatedInvoice) {
//        logger.info("Updating invoice with ID {}", this.id);
//        this.clientName = updatedInvoice.getClientName();
//        this.date = updatedInvoice.getDate();
//        this.amount = updatedInvoice.getAmount();
//       this.userid = updatedInvoice.getUser();
//    }
}
