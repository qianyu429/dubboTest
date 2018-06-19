package threadTest;

import org.testng.annotations.Test;

/**
 * Created by duanzonghai on 2018/5/29.
 */
public class MyThread3 implements Runnable {

    int ticket = 100;
    Object lock = new Object();

    @Override
    public void run() {
        while (true) {
//            当没有明确的对象作为锁，只是想让一段代码同步时，可以创建一个特殊的对象来充当锁
//            同步代码块, 安全性高(票不会重复 负数)
            synchronized (lock) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(50);

                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":" + ticket--);

                }

            }
        }
    }

//    @Test
//    public void testThread(){
//        MyThread3 myThread3 = new MyThread3();
//
//        Thread t1 = new Thread(myThread3);
//        t1.setName("窗口1:");
//        t1.start();
//
//        Thread t2 = new Thread(myThread3);
//        t2.setName("窗口2:");
//        t2.start();
//
//        Thread t3 = new Thread(myThread3);
//        t3.setName("窗口3:");
//        t3.start();
//
//
//    }
//}


//        同步代码块比同步方法，同步代码块可以让我拥有对锁的可控权。
//        同步块是更好的选择，因为它不会锁住整个对象（当然也可以让它锁住整个对象）。
//        同步方法会锁住整个对象，哪怕这个类中有多个不相关联的同步块，这通常会导致他们停止执行并需要等待获得这个对象上的锁

    public static void main(String[] args) {
        MyThread3 myThread3 = new MyThread3();

        Thread t1 = new Thread(myThread3);
        t1.setName("窗口1:");
        t1.start();

        Thread t2 = new Thread(myThread3);
        t2.setName("窗口2:");
        t2.start();

        Thread t3 = new Thread(myThread3);
        t3.setName("窗口3:");
        t3.start();
    }
}