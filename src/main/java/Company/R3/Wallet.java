package main.java.Company.R3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

interface Wallet {

    /**
     * Load money into my wallet (fixed sized denominations of any kind are acceptable)
     * (assume that [filename] is readable from the classpath)
     */
    void load(String filename);

    /**
     * Return the coins in the wallet.
     * (peek does NOT need to be performant as to be used solely for testing)
     */
    Collection<Long> peek();

    /**
     * Return current balance of my wallet
     */
    Long getBalance();

    /**
     * Spend an [amount] of money from Wallet and ensure the wallet is updated
     * (any change should be added back to the wallet as a single amount)
     * Return single change amount (if any change due) or zero.
     * This time return the actual coins spent as well as any change due.
     * SpendSummary should include the collection of coins spent and a single change amount
     */
    SpendSummary spend(Long amount);
}

class SpendSummary {
    List<Long> spent = new LinkedList<>();
    Long change = 0L;
}

class WalletImpl implements Wallet {

    private List<Long> denominations = new LinkedList<>();

    @Override
    public void load(String filename) {
        BufferedReader reader;
        String line = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
            line = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (line != null) {
            String[] results = line.split(",");
            for (String coin:results) denominations.add(Long.valueOf(coin));
        }

        //denominations.sort(Comparator.comparingLong(a -> -a));
    }

    @Override
    public Collection<Long> peek() {
        return denominations;
    }

    @Override
    public Long getBalance() {
        Long sum = 0L;
        for (Long denomination:denominations) sum+=denomination;
        return sum;
    }

    @Override
    public SpendSummary spend(Long amount) {
        if (amount > getBalance()) throw new RuntimeException("not sufficient balance");
        SpendSummary spendSummary = new SpendSummary();
        Iterator<Long> it = denominations.iterator();
        while (it.hasNext()) {
            Long val = it.next();
            spendSummary.spent.add(val);
            it.remove();
            if (amount <= val) {
                spendSummary.change = val - amount;
                break;
            }
            else {
                amount-=val;
            }
        }

        if (spendSummary.change != 0L) denominations.add(spendSummary.change);
        //denominations.sort(Comparator.comparingLong(a -> -a));

        return spendSummary;
    }
}

class Test {
    public static void main(String[] args) {
        WalletImpl w = new WalletImpl();
        w.load("/Users/wyao/TestProjects/LearningJava/src/main/java/Company/R3/denominations.txt");

        System.out.println(w.getBalance());

        SpendSummary s = w.spend(203L);
        System.out.println("change:" + s.change);
        for (Long l:s.spent) System.out.println(l);
        System.out.println("after spending");
        for (Long d:w.peek()) {
            System.out.println(d);
        }

    }
}
