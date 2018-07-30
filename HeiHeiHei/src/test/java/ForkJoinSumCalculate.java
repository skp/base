import org.junit.Test;

import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoinSumCalculate extends RecursiveTask<Long> {
	
	private static final long serialVersionUID = -1812835340478767238L;
	
	private long start;
	private long end;
	
	private static final long THURSHOLD = 10000L;  //临界值
	
	public ForkJoinSumCalculate() {
	}
	
	private ForkJoinSumCalculate(long start, long end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	protected Long compute() {
		long length = end - start;
		//小于临界值，则不进行拆分，直接计算初始值到结束值之间所有数之和
		if (length <= THURSHOLD) {
			long sum = 0L;
			
			for (long i = start; i <= end; i++) {
				sum += i;
			}
			
			return sum;
		} else {  //大于临界值，取中间值进行拆分，递归调用
			long middle = (start + end) / 2;
			
			ForkJoinSumCalculate left = new ForkJoinSumCalculate(start, middle);
			left.fork(); //进行拆分，同时压入线程队列
			
			ForkJoinSumCalculate right = new ForkJoinSumCalculate(middle + 1, end);
			right.fork(); //
			
			return left.join() + right.join();
		}
	}
	
	@Test
	public void test1(){
		Instant start = Instant.now();
		ForkJoinPool pool = new ForkJoinPool();
		ForkJoinTask<Long> task = new ForkJoinSumCalculate(0L, 50000000000L);
		Long sum = pool.invoke(task);
		System.out.println(sum);
		Instant end = Instant.now();
		System.out.println("耗费时间为：" + Duration.between(start, end).toMillis());
	}
	
	@Test
	public void test2(){
		Instant start = Instant.now();
		Long sum = LongStream.rangeClosed(0L, 50000000000L)
				.parallel()
				.reduce(0L, Long::sum);
		System.out.println(sum);
		Instant end = Instant.now();
		System.out.println("耗费时间为：" + Duration.between(start, end).toMillis());//1536-8118
	}
	
	@Test
	public void test3() {
//		BigInteger::multiply
	}
}