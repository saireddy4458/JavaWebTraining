//package com.ibm.iostreams;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//public class Application {
//	public static void main(String[] args) {
////		File file = new File("./src/main/resources/ibm/");
////		System.out.println(file.exists());
////		System.out.println(file.isFile());
//// 		System.out.println(file.isDirectory());
//
//		FileInputStream in = null;
//		FileOutputStream out = null;
//
//		try {
//			in = new FileInputStream("./src/main/resources/ibm/file1.txt");
//			out = new FileOutputStream("./src/main/resources/ibm/file2.txt");
//			byte c;
//
//			while ((c = (byte) in.read()) != -1) {
//				out.write(c);
//			}
//
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}finally {
//			if(in != null) {
//				try {
//					in.close();
//				} catch (IOException e) {
//					
//					e.printStackTrace();
//				}
//			}
//			if(out != null) {
//				try {
//					out.close();
//				} catch (IOException e) {
//					
//					e.printStackTrace();
//				}
//			}
//		}
//
//	}
//}
//
//package com.ibm.iostreams;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//
//public class Application {
//	public static void main(String[] args) {
//
//		try (FileReader inputStream = new FileReader("./src/main/resources/ibm/file1.txt");
//				FileWriter outputStream = new FileWriter("./src/main/resources/ibm/file2.txt");) {
//
//			int c;
//			while ((c = (byte) inputStream.read()) != -1) {
//				outputStream.write(c);
//			}
//
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	} 
//}
//

package com.ibm.iostreams;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Application {
	public static void main(String[] args) {
		
		
		short num = 12345;
		try (DataOutputStream out = new DataOutputStream(
				new BufferedOutputStream(new FileOutputStream("./src/main/resources/ibm/file1.txt")))) {
				
			out.writeInt(num);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
