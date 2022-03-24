package com.network.member;

import java.util.ArrayList;

// 계정에 대한 저장소, 기능 클래스
public class AccountDAO {
	private ArrayList<AccountDTO> list = new ArrayList<>();
	
	public AccountDAO() {}
	public void insert(AccountDTO dto) {
		list.add(dto);
	}
	


	public boolean checkLogin(String id, String pw){
		//list의 0번 인덱스부터 for문을 돌면서
		// 각 인덱스에 들어있는 AccountDTO형 인스턴스에
		// .찍고 getId() / getPw() 메서드를 써서 가져온
		// 데이터와 클라이언트가 넘겨준 매개변수 id, pw 를 비교
		for(AccountDTO dto : list) {
			if(dto.getId().equals(id) && dto.getPw().equals(pw)) {
				return true;
			}
		}
		return false;
	}
	

}
