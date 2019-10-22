import java.lang.reflect.Array;
import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Record> records = new ArrayList<>();
    private ArrayList<Reader> readers = new ArrayList<>();

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Record> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<Record> records) {
        this.records = records;
    }

    public ArrayList<Reader> getReaders() {
        return readers;
    }

    public void setReaders(ArrayList<Reader> readers) {
        this.readers = readers;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addReader(Reader reader) {
        readers.add(reader);
    }

    public void addRecord(Record record) {
        records.add(record);
    }

    public void removeRecord(Record record) {
        records.remove(record);
    }

    public ArrayList<Reader> readerList() {
        return getReaders();
    }

    public ArrayList<Record> bookList() {
        return getRecords();
    }


}
