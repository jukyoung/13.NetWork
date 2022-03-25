package com.network.upload01;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		// Ŭ���̾�Ʈ�� ������ ������ ���ε�
		// Ŭ���̾�Ʈ ���� ���
		Scanner sc = new Scanner(System.in);
		String path = "D:\\client\\";

		try (Socket client = new Socket("192.168.35.207", 8000);
				DataOutputStream dos = new DataOutputStream(client.getOutputStream());) {

			System.out.println("���ε��� ���ϸ��� �Է��ϼ���(Ȯ���� ����)");
			System.out.print(">> ");
			String fileName = sc.nextLine();

			try (FileInputStream fis = new FileInputStream(path + fileName);) {
				// Ŭ���̾�Ʈ�� hdd �κ��� ���� �о����
				byte[] arr = fis.readAllBytes();

				// �ϴ� ���ε��� ������ ũ����� ���� ��.
				dos.writeInt(arr.length);
				// ���ϸ��� ������ �������� Ȯ���ڸ� ���������� �������� �ʾƵ� �ǵ���
				dos.writeUTF(fileName);
				dos.flush();
				// ���� ������ ����
				dos.write(arr);

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
