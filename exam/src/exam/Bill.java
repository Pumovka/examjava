//Объект "Счет". Объявляется синхронизатор данных, баланс каждого счета(изначально 0, но после присваивается рандомное значение)
//Присутствуют функции по управлению балансом д.с., учитывающие увеличение и уменьшение баланса. Данные данного блока в последующем конвертируются в строку

package exam;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bill {
    Lock lock = new ReentrantLock();

    protected Random random = new Random();

    private String id;

    private double balance = 0.0;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getMoney() {
        return balance;
    }

    public void setMoney(double balance) {
        this.balance = balance;
    }

    public  void addMoney(double billBalance){
        balance += billBalance;
    }

    public  void takeMoney(double billBalance){
        balance -= billBalance;
    }

    public Bill() {
        balance = random.nextDouble() * 100;
    }

    public Bill(String id) {
        this();
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Bill: " +
                id + '\'' +
                ", Balance: %.2f}", balance);
    }
}
