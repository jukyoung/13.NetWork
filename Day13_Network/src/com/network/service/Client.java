package com.network.service;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try(Socket client = new Socket("192.168.35.154", 8000);
			DataInputStream dis = new DataInputStream(client.getInputStream());
		    DataOutputStream dos = new DataOutputStream(client.getOutputStream());){
			
			String hi = dis.readUTF();
			System.out.println(hi);
			
			// 서버를 통해 제공받을 수 있는 서비스 메뉴를 띄워줌
			// 1. 오늘의 운세 / 2. 오늘의 날씨 / 3. 오늘의 로또번호
			// 4. 프로그램 종료
			while(true) {
				System.out.println("\n===== 서비스 메뉴 =====");
				System.out.println("1. 오늘의 운세");
				System.out.println("2. 오늘의 날씨");
				System.out.println("3. 오늘의 로또번호");
				System.out.println("4. 프로그램 종료");
				System.out.print("메뉴 선택 >> ");
				String menu = sc.nextLine();
				
				dos.writeUTF(menu);
				dos.flush();
				
				// 4번을 선택했다면 프로그램 종료
				if(menu.equals("4")) {
					System.out.println("서비스 메뉴를 종료합니다.");
					break;
				}
				// 요청한 서비스에 대한 결과값
				String rs = dis.readUTF();
				System.out.println(rs);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
