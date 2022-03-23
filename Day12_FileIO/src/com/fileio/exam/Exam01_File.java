package com.fileio.exam;

import java.io.File;

public class Exam01_File {
	public static void main(String[] args) {
		
		// 파일을 객체로(인스턴스화) 만들어 사용
		File file = new File("test.txt"); // 파일 생성자의 인자값 : HDD 해당 파일의 경로 값 + 파일명 + 확장자
		// 같은 프로젝트 안에 있기때문에 경로값은 안적어주어도 됨
		// 파일의 확장자까지도 이름에 속한다고 생각해야함
		
		System.out.println("이 파일이 실제 존재하는가? " + file.exists());
		System.out.println("파일인가? " + file.isFile());
		System.out.println("폴더인가? " + file.isDirectory());
		System.out.println("파일의 크기 : " + file.length());
		System.out.println("파일의 절대 경로 : " + file.getAbsolutePath());
		System.out.println("파일의 이름 : " + file.getName());
		
		File newFile = new File("new.txt"); // 없는 파일 만들기
		if(!newFile.exists()) { //if문 없으면 기존파일에 덧씌워짐
			// Checked Exception : 코드가 실제 실행되기도 전에 에러가 발생할 수 있따고 보여지는 에러
			try{
				newFile.createNewFile();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		File newFolder = new File("newFolder");
		if(!newFolder.exists()) {
			newFolder.mkdir();
		}
		
	}

}
