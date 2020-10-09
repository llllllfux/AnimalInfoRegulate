package service;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description: 定义一些方法方便随时调用
 * @author xuxingjun
 * @data 2020/9/30  -  16:12
 */
public class TSUtility {


    /**
     *
     * 从键盘获取数据，执行对应功能
     * 若所输数据无对应功能则提示用用户重新输入
     * @return
     */
    public static int getKeyboardNum() {
        Scanner scanner = new Scanner(System.in);

        int key;

        for (; ; ) {
            key = scanner.nextInt();
            if (key != 1 && key != 2 &&
                    key != 3 && key != 4 &&
                    key != 5 && key != 6 &&
                    key != 7) {
                System.out.print("选择错误，请重新输入：");
            } else
                break;
        }
        return key;
    }

    /**
     * 向用户获取确认
     *
     * @return
     */
    public static char readConfirmSelection() {
        char c;
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String str = scanner.nextLine();
            if (!"".equals(str)) {
                c = str.toUpperCase().charAt(0);
                if (c == 'Y' || c == 'N') {
                    break;
                } else {
                    System.out.print("选择错误，请重新输入：" + '\n');
                }
            }else
                System.out.print("不可为空，请重新输入：" + '\n');

        }
        return c;
    }

    /**
     *   主菜单模板
     */
    public static void mainMenu() {

        System.out.print("1-动物列表"
                + '\n' + "2-查找动物"
                + '\n' + "3-添加动物"
                + '\n' + "4-删除动物"
                + '\n' + "5-修改动物信息"
                + '\n' + "6-按年龄排序"
                + '\n' + "7-退出 " +
                + '\n' + "请选择(1-7)：");
        System.out.println();
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
     * @param <T>
     * @return
     */
    public static<T> ArrayList<T> copy(ArrayList<T> start, ArrayList<T> end) {
        end.addAll(0, start);
        return end;
    }

    /**
     * 查看形参animal是否与animals集合中元素一样
     * 将一样的元素放入放新集合中
     * 返回新集合的长度
     * 若不存在相同元素则新集合长度为 0
     * @param arrayList
     * @param t
     * @param <T>
     * @return
     */
    public static<T>  int duplicationRemove(ArrayList<T> arrayList,T t){
        ArrayList<T> animalIsUnique = new ArrayList<T>(1);
        animalIsUnique.add(t);
        ArrayList<T> animalArrayListCopy = copy(arrayList, new ArrayList<T>());
        animalArrayListCopy.retainAll(animalIsUnique);
        return animalArrayListCopy.size();

    }

}
