package cc.lovesq.study.test;

import org.junit.Test;

import cc.lovesq.model.Creative;

/**
 * Created by shuqin on 18/6/25.
 */
public class BaseTest {

  @Test
  public void testType() {
    System.out.println(new int[0].getClass().getSimpleName());
    System.out.println(new long[0].getClass().getSimpleName());
    System.out.println(new String[0].getClass().getSimpleName());
    System.out.println(new Object[0].getClass().getSimpleName());
    System.out.println(new Creative[0].getClass().getSimpleName());
  }

}
