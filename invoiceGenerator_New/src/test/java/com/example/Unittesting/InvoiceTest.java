package com.example.Unittesting;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.example.invoice.Invoices;

public class InvoiceTest {

    @Test
    public void testGetters() {
       
        Invoices invoice = new Invoices();
        assertEquals(2, invoice.getId());
        assertNotEquals("Client Name", invoice.getClientName());
        assertEquals(LocalDate.of(2024, 5, 20), invoice.getDate());
        assertNotEquals(1000.0, invoice.getAmount());
        
    }

    @Test
    public void testSetters() {
        
    	 Invoices invoice = new Invoices();

        invoice.setId(1L);
        invoice.setClientName("Client Name");
        invoice.setDate(LocalDate.of(2022, 5, 15));
        invoice.setAmount(9000);
       

        // Verify using getters
        assertEquals(1L, invoice.getId());
        assertEquals("Client Name", invoice.getClientName());
        assertEquals(LocalDate.of(2022, 5, 15), invoice.getDate());
        assertEquals(9000, invoice.getAmount());
        
    }

    
}

