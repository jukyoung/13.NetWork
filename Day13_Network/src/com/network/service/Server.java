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

			String hi = "접속하신걸 환영합니다.";
			dos.writeUTF(hi);
			dos.flush();

			while (true) {
				// 클라이언트 선택메뉴 받아주기
				String menu = dis.readUTF();
				String rs = "";
				if (menu.equals("1")) {
					rs = "===== 오늘의 운세 =====" + "\n생각지 못했던 좋은 기회를 만나게 되니, \n인생에 순풍이 불어오는 운세를 만난다.";

				} else if (menu.equals("2")) {
					rs = "===== 오늘의 날씨 =====" + "\n 낮밤 기온차20도 '봄추위가 장독 깬다' 한낮 포근";

				} else if (menu.equals("3")) {
					rs = "===== 오늘의 로또번호 =====" + getLotto();

				} else if (menu.equals("4")) {
					System.out.println("클라이언트 접속이 끊어졌습니다.");
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
		// 1~45 사이의 6개의 랜덤한 번호 뽑아내서 반환해주기
		// Math.random()*(45-1+1)+1
		Random rand = new Random();
		// nextInt : 0 ~ N(인자값) 미만의 랜덤한 수를 반환해주는 함수

		// 켈렉션 -> 중복되지 않는 값만 저장하는 저장소
		// + 값이 순서대로 저장되지 않음
		// HashSet<제네릭> 변수이름 = new HashSet<>(); = ArrayList와 비슷함
		HashSet<Integer> lotto = new HashSet<>();
		for (int i = 0; i < 6; i++) {
			lotto.add(rand.nextInt(45) + 1); // +1을 해주면 1~45사이의 수를 뽑아줌
		}
		return lotto;
	}

}
