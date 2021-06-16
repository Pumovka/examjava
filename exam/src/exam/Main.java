//

package exam;

public class  Main {

    public static void main(String[] args) throws InterruptedException {
        final Acc account1 = new Acc("Account1", new Bill("bill_1"));
        final Acc account2 = new Acc("Account2", new Bill("bill_2"));
        final Acc account3 = new Acc("Account3", new Bill("bill_3"));
        final Acc account4 = new Acc("Account4", new Bill("bill_4"));

        Thread Operations = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    new Transaction(account1, account2, 10);
                } catch (SendManyExeption sendManyExeption) {
                    sendManyExeption.printStackTrace();
                }
                try {
                    new Transaction(account2, account1, 20);
                } catch (SendManyExeption sendManyExeption) {
                    sendManyExeption.printStackTrace();
                }

                try {
                    new Transaction(account3, account4, 10);
                } catch (SendManyExeption sendManyExeption) {
                    sendManyExeption.printStackTrace();
                }
                try {
                    new Transaction(account4, account3, 20);
                } catch (SendManyExeption sendManyExeption) {
                    sendManyExeption.printStackTrace();
                }
                Bank.printTransactions();
            }
        });
        Thread Operations1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    new Transaction(account2, account4, 10);
                } catch (SendManyExeption sendManyExeption) {
                    sendManyExeption.printStackTrace();
                }
                try {
                    new Transaction(account3, account1, 20);
                } catch (SendManyExeption sendManyExeption) {
                    sendManyExeption.printStackTrace();
                }

                try {
                    new Transaction(account3, account2, 10);
                } catch (SendManyExeption sendManyExeption) {
                    sendManyExeption.printStackTrace();
                }
                try {
                    new Transaction(account4, account1, 20);
                } catch (SendManyExeption sendManyExeption) {
                    sendManyExeption.printStackTrace();
                }
                Bank.printTransactions();
            }
        });



        Operations.start();
        Operations1.start();
        // try {
        //     new Transaction(account1, account2, 21);
        //
        // }catch (SendManyExeption sendManyExeption){
        //     sendManyExeption.printStackTrace();
        // }
        //
        // try {
        //     new Transaction(account2, account1, 22);
        // } catch (SendManyExeption sendManyExeption) {
        //     sendManyExeption.printStackTrace();
        // }
        //
        // try {
        //     new Transaction(account3, account4, 23);
        //
        // }catch (SendManyExeption sendManyExeption){
        //     sendManyExeption.printStackTrace();
        // }
        //
        // try {
        //     new Transaction(account4, account3, 24);
        // } catch (SendManyExeption sendManyExeption) {
        //     sendManyExeption.printStackTrace();
        // }

//        Bank.printTransactions();
        Operations.join();
    }
}
