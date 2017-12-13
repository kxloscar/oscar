package bookstoreDao;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BeansResultSetHandler<T> implements IResultSetHandler<List<T>> {
	
private Class<T> classType;
	
	public BeansResultSetHandler(Class<T> classType) {
		this.classType = classType;
	}
	

	@Override
	public List<T> handler(ResultSet rs) throws Exception {
		List<T> lists = new ArrayList<>();
		while(rs.next()) {
			//创建该类型的实例
			T obj = classType.newInstance();
			//获取该类的所有的属性
			Field[] fields = classType.getDeclaredFields();
			for(Field f : fields) {
				//设置可以访问私有属性
				f.setAccessible(true);
				//获取属性的名字
				String columnName = f.getName();
				//根据属性名获取该行记录中同名字段的数据值
				Object columnValue = rs.getObject(columnName);
				//调用属性的set方法
				f.set(obj, columnValue);
			}
			
			lists.add(obj);
		}
		return lists;
	}
	}


