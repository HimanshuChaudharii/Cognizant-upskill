// Document interface for the Factory Method pattern
interface Document {
    void open();

    void close();
}

// Concrete Product: Excel Document
public class ExcelDocument implements Document {
    public void open() {
        System.out.println("Opening Excel Spreadsheet (.xlsx)...");
    }

    public void close() {
        System.out.println("Closing Excel Spreadsheet (.xlsx)...");
    }
}
