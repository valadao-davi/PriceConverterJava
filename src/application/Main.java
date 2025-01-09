package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entities.Product;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Set the path for your products: ");
		String strPath =  sc.nextLine();
		List<Product> listProducts = new ArrayList<>();

		try(BufferedReader br = new BufferedReader(new FileReader(strPath))){
			String line = br.readLine();
			while(line != null) {
				String[] lineString = line.toString().split(",");
				String name = lineString[0];
				double unitPrice = Double.parseDouble(lineString[1]);
				int quantity = Integer.parseInt(lineString[2]);
				listProducts.add(new Product(name, unitPrice, quantity));
				line = br.readLine();
			}
			for(Product product : listProducts) {
				System.out.println(product);
			}
		}catch(IOException e) {
			System.out.println("An error occured in the file system:");
		}
		
		sc.close();
	}

}
