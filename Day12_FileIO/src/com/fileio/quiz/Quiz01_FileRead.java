package com.fileio.quiz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

public class Quiz01_FileRead {
	public static void main(String[] args) {
		
		// 구글에서 원하는 짧은 영어로 된 시나, 가사, 뉴스, 소설 하나를 구해서
		// 프로젝트 폴더 내에 txt 파일로 저장 -> 그 파일을 읽어들여 콘솔로 출력하기
		
		File newFile = new File("Crying Over You.txt");
		if(!newFile.exists()) {
			try {
				newFile.createNewFile();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		try(FileInputStream lyrics = new FileInputStream("Crying Over You.txt");) {
			byte[] file = new byte[1024];
			lyrics.read(file);
			for(byte f : file) {
				System.out.print((char)f);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		// File Reader / BufferedReader를 사용해서 읽기로 수정
		
		try(FileReader lyric = new FileReader("Crying Over You.txt");
				BufferedReader br = new BufferedReader(lyric);){
			
			String line = "";
			
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
