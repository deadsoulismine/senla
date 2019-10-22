public class Main {
    public static void main (String [] args) {
        Library library = new Library();

        //Create books
        Book book1 = new Book ("Теремок", "Сказка");
        Book book2 = new Book ("Колобок", "Сказка");
        Book book3 = new Book ("Война и мир", "Роман");

        //Create readers list
        Reader reader1 = new Reader("Ваня", "Магадан");
        Reader reader2 = new Reader("Cергей", "Сургут");
        Reader reader3 = new Reader("Мария", "Тула");

        //Create records
        Record record1 = new Record("Ваня", "Колобок");
        Record record2 = new Record("Мария", "Война и мир");

        //add books
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        //add readers
        library.addReader(reader1);
        library.addReader(reader2);
        library.addReader(reader3);

        //add record
        library.addRecord(record1);
        library.addRecord(record2);

        //remove record
        library.removeRecord(record2);

        //book list
        for (Record n : library.bookList()) {
            System.out.println(n.getFullName()+" "+n.getTitle());
        }

        //reader list
        for (Reader n : library.readerList()) {
            System.out.println(n.getFullName() + " " + n.getAdress());
        }

        //reader's books
        System.out.println("Читатель '" + reader1.getFullName() + "'имеет книги:");
        for (Record n : library.bookList()) {
            if (n.getFullName() == reader1.getFullName()) {
                System.out.println(n.getTitle());
            }
            else {
                System.out.println("У читателя нет книг!");
            }
        }

        //book's reader
        System.out.println("Книга '" + book2.getTitle() + "' находится у:");
        for (Record n : library.bookList()) {
            if (n.getTitle() == book2.getTitle()) {
                System.out.println(n.getFullName());
            }
            else {
                System.out.println("Данная книга в библиотеке!");
            }
        }

    }

}
