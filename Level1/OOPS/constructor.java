public class Main{
    public static class Person{
        int age;
        String name;
        
        /*
        Person(){
            // this is provided by java language. Incase user forgets
        }
        */
        Person(){
            System.out.println("Welcome User");
            name = "NA";
            age = -1;
        }
        Person(String n, int a){
            name = n;
            age = a;
        }
        void sayHi(){
            System.out.println("Hi "+name+" [ "+age+" ] ");
        }


    }
    public static void main(String[] args){

        Person p1 = new Person();
        p1.sayHi();

        Person p2 = new Person("pepcoding", 3);
        p2.sayHi();
    }
}