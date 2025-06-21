package factories;

import documents.Document;

public abstract class DocumentFactory {
    // The factory method
    public abstract Document createDocument();

    // Common operations can be implemented here
    public void processDocument() {
        Document doc = createDocument();
        doc.open();
        doc.save();
        doc.close();
    }
}