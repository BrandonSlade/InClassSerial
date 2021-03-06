package com.revature.serial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Associate;

public class SerialLauncher {

	public static void main(String[] args) {
	
		String fileName = "src/serializedAssociates.txt";
		
		List<Associate> aList = new ArrayList<Associate>();
		aList.add(new Associate("Alec Batson", "Trainer/Tech Analyst", 25, "Cheese", "012-34-5678"));
		serializeToFile(fileName, aList);
		
		System.out.println(deserializeFromFile(fileName));
		
	}
	
	static void serializeToFile(String fileName, Object o) {
		
		try {
			FileOutputStream fileOut = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			
			out.writeObject(o);
			
			out.close();
			fileOut.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	static Object deserializeFromFile(String fileName) {
		Object o = null;
		
		try {
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			o = in.readObject();
			in.close();
			fileIn.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return o;
	}
	

}
