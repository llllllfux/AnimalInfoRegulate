package service;



import domain.Animal;

import java.util.ArrayList;

/**
 * @Description: 动物集合类，封装了动物的集合提供了一些对动物集合操作和判断的方法
 * @author xuxingjun
 * @data 2020/9/30  -  22:03
 */
public class ArrayOfAnimal {


    private final static ArrayList<Animal> animals = new ArrayList<Animal>();

    public static ArrayList<Animal> getAnimals() {
        return animals;
    }

    /**
     * 判断集合中元素是否存在
     * 不存在返回-1
     * 存在返回元素索引
     * @param a
     * @param index
     * @return
     */
    public static int isExist(ArrayList a, int index) {
        if (index < 0 || index >= a.size()) {
            return -1;
        } else {
            return index;
        }
    }

    /**
     * 复制一个和start集合元素一样的集合end
     * 返回此集合
     * @param start
     * @param end
     * @return
     */
    public static ArrayList<Animal> copy(ArrayList<Animal> start, ArrayList<Animal> end) {
        end.addAll(0, start);
        return end;
    }

    /**
     * 查看形参animal是否与animals集合中元素一样
     * 将一样的元素放入放新集合中
     * 返回新集合的长度
     * 若不存在相同元素则新集合长度为 0
     * @param animal
     * @return
     */
    public static int duplicationRemove(Animal animal){
        ArrayList<Animal> animalIsUnique = new ArrayList<Animal>(1);
        animalIsUnique.add(animal);
        ArrayList<Animal> animalArrayListCopy = copy(getAnimals(), new ArrayList<Animal>());
        animalArrayListCopy.retainAll(animalIsUnique);
        return animalArrayListCopy.size();

    }
}
