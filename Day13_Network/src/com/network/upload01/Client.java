package com.network.upload01;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		// 클라이언트의 파일을 서버에 업로드
		// 클라이언트 파일 경로
		Scanner sc = new Scanner(System.in);
		String path = "D:\\client\\";

		try (Socket client = new Socket("192.168.35.207", 8000);
				DataOutputStream dos = new DataOutputStream(client.getOutputStream());) {

			System.out.println("업로드할 파일명을 입력하세요(확장자 포함)");
			System.out.print(">> ");
			String fileName = sc.nextLine();

			try (FileInputStream fis = new FileInputStream(path + fileName);) {
				// 클라이언트의 hdd 로부터 파일 읽어오기
				byte[] arr = fis.readAllBytes();

				// 일단 업로드할 파일의 크기부터 보낼 것.
				dos.writeInt(arr.length);
				// 파일명을 보내서 서버에서 확장자를 고정적으로 정해주지 않아도 되도록
				dos.writeUTF(fileName);
				dos.flush();
				// 파일 데이터 전송
				dos.write(arr);

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
