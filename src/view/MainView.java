package view;

import domain.Animal;
import domain.AnimalField;
import service.GetOrModifyAnimalInfo;
import domain.ArrayOfAnimal;
import service.TSUtility;

import java.util.*;


/**
 * @author xuxingjun
 * @Description: 主界面和各个功能的具体实现
 * @data 2020/9/30  -  21:38
 */
public class MainView {

    private GetOrModifyAnimalInfo gomai = new GetOrModifyAnimalInfo();
    private ArrayOfAnimal arrayOfAnimal = new ArrayOfAnimal();


    public void enterMainMenu() {

        System.out.println("-----------------------动物信息管理-----------------------------" + '\n');
        boolean flag = true;
        do {

            TSUtility.mainMenu();

            int key = 0;
            try {
                key = TSUtility.getKeyboardNum();
            } catch (InputMismatchException e) {
                System.out.println("数据输入错误!!：" + '\n');
            }

            switch (key) {
                case 1:
                    listTeam();
                    System.out.println();
                    break;
                case 2:
                    queryAnimal();
                    System.out.println();
                    break;
                case 3:
                    addMember();
                    System.out.println();
                    break;
                case 4:
                    deleteMember();
                    System.out.println();
                    break;
                case 5:
                    modifyMember();
                    System.out.println();
                    break;
                case 6:
                    sortByAge();
                    System.out.println();
                    break;
                case 7:
                    System.out.println("是否退出（Y/N）:");
                    if ('Y' == TSUtility.readConfirmSelection())
                        flag = false;
                    break;

            }
        } while (flag);

    }


    /**
     * 判断列表中有没有数据，无数据则给予提示，有数据显示出数据
     */
    private void listTeam() {

        System.out.println("---------------------动物列表----------------------" + '\n');

        int id = 0;


        if (arrayOfAnimal.getAnimals().size() == 0) {
            System.out.println("              列表无数据！！");
        } else {
            for (Animal a : arrayOfAnimal.getAnimals()) {
                id++;
                System.out.println("编号：" + id + a.toString());
            }
        }
    }


    /**
     * 向列表中增加数据
     * 若添加的数据列表中已经存在，则向用户获取指令是否仍要添加
     */
    private void addMember() {
        System.out.println("------------添加动物------------" + '\n');

        //确认用户是否要添加数据
        System.out.println("是否确认添加动物（Y/N）");
        //用户确实添加
        if ('Y' == TSUtility.readConfirmSelection()) {

            Animal animalAdd = new Animal(gomai.speciesAdd(), gomai.genderAdd(), gomai.ageAdd());
            AnimalField animalField = new AnimalField();
            gomai.getAnimalFieldMap(animalField.getAnimalFieldAdd());
            animalAdd.setAnimalFiled(animalField);

            //判断要添加的数据列表中是否已经存在;
            int size = TSUtility.duplicationRemove(arrayOfAnimal.getAnimals(), animalAdd);
            if (size == 0) {
                //要添加的数据不存在
                arrayOfAnimal.getAnimals().add(animalAdd);
                System.out.println("------添加成功！！-------");
            } else {
                //要添加的数据已存在，向用户确认
                System.out.println("该数据已添加过是否再次添加（Y/N)");
                if ('Y' == TSUtility.readConfirmSelection()) {
                    arrayOfAnimal.getAnimals().add(animalAdd);
                    System.out.println("---------已添加！！------");
                } else
                    System.out.println("-----------已取消添加！！--------");
            }
        } else
            //用户退出添加
            System.out.println("--------已退出动物数据增加--------");
    }


    /**
     * 删除列表中数据
     * 获取用户要删除的数据编号（只获取整形，其他类型重新输入）
     * 若数据存在则删除，数据不存在则提示用户数据不存在并退出功能
     */
    private void deleteMember() {
        if (arrayOfAnimal.getAnimals().size() != 0) {
            System.out.println("---------------------删除动物----------------------" + '\n');
            listTeam();
            //获取要删除的数据编号
            System.out.println('\n' + "请选择要删除的数据编号（输入0退出删除）：");
            Scanner num = new Scanner(System.in);
            int deleteNum;
            try {
                deleteNum = num.nextInt();
            } catch (Exception e) {
                System.out.println("数据类型错误！！");
                deleteMember();
                return;
            }

            //退出数据删除
            if (deleteNum == 0) {
                System.out.println("-------已退出删除--------");
            } else {
                //判断此数据是否存在
                int exist = TSUtility.isExist(arrayOfAnimal.getAnimals(), deleteNum - 1);
                if (exist == -1) {
                    //数据不存在
                    System.out.println("此数据不存在！！删除失败！！");
                } else {
                    //数据存在
                    System.out.println(arrayOfAnimal.getAnimals().get(deleteNum - 1).toString());
                    System.out.println("是否删除此条数据（Y/N）:");
                    if ('Y' == TSUtility.readConfirmSelection()) {
                        arrayOfAnimal.getAnimals().remove(deleteNum - 1);
                        System.out.println("--------删除成功！！-------");
                    }

                }
            }
        } else {
            System.out.println("              列表无数据！！");

        }
    }

