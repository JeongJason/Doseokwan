package Tests.DaoTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

//import java.util.Date;
import java.sql.Date;

import org.junit.jupiter.api.Test;

import Domain.Common.Dao.BoardDao;
import Domain.Common.Dto.BoardDto;

class DaoTests {

//	@Test
//	void BoardDaoTest1() {
//		BoardDao dao = BoardDao.getInstance();
//		assertNotNull(dao);
//	}
	/*@Test
	void BoardDaoTest2()throws Exception {
		BoardDao dao = new BoardDao();
		assertNotNull(dao);
		int result=dao.insert(new BoardDto(1,"김민수","짱나","이준호욜라짱나",null,null,null));
		assertEquals(1,result);
	}*/
//	@Test
//	void BoardDaoTest3() throws Exception {
//		java.util.Date currentDate = new java.util.Date();
//		Date sqlDate = new Date(currentDate.getTime());
//		BoardDao dao = new BoardDao();
//		assertNotNull(dao);
//		int result=dao.update(new BoardDto(1,"김민수","열나","이준호열나게착하다",null,null,null));
//		assertEquals(1,result);
//		
//	}
	@Test
	void BoardDaoTest4() throws Exception{
		BoardDao dao = new BoardDao();
		assertNotNull(dao);
		int result=dao.delete(1);
		assertEquals(1,result);
		
	}

}
