package Generics;
//You can call the T whatever you want, but It's common to call it "T" for type :)
public class Printer <T>{
    T thingToPrint;

    public Printer(T thingToPrint){
        this.thingToPrint = thingToPrint;
    }

    public void print(){
        System.out.println(thingToPrint);
    }

}
