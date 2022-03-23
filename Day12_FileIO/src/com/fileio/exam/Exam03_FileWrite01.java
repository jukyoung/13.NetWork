package com.fileio.exam;

import java.io.FileOutputStream;

public class Exam03_FileWrite01 {
	public static void main(String[] args) {
		
		// 프로그램 입장에서 파일을 출력하는 것이기 때문에 OutputStream 필요
		
		try(FileOutputStream fos = new FileOutputStream("output.txt", true);){//저장할 파일의 경로
			// write 라는 메서드 안써줘도 file 은 생성됨 -> 위의 코드에서 이미 파일이 생성됐기 때문
			//fos.write('B');
			//write : 생성된 파일에 문자를 써주는 메서드
			//만약 기존의 파일에 이어서 내용을 작성하고 싶다면(덮어쓰기X) true 인자값 
			
			//여러글자 쓰려면 배열
			byte [] fileCotents = {'a', 'b', 'c', 'd'};
			fos.write(fileCotents);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
