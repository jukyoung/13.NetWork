package com.network.basic;

import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		
		// 클라이언트의 소켓 생성 시 두가지 인자값 필요
		// 1. 서버의 IP주소
		// 2. 서버에서 열어준 포트번호
		// 본인의 IP주소 -> localhost 라고 쓸 수도 있음
		try(Socket client = new Socket("192.168.35.154", 8000);){
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
