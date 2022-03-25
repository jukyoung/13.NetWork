package com.network.download02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.Socket;
import java.util.Scanner;

// while -> 1. 파일 다운로드 2. 프로그램 종료
// 2번 입력하기 전까지는 계속 프로그램이 실행되도록

public class Client {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String path_down = "D:\\client_download\\";
		String path_up = "D:\\client_upload\\";

		try (Socket client = new Socket("192.168.35.207", 8000);
				DataInputStream dis = new DataInputStream(client.getInputStream());
				DataOutputStream dos = new DataOutputStream(client.getOutputStream());) {

			while (true) {
				System.out.println("===== 파일 다운로드 프로그램 =====");
				System.out.println("1. 파일다운로드");
				System.out.println("2. 파일 업로드");
				System.out.println("3. 프로그램 종료");
				System.out.print(">> ");
				String menu = sc.nextLine();

				dos.writeUTF(menu);
				dos.flush();

				if (menu.equals("1")) {
					// 몇개의 파일 이름이 넘어올지
					int cnt = dis.readInt();
					System.out.println("*** 파일 목록 ***");
					for (int i = 0; i < cnt; i++) {
						System.out.println(dis.readUTF());
					}
					System.out.println("다운로드 할 파일명 입력(확장자 포함)");
					System.out.print(">> ");
					String fileName = sc.nextLine();
					// 서버에 다운로드할 파일명 전송
					dos.writeUTF(fileName);
					dos.flush();

					// 파일의 사이즈 먼저 받기
					int size = dis.readInt();
					byte[] arr = new byte[size];
					// 파일 받기
					dis.readFully(arr);

					try (FileOutputStream fos = new FileOutputStream(path_down + fileName);) {

						fos.write(arr);
						fos.flush();
						System.out.println("다운로드 성공!");

					} catch (Exception e) {
						e.printStackTrace();
					}
				} else if(menu.equals("2")) {
					System.out.println("업로드할 파일명을 입력(확장자 포함)");
					System.out.print(">> ");
					String fileName = sc.nextLine();
					
					try(FileInputStream fis = new FileInputStream(path_up + fileName);){
						byte[] arr = fis.readAllBytes();
						dos.writeInt(arr.length);
						dos.writeUTF(fileName);
						dos.write(arr);
						dos.flush();
						System.out.println("업로드가 완료됐습니다.");
						
					}catch(Exception e) {
						e.printStackTrace();
					}
					
					
				}else if (menu.equals("3")) {
					System.out.println("프로그램을 종료합니다.");
					break;
				
			}

		} 
		}catch (Exception e) {
			e.printStackTrace();
	}
	}
}
