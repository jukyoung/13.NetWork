package com.network.service;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Random;

public class Server {
	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(8000);
				Socket sock = server.accept();
				DataInputStream dis = new DataInputStream(sock.getInputStream());
				DataOutputStream dos = new DataOutputStream(sock.getOutputStream());) {

			String hi = "�����ϽŰ� ȯ���մϴ�.";
			dos.writeUTF(hi);
			dos.flush();

			while (true) {
				// Ŭ���̾�Ʈ ���ø޴� �޾��ֱ�
				String menu = dis.readUTF();
				String rs = "";
				if (menu.equals("1")) {
					rs = "===== ������ � =====" + "\n������ ���ߴ� ���� ��ȸ�� ������ �Ǵ�, \n�λ��� ��ǳ�� �Ҿ���� ��� ������.";

				} else if (menu.equals("2")) {
					rs = "===== ������ ���� =====" + "\n ���� �����20�� '�������� �嵶 ����' �ѳ� ����";

				} else if (menu.equals("3")) {
					rs = "===== ������ �ζǹ�ȣ =====" + getLotto();

				} else if (menu.equals("4")) {
					System.out.println("Ŭ���̾�Ʈ ������ ���������ϴ�.");
					break;
				}
				dos.writeUTF(rs);
				dos.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static HashSet<Integer> getLotto() {
		// 1~45 ������ 6���� ������ ��ȣ �̾Ƴ��� ��ȯ���ֱ�
		// Math.random()*(45-1+1)+1
		Random rand = new Random();
		// nextInt : 0 ~ N(���ڰ�) �̸��� ������ ���� ��ȯ���ִ� �Լ�

		// �̷��� -> �ߺ����� �ʴ� ���� �����ϴ� �����
		// + ���� ������� ������� ����
		// HashSet<���׸�> �����̸� = new HashSet<>(); = ArrayList�� �����
		HashSet<Integer> lotto = new HashSet<>();
		for (int i = 0; i < 6; i++) {
			lotto.add(rand.nextInt(45) + 1); // +1�� ���ָ� 1~45������ ���� �̾���
		}
		return lotto;
	}

}
