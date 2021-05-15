public class Main{
    public static class Person{
        int age;
        String name;
        void sayHi(){
            System.out.println("Hi "+name+" [ "+age+" ] ");
        }
    }
    public static void swap1(Person p1, Person p2){
        Person temp = p1;
        p1 = p2;
        p2 = temp;
    }
    public static void swap2(Person p1, Person p2){
        int age = p1.age;
        p1.age = p2.age;
        p2.age = age;
        
        String name = p1.name;
        p1.name = p2.name;
        p2.name = name;
    }
    public static void main(String[] args){
        Person p1 = new Person();
        p1.name = "Steven";
        p1.age = 24;
        // p1.sayHi();

        Person p2 = new Person();
        p2.name = "Ambika";
        p2.age = 21;
        // p2.sayHi();
        
        System.out.println("SWAP 1 -----------------------");
        p1.sayHi();
        p2.sayHi();
        swap1(p1, p2);
        p1.sayHi();
        p2.sayHi();
        
        
        System.out.println("SWAP 2 -----------------------");
        p1.sayHi();
        p2.sayHi();
        swap2(p1, p2);
        p1.sayHi();
        p2.sayHi();
        
        
    }
}