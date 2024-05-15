package com.example.Unittesting;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.invoice.InvoiceRepository;
import com.example.invoice.Invoices;
@DataJpaTest

public class InvoiceRepositoryTest {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Test
    public void testSaveInvoice() {
     
        Invoices invoice = new Invoices();
        invoice.setClientName("Client A");
        invoice.setDate(LocalDate.now());
        invoice.setAmount(1000);
        invoice.setId(3L);
        Invoices savedInvoice = invoiceRepository.save(invoice);

        // Verify that the invoice is saved with an ID
        assertNotNull(savedInvoice.getId());
        assertEquals("Client A", savedInvoice.getClientName());
        assertEquals(LocalDate.now(), savedInvoice.getDate());
        assertNotEquals(8000, savedInvoice.getAmount());
        assertNotEquals(5L, savedInvoice.getId());
        
    }

    @Test
    public void findNonExistentInvoiceByIdTest() {
       
        Optional<Invoices> foundInvoice = invoiceRepository.findById(-1L);
        assertFalse(foundInvoice.isPresent());
    }
    
    @Test
    public void saveNullInvoice() {
        try {
        	invoiceRepository.save(null);
        } catch (Exception e) {
            return;
        }
        // If no exception was thrown, fail the test
        fail("Expected IllegalArgumentException was not thrown");
    }
    @Test
    public void deleteInvoiceTest() {
       
        Invoices invoice = new Invoices();
        invoiceRepository.save(invoice);
        invoiceRepository.delete(invoice);
        Optional<Invoices> deletedInvoice = invoiceRepository.findById(invoice.getId());
        assertFalse(deletedInvoice.isPresent());
    }

   



    
}
