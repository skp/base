package v1ch06.other;

import v1ch05.abstractClasses.Person;
import v1ch05.abstractClasses.Student;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class Test {
	
	public static void main(String[] args) {
		System.out.println(Integer.compare(Integer.MAX_VALUE, 23454325));
		System.out.println(Double.compare(3.0, 2.99999999999999));
//		Paths
//		BiFunction
//		Comparator
//		ArrayList<String> arrayList = new ArrayList<>();
//		Stream<Student> stream = arrayList.stream().map((String name) -> new Student(name));
		System.out.println(new Object() {}.getClass().getEnclosingClass());
		//		arrayList.removeIf(Objects:: isNull);
	}
}

interface Comparable<T> {
	
	default int compareTo(T other) {return 0;}
}

class Super {
	
	public boolean a() throws IOException, SQLException {
		return true;
	}
}

class Child extends Super {
	
	@Override
	//	public boolean a() throws Exception {
	public boolean a() throws SQLException {
		return true;
	}
	
	public static boolean b() throws Throwable {
		try {
			throw new SQLException();
		} catch (SQLException e) {
			Throwable se = new ServletException("database error");
			se.initCause(e);
			throw se;
		}
	}
	
	public static void main(String[] args) {
		try {
			b();
		} catch (Throwable e) {
			System.out.println(e.getCause());
		}
	}
}

class ServletException extends SQLException {
	
	public ServletException(String reason) {
		super(reason);
	}
	
	public ServletException() {
	}
}