package service;


import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * @Description: 定义了各个功能实现的要调用的方法实现细节
 * @author xuxingjun
 * @data 2020/9/30  -  20:40
 */
public class GetOrModifyAnimalInfo {


    /**
     * 获取性别信息：雌或雄
     * 数据不符合则重新输入
     * @return
     */
    public String genderAdd() {
        Scanner readGender = new Scanner(System.in);
        System.out.println("请输入性别(雌、雄）：");
        String theGender = readGender.nextLine();
        do {
            if ("".equals(theGender)) {
                System.out.println("不可为空请重新输入：");
                theGender = readGender.nextLine();
            } else if (!"雌".equals(theGender) && !"雄".equals(theGender)) {
                System.out.println("性别错误请重新输入：");
                theGender = readGender.nextLine();
            } else
                break;

        } while (true);
        return theGender;
    }

    /**
     * 获取年龄信息
     * 数据只能是 整形数据，范围[0,100]
     * 输入其他数据提示数据错误，重新输入
     * @return
     */
    public int ageAdd() {
        Scanner readAge = new Scanner(System.in);
        System.out.println("请输入年龄：");
        int theAge;

        try {
            do {
                theAge = readAge.nextInt();
                if (theAge <= 0 || theAge > 100) {
                    System.out.println("年龄错误请重新输入：");
                } else
                    break;
            } while (true);
        } catch (Exception e) {
            System.out.println("数据类型输入错误！！！");
            int i = ageAdd();
            return i;
        }
        return theAge;
    }


    /**
     * 获取物种信息
     *
     * @return
     */
    public String speciesAdd() {
        Scanner readSpecies = new Scanner(System.in);
        System.out.println("请输入物种：");
        String thespecies = readSpecies.nextLine();
        do {
            if ("".equals(thespecies)) {
                System.out.println("不可为空请重新输入：");
                thespecies = readSpecies.nextLine();
            } else
                break;

        } while (true);


        return thespecies;
    }

    /**
     * 获取性别修改信息
     * @return
     */
    public String genderModify() {
        return genderAdd();
    }

    /**
     * 获取年龄修改信息
     * @return
     */
    public int ageModify() {
        return ageAdd();
    }

    /**
     * 获取物种修改信息
     * @return
     */
    public String speciesModify() {
        return speciesAdd();
    }

    /**
     * 获取除给定属性外用户要添加的属性和备注
     * 将用户输入的数据装入LinkedHashMap集合，并返回此集合
     * @param map
     * @return
     */
    public LinkedHashMap getAnimalFieldMap(LinkedHashMap<String, String> map) {
        do {
            System.out.println("是否要添加新的属性（Y/N）：");
            if ('Y' == TSUtility.readConfirmSelection()) {

                System.out.println("请输入属性：");
                Scanner readField = new Scanner(System.in);
                String filed = readField.nextLine();

                System.out.println("请输入属性值：");
                Scanner readFieldValue = new Scanner(System.in);
                String filedValue = readFieldValue.nextLine();

                map.put(filed, filedValue);
            } else {
                System.out.println("是否还有要备注的(Y/N)");
                if ('Y' == TSUtility.readConfirmSelection()) {
                    System.out.println("请写入备注：");
                    Scanner readRemarks = new Scanner(System.in);
                    String remarksValue = readRemarks.nextLine();
                    map.put("备注", remarksValue);
                    break;
                } else
                    break;
            }
        } while (true);


        return map;
    }
}
