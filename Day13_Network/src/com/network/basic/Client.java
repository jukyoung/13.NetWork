package com.network.basic;

import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		
		// Ŭ���̾�Ʈ�� ���� ���� �� �ΰ��� ���ڰ� �ʿ�
		// 1. ������ IP�ּ�
		// 2. �������� ������ ��Ʈ��ȣ
		// ������ IP�ּ� -> localhost ��� �� ���� ����
		try(Socket client = new Socket("192.168.35.154", 8000);){
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
