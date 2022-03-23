package com.fileio.exam;

import java.io.BufferedReader;
import java.io.FileReader;

public class Exam04_FileRead02 {
	public static void main(String[] args) {
		// FileReader : text file character 단위로 읽어오는 클래스
		// BufferedReader : 데이터를 한 줄 단위로 읽어들여올 수 있게 해줌
		try(FileReader fr = new FileReader("test.txt");
				BufferedReader br = new BufferedReader(fr);){
			
//			System.out.println((char)fr.read());
//			System.out.println((char)fr.read());
//			System.out.println((char)fr.read());
			
			String line = "";
			while((line = br.readLine()) != null) { // 한줄에 데이터가 존재하면 데이터를 출력해라
				System.out.println(line);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
