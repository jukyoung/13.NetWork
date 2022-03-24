package com.network.member;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Random;

public class Server {
	public static HashSet<Integer> getLotto() {
		Random ran = new Random();
		HashSet<Integer> lotto = new HashSet<>();
		for(int i = 0; i < 6; i++) {
			lotto.add(ran.nextInt(45)+1);
		}
		return lotto;
	}
	public static void main(String[] args) {
		
		// ȸ������
		// ����
		
		AccountDAO dao = new AccountDAO(); // �������� DAO�� ����� �� �� ����
		try(ServerSocket server = new ServerSocket(8000);
				Socket sock = server.accept();
				DataInputStream dis = new DataInputStream(sock.getInputStream());
				DataOutputStream dos = new DataOutputStream(sock.getOutputStream());){
			
			String hi = "������ ȯ���մϴ�.";
			dos.writeUTF(hi);
			dos.flush();
			while(true) {
				String menu = dis.readUTF();
				if(menu.equals("1")) {
					String id = dis.readUTF();
					String pw = dis.readUTF();
					dao.insert(new AccountDTO(id, pw));
					
				}else if(menu.equals("2")) {
					String id = dis.readUTF();
					String pw = dis.readUTF();
					System.out.println("Ŭ���̾�Ʈ�� id : " + id);
					System.out.println("Ŭ���̾�Ʈ�� pw : " + pw);
					
					if(dao.checkLogin(id,pw)) {
						dos.writeUTF("success");
						while(true) {
							String input = dis.readUTF();
							String rs = "";
							if(input.equals("1")) {
								rs = "===== ������ � =====" + "\n������ ���ߴ� ���� ��ȸ�� ������ �Ǵ�, \n�λ��� ��ǳ�� �Ҿ���� ��� ������.";	
							}else if(input.equals("2")) {
								rs = "===== ������ ���� =====" + "\n���� �����20�� '�������� �嵶 ����' �ѳ� ����";
							}else if(input.equals("3")) {
								rs = "===== ������ �ζǹ�ȣ =====\n" + getLotto();
							}else if(input.equals("4")) {
								break;
							}
							dos.writeUTF(rs);
						}
						
					}else {
						dos.writeUTF("fail");
					}
					dos.flush();
					
				}else if(menu.equals("3")) {
					System.out.println("Ŭ���̾�Ʈ�� ������ ���������ϴ�.");
					break;
				}
			
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
