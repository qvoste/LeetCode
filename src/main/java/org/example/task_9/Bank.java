package org.example.task_9;

//легко но долго, особенно тест для всего этого писать
class Bank {
    private long[] balance;

    private boolean valid(int account) {
        return account >= 1 && account <= balance.length;
    }

    public Bank(long[] balance) {
        this.balance = new long[balance.length];
        System.arraycopy(balance, 0, this.balance, 0, balance.length);
    }

    public boolean transfer(int from, int to, long money) {
        if (!valid(from) || !valid(to)) return false;
        if (balance[from - 1] < money) return false;
        balance[from - 1] -= money;
        balance[to - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (!valid(account)) return false;
        balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (!valid(account)) return false;
        if (balance[account - 1] < money) return false;
        balance[account - 1] -= money;
        return true;
    }

    public long[] getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        String[] operations = {"Bank", "withdraw", "transfer", "deposit", "transfer", "withdraw"};
        int[][] params = {{10, 100, 20, 50, 30}, {3, 10}, {5, 1, 20}, {5, 20}, {3, 4, 15}, {10, 50}};

        Object[] results = new Object[operations.length];
        Bank bank = null;

        for (int i = 0; i < operations.length; i++) {
            String op = operations[i];
            int[] param = params[i];

            switch (op) {
                case "Bank":
                    long[] initialBalance = new long[param.length];
                    for (int j = 0; j < param.length; j++) {
                        initialBalance[j] = param[j];
                    }
                    bank = new Bank(initialBalance);
                    results[i] = null; // Первая операция — null, как ты просил
                    break;
                case "withdraw":
                    results[i] = bank.withdraw(param[0], param[1]);
                    break;
                case "transfer":
                    results[i] = bank.transfer(param[0], param[1], param[2]);
                    break;
                case "deposit":
                    results[i] = bank.deposit(param[0], param[1]);
                    break;
            }
        }

        System.out.print("[");
        for (int i = 0; i < results.length; i++) {
            System.out.print(results[i] == null ? "null" : results[i]);
            if (i < results.length - 1) System.out.print(",");
        }
        System.out.println("]");
    }
}