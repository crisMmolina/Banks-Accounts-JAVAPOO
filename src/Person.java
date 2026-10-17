public class Person {
    private String name;
    private String apellido;
    private float balance;
    private int pin;

    public Person(String name, String apellido, float balance, int pin) {
        this.name = name;
        this.apellido = apellido;
        this.balance = balance;
        this.pin = pin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public float deposit (float amount){
        balance+=amount;
        return balance;
    }
    public float withdraw (float amount){
        if (amount>balance){
            System.out.println("INSUFFICIENT BALANCE");
        }else
            balance-=amount;
        return balance;
    }
}
