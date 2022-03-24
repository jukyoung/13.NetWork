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
		
		// 회원가입
		// 서비스
		
		AccountDAO dao = new AccountDAO(); // 만들어야지 DAO의 기능을 쓸 수 있음
		try(ServerSocket server = new ServerSocket(8000);
				Socket sock = server.accept();
				DataInputStream dis = new DataInputStream(sock.getInputStream());
				DataOutputStream dos = new DataOutputStream(sock.getOutputStream());){
			
			String hi = "접속을 환영합니다.";
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
					System.out.println("클라이언트의 id : " + id);
					System.out.println("클라이언트의 pw : " + pw);
					
					if(dao.checkLogin(id,pw)) {
						dos.writeUTF("success");
						while(true) {
							String input = dis.readUTF();
							String rs = "";
							if(input.equals("1")) {
								rs = "===== 오늘의 운세 =====" + "\n생각지 못했던 좋은 기회를 만나게 되니, \n인생에 순풍이 불어오는 운세를 만난다.";	
							}else if(input.equals("2")) {
								rs = "===== 오늘의 날씨 =====" + "\n낮밤 기온차20도 '봄추위가 장독 깬다' 한낮 포근";
							}else if(input.equals("3")) {
								rs = "===== 오늘의 로또번호 =====\n" + getLotto();
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
					System.out.println("클라이언트의 접속이 끊어졌습니다.");
					break;
				}
			
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
