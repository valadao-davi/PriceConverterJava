package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entities.Product;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the path of your file products: ");
		String strPath =  sc.nextLine();
		
		File path = new File(strPath);
		String folderParent = path.getParent();
		
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
			
		}catch(IOException e) {
			System.out.println("An error occured in the file system:");
		}
		
		
		boolean success = new File(folderParent + "\\out").mkdir();

		String newFileCsv = folderParent + "\\out\\summary.csv";
		if(success) {
			try(BufferedWriter br = new BufferedWriter(new FileWriter(newFileCsv))){
				for(Product product : listProducts) {
					br.write(product.getName() + "," + product.calculatePrice() + "\n");
				}
				System.out.println("Recalculated all the products price based on their quantity.");
				System.out.println("Access the out folder to visualize it.");
			}catch(IOException e) {
				System.out.println("An error occured in the file system:");
			}
		}
		
		
		
		
		sc.close();
	}

}
