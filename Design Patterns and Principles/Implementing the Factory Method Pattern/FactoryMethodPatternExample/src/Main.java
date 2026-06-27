public class Main {
    public static void main(String[] args) {
        System.out.println("=== Document Management System (Factory Method Pattern) ===\n");

        // 1. Creating and processing a Word Document
        System.out.println("--- Scenario 1: Processing Word Document ---");
        DocumentFactory wordFactory = new DocumentFactory() {
            @Override
            public Document createDocument() {
                return new WordDocument();
            }
        };
        // Demonstrate direct creation
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();
        wordDoc.close();
        
        System.out.println();

        // 2. Creating and processing a PDF Document
        System.out.println("--- Scenario 2: Processing PDF Document ---");
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        // Demonstrate creation and processing via the factory's template method
        pdfFactory.processDocument();

        System.out.println();

        // 3. Creating and processing an Excel Document
        System.out.println("--- Scenario 3: Processing Excel Document ---");
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
        excelDoc.close();
    }
}

interface DocumentFactory {
    Document createDocument();

    default void processDocument() {
        Document document = createDocument();
        document.open();
        document.close();
    }
}

interface Document {
    void open();

    void close();
}

class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Word document");
    }

    @Override
    public void close() {
        System.out.println("Closing Word document");
    }
}

class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF document");
    }

    @Override
    public void close() {
        System.out.println("Closing PDF document");
    }
}

class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Excel document");
    }

    @Override
    public void close() {
        System.out.println("Closing Excel document");
    }
}

class PdfDocumentFactory implements DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}

class ExcelDocumentFactory implements DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}
