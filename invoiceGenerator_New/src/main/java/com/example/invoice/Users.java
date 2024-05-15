package com.example.invoice;


import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String password;
    private String email;
    private LocalDate signInDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Invoices> invoices;
  
    // Getters and Setters

	public Long getId() {
		return userId;
	}

	public void setId(Long id) {
		this.userId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Invoices> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoices> invoices) {
		this.invoices = invoices;
	}

	public LocalDate getSignInDate() {
		return signInDate;
	}

	public void setSignInDate(LocalDate signInDate) {
		this.signInDate = signInDate;
	}

   
    
}
