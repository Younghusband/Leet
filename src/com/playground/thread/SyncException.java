package com.playground.thread;

/**
 * @description
 * @author vermouth.Mac
 * @version 2018年2月5日 上午12:03:43
 * 
 *          同步方法中出现异常 咋整
 */

public class SyncException {

	private int i = 0;

	public synchronized void add() {
		while (true) {
			try {
				i++;
				Thread.sleep(200);
				System.out.println(Thread.currentThread().getName() + ", i = " + i);
				if (i == 10) {
					Integer.parseInt("a"); // throw new RuntimeException();
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(" log info i = " + i);
				// 具体的处理 或者throw new Exception();
				throw new RuntimeException(e);
			}

		}

	}

	public static void main(String[] args) {
           final SyncException sync = new SyncException();
           Thread t1 = new Thread(new Runnable(){
        	   public void run(){
        		   sync.add();
        	   }
           },"t1");
           t1.start();
           try{
              sync.add();
           }catch(Exception e){
        	  try {
				t1.join();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
           }
           
           
           
	}

}
