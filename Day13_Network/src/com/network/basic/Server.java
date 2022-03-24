package com.network.basic;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		//1. ������ ���� ����(���Ͽ��� ��ü�̱⶧���� �ݳ� �ʼ�)
		// ServerSocket : Client ����ŭ socket�� �������ִ� ����
		try(ServerSocket server = new ServerSocket(8000); // ������ ��Ʈ��ȣ�� �Է�
			Socket sock = server.accept();	){ 
			// 2. Ŭ���̾�Ʈ�� ��û�� ������ Ŭ���̾�Ʈ ���� ���� ����(������ ������ �ϸ� = server.accept)
			// Ŭ���̾�Ʈ�� ���� ���� �������� ������ ����ϴٰ� ���� ����
			
			System.out.println("���ο� Ŭ���̾�Ʈ�� �����߽��ϴ�.");
			System.out.println("������ IP : " + sock.getLocalAddress());
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
