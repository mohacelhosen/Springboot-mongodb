
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;

public class DemoPdf {
    public static void main(String[] args) {
        String path = "E:\\Practice\\PDF\\test.pdf";
        try (PdfWriter pdfWriter = new PdfWriter(path);
             PdfDocument pdfDocument = new PdfDocument(pdfWriter);
             Document document = new Document(pdfDocument)) {

            String imgPath = "E:\\Practice\\productivity.png";
            String[] header = {"Product", "Qty", "Price", "Image"};

            // Create ImageData and Image objects for the original image outside the loop
            ImageData originalImageData = ImageDataFactory.create(imgPath);
            Image originalImage = new Image(originalImageData);
            // Set the width and height of the original image
            originalImage.setWidth(UnitValue.createPointValue(50)); // Set width to 50 points
            originalImage.setHeight(UnitValue.createPointValue(50)); // Set height to 50 points

            String[][] productList = {
                    {"Monitor", "1", "5600", imgPath},
                    {"RAM", "2", "5800", imgPath},
                    {"Keyboard", "3", "2500", imgPath},
                    {"Mouse", "4", "1200", imgPath},
                    {"Headphones", "5", "3500", imgPath},
                    {"Laptop", "6", "25000", imgPath},
                    {"Printer", "7", "4500", imgPath},
                    {"Desk Chair", "8", "1800", imgPath},
                    {"Webcam", "9", "1500", imgPath},
                    {"External Hard Drive", "10", "4000", imgPath}
            };

            float[] columnWidth = {200, 100, 100, 50};
            Table table = new Table(columnWidth);
            table.setHorizontalAlignment(HorizontalAlignment.CENTER);

            // Create a centered title
            Paragraph title = new Paragraph("Shopping List").setTextAlignment(TextAlignment.CENTER);
            title.setFontSize(18);
            title.setFontColor(new DeviceRgb(0, 0, 255));
            document.add(title);

            // Add the headers in the first row
            for (String i : header) {
                table.addCell(new Cell().add(new Paragraph(i)).setBackgroundColor(new DeviceRgb(156, 104, 122)));
            }

            // Add product data rows
            for (int i = 0; i < productList.length; i++) {
                String[] singleProduct = productList[i];
                for (int j = 0; j < singleProduct.length; j++) {
                    if (j == 3) {
                        table.addCell(new Cell().add(originalImage));
                    } else {
                        // Add the text data for other columns
                        table.addCell(new Cell().add(new Paragraph(singleProduct[j]))).setBackgroundColor(new DeviceRgb(56, 104, 122));
                    }
                }
            }

            // Add the table to the document
            document.add(table);

            // Close the document, PdfDocument, and PdfWriter
            document.close();
            pdfDocument.close();
            pdfWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Done😇");
    }
}
