# Library Management System (Java)

## Overview
This is a simple **Library Management System** implemented in Java, demonstrating key Object-Oriented Programming (OOP) concepts such as **Encapsulation, Inheritance, Abstraction, and Interfaces**.

## Features
- **Encapsulation**: Private attributes with public getter methods.
- **Inheritance**: `EBook` and `PrintedBook` classes inherit from `Book`.
- **Abstraction**: `Book` is an abstract class that defines a blueprint for book types.
- **Interface Implementation**: `Borrowable` interface ensures books can be borrowed and returned.

## Project Structure
```
org.example
│-- Borrowable.java (Interface for borrowable items)
│-- Book.java (Abstract class defining common properties of books)
│-- EBook.java (Child class representing an electronic book)
│-- PrintedBook.java (Child class representing a printed book)
│-- LibraryManagement.java (Main class to execute the program)
```

## Classes & Implementation

### 1. `Borrowable` (Interface)
Defines two essential methods for book borrowing:
```java
interface Borrowable {
    void borrow();
    void returnBook();
}
```

### 2. `Book` (Abstract Class)
Defines common attributes (`title`, `author`, `isAvailable`) and abstract method `displayInfo()`.
```java
abstract class Book {
    private String title;
    private String author;
    protected boolean isAvailable = true;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }
    
    public abstract void displayInfo();
}
```

### 3. `EBook` (Subclass)
Extends `Book` and implements `Borrowable`.
```java
class EBook extends Book implements Borrowable {
    private String downloadLink;

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
```

### 4. `PrintedBook` (Subclass)
Represents physical books with additional `totalPages` attribute.
```java
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
```

### 5. `LibraryManagement` (Main Class)
Demonstrates the creation, borrowing, and returning of books.
```java
public class LibraryManagement {
    public static void main(String[] args) {
        EBook manga = new EBook("Dragon Ball Z ", "Akira Toriyama", "www.DragonBallZ.com");
        PrintedBook printedManga = new PrintedBook("Icha-Icha ", "Jiraya Sensei", 350);

        manga.displayInfo();
        printedManga.displayInfo();
        System.out.println();

        manga.borrow();
        printedManga.borrow();
        System.out.println();

        manga.borrow(); // Try borrowing again
        printedManga.borrow();
        System.out.println();

        manga.returnBook();
        printedManga.returnBook();
        System.out.println();

        manga.borrow(); // Borrow again after returning
        printedManga.borrow();
    }
}
```

## How to Run
### 1. Compile the program
```
javac LibraryManagement.java
```
### 2. Run the program
```
java LibraryManagement
```

## Expected Output
```
E-Manga: Dragon Ball Z  Author: Akira Toriyama
Download at: www.DragonBallZ.com
Book: Icha-Icha  Author: Jiraya Sensei
Total Pages: 350

Dragon Ball Z --borrowed good.
Icha-Icha --borrowed good.

Dragon Ball Z --already borrowed hai.
Icha-Icha --already borrowed hai.

Dragon Ball Z --wapas de di successfully.
Icha-Icha --wapas de di successfully.

Dragon Ball Z --borrowed good.
Icha-Icha --borrowed good.
```

## Conclusion
This project effectively demonstrates OOP principles in Java through a **Library Management System**, showcasing how interfaces, abstraction, and inheritance work together in a real-world scenario.

