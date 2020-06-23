package Home_Work_1;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    List list;
    private T[] arr;
    int fruitQuantity;
    ArrayList<T> fruitBox;
    T typeFruit;

    public Box(T typeFruit){
        fruitBox = new ArrayList<>();
        this.typeFruit = typeFruit;
    }
    public int getFruitQuantity(){
        return fruitBox.size();
    }
    public float getWeight(){
        fruitQuantity = fruitBox.size();
        return fruitQuantity * typeFruit.getWeight();
    }
    public static boolean compare(float f, float s){
        if (f==s){return true;} else return false;
//        return this.getWeight() - anotherBox.getWeight() < 0.0001;
    }
    public void addFruit(int quantity) {
        for (int i = 0; i < quantity; i++) {
            this.fruitBox.add(typeFruit);
        }
    }
    public void putInAnotheBox(Box<T> boxTo){
        boxTo.addFruit(this.getFruitQuantity());
        fruitBox.clear();

    }

}

class Fruit {
    public static float weight;

    Fruit() {
        weight = 0;
    }

    public float getWeight() {
        return weight;
    }
}

class Apple extends Fruit {
    float weight;

    Apple() {
        weight = 1.5f;
    }

    @Override
    public float getWeight() {
        return weight;
    }
}

class Orange extends Fruit {
    float weight;

    Orange() {
        weight = 1.0f;
    }

    @Override
    public float getWeight() {
        return weight;
    }
}

class Run {
    public static void main(String[] args) {
        Box<Orange> orangeBox = new Box<>(new Orange());
        Box<Apple> appleBox = new Box<>(new Apple());
        System.out.println("В коробке с апельсинами " +orangeBox.getFruitQuantity() + " фруктов.");
        orangeBox.addFruit(45);
        System.out.println("В коробке с апельсинами " +orangeBox.getFruitQuantity() + " фруктов.");
        System.out.println("Коробка с апельсинами весит: " + orangeBox.getWeight());

        System.out.println("В коробке с яблоками " +appleBox.getFruitQuantity() + " фруктов.");
        appleBox.addFruit(2);
        System.out.println("В коробке с яблоками " +appleBox.getFruitQuantity() + " фруктов.");
        appleBox.addFruit(28);
        System.out.println("В коробке с яблоками " +appleBox.getFruitQuantity() + " фруктов.");
        System.out.println("Коробка с яблоками весит: " + appleBox.getWeight());

        System.out.println("Коробка апельсинов весит столько же, сколько коробка яблок: " + Box.compare(appleBox.getWeight(),orangeBox.getWeight()));

        Box<Orange> bigOrangeBox = new Box<>(new Orange());
        System.out.println("Фруктов в коробке orangeBox: " + orangeBox.getFruitQuantity());
        System.out.println("Фруктов в коробке bigOrangeBox: " + bigOrangeBox.getFruitQuantity());
        orangeBox.putInAnotheBox(bigOrangeBox);
        System.out.println("Фруктов в bigOrangeBox после пересыпания: " + bigOrangeBox.getFruitQuantity());
        System.out.println("Фруктов в orangeBox после пересыпания: " + orangeBox.getFruitQuantity());
    }
}