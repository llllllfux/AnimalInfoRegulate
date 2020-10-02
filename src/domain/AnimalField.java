package domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Description: 动物属性类，封装了动物特有属性的集合。提供了操作属性集合的方法
 * @author xuxingjun
 * @data 2020/9/30  -  14:57
 */
public class AnimalField {

    private LinkedHashMap<String, String> AnimalFieldAdd = new LinkedHashMap<>();

    public  LinkedHashMap<String, String> getAnimalFieldAdd() {
        return AnimalFieldAdd;
    }

    public void setAnimalFieldAdd(LinkedHashMap<String, String> animalFieldAdd) {
        AnimalFieldAdd = animalFieldAdd;
    }

    /**
     * 遍历getAnimalFieldAdd，返回一个字符串
     * @return
     */
    public String sortAnimalField(){
        String massage = "";

        Set<Map.Entry<String, String>> entries = AnimalFieldAdd.entrySet();
        for (Map.Entry<String,String> entry:
             entries) {
            massage += "  "+ entry.getKey() + ": " + entry.getValue() + "  ";
        }
        return massage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnimalField that = (AnimalField) o;

        return AnimalFieldAdd != null ? AnimalFieldAdd.equals(that.AnimalFieldAdd) : that.AnimalFieldAdd == null;
    }

    @Override
    public int hashCode() {
        return AnimalFieldAdd != null ? AnimalFieldAdd.hashCode() : 0;
    }
}
