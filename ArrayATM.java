package ATM;

public class ArrayATM {
    private int amount20;
    private int amount50;
    private int amount100;

    private int number;


    public ArrayATM() {
    }

    public ArrayATM(int amount20, int amount50, int amount100) {
        this.amount20 = amount20;
        this.amount50 = amount50;
        this.amount100 = amount100;
    }

    public int addcount20(int amount20) {
        return getAmount20() * 20;
    }

    public int addCount50(int amount50) {
        return getAmount50() * 50;
    }

    public int addCount100(int amount100) {
        return getAmount100() * 100;
    }

    public boolean isWithdrawMoney(int sumPenny) {
        if (sumPenny % 10 != 0) {
            System.out.println("неправильная сумма, введите корректную сумму");
        } else if (sumPenny <= 1250) {
            countNominal(sumPenny);
        } else {
            System.out.println("нет такой суммы в банкомате");
            return false;
        }
        return true;
    }

    public void countNominal (int sumPenny) {
        int[] nominal = {20, 50, 100};
        int[] count = new int[nominal.length];
        int index = nominal.length - 1;

        while (index != -1) {
                count[index] = sumPenny / nominal[index];
                sumPenny = sumPenny % nominal[index];
                index--;

            }

        for (int i = 0; i < count.length; i++) {
            System.out.printf("Номинал в %d руб. = %d шт.\n", nominal[i], count[i]);
        }

    }

    public int getAmount20() {
        return amount20;
    }

    public int getAmount50() {
        return amount50;
    }

    public int getAmount100() {
        return amount100;
    }
}

