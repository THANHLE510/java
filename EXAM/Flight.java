package EXAM;

public class Flight {
    private int number;
    private String destination;

    public Flight() {
        this.number = 0;
        this.destination = "";
    }
    public Flight(int number,String destination){
        if(number > 0 && destination != null){
            this.number = number;
            this.destination = destination;
        }
        else {
            this.number = 0;
            this.destination="";
        }
    }
    public String getDestination(){
        return this.destination;
    }

    public int getNumber() {
        return this.number;
    }
    public void display(){
        System.out.println(this.number + "," + this.destination);
    }
}
