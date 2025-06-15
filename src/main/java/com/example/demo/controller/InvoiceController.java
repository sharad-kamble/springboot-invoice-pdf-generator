package com.example.demo.controller;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Item;
import com.example.demo.model.Order;
import com.example.demo.service.InvoiceGeneratorService;

@RestController
public class InvoiceController {

    @Autowired
    InvoiceGeneratorService genratorService;

    @GetMapping("getInvoice/{orderId}")
    public ResponseEntity<byte[]> getInvoice(@PathVariable("orderId") int orderId) throws IOException {

        // Meaningful item data
        Item i1 = new Item("Wireless Mouse", 2, 799.00);
        Item i2 = new Item("Mechanical Keyboard", 1, 3499.00);
        Item i3 = new Item("Laptop Stand", 1, 1250.00);
        Item i4 = new Item("USB-C Hub", 3, 599.00);
        Item i5 = new Item("Noise Cancelling Headphones", 1, 6999.00);

        // Simulated order with customer name and list of items
        Order order = new Order(orderId, "Sharad kamble", Arrays.asList(i1, i2, i3, i4, i5));
        
        // Generate invoice as PDF
        byte[] bytes = genratorService.genrateInvoice(order);

        // Set response headers
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/pdf");

        return ResponseEntity.ok().headers(headers).body(bytes);
    }
}
