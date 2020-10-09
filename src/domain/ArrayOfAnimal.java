package domain;




import java.util.ArrayList;

/**
 * @Description: 动物集合类，封装了动物的集合提供了一些对动物集合操作和判断的方法
 * @author xuxingjun
 * @data 2020/9/30  -  22:03
 */
public class ArrayOfAnimal {


    private final static ArrayList<Animal> animals = new ArrayList<Animal>();

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

}
