package com.example.Users;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.example.invoice.Invoices;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
//import jakarta.persistence.Table;
//import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Table;



//@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "username")})
@Entity
@Table(name = "Users")
public class Users {

//    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @Column(name = "userName")
    private String userName;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "signInDate")
    private LocalDate signInDate;
    
    @JdbcTypeCode(SqlTypes.JSON)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Invoices> invoices;
    
    public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getSignInDate() {
		return signInDate;
	}
	public void setSignInDate(LocalDate signInDate) {
		this.signInDate = signInDate;
	}
	
    
    
  

    
}

