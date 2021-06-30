package puciłowski;

public class Ticket implements TicketMBean {
    int priority;
    String name;
    char symbol;
    int number;

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Ticket(int priority, char symbol, int number) {
        this.priority = priority;
        this.symbol = symbol;
        this.number = number;
        StringBuilder sb = new StringBuilder();
        sb.insert(0,"00000");
        sb.insert(0,symbol);
        for(int i = 5;i>0;i--){
            if(number>0){
                int num = number % 10;
                sb.setCharAt(i, String.valueOf(num).charAt(0));
            }
            number = number/10;
            if(number == 0){
                i = 0;
            }
        }

        this.name = sb.toString();
    }
}
