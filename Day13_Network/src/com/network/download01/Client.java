package com.network.filedownload01;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		/* ������ ������ ���� �ޱ�
		 * Ŭ���̾�Ʈ�� HDD �� ������ ����(���)
		 * */
		String path = "D:\\client\\";
		try(Socket client = new Socket("192.168.35.207", 8000);
			DataInputStream dis = new DataInputStream(client.getInputStream());){
			
			// ����� ���� �޾� �迭 �����
			int size = dis.readInt(); // int�� �����ָ� int�� �޾��ֱ�
			byte[] arr = new byte[size];
			
			//�о� ���� �����͸� �迭 �ȿ��ٰ� ��ڴ�.
			dis.readFully(arr);
			System.out.println("�޾� �� ���� ũ�� : " + arr.length);
			
			// ������ �ϵ��ũ�� �������°� �ϱ� outputstream
			// ���� �ڵ���� �� ����ǰ� ���������ϴ� �Ŵϱ� �ٽ� try ���� �����ֱ�
			// Ŭ���̾�Ʈ hdd�� ����� ���� Ȯ���ڴ� �ݵ�� �������� ������ ���� Ȯ���ڿ� ���ƾ���
			try(FileOutputStream fos = new FileOutputStream(path + "image.png");){
				// ��ο��ٰ� image.png ��� �̸����ڴ�
				
				fos.write(arr);
				fos.flush();
				System.out.println("�ٿ�ε� ����!");
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
