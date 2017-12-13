package bookstoreDao;

import java.util.List;

public class bookDAOIpml implements bookDAO {
	   
	public bookDAOIpml(){}
	public bookModel  getBook(String id) {
	
		String sql = "select * from bookstore where id="+id;
		return JdbcTemplate.select(sql, new BeanResultSetHandler<>(bookModel.class));
	}
	@Override
	public void addbook(bookModel book) {
		String sql = "insert into bookstore(id,title,writer,discount,price,amount,synopsis,type) values(?,?,?,?,?,?,?,?)";
		Object[] params = {null,book.getTitle(), book.getWriter(), book.getDiscount(), book.getPrice(), book.getAmount(), book.getSynopsis(),book.getType()};
		
		try {
			JdbcTemplate.update(sql, params);
		} catch(Exception e) {
			
		}

	}

	@Override
	public List<bookModel> getAllbooks() {
		String sql = "select * from bookstore";
		return JdbcTemplate.select(sql, new BeansResultSetHandler<>(bookModel.class));
	}

}
