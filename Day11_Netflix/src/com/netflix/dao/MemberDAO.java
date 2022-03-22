package com.netflix.dao;

import java.util.ArrayList;

import com.netflix.dto.Membership;

public class MemberDAO {

	private ArrayList<Membership> list = new ArrayList<>(); //basic standard premium 다 품는 부모클래스 Membership 자료형으로
	
	public void insert(Membership dto) { //ㄴ.인스턴스를 넘겨서 list라는 공간에 접근할수 있도록 메서드 만듬
		list.add(dto);   // ㄴ1.베이직 스탠다드 프리미엄 을 받아줄 수 있는 멤버십이라는 클래스 -> 다형성이라는 성질을 지님 매개변수를 멤버쉽 형으로
		//ㄴ2.넘겨받은 dto를 추가해주기
	}
	public ArrayList<Membership> selectAll(){ // ㄴ. 저장소의 주소값을 던져주는 메서드를 만들어야함 (list 자체는 못넘겨줌 프라이빗 때문에 배열의 주소값은 가능)
		return list; //ㄷ. list의 자료형을 반환 자료형으로 ArrayList<Membership>
		//ㄹ.매개변수는 딱히 필요없음 반환해줄값 list를 반환
	}
	public Membership selectById (String id) { //ㄴ. 넘겨받을 매개변수 입력 String id , nickname
		// 멤버쉽 형으로 반환 해주겠다.
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(id)) { // 사용자가 입력한 아이디와 실제 일치하는 아이디가 있는지 검색
				return list.get(i); // 인스턴스 자체를 반환 	
			} //else { return null;} 하지 않은 이유 -> 일치하지 않은 회원의 정보가 일치하는 회원보다 먼저 있으면 for문을 다 돌지않고 null 값이 나오기때문
		}
		return null; // if문이 실행되지 않았을경우에 반환해야할 값 필요
	}
	public Membership selectByNickname(String nickname) {
		for(Membership dto : list) {
			if(dto.getNickname().equals(nickname)) {
				return dto;
			}
		}
		return null;
	}
	public int modify(String id, String nickname, int point) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(id) ) { // 수정할 회원의 정보 -> list.get(i)
				list.get(i).setNickname(nickname); // 값을 얻어오는게 아니라 세팅해주는 setter 쓰기
				list.get(i).setPoint(point);
				return 1;
			}
		}
		return -1;
	}
	public  int delete(String id) { // 반환해주는 값이 1 ,-1 이므로 int 반환매개변수
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId().equals(id)) {
				list.remove(i);
				return 1;
			}
		}
		return -1;
	}	
	public boolean doesIdExist(String id){
		for(Membership dto : list) {
			if(dto.getId().equals(id)){
				return true; // id 존재한다
			}
		}
		return false;
	}
	public boolean doesNickExist(String nickname) {
		for(Membership dto : list) {
			if(dto.getNickname().equals(nickname)) {
				return true;
			}
		}
		return false;
	}
	}

