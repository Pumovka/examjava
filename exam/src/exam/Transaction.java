//

package exam;

import java.util.Random;

public class Transaction {
    protected Random random = new Random();
    private Integer id;

    public Transaction(Acc recipient, Acc sender, double countMoney) throws SendManyExeption {
        id = random.nextInt();
        SendMoney(recipient, sender, countMoney);
    }

    public void SendMoney(Acc recipient, Acc sender, double countMoney) throws SendManyExeption {
        boolean finish = true;
        while (finish) {

            if (recipient.getBill().lock.tryLock()) {
                if (sender.getBill().lock.tryLock()) {

                    try {
                        Bank.addTransaction(id, recipient, sender, countMoney);
                    } catch (SendManyExeption sendManyExeption) {
                        sendManyExeption.printStackTrace();
                    }

                    if (sender.getBill().getMoney() < countMoney) {
                        recipient.getBill().lock.unlock();
                        sender.getBill().lock.unlock();
                        throw new SendManyExeption();
                    }
                    double moneyRecipient = recipient.getBill().getMoney();
                    double moneySender = sender.getBill().getMoney();

                    if (moneyRecipient > countMoney) {
                        recipient.getBill().takeMoney(countMoney);
                        sender.getBill().addMoney(countMoney);
                    }
                    else
                    {
                        recipient.getBill().takeMoney(moneyRecipient);
                        sender.getBill().addMoney(moneySender);
                    }

                    // try {
                    //     recipient.getBill().addMoney(countMoney);
                    //     sender.getBill().takeMoney(countMoney);
                    // } catch (Exception e) {
                    //     recipient.getBill().addMoney(moneyRecipient);
                    //     sender.getBill().takeMoney(moneySender);
                    // }
                    finish = false;
                    Bank.addTransaction(id, recipient, sender, countMoney);
                    sender.getBill().lock.unlock();
                }
                recipient.getBill().lock.unlock();
            }
        }
    }
}
