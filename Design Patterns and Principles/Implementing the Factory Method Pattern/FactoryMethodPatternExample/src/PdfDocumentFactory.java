// Concrete Creator: PDF Document Factory
public class PdfDocumentFactory implements DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}
