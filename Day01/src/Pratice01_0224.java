// 실습1 : 인삿말, 본인의 이름, 영어이름, 나이, 체온 측정 결과
public class Pratice01_0224 {
   public static void main(String[] args) {
	   System.out.println("안녕하세요?");
	   System.out.println("저의 이름은 김주경입니다. 영어 이름은 JUkYOUNG입니다.");
	   System.out.print("제 나이는 ");
	   System.out.print(27);
	   System.out.print("살입니다.");
	   
	   System.out.print("\n오늘의 체온 측정 결과는 ");
	   // \n : 개행 문자 줄을 바꾸겠다는 것 표현
	   System.out.print(36.5);
	   System.out.print("도 입니다.");
	   //전체 드래그 컨트롤 누르고 슬래시 쓰면 주석 처리 한꺼번에 됨
	   
	   // + : 문자열 연결, 덧셈
	   System.out.println("안녕하세요?");
	   System.out.println("저의 이름은 김주경입니다. 영어 이름은 JUKYOUNG 입니다.");
	   System.out.println("제 나이는 " + 27 + "살 입니다.");
       System.out.println("오늘의 체온 측정 결과는 " + 36.5 + "도 입니다.");
	   
	   // 문자와 숫자를 연결할 때 주의해야 하는 점
	   // : 순서에 따라 문자와 숫자가 연결되어 문자로 합쳐질 수도, 숫자와 숫자가 더해져 덧셈이 될 수도 있음
       // 왼쪽부터 간다 ("a" + "b" + 5 + 10) = ab510 
	   // : (5 + 10 + "a" + "b") = 15ab 순서(조합)에 따라 결과값이 달라짐
   }
}
