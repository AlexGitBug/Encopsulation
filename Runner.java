package ATM;

public class Runner {

    public static void main(String[] args) {
        ATM atm = new ATM(4,1,0);
        boolean result = atm.countNominal(130);
        System.out.println(result);
    }
}
