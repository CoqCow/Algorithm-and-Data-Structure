package com.niu.annotation;

/**
 * Created by Lenovo on 2018/3/27.
 */
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList arrayList=new ArrayList();
        User user1 = new User();
        user1.setId(0001);//查询ID为0001的用户
        user1.setNickname("繁华");//查询昵称为繁华的用户

        User user2 = new User();
        user2.setUsername("Jack");//查询用户名为Jack的用户
        user2.setAge(18);//查询年龄为18的用户

        User user3 = new User();
        user3.setEmail("lian@sina.com,jiang@qq.com");//查询邮箱为其中任意一个的用户

        String sql1 = query(user1);
        String sql2 = query(user2);
        String sql3 = query(user3);

        System.out.println(sql1);
        System.out.println(sql2);
        System.out.println(sql3);
    }

    private static String query(User user){
        StringBuilder sb = new StringBuilder();
        //1.获取到Class
        Class< ?> class1 = user.getClass();
        //2.获取到table的名字
        boolean flag1 = class1.isAnnotationPresent(Table.class);
        if(!flag1){
            return null;
        }
        Table table = (Table)class1.getAnnotation(Table.class);
        String tableName = table.value();
        sb.append("select * from ").append(tableName).append(" where 1=1");
        //3.遍历所有的字段
        Field[] fields = class1.getDeclaredFields();
        for (Field field : fields) {
            //4.处理每个字段对应的sql
            //拿到字段名
            boolean flag2 = field.isAnnotationPresent(Column.class);
            if (!flag2) {
                continue;
            }
            Column column = field.getAnnotation(Column.class);
            String columnName = column.value();

            //拿到字段值
            String fieldName = field.getName();
            String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            Object fieldValue = null;
            try {
                Method getMethod = class1.getMethod(getMethodName);
                fieldValue = getMethod.invoke(user);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //拼装sql
            if(fieldValue == null || (fieldValue instanceof Integer && (Integer)fieldValue == 0)){
                continue;
            }
            sb.append(" and ").append(columnName);
            if(fieldValue instanceof String){
                if(((String)fieldValue).contains(",")){
                    String[] values = ((String)fieldValue).split(",");
                    sb.append(" in(");
                    for (String value : values) {
                        sb.append("'").append(value).append("'").append(",");
                    }
                    sb.deleteCharAt(sb.length()-1);
                    sb.append(")");
                }else {
                    sb.append(" = ").append("'").append(fieldValue).append("'");
                }
            }else if(fieldValue instanceof Integer) {
                sb.append(" = ").append(fieldValue);
            }

        }
        return sb.toString();
    }

}
