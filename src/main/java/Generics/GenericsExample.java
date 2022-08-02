package Generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsExample {
    public static void main(String[] args){


        IntegerPrinter printer = new IntegerPrinter(25);
        printer.print();

        DoublePrinter printer1 = new DoublePrinter(2.4);
        printer1.print();

        // Instead of doing exactly the same thing for every Type, we can use Generics to make this easier


        // So you can use the Printer class, to print every type
        Printer<Integer> printer2 = new Printer<>(23);
        printer2.print();

        Printer<String> printer3 = new Printer<>("Wow this is much more understandable than whatever the fuck the teacher was trying to teach us");
        printer3.print();

        //Generics are also true for already used Java things like arraylists

        ArrayList<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("Yo");

        // Since listOfStrings have the type "String", we can not add something other than strings i.e.

        // listOfStrings.add(25); this will throw an error
        //Instead we can make an arrayList of type "Object" that can hold everything

        ArrayList<Object> listOfObjects = new ArrayList<>();
        listOfObjects.add(245);
        listOfObjects.add("This is also an object");
        listOfObjects.add(new Cat());

        // This however, is not type-safe

        //If you want something from this list i.e. the Cat
        // It will be an object, so if you want to get the cat, you neew to typecast this to a Cat
        Cat myCat = (Cat) listOfObjects.get(2);
        System.out.println(myCat);
        Integer desiredInt = (Integer) listOfObjects.get(0);
        System.out.println(desiredInt);



        AnimalPrinter<Cat> catAnimalPrinter = new AnimalPrinter<>(new Cat());
        AnimalPrinter<Dog> dogAnimalPrinter = new AnimalPrinter<>(new Dog());

        catAnimalPrinter.print();
        dogAnimalPrinter.print();



        shout("Martin");
        shout(42);
        shout(new Cat());
        shout("Martin", 42);
        shout(new Cat(), new Dog());

        shoutWithReturn("Martin", "Cool");


        // This throws an error
//        List<Integer> intList = new ArrayList<>();
//        intList.add(3);
//        printList(intList);



        // Since we uysed "?" as the defined type, we can use the printList to print out any tyoe we want
        // This is for integers
        List<Integer> intList = new ArrayList<>();
        intList.add(2);
        printList(intList);

        // But it also works with strings:
        List<String> stringList = new ArrayList<>();
        stringList.add("Hey there bucko");
        printList(stringList);


        // This works because cat is of type animal
        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat());
        printAnimalList(catList);

        // And it works for dogs:
        List<Dog> dogList = new ArrayList<>();
        dogList.add(new Dog());
        printAnimalList(dogList);

        // But you cannot do this;

//        List<Integer> integerList = new ArrayList<>();
//        integerList.add(245);
//        printAnimalList(integerList);
        // Although we used the "?" in animal list, since the "?" extends Animal, the list needs to be of some type of Animal
    }


    // you can have generics in methods as well:
    // If you want to use generics in a method, you need to put <T(or whatever you want)> between static and void
    private static <T> void shout(T thingToShout){
        System.out.println(thingToShout + "!!!!!!!!!!");
    }

    // You can have multiple generics as well
    private static <T, V> void shout(T thingToShout, V otherThingToShout){
        System.out.println(thingToShout + "!!!!!!!!!!");
        System.out.println(otherThingToShout + "!!!!!!!!!!");
    }

    // You can return a generic as well
    private static <T, V> T shoutWithReturn(T thingToShout, V otherThingToShout){
        System.out.println(thingToShout + "!!!!!!!!!!");
        System.out.println(otherThingToShout + "!!!!!!!!!!");
        return thingToShout;
    }

    // List that can print out everything no matter the type

    //This does not work

//    private static void  printList(List<Object> myList){
//        System.out.println();
//    }


    // You need to add a wildcard
    private static void printList(List<?> myList){
        System.out.println();
    }

    //You can bind this wildcard as well

    private static void printAnimalList(List<? extends Animal> myAnimalList){
        System.out.println();
    }
}
