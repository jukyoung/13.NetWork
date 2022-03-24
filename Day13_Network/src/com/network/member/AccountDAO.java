package com.network.member;

import java.util.ArrayList;

// ������ ���� �����, ��� Ŭ����
public class AccountDAO {
	private ArrayList<AccountDTO> list = new ArrayList<>();
	
	public AccountDAO() {}
	public void insert(AccountDTO dto) {
		list.add(dto);
	}
	


	public boolean checkLogin(String id, String pw){
		//list�� 0�� �ε������� for���� ���鼭
		// �� �ε����� ����ִ� AccountDTO�� �ν��Ͻ���
		// .��� getId() / getPw() �޼��带 �Ἥ ������
		// �����Ϳ� Ŭ���̾�Ʈ�� �Ѱ��� �Ű����� id, pw �� ��
		for(AccountDTO dto : list) {
			if(dto.getId().equals(id) && dto.getPw().equals(pw)) {
				return true;
			}
		}
		return false;
	}
	

}
