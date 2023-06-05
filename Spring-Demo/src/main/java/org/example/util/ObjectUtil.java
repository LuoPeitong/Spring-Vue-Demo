package org.example.util;


import org.example.vo.Result;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ObjectUtil {
    private static Map<Class<?>, Map<String, Field>> fieldCache = new HashMap<>();

    public static Result haveEmpty(Object object) {
        // 获取对象的 Class 属性
        Class<?> objectClass = object.getClass();

        Map<String, Field> classFieldCache = fieldCache.get(objectClass);

        // 如果缓存中不存在该类的字段信息，则进行反射获取并缓存起来
        if (classFieldCache == null) {
            classFieldCache = new HashMap<>();
            Field[] fields = objectClass.getDeclaredFields();
            for (Field field : fields) {
                // 设置属性可访问，即使是私有属性
                field.setAccessible(true);
                classFieldCache.put(field.getName(), field);
            }
            fieldCache.put(objectClass, classFieldCache);
        }

        // 遍历属性
        for(Field field : classFieldCache.values()) {
            String fieldName = field.getName();
            Class<?> fieldType = field.getType();

            try{
                Object fieldValue = field.get(object);
                /* 判空操作
                 * 使用 StringUtils 工具类或自定义的静态方法，避免直接调用 isEmpty() 方法，可以提高性能。
                 */
                if (String.class.equals(fieldType) && StringUtils.isEmpty(fieldValue)){
                    return Result.error(201,"字段：" + fieldName + "为空。");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return Result.ok("验证完毕，无空字符串");
    }
}
