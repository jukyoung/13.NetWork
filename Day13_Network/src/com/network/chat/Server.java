package com.network.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) {
		
		/* 서버 가동 -> 클라이언트 접속
		 * 1. 클라이언트에게 환영 인사 전송
		 * 2. 클라이언트가 -> 닉네임 입력 -> 전송
		 * 3. 서버에서 "~님 접속" 문구 띄워주기
		 * 
		 * 4. 클라이언트가 먼저 메세지 전송
		 * 5. 서버에서 메세지를 받아 "~님 메세지 : 메세지내용" 출력
		 * 6. 클라이언트한테 메시지 전송
		 * 7. 클라이언트에서 메세지를 받아 "서버 메세지: 메세지 내용"
		 * 
		 * 4~7 까지 과정 반복
		 */
		Scanner sc = new Scanner(System.in);
		
		try(ServerSocket server = new ServerSocket(8000);
			Socket sock = server.accept();
			DataInputStream dis = new DataInputStream(sock.getInputStream());
			DataOutputStream dos = new DataOutputStream(sock.getOutputStream());){
			//환영인사 전송
			String hi = "채팅 프로그램에 접속하신 걸 환영합니다~";
			dos.writeUTF(hi);
			dos.flush();
			//닉네임 받기
			String nickname = dis.readUTF();
			System.out.println(nickname + "님 접속~!");
			try{
				while(true) {
					//메세지 받기
					String msg = dis.readUTF();
					System.out.println(nickname + "님 메세지 : " + msg);
					
					//메세지 전송
					System.out.print("메세지 입력 >> ");
					String msg_server = sc.nextLine();
					dos.writeUTF(msg_server);
					dos.flush();
				}
			}catch(Exception e) {
				System.out.println("서버를 재부팅하세요.");
				e.printStackTrace();
				
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
