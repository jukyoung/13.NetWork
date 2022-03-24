package com.network.message;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		try(Socket client = new Socket("192.168.35.154", 8000);
			DataInputStream dis = new DataInputStream(client.getInputStream());	
			DataOutputStream dos = new DataOutputStream(client.getOutputStream())){
			// 클라이언트 입장에서 메세지가 들어오는거니까 Input
			// 메세지를 보내려면 다시 Output
			String msg = dis.readUTF();
			System.out.println("msg : " + msg);
			
			while(true) {

				// 서버에게 메세지 보내기
				System.out.print("메세지를 입력하세요 >> ");
				String message = sc.nextLine();
				dos.writeUTF(message);
				dos.flush();
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
}

}
