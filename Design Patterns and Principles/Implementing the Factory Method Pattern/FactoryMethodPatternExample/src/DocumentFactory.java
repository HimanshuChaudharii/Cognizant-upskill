// Abstract Creator Class
public abstract class DocumentFactory {
    // Simple Document type declaration to ensure the type is available.
    // Implementations can provide their own Document implementations.
    public static interface Document {
        void open();
        void close();
    }
    
    // The Factory Method
    public abstract Document createDocument();

    // Business logic that works with the created documents
    public void processDocument() {
        Document doc = createDocument();
        doc.open();
        // Additional operations on document
        doc.close();
    }
}
