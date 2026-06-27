// Concrete Creator: Word Document Factory
public class WordDocumentFactory implements DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

interface DocumentFactory {
    Document createDocument();
}

interface Document {
}

class WordDocument implements Document {
}
