package com.fileio.exam;

import java.io.FileWriter;

public class Exam05_FileWrite02 {
	public static void main(String[] args) {
		
		String str = "맨발로 기억을 거닐다.\r\n"
				+ "떨어지는 낙엽에\r\n"
				+ "그간 잊지 못한 사람들을 보낸다.\r\n"
				+ "맨발로 기억을 거닐다.\r\n"
				+ "붉게 물든 하늘에\r\n"
				+ "그간 함께 못한 사람들을 올린다." ;
		
		try(FileWriter fw = new FileWriter("newKorean.txt");){
			
			fw.write(str);
			fw.flush(); //한번에 방출해주는 역할
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
