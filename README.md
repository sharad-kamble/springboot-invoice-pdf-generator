
# 🧾 Invoice PDF Generator using Spring Boot & PDFBox

This project is a Spring Boot application that dynamically generates PDF invoices based on customer orders. The invoice includes itemized product details like name, quantity, unit price, and total amount, and is returned as a downloadable PDF.

---

## 📌 Features

- Generate invoice PDF on-the-fly
- Use of Apache PDFBox to create structured PDF layout
- RESTful endpoint to trigger invoice generation
- Easy to customize for real-world use cases (e.g. add billing, logo, date)
- Lightweight and simple to understand

---

## 🚀 Technologies Used

- Java 17+
- Spring Boot
- Apache PDFBox
- Maven

---

## 🗂️ Project Structure

```

src/
├── main/
│   ├── java/com/example/demo/
│   │   ├── controller/InvoiceController.java
│   │   ├── model/Item.java
│   │   ├── model/Order.java
│   │   └── service/
│   │       ├── InvoiceGeneratorService.java
│   │       └── InvoiceGenratorServiceImpl.java

````

---

## 🔧 How It Works

### 1. Sample Endpoint
> URL: `http://localhost:8080/getInvoice/123`

This endpoint will generate and return a **PDF invoice** for the order with ID `123` and a hardcoded list of items.

### 2. PDF Structure Includes:
- Invoice Header
- Customer Name
- Product Name, Quantity, Unit Price
- Total Amount

---

## 📦 Sample Data in PDF

- **Customer:** John Wick  
- **Items:**
  - Wireless Mouse (2 × ₹799)
  - Mechanical Keyboard (1 × ₹3499)
  - Laptop Stand (1 × ₹1250)
  - USB-C Hub (3 × ₹599)
  - Noise Cancelling Headphones (1 × ₹6999)

---

## 🔁 API Usage

### Request
```http
GET /getInvoice/{orderId}
Host: localhost:8080
````

### Response

* Returns: `application/pdf` file (Content-Disposition: inline/download)

---

## 📄 Sample Output

A sample invoice PDF will look like:

```
Invoice
Customer Name: John Wick

Item                    Quantity      Unit Price
Wireless Mouse          2             ₹799
Mechanical Keyboard     1             ₹3499
...
Total Amount: ₹XXXXX
```

---

## 🧑‍💻 Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/invoice-pdf-generator.git
cd invoice-pdf-generator
```

### 2. Build & Run the App

```bash
mvn spring-boot:run
```

### 3. Access Endpoint

```
http://localhost:8080/getInvoice/123
```

---

## 📚 Dependencies

Make sure the following is in your `pom.xml`:

```xml
<dependency>
    <groupId>org.apache.pdfbox</groupId>
    <artifactId>pdfbox</artifactId>
    <version>2.0.27</version>
</dependency>
```

---

## 📬 Contact

**Sharad Kamble**
📧 [sharadkamble131@gmail.com](mailto:sharadkamble131@gmail.com)
🔗 [LinkedIn](#) | [GitHub](https://github.com/sharad-kamble)

---

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).

```

---

Let me know if you'd like me to:
- Add a sample screenshot of the PDF
- Create a downloadable `.zip` with everything
- Generate the actual GitHub repo structure for upload

Would you also like a `LICENSE` file (MIT, Apache, etc.)?
```
