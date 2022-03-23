package com.fileio.quiz;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class Quiz03_CopyFile {
	
	public static void copyFile(String from, String to) { // 파일명을 매개변수로 받아서 사용하기
		try(FileReader fr = new FileReader(from);
				BufferedReader br = new BufferedReader(fr);
				FileWriter fw = new FileWriter(to);){
				
				String line = "";
				while((line = br.readLine()) != null) {
					fw.write(line + "\n");
				}
				fw.flush();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
	}
	
	public static void main(String[] args) {
		copyFile("A.txt", "B.txt"); // 파일명을 넣어서 쓰기 -> 얼마든지 바꿀 수 있음
		//A.txt 파일을 복사해서 B.txt 파일로 만들어 보세요.
		// A.txt의 데이터를 입력
		// -> 그 데이터를 B.txt 파일로 출력
		// Reader Writer -> 수정
		
		
//		try(FileInputStream fis = new FileInputStream("A.txt");
//		    FileOutputStream fos =  new FileOutputStream("B.txt");){
//			
//			byte[] temp = new byte[1024];
//			
//			fis.read(temp);
//			System.out.println(new String(temp));
//			
//			fos.write(temp);
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
	}

}
