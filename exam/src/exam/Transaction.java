//

package exam;

import java.util.Random;

import static java.lang.Math.abs;

public class Transaction {
    protected Random random = new Random();
    private Integer id;

    public Transaction(Acc recipient, Acc sender, double countMoney) throws SendManyExeption {
        id = random.nextInt();
        SendMoney(recipient, sender, countMoney);
    }

    public void SendMoney(Acc recipient, Acc sender, double countMoney) throws SendManyExeption {
        boolean finish;
        finish = true;
        while (finish) {
            if (recipient.getBill().lock.tryLock()) {
                if (sender.getBill().lock.tryLock()) {

//                    Bank.addTransaction(id, recipient, sender, countMoney);

//                    if (sender.getBill().getMoney() < countMoney) {
//                        recipient.getBill().lock.unlock();
//                        sender.getBill().lock.unlock();
//                        throw new SendManyExeption();
//                    }
                    double moneyRecipient = recipient.getBill().getMoney();
//                    double moneySender = sender.getBill().getMoney();

                    if (moneyRecipient < countMoney) {
                         countMoney = moneyRecipient;
                    }
                    recipient.getBill().takeMoney(countMoney);
                    sender.getBill().addMoney(countMoney);

                    finish = false;
                    Bank.addTransaction(id, recipient, sender, countMoney);
                    sender.getBill().lock.unlock();
                }
                recipient.getBill().lock.unlock();
            }
        }
    }


}
