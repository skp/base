import org.junit.Test;

import java.time.Duration;
import java.time.Instant;

public class StringTest {
	
	@Test
	public void test1() {
//		"asd".substring()
		//代码1
		String sa = "ab";
		String sb = "cd";
		String sab=sa+sb;
		String s="abcd";
		System.out.println(sab==s); // false
		//代码2
		String sc="ab"+"cd";
		String sd="abcd";
		System.out.println(sc==sd); //true
	}
	
//	@Test
//	public void test2() {
//		Instant b = Instant.now();
//		String s1="Heart";
//		StringBuffer sb=new StringBuffer();
//		for(int i=0;i<10000;i++){
//			sb.append(s1);
//		}
//		Instant e = Instant.now();
//		System.out.println(Duration.between(b, e).toMillis());
//		long endTime=System.currentTimeMillis();
//		System.out.println(endTime-beginTime);
//	}
}
