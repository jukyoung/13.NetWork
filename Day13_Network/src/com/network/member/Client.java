package com.network.member;

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
			while(true) {
				System.out.println("===== 메뉴 선택 =====");
				System.out.println("1. 회원가입");
				System.out.println("2. 로그인");
				System.out.println("3. 프로그램 종료");
				System.out.print(">> ");
				String menu = sc.nextLine();
				
				dos.writeUTF(menu);
				dos.flush();
				if(menu.equals("1")) {
					System.out.println("=== 회원가입 ===");
					System.out.print("ID 입력 : ");
					String id = sc.nextLine();
					System.out.print("PW 입력 : ");
					String pw = sc.nextLine();
					
					dos.writeUTF(id);
					dos.writeUTF(pw);
					dos.flush();
					
				}else if(menu.equals("2")) {
					System.out.println("=== 로그인 ===");
					System.out.print("ID 입력 : ");
					String id = sc.nextLine();
					System.out.print("PW 입력 : ");
					String pw = sc.nextLine();
					
					dos.writeUTF(id);
					dos.writeUTF(pw);
					dos.flush();
					
					// 결과 받기
					String rs = dis.readUTF();
					if(rs.equals("success")) {
						System.out.println("로그인 성공");
						while(true) {
							System.out.println("=== 서비스 메뉴 ===");
							System.out.println("1. 오늘의 운세");
							System.out.println("2. 오늘의 날씨");
							System.out.println("3. 랜덤로또 번호");
							System.out.println("4. 메인메뉴로 돌아가기");
							System.out.print(">> ");
							String input = sc.nextLine();
							
							dos.writeUTF(input);
							dos.flush();
							
							if(input.equals("4")) {
								System.out.println("메인메뉴로 돌아갑니다.");
								break;
							}
							String service = dis.readUTF();
							System.out.println(service);
						}
						
						
					}else if(rs.equals("fail")) {
						System.out.println("아이디 혹은 비밀번호가 일치하지 않습니다.");
					}
					
				}else if(menu.equals("3")) {
					System.out.println("프로그램을 종료합니다.");
					break;
				}
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
