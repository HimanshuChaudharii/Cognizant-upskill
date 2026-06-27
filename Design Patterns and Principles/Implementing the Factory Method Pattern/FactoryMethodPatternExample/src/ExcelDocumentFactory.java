// Concrete Creator: Excel Document Factory
abstract class DocumentFactory {
    public abstract Document createDocument();
}

interface Document {}

class ExcelDocument implements Document {}

public class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}
