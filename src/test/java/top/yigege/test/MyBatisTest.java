package top.yigege.test;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import junit.framework.TestCase;
import top.yigege.dao.WorksDao;
import top.yigege.domain.Works;
import top.yigege.util.MyBatisUtil;

public class MyBatisTest extends TestCase {
		
	@Test
	public void testWorksInsert() {
		SqlSession session = MyBatisUtil.getSqlSession(true);
		WorksDao dao = session.getMapper(WorksDao.class);

		Works works = new Works();
		works.setName("优秀的我");
		works.setTime(new Date());
		works.setImagepath("1527924381983pic1.jpg;1527924351929Lighthouse.jpg;1527924351933Tulips.jpg");
		works.setRemark("自己做的几张新海报");
		
		dao.saveWorks(works);
		session.close();

	}
}
