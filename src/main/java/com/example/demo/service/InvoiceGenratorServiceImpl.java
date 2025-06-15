package com.example.demo.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Service;

import com.example.demo.model.Item;
import com.example.demo.model.Order;

@Service
public class InvoiceGenratorServiceImpl implements InvoiceGeneratorService {

    @Override
    public byte[] genrateInvoice(Order order) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        // Add Header
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 16);
        contentStream.beginText();
        contentStream.newLineAtOffset(50, 750);
        contentStream.showText("Invoice");
        contentStream.endText();

        // Customer Name
        contentStream.setFont(PDType1Font.HELVETICA, 12);
        contentStream.beginText();
        contentStream.newLineAtOffset(50, 720);
        contentStream.showText("Customer Name: " + order.getCustomerName());
        contentStream.endText();

        // Table Header
        contentStream.beginText();
        contentStream.newLineAtOffset(50, 680);
        contentStream.showText("Item");
        contentStream.newLineAtOffset(200, 0);
        contentStream.showText("Quantity");
        contentStream.newLineAtOffset(100, 0);
        contentStream.showText("Unit Price");
        contentStream.endText();

        // Table Data
        int yOffset = 660;
        for (Item item : order.getItems()) {
            contentStream.beginText();
            contentStream.newLineAtOffset(50, yOffset);
            contentStream.showText(item.getProductName());
            contentStream.newLineAtOffset(200, 0);
            contentStream.showText(String.valueOf(item.getQuantity()));
            contentStream.newLineAtOffset(100, 0);
            contentStream.showText("RS" + item.getUnitPrice());
            contentStream.endText();
            yOffset -= 20;
        }

        // Total
        contentStream.beginText();
        contentStream.newLineAtOffset(50, yOffset - 20);
        double totalAmount = calculateTotal(order.getItems());
        contentStream.showText("Total Amount: RS" + totalAmount);
        contentStream.endText();

        contentStream.close();
        document.save(baos);
        document.close();

        return baos.toByteArray();
    }

    private double calculateTotal(List<Item> items) {
        double total = 0;
        for (Item item : items) {
            total += item.getQuantity() * item.getUnitPrice();
        }
        return total;
    }
}
