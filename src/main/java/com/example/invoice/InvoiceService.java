package com.example.invoice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    private static final Logger logger = LoggerFactory.getLogger(InvoiceService.class);

    public Invoices createInvoice(Invoices invoice) {
        logger.info("Creating invoice: {}", invoice);
        return invoiceRepository.save(invoice);
    }

    public List<Invoices> getAllInvoices() {
        logger.info("Fetching all invoices");
        return invoiceRepository.findAll();
    }
    public Invoices findById(Long id) {
        logger.info("Finding invoice by ID: {}", id);
        return invoiceRepository.findById(id).orElse(null);
    }

    public void deleteInvoice(Long id) {
        logger.info("Deleting invoice with ID {}", id);
        invoiceRepository.deleteById(id);
    }
 
    public Invoices updateInvoice(Long id, Invoices updatedInvoice) {
        logger.info("Updating invoice with ID {} in service", id);
        Invoices existingInvoice = invoiceRepository.findById(id).orElse(null);
        if (existingInvoice != null) {
            existingInvoice.setClientName(updatedInvoice.getClientName());
            existingInvoice.setDate(updatedInvoice.getDate());
            existingInvoice.setAmount(updatedInvoice.getAmount());
            //existingInvoice.setUser(updatedInvoice.getUser());
            return invoiceRepository.save(existingInvoice);
        } else {
            logger.warn("Invoice with ID {} not found", id);
            return null;
        }
    }

 
}
