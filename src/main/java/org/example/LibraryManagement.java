package org.example;

// 1. Interface for Borrowable Items
interface Borrowable {
    void borrow();

    void returnBook();
}

// 2. Abstract Class: 
abstract class Book {
    private String title;
    private String author;
    protected boolean isAvailable = true;


    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // (Encapsulation)
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }


    public abstract void displayInfo();
}

//  3. Inheritance
class EBook extends Book implements Borrowable {
    private String downloadLink;

    // Constructor
    public EBook(String title, String author, String downloadLink) {
        super(title, author);
        this.downloadLink = downloadLink;
    }


    @Override
    public void displayInfo() {
        System.out.println("E-Manga: " + getTitle() + " Author: " + getAuthor());
        System.out.println("Download at: " + downloadLink);
    }


    @Override
    public void borrow() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(getTitle() + "--borrowed good.");
        } else {
            System.out.println(getTitle() + "--already borrowed hai.");
        }
    }

    @Override
    public void returnBook() {
        isAvailable = true;
        System.out.println(getTitle() + "--wapas de di successfully.");
    }
}

//  4. Child Class: PrintedBook (Demonstrating Inheritance)
class PrintedBook extends Book implements Borrowable {
    private int totalPages;


    public PrintedBook(String title, String author, int totalPages) {
        super(title, author);
        this.totalPages = totalPages;
    }

    @Override
    public void displayInfo() {
        System.out.println("Book: " + getTitle() + " Author: " + getAuthor());
        System.out.println("Total Pages: " + totalPages);
    }

    @Override
    public void borrow() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(getTitle() + "--borrowed good.");
        } else {
            System.out.println(getTitle() + "--already borrowed hai.");
        }
    }

    @Override
    public void returnBook() {
        isAvailable = true;
        System.out.println(getTitle() + "--wapas de di successfully.");
    }
}

//  5. Main Class 
public class LibraryManagement {
    public static void main(String[] args) {

        EBook manga = new EBook("Dragon Ball Z ", "Akira Toriyama", "www.DragonBallZ.com");
        PrintedBook printedManga = new PrintedBook("Icha-Icha  ", "Jiraya Sensei", 350);
        System.out.println();

        manga.displayInfo();
        printedManga.displayInfo();
        System.out.println();


        manga.borrow();
        printedManga.borrow();
        System.out.println();

        // borrow again
        manga.borrow();
        printedManga.borrow();
        System.out.println();

        // Returning
        manga.returnBook();
        printedManga.returnBook();
        System.out.println();

        // Borrowing again
        manga.borrow();
        printedManga.borrow();
        System.out.println();
    }
}
