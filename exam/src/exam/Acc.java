//Объект "Аккаунты". Отвечает за оперировании такими данными аккаунта как "Имя" и "Счет", с последующей конвертацией в строку

package exam;

public class Acc {
    private String userName;
    private Bill userBill;

    public Bill getBill() {
        return userBill;
    }

    public void setBill(Bill bill) {
        this.userBill = bill;
    }

    public String getName() {
        return userName;
    }

    public void setName(String name) {
        this.userName = name;
    }

    public Acc() { }

    public Acc(String name, Bill bill) {
        this.userName = name;
        this.userBill = bill;
    }

    @Override
    public String toString() {
        return "" + userName + '\'' +
                ", " + userBill +
                '}';
    }
}

