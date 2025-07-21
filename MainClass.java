package com.bookassignment;
import java.io.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;
public class MainClass {

	public static void main(String[] args) { //main method is a thread
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int size;
		System.out.println("Enter number of books");
		size=sc.nextInt();
		sc.nextLine();
		EngineeringBook[] eBookArr=new EngineeringBook[size];
		
		for(int i=0;i<eBookArr.length;i++) {
			System.out.println("Enter details for Engineering Books :");

            System.out.print("Book Title: ");
            String title = sc.nextLine();
            
            System.out.print("Author Name: ");
            String name = sc.nextLine();
            
            System.out.print("Author Email: ");
            String email = sc.nextLine();
            
            System.out.print("Author Gender (M/F): ");
            char gender = sc.next().charAt(0);
            sc.nextLine(); // consume leftover newline

            Author author = new Author(name, email, gender);

            // Book input
            
            System.out.print("Price: ");
            double price = sc.nextDouble();
            sc.nextLine(); // consume newline
            
            System.out.print("Publisher: ");
            String publisher = sc.nextLine();
            
            System.out.print("Copyright (Yes/No): ");
            String copyright = sc.nextLine();
            
            System.out.print("Quantity: ");
            int qty = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Category: ");
            String category = sc.nextLine();

            eBookArr[i] = new EngineeringBook(title, author, price, publisher, copyright, qty, category);
            
            
          }
		
		//Serialization
		
		try(
    			FileOutputStream fout=new FileOutputStream("books.txt");	
    			ObjectOutputStream oos=new ObjectOutputStream(fout);
    			){
    			oos.writeObject(eBookArr);
    			System.out.println("Object written into the File Successfully");
    		}
    		catch(IOException e) {
    			System.out.println(e);
    		}

		
        
            for(EngineeringBook eb:eBookArr){
            	
            	System.out.println(eb.toString()+eb.getCategory());
            
            }
            
            EngineeringBook[] booksFromFile = null;
            
            //De-serialization
            try (
                FileInputStream fin = new FileInputStream("books.txt");
                ObjectInputStream ois = new ObjectInputStream(fin);
            ) {
                booksFromFile = (EngineeringBook[]) ois.readObject();
                System.out.println("Books loaded from file successfully.");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error reading from file: " + e.getMessage());
            }
            

            if(booksFromFile!=null) {
            	System.out.println("Enter book number you want ");
            	int target=sc.nextInt();
            	EngineeringBook.searchBook(eBookArr, target) ;
            }
        		
        	
            sc.close();

	}

}
