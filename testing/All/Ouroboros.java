package testing.All;

class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    Student(Student obj) {
        this.name = obj.name;
        this.age = obj.age;
    }

    void display() {
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
    }
}



public class Ouroboros {
    public static void main(String[] args) {
         Student n  = new Student("Arfa", 19);
         n.display();
         Student n2 = new Student(n);
         n2.display();

    }
}
