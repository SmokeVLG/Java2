import java.util.ArrayList;

/**
 * Java 2 home work for Lesson 1
 * author Denisov Maxim
 * date 16/08/2018
 *
 * @link https://github.com/SmokeVLG/Java2/blob/master/HomeWork1.java
 */
public class HomeWork1 {
    static final int LENGTH_JUMP_CAT = 200;

    public enum Color {
        BLACK, WHITE
    }


    //Action for animal

    interface IAction {
        void run(int length);

        void swim(int length);

        void jump(int height);
    }


    /*
    * Class for Animal
    * */
    abstract static class Animal implements IAction {
        String name;
        Color color;
        int age;


        Animal(String name, Color color, int age) {
            this.name = name;
            this.color = color;
            this.age = age;
        }

        @Override
        public String toString() {
            return name + " " + color + " " + age;
        }
    }

    /*
  * Class for Cat
  * */
    public static class Cat extends Animal {

        Cat(String name, Color color, int age) {
            super(name, color, age);
        }


        @Override
        public void run(int length) {
            if (length > LENGTH_JUMP_CAT) {
                System.out.println("Cat can't run that much.");
            } else {
                System.out.println("result run cat: true.");
            }
        }

        @Override
        public void swim(int length) {
            System.out.println("Cat can't swim ");
        }

        @Override
        public void jump(int height) {
            if (height > 2) {
                System.out.println("Cat can't jump that much.");
            } else {
                System.out.println("result jump cat: true.");
            }
        }
    }

    /*
  * Class for Dog
  * */
    public static class Dog extends Animal {

        Dog(String name, Color color, int age) {
            super(name, color, age);
        }


        @Override
        public void run(int length) {
            if (length > 500) {
                System.out.println("Dog can't run that much.");
            } else {
                System.out.println("result run dog: true.");
            }
        }

        @Override
        public void swim(int length) {
            if (length > 10) {
                System.out.println("Dog can't swim that much.");
            } else {
                System.out.println("result swim dog: true.");
            }
        }

        @Override
        public void jump(int height) {
            if (height > 0.5) {
                System.out.println("Dog can't jump that much.");
            } else {
                System.out.println("result jump dog: true.");
            }
        }
    }


    public static void main(String[] args) {

        //create animal
        ArrayList<IAction> animals = new ArrayList<>();
        animals.add(new Cat("Barsik", Color.BLACK, 2));
        animals.add(new Dog("Sharik", Color.WHITE, 3));

        //action for animal
        for (IAction animal : animals) {
            animal.jump(10);
            animal.run(20);
            animal.swim(30);
        }
    }
}