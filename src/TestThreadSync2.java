/**
 * t1你是第1个使用timer的线程
 * t2你是第2个使用timer的线程
 */
public class TestThreadSync2 implements  Runnable{ //自己就是一个线程类
    Timer timer = new Timer();//Timer 是另一个内部类
    public void run(){
        timer.add(Thread.currentThread().getName());  //线程启动后，调用另一个内部类的add方法
    }

    public static void main(String[] args){
        TestThreadSync2  test = new TestThreadSync2(); //本类的对象 test
        Thread t1 = new Thread(test);// 线程1 加入test对象
        Thread t2 = new Thread(test);// 线程2 加入test对象
        t1.setName("t1");
        t2.setName("t2");
        t1.start(); //开始
        t2.start();
    }

}

class Timer{
    private static int num = 0;
    public synchronized void add(String name) {//执行时，当前对象被锁定
        num++;
        try {
            Thread.sleep(1);//必须等到这方法执行完了，才能进入下一个，即使睡了也无用
        } catch (InterruptedException e) {
            ;
        }
        System.out.println(name + "你是第" + num + "个使用timer的线程");
    }
}