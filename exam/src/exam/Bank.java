//Объект "Банк". Сохраняет информацию о транзакциях аккаунтов используя Hashtable и ArrayList.
//Присутствуют функция добавления всех данных транзакции(ID,Аккаунт отправитель и аккаунт получатель), и их вывода

package exam;

import java.util.*;

public class Bank {
    static Hashtable<Integer,ArrayList<String>>transList= new Hashtable<Integer, ArrayList<String>>();

    static void addTransaction(Integer id, Acc recipient, Acc sender, double billBalance){
        String strTransaction =
              String.format("Transaction |%d| MONEY=%.2f RECIPIENT: %s, SENDER: %s \n",
                       id,billBalance ,recipient.toString(), sender.toString());

        if(transList.get(id)==null){
            transList.put(id,new ArrayList<String>());
            transList.get(id).add(strTransaction);
        }
        else{
            transList.get(id).add(strTransaction);
        }
    }

    static void printTransactions(){
        for(Map.Entry e : transList.entrySet()){
            System.out.println(e.getValue().toString());
        }
    }
}
