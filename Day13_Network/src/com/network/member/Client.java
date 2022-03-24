package com.network.member;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try(Socket client = new Socket("192.168.35.154", 8000);
				DataInputStream dis = new DataInputStream(client.getInputStream());
			    DataOutputStream dos = new DataOutputStream(client.getOutputStream());){
		
			String hi = dis.readUTF();
			System.out.println(hi);
			while(true) {
				System.out.println("===== �޴� ���� =====");
				System.out.println("1. ȸ������");
				System.out.println("2. �α���");
				System.out.println("3. ���α׷� ����");
				System.out.print(">> ");
				String menu = sc.nextLine();
				
				dos.writeUTF(menu);
				dos.flush();
				if(menu.equals("1")) {
					System.out.println("=== ȸ������ ===");
					System.out.print("ID �Է� : ");
					String id = sc.nextLine();
					System.out.print("PW �Է� : ");
					String pw = sc.nextLine();
					
					dos.writeUTF(id);
					dos.writeUTF(pw);
					dos.flush();
					
				}else if(menu.equals("2")) {
					System.out.println("=== �α��� ===");
					System.out.print("ID �Է� : ");
					String id = sc.nextLine();
					System.out.print("PW �Է� : ");
					String pw = sc.nextLine();
					
					dos.writeUTF(id);
					dos.writeUTF(pw);
					dos.flush();
					
					// ��� �ޱ�
					String rs = dis.readUTF();
					if(rs.equals("success")) {
						System.out.println("�α��� ����");
						while(true) {
							System.out.println("=== ���� �޴� ===");
							System.out.println("1. ������ �");
							System.out.println("2. ������ ����");
							System.out.println("3. �����ζ� ��ȣ");
							System.out.println("4. ���θ޴��� ���ư���");
							System.out.print(">> ");
							String input = sc.nextLine();
							
							dos.writeUTF(input);
							dos.flush();
							
							if(input.equals("4")) {
								System.out.println("���θ޴��� ���ư��ϴ�.");
								break;
							}
							String service = dis.readUTF();
							System.out.println(service);
						}
						
						
					}else if(rs.equals("fail")) {
						System.out.println("���̵� Ȥ�� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
					}
					
				}else if(menu.equals("3")) {
					System.out.println("���α׷��� �����մϴ�.");
					break;
				}
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
