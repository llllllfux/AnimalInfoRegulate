package domain;


/**
* @Description: 动物类，封装了一些动物信息。
 * @author xuxingjun
 * @data 2020/9/30  -  21:28
 */
public  class Animal {


    private String species;
    private String gender;
    private int age;
    private AnimalField AnimalFiled = new AnimalField();


    public Animal() {
    }

    public Animal(String species, String gender, int age) {
        this.species = species;
        this.gender = gender;
        this.age = age;
    }


    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public AnimalField getAnimalFiled() {
        return AnimalFiled;
    }

    public void setAnimalFiled(AnimalField animalFiled) {
        AnimalFiled = animalFiled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (age != animal.age) return false;
        if (species != null ? !species.equals(animal.species) : animal.species != null) return false;
        if (gender != null ? !gender.equals(animal.gender) : animal.gender != null) return false;
        return AnimalFiled != null ? AnimalFiled.equals(animal.AnimalFiled) : animal.AnimalFiled == null;
    }

    @Override
    public int hashCode() {
        int result = species != null ? species.hashCode() : 0;
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (AnimalFiled != null ? AnimalFiled.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "  " +
                "物种：" + getSpecies() + "  " +
                "性别：" + getGender() + "  " +
                "年龄：" + getAge() + "  " +
                getAnimalFiled().sortAnimalField();
    }
}
