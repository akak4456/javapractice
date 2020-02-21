package ch13;

public class ThreadEx22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable r = new RunnableEx22();
		new Thread(r).start();
		new Thread(r).start();
	}

}

class Account2 {
	private int balance = 1000;

	public int getBalance() {
		return balance;
	}

	public void withdraw(int money) {
		synchronized (this) {
			if (balance >= money) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}

				balance -= money;
			}
		}
	}
}

class RunnableEx22 implements Runnable {
	Account2 acc = new Account2();

	public void run() {
		while (acc.getBalance() > 0) {
			int money = (int) (Math.random() * 3 + 1) * 100;
			acc.withdraw(money);
			System.out.println("balance:" + acc.getBalance());
		}
	}
}
