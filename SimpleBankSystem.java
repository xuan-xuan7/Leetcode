public class Bank {
    long[] count;
    int n;

    public Bank(long[] balance) {
        count = balance;
        n = count.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        if(account1 < 1 || account1 > n || account2 < 1 || account2 > n){
            return false;
        }
        if(count[account1 - 1] < money){
            return false;
        }
        count[account1 - 1] -= money;
        count[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if(account < 1 || account > n){
            return false;
        }
        count[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if(account < 1 || account > n){
            return false;
        }
        if(count[account - 1] < money){
            return false;
        }
        count[account - 1] -= money;
        return true;
    }
}
