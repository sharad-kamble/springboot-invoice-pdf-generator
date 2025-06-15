package com.example.demo.service;

import java.io.IOException;

import com.example.demo.model.Order;


public interface InvoiceGeneratorService {
    public byte[] genrateInvoice(Order order) throws IOException;
}
