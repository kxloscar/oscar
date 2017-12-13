package bookstoreDao;

import java.lang.reflect.Field;
import java.sql.ResultSet;

public class BeanResultSetHandler<T> implements IResultSetHandler<T> {
	private Class<T> classType;

	public BeanResultSetHandler(Class<T> classType) {
		this.classType = classType;
	}

	@Override
	public T handler(ResultSet rs) throws Exception {
		// 创建实体类型的实例
		T obj = classType.newInstance();
		// 获取该类型实例的所有属性
		Field[] fields = classType.getDeclaredFields();

		if (rs.next()) {
			for (Field f : fields) {
				// 设置可以访问私有属性
				f.setAccessible(true);
				// 获取属性名
				String columnName = f.getName();
				// 获取该记录行同名字段的数据值
				Object columnValue = rs.getObject(columnName);
				// 调用属性set方法
				f.set(obj, columnValue);
			}
		}
		return obj;
	}

}
