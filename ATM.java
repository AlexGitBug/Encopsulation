package ATM;

public class ATM {
    private int amount20;
    private int amount50;
    private int amount100;

    private int allMoneyInATM() {
        return getAmount20() * 20 + getAmount50() * 50 + getAmount100() * 100;
    }


    public ATM(int amount20, int amount50, int amount100) {
        addMoney(amount20, amount50, amount100);
    }

    public void addMoney(int amount20, int amount50, int amount100) {
        this.amount20 += amount20;
        this.amount50 += amount50;
        this.amount100 += amount100;
    }

    public void print() {
        System.out.println("Купюр номиналом 20: " + getAmount20());
        System.out.println("Купюр номиналом 50: " + getAmount50());
        System.out.println("Купюр номиналом 100: " + getAmount100());

    }

    public static int TWENTY = 20;
    public static int FIFTY = 50;
    public static int ONE_HUNDRED = 100;

    public boolean countNominal(int sum) {
        int currentSum = sum;
        int current100 = 0;
        int current50 = 0;
        int current20 = 0;
        while (currentSum != 0) {
            if (currentSum > allMoneyInATM()) {
                System.out.println("Укажите сумму меньше");
            }

            if (currentSum > ONE_HUNDRED && (currentSum / ONE_HUNDRED) <= amount100 && currentSum % FIFTY != 10 && currentSum % FIFTY != 30) {
                current100 = currentSum / ONE_HUNDRED;
                currentSum -= current100 * ONE_HUNDRED;
            } else if (currentSum > ONE_HUNDRED && (currentSum / ONE_HUNDRED) > amount100 && currentSum % FIFTY != 10 && currentSum % FIFTY != 30) {
                current100 = amount100;
                currentSum -= amount100 * ONE_HUNDRED;
            } else if (currentSum % ONE_HUNDRED == 10) {
                current50 += 1;
                current20 += 3;
                currentSum -= (FIFTY + TWENTY * 3);
                current100 = currentSum / ONE_HUNDRED;
                currentSum -= current100 * ONE_HUNDRED;

            }
            if (currentSum >= 50 && (currentSum / 50) <= amount50 && currentSum % FIFTY != 10 && currentSum % FIFTY != 30) {
                current50 = currentSum / FIFTY;
                currentSum -= current50 * FIFTY;
            } else if (currentSum % FIFTY == 10) {
                current20 += 1;
                currentSum -= TWENTY;
                current50 = currentSum / FIFTY;
                currentSum -= current50 * FIFTY;
            } else if (currentSum % FIFTY == 30) {
                current20 += 3;
                currentSum -= TWENTY * 3;
                current50 = currentSum / FIFTY;
                currentSum -= current50 * 50;
            }

            if (currentSum % 20 == 0 && amount20 >= (currentSum / TWENTY)) {
                int banknotesTwenty = currentSum / TWENTY;
                current20 += currentSum / TWENTY;
                currentSum -= banknotesTwenty * TWENTY;
            }

            System.out.println("Снято: ");
            System.out.println(String.format("%s купир номиналом 100 ", current100));
            System.out.println(String.format("%s купир номиналом 50 ", current50));
            System.out.println(String.format("%s купир номиналом 20 ", current20));
        }
        if (currentSum == 0) {

            return true;
        } else
            return false;
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



