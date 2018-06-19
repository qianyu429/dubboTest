package bank;

/**
 * Created by duanzonghai on 2018/5/31.
 */
public class Account {
    private String name;
    private double amount;

    public Account(String name,double amount){
        this.name = name;
        this.amount = amount;
    }

//    存钱
    public void deposit(double amt){
        amount+= amt;

        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

//    取钱
    public void withdraw(double amt){
        amount -= amt;

        try {
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

//        查询余额
        public Double balance(){
        return amount;
    }

    }
}

