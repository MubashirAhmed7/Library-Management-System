package io.github.mubashirahmed7.librarymanagement;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class LibraryManagement2{
    protected String[] student = {"Harry","John","Ahmed","Ram","Rahul","Shivam","Jarry","alen"};
    protected ArrayList<String> bookList = new ArrayList<>();
    protected ArrayList<String> issuedList = new ArrayList<>();
    protected ArrayList<String> libraryHistory = new ArrayList<>();

    public LibraryManagement2(){
        String[] book = {"data structure", "algorithm", "dbms", "networking", "design pattern", "java", "social", "system design", "c++"};
        Collections.addAll(bookList, book);
    }
    public boolean checkName(String name){
        for (String s : student) {
            if (s.equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
    public void add(String bookName){
        bookList.add(bookName);
    }
    public void issueBook(String bookName, String name){
        if (checkName(name)) {
            if (bookList.contains(bookName)){
                issuedList.add(bookName);
                bookList.remove(bookName);
                System.out.println("Book is issued!");
                libraryHistory.add("Book is issued to "+ name +" on "+ LocalDateTime.now());
            }else {
                System.out.println("No Book found in the library!");
            }
        }else {
            System.out.println("Student name does not match with library central data base!");
        }
    }
    public void returnIssuedBook(String bookName, String name){
        if (checkName(name)) {
            if (issuedList.contains(bookName)) {
                bookList.add(bookName);
                issuedList.remove(bookName);
                System.out.println("Book is returned!");
                libraryHistory.add("Book is returned by "+ name +" on "+ LocalDateTime.now());
            }else {
                System.out.println("No such book is issued before from this library!");
            }
        } else {
            System.out.println("Student name does not match with library central data base!");
        }
    }
    public ArrayList<String> seeBooks(){
        return new ArrayList<>(bookList);// return a shallow copy
    }
    public void seeIssuedBooks(){
        if(issuedList.isEmpty()){
            System.out.println("No books is issued to a student!");

        } else{
            System.out.println(libraryHistory);
        }
    }
    public void seeHistory(){
        if(libraryHistory.isEmpty()){
            System.out.println("No history in library, history only stored when the a book is Issued to a student or Returned by a student!");

        } else{
            System.out.println(libraryHistory);
        }
    }
}
public class LibraryManagement {
    static void main(String... args) {
        LibraryManagement2 l1 = new LibraryManagement2();
        System.out.println("Welcome to the library!");
        Scanner sc = new Scanner(System.in);
        while (true){
            try {
                System.out.println("Enter any number from 1-7 to use library management!");
                System.out.println("1-Add Book, 2-Issue Book, 3-Return Book, 4-See Available Books, 5-See Issued Books, 6-See Library Records, 7-Exit.");
                int choice = sc.nextByte();
                sc.nextLine();
                switch (choice){
                    case 1:
                        System.out.println("Enter book name to add in the library!");
                        String str = sc.next();
                        sc.nextLine();
                        l1.add(str);break;
                    case 2:
                        System.out.println("Enter a book name to issue!");
                        String str1 = sc.next();
                        sc.nextLine();
                        System.out.println("Enter your name to check from the existing student data base!");
                        String str2 = sc.nextLine();
                        l1.issueBook(str1,str2);
                        break;
                    case 3:
                        System.out.println("Enter a book name to return!");
                        String book = sc.next();
                        sc.nextLine();
                        System.out.println("Enter your name to check from the existing student data base!");
                        String name = sc.nextLine();
                        l1.returnIssuedBook(book,name);
                        break;
                    case 4:
                        System.out.println("See All the available books!");
                        System.out.println(l1.seeBooks());
                        break;
                    case 5:
                        System.out.println("See All the issued books!");
                        l1.seeIssuedBooks();
                        break;
                    case 6:
                        System.out.println("See All the issued date and time Record of the Library!");
                        l1.seeHistory();
                        break;
                    case 7:
                        System.out.println("Exiting...");
                        sc.close();
                        return;
                    default:
                        System.out.println("Please Enter any number from 1 to 7 to use the Library!");
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid key to run the library management functions!");
                sc.nextLine();
            }
        }
    }
}
