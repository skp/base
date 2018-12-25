package inherit;

public class SubClass extends SuperClass {
 
    private int mSubX = 1;
 
    public SubClass() {}
 
    @Override
    public void setX(int x) {
        super.setX(x);
        mSubX = x;
        System.out.println("SubX is assigned " + x);
    }
 
    public void printX() {
        System.out.println("SubX = " + mSubX);
    }
    
    /*
    https://mp.weixin.qq.com/s/5dtjN2PTl9pRsHC8m1YagQ
     */
    public static void main(String[] args) {
        SubClass sc = new SubClass();
        sc.printX(); // 输出mSubX = 1
        // 初始化顺序
        // 父类static成员 -> 子类static成员 -> 父类普通成员初始化和初始化块 -> 父类构造方法 -> 子类普通成员初始化和初始化块 -> 子类构造方法
    }
}