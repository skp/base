package v1ch09;

import java.io.BufferedInputStream;
import java.util.*;

public class Test_1_9 {
	
	public static void main(String[] args) {
		//		Enumeration
		//		RandomAccess
		//		HashSet<String> hs = new HashSet<>();
		//		hs.add("a");
		//		System.out.println(hs);
//		Collections.max()
		System.out.print("请输入需要加分的成绩：");
		int score = 0;
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			score = sc.nextInt();
		}
		if (score >= 60) {
			System.out.print("您的输入有误，请重新输入(小于60的数字): ");
		}
	}
}
