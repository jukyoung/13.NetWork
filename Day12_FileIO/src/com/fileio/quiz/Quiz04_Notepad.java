package com.fileio.quiz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Quiz04_Notepad {

	public static void makeMemo(String memo, String memoName) {
		try (FileWriter fw = new FileWriter(memoName, true);) {
			fw.write(memo + "\n");
			fw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void readFile(String memoName) {
		try (FileReader fr = new FileReader(memoName); BufferedReader br = new BufferedReader(fr);) {
			String line = "";
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void modifyMemo(String memoName, boolean keep, String modify) {
		if (keep) {
			try (FileWriter fw = new FileWriter(memoName, true);) {
				fw.write(modify + "\n");
				fw.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try (FileWriter fw = new FileWriter(memoName);) {
				fw.write(modify + "\n");
				fw.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<String> list = new ArrayList<>();

		while (true) {

			System.out.println("\n*** 콘솔 메모장 ***");
			System.out.println("1. 메모하기");
			System.out.println("2. 메모장 보기");
			System.out.println("3. 메모 수정하기");
			System.out.println("4. 프로그램 종료");
			System.out.print(">> ");
			int menu = Integer.parseInt(sc.nextLine());

			if (menu == 1) {
				System.out.println("메모 입력");
				System.out.print(">> ");
				String memo = sc.nextLine();
				System.out.println("저장할 파일의 이름을 입력하세요.");
				System.out.print(">> ");
				String memoName = sc.nextLine();

				list.add(memoName);
				makeMemo(memo, memoName);

			} else if (menu == 2) {
				System.out.println("===== 저장된 메모 목록 =====");

				if (list.size() == 0) {
					System.out.println("저장된 메모가 없습니다.");
				} else {

					for (int i = 0; i < list.size(); i++) {
						System.out.println((i + 1) + ". " + list.get(i));
					}
					System.out.println("열어볼 파일의 이름을 입력하세요.");
					System.out.print(">> ");
					String memoName = sc.nextLine();

					readFile(memoName);

				}

			} else if (menu == 3) {
				System.out.println("===== 저장된 메모 목록 =====");

				for (int i = 0; i < list.size(); i++) {
					System.out.println((i + 1) + ". " + list.get(i));
				}

				System.out.println("수정할 파일의 이름을 입력하세요.");
				System.out.print(">> ");
				String memoName = sc.nextLine();

				System.out.println("수정방식을 선택하세요.");
				System.out.println("1. 덮어쓰기");
				System.out.println("2. 이어쓰기");
				System.out.print(">> ");
				int no = Integer.parseInt(sc.nextLine());

				System.out.println("수정할 내용을 입력하세요.");
				System.out.print(">> ");
				String modify = sc.nextLine();

				if (no == 1) {
					modifyMemo(memoName, false, modify);
				} else if (no == 2) {
					modifyMemo(memoName, true, modify);
				}
				System.out.println("수정완료");

			} else if (menu == 4) {
				System.out.println("프로그램 종료");
				break;
			}

		}
	}
}
