package Generics;


// You can limit generics to be of a certain class with inheritance i.e. Animal
public class AnimalPrinter<T extends Animal>{
    // Since the type extends animal, thingToPrint gets the animal inheritance as well
   T thingToPrint;

    public AnimalPrinter(T thingToPrint){
        this.thingToPrint = thingToPrint;
    }

    public void print(){
        // Since T extends animal, thingToPrint can access the eat method
        thingToPrint.drink();
        System.out.println(thingToPrint);
    }
}
