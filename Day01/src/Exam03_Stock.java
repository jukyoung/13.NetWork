
public class Exam03_Stock {
   public static void main(String[] args) {
//	 System.out.println("========== 주식 마켓 ==========");
//	 System.out.println("1. 삼성전자 (1주: " + 50000 + ")" );
//	 System.out.println("2. 테슬라 (1주: " + 50000 + ")");
//	 System.out.println("3. 카카오 (1주: " + 30000 + ")");
//	 System.out.println("잔고 : " + 200000 + "원" );
//	 System.out.println("============================");
//	   
//	 System.out.println("삼성전자 1주 매수");
//	 System.out.println("잔고 : " + (200000 - 50000) + "원");
//	 //문자열에서 숫자 빼는것은 x 예: ("잔고 : " + 200 - 40 + "원")
//	 //뺄셈 먼저 하는거 : 소가로
//	 
//	 System.out.println("테슬라 2주 매수");
//	 System.out.println("잔고 : " + (200000 - 50000 - 100000) + "원");
//	 
//	 System.out.println("카카오 1주 매수");
//	 System.out.println("잔고 : " + (200000 - 50000 -100000 - 30000) + "원");
//	 
//	 System.out.println("테슬라 1주 매도");
//	 System.out.println("잔고 : " + (200000-50000-100000-30000+50000) + "원");
	 // 가격이 변동됐을때 여러 줄 코드 바꾸는거 쉽게 하는거 "변수" 
  
   //변수 사용해서 한번해보기
	int m1 = 40000;
	int m2 = 30000;
	 System.out.println("\n1. 현대자동차 (1주 : " + m1 + "원)");
	 System.out.println("2. 스튜디오드래곤 (1주: " + m2 + "원)" );
	 System.out.println("잔고 : " + 250000 + "원");
	 
	 System.out.println("\n현대자동차 1주, 스튜디오드래곤 1주 매수");
	 System.out.println("잔고 : " + (250000 - m1 - m2) + "원");
	 
	
   
   }
}
