public class Main{
    public static class Person{
        int age;
        String name;
        void sayHi(){
            System.out.println("Hi "+name+" [ "+age+" ] ");
        }
    }
    public static void main(String[] args){
        Person p1 = new Person();
        p1.name = "Steven";
        p1.age = 24;
        p1.sayHi();

        Person p2 = new Person();
        p2.name = "Ambika";
        p2.age = 21;
        p2.sayHi();
    }
}