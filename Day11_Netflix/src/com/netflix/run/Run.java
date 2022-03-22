package com.netflix.run;

import java.util.ArrayList;
import java.util.Scanner;

import com.netflix.dao.MemberDAO;
import com.netflix.dto.Basic;
import com.netflix.dto.Membership;
import com.netflix.dto.Premium;
import com.netflix.dto.Standard;

public class Run {

	static Scanner sc = new Scanner(System.in); //main 안에서 선언하면 static 메서드 오류나서 static 으로 선언해주기
	
	public static void printList(ArrayList<Membership> list) {
		System.out.println("ID\t등급\t닉네임\t가입일\t포인트");
		for (Membership dto : list) {
			System.out.println(dto.toString());
		}
	}
	// try ~ catch문은 출력문구도 있고 사용자에게 입력을 받기 때문에 실행클래스에서 메서드 구성하기
	public static int getNumberInput() {
		while(true) {
			try {
				System.out.print(">> ");
				int menu = Integer.parseInt(sc.nextLine());
				return menu;
			}catch(Exception e){
				System.out.println("숫자가 아닌 값을 입력할 수 없습니다.");
				e.printStackTrace(); // <- 어떤 에러가 발생했는지 보여주는 메서드 필수적임
			}
		}
	}
		public static void printMembership(Membership dto) {
			System.out.println("ID\t등급\t닉네임\t가입일\t포인트");
			System.out.println(dto.toString());
		}
	
	public static void main(String[] args) {

		MemberDAO dao = new MemberDAO(); // DAO 형 인스턴스 안에 ArrayList list(배열)가 생겨남
		
		String id = null;
		String nickname = null;
		int menu = 0;

		while (true) {

			System.out.println("\n*** Netflix 회원 관리 시스템 ***");
			System.out.println("1. 신규 회원 등록");
			System.out.println("2. 회원 목록 출력");
			System.out.println("3. 회원 정보 검색");
			System.out.println("4. 회원 정보 수정");
			System.out.println("5. 회원 정보 삭제");
			System.out.println("6. 시스템 종료");
			menu = getNumberInput();
			
			if (menu == 1) {
				System.out.println("\n회원 등급 선택");
				System.out.println("1. Basic");
				System.out.println("2. Standard");
				System.out.println("3. Premium");
				System.out.print(">> ");
				int grade = getNumberInput();

				while (true) {
					System.out.print("\n신규 회원 ID(7자 이내) : ");
					 id = sc.nextLine();
					// 중복검사
					if (dao.doesIdExist(id)) {
						System.out.println("중복된 ID 입니다.");
						continue;
					} else {
						break;
					}
				}
				while(true) {
					System.out.print("신규 회원 닉네임(4자 이내) : ");
					nickname = sc.nextLine();
					if(!dao.doesNickExist(nickname)) {
						break;
					}
					System.out.println("중복된 닉네임 입니다.");
				}
				System.out.print("신규 회원 가입일(210505 형식으로) : ");
				String signup_date = sc.nextLine();
				System.out.print("신규 회원 포인트 : ");
				int point = getNumberInput();

				if (grade == 1) {
					dao.insert(new Basic(id, nickname, signup_date, point)); // 베이직형 인스턴스
				} else if (grade == 2) {
					dao.insert(new Standard(id, nickname, signup_date, point)); // 스탠다드형 인스턴스
				} else if (grade == 3) {
					dao.insert(new Premium(id, nickname, signup_date, point)); // ㄱ.프리미엄형 인스턴스 -> dao한테 넘겨서 list라는 저장소에 저장해야함
																				
				}

			} else if (menu == 2) {
				ArrayList<Membership> list = dao.selectAll();
				printList(list);
//				System.out.println("ID\t등급\t닉네임\t가입일\t포인트");
//				// ㄱ. 실제 출력하려고 하는 값들이 DAO 클래스 list 라는 저장소안에 들어가 있는 상태
//				ArrayList<Membership> list = dao.selectAll(); // ㅁ. 반환해주고 있는 데이터 ArrayList<Membership> list 에 담기
//				// dao.selectAll()는 DAO클래스의 list의 주소값을 담고있음
//				for (Membership dto : list) {
//					System.out.println(dto.toString());
//				}

			} else if (menu == 3) {
				System.out.println("\n1. ID로 검색");
				System.out.println("2. 닉네임으로 검색");
				System.out.print(">> ");
				int search = getNumberInput();
				if (search == 1) {
					System.out.print("\n검색 할 ID 입력 : ");
					String Id = sc.nextLine(); // ㄱ. 입력했을때 배열의 list를 봐야하는 상황 dao에 id / nickname 넘겨줘야함
					Membership dto = dao.selectById(Id);
					if (dto != null) {
						printMembership(dto);
					} else {
						System.out.println("일치하는 회원의 정보가 없습니다.");
					}

				} else if (search == 2) {
					System.out.print("\n검색 할 닉네임 입력 : ");
					nickname = sc.nextLine();
					Membership dto = dao.selectByNickname(nickname);
					if (dto != null) {
						printMembership(dto);
					} else {
						System.out.println("일치하는 회원의 정보가 없습니다.");
					}

				} else if (menu == 4) {
					ArrayList<Membership> list = dao.selectAll();
					printList(list);
					
					System.out.print("\n수정할 회원의 ID 입력 : ");
					id = sc.nextLine();
					System.out.print("수정할 닉네임 : ");
					nickname = sc.nextLine();
					System.out.print("수정할 포인트 : ");
					int point = getNumberInput();
					// 멤버십형으로 넘겨줄 수 없음 -> 추상화 쓰기 때문에 new 못함

					int rs = dao.modify(id, nickname, point); // 넘겨줘야하는값 넣기
					if (rs == 1) {
						System.out.println("변경이 완료되었습니다.");
					} else if (rs == -1) {
						System.out.println("변경할 수 없는 ID 입니다.");
					}

				} else if (menu == 5) {
					ArrayList<Membership> list = dao.selectAll();
					printList(list);
					
					System.out.print("\n삭제할 회원의 ID 입력 : ");
					id = sc.nextLine();
					int rs = dao.delete(id);
					if (rs == 1) {
						System.out.println("삭제가 완료되었습니다.");
					} else if (rs == -1) {
						System.out.println("삭제할 수 없는 ID 입니다.");
					}

				} else if (menu == 6) {
					System.out.println("시스템을 종료합니다.");
					break;
				}
			}
		}
	}
}
