package util;


import java.lang.reflect.Field;


/**
 * Created by Hiki on 12/4/2016.
 */
public class CommonMethod {

    // 打印对象中的所有成员
    public static void printClass(Object obj){

        // 获取对象中的所有属性域
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields)
        {
            // 对于每个属性，获取属性名
            String varName = field.getName();

            try {
                boolean access = field.isAccessible();
                if(!access) field.setAccessible(true);

                //从obj中获取field变量
                Object o = field.get(obj);
                System.out.println(varName + " : " + o);

                if(!access) field.setAccessible(false);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }




}