    /**
     * 修改列表中的数据
     * 获取用户要修改的数据编号（只获取整形，其他类型重新输入）
     * 若数据存在则修改数据。数据不存在则提示用户改数据不存在，并退出功能
     */
    private void modifyMember() {
        if (arrayOfAnimal.getAnimals().size() != 0) {
            listTeam();
            System.out.println("------------修改动物信息------------" + '\n');
            //向用户确认是否要修改
            System.out.println("是否确认修改动物（Y/N）");
            if ('Y' == TSUtility.readConfirmSelection()) {
                //用户确认添加
                System.out.println("请选择要修改的数据编号：");
                Scanner scanner = new Scanner(System.in);
                int keyboardNum = 0;
                try {
                    keyboardNum = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("数据类型错误！！");
                    modifyMember();
                    return;
                }

                //判断要修改的数据是否存在
                int modifyNum = TSUtility.isExist(arrayOfAnimal.getAnimals(), keyboardNum - 1);
                if (modifyNum != -1) {
                    //数据存在
                    Animal animalModify = new Animal(gomai.speciesModify(), gomai.genderModify(), gomai.ageModify());
                    AnimalField newAnimalField = new AnimalField();
                    gomai.getAnimalFieldMap(newAnimalField.getAnimalFieldAdd());
                    animalModify.setAnimalFiled(newAnimalField);
                    arrayOfAnimal.getAnimals().set(modifyNum, animalModify);
                    System.out.println("--------数据修改成功！！--------");
                } else {
                    //数据不存在
                    System.out.println("无此数据！！");
                }
            } else
                //用户退出修改
                System.out.println("----------已退出动物数据修改----------");
        } else {
            System.out.println("              列表无数据！！");
        }
    }

    /**
     * 将列表数据按年龄排序
     * 若年龄相同按物种排序
     */
    private void sortByAge() {
        if (arrayOfAnimal.getAnimals().size() != 0) {
            System.out.println("--------------将动物按年龄排序--------------" + '\n');
            //获取一个和动物集合一样的集合
            ArrayList<Animal> copy = TSUtility.copy(arrayOfAnimal.getAnimals(), new ArrayList<Animal>());

            // 借助比较器来按年龄排序
            Collections.sort(copy, new Comparator<Animal>() {
                @Override
                public int compare(Animal o1, Animal o2) {
                    if (o1 instanceof Animal && o2 instanceof Animal) {
                        if (o1.getAge() == o2.getAge()) {
                            return o1.getSpecies().compareTo(o2.getSpecies());
                        } else if (o1.getAge() > o2.getAge()) {
                            return 1;
                        } else if (o1.getAge() < o2.getAge()) {
                            return -1;
                        }
                    }
                    throw new RuntimeException("输入的数据类型不一致");
                }
            });

            copy.forEach(System.out::println);

        } else {
            System.out.println("              列表无数据！！");

        }
    }


    /**
     * 查找列表中的数据
     * 获取用户要查询的数据编号（只获取整形，其他类型重新输入）
     * 若该数据存在则显示，若不存在则提示用户数据不存在，并退出功能
     */
    private void queryAnimal() {

        if (arrayOfAnimal.getAnimals().size() != 0) {
            //获取要查找的数据编号
            System.out.println('\n' + "请选择要查找的数据编号：");
            Scanner num = new Scanner(System.in);
            int animalNum;
            try {
                animalNum = num.nextInt();
            } catch (Exception e) {
                System.out.println("数据类型错误！！");
                queryAnimal();
                return;
            }
            //判断此数据是否存在
            int exist = TSUtility.isExist(arrayOfAnimal.getAnimals(), animalNum - 1);
            if (exist == -1) {
                //数据不存在
                System.out.println("此数据不存在！！查找失败！！");
            } else {
                //数据存在
                System.out.println(arrayOfAnimal.getAnimals().get(animalNum - 1).toString());
                System.out.println("---------查询成功！！----------");

            }
        } else {
            System.out.println("              列表无数据！！");
        }

    }

    public static void main(String[] args) {

        MainView mainView = new MainView();
        mainView.enterMainMenu();

    }
}
