package bookstoreDao;

import java.sql.ResultSet;

public interface IResultSetHandler<T> {
	public T handler(ResultSet rs) throws Exception;
}
