import documents.Document;
import factories.*;

public class Main {
    public static void main(String[] args) {
        // Create factories
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        System.out.println("=== Creating and processing documents ===");
        
        // Use factories to create documents
        Document wordDoc = wordFactory.createDocument();
        Document pdfDoc = pdfFactory.createDocument();
        Document excelDoc = excelFactory.createDocument();

        // Use the documents
        wordDoc.open();
        wordDoc.save();
        wordDoc.close();

        pdfDoc.open();
        pdfDoc.save();
        pdfDoc.close();

        excelDoc.open();
        excelDoc.save();
        excelDoc.close();

        System.out.println("\n=== Processing documents through factory methods ===");
        wordFactory.processDocument();
        pdfFactory.processDocument();
        excelFactory.processDocument();

        System.out.println("\n=== Using document-specific methods ===");
        // Need to cast to access specific methods
        if (wordDoc instanceof WordDocument) {
            ((WordDocument) wordDoc).edit();
        }

        if (pdfDoc instanceof PdfDocument) {
            ((PdfDocument) pdfDoc).preview();
        }

        if (excelDoc instanceof ExcelDocument) {
            ((ExcelDocument) excelDoc).calculate();
        }
    }
}