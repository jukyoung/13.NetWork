package com.network.filedownload01;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		/* 서버가 전송한 파일 받기
		 * 클라이언트의 HDD 에 파일을 저장(출력)
		 * */
		String path = "D:\\client\\";
		try(Socket client = new Socket("192.168.35.207", 8000);
			DataInputStream dis = new DataInputStream(client.getInputStream());){
			
			// 사이즈를 먼저 받아 배열 만들기
			int size = dis.readInt(); // int로 보내주면 int로 받아주기
			byte[] arr = new byte[size];
			
			//읽어 오는 데이터를 배열 안에다가 담겠다.
			dis.readFully(arr);
			System.out.println("받아 온 파일 크기 : " + arr.length);
			
			// 파일을 하드디스크로 내보내는거 니까 outputstream
			// 위에 코드들이 다 실행되고 내보내야하는 거니까 다시 try 구문 열어주기
			// 클라이언트 hdd에 저장될 파일 확장자는 반드시 서버에서 보내는 파일 확장자와 같아야함
			try(FileOutputStream fos = new FileOutputStream(path + "image.png");){
				// 경로에다가 image.png 라고 이름짓겠다
				
				fos.write(arr);
				fos.flush();
				System.out.println("다운로드 성공!");
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
