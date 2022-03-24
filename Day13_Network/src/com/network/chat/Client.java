package com.network.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try(Socket client = new Socket("211.226.179.42", 8099);
			DataInputStream dis = new DataInputStream(client.getInputStream());
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());	){
			//환영인사 받기
			String hi = dis.readUTF();
			System.out.println(hi);
			//닉네임 전송
			System.out.print("닉네임 입력 >> ");
			String nickname = sc.nextLine();
			dos.writeUTF(nickname);
			dos.flush();
			try{
				while(true) {
					//메세지 전송
					System.out.print("메세지 입력 >> ");
					String msg = sc.nextLine();
					dos.writeUTF(msg);
					dos.flush();
					
					//메세지 받기
					String msg_server = dis.readUTF();
					System.out.println("서버 메세지 : " + msg_server);
					
				}
			}catch(Exception e) {
				System.out.println("접속이 원활하지 않습니다. 재접속하세요.");
				e.printStackTrace();
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
