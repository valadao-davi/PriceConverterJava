package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Set the path for your products: ");
		String strPath =  sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(strPath))){
			String line = br.readLine();
			while(line != null) {
				String[] lineString = line.toString().split(",");
				for(String item : lineString) {
					System.out.println(item);
				}
				line = br.readLine();
			}
		}catch(IOException e) {
			System.out.println("An error occured in the file system:");
		}
		
		sc.close();
	}

}
