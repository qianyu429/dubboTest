package bank;

/**
 * Created by duanzonghai on 2018/5/31.
 */
public class AccountOperator implements Runnable {

    private Account account;

    public AccountOperator(Account account){
        this.account = account;
    }

    public void run(){

        synchronized(account){

                account.deposit(500);
                account.withdraw(600);
                System.out.println(Thread.currentThread().getName() + ":" + account.balance());
        }
    }

}
