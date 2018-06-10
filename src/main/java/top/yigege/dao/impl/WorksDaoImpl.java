package top.yigege.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import top.yigege.dao.WorksDao;
import top.yigege.domain.Works;


/**
 * mybatis直接使用接口生成的代理类，不需要自己单独写实现类
 * @author yigege
 *
 */
public class WorksDaoImpl implements WorksDao {

	@Override
	public void saveWorks(Works works) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Works> getAll() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Works> getWorksByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Works getWorksById(Integer worksId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void starWorks(Integer parseInt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Works> getFindWorksByRemark(String remark) {
		// TODO Auto-generated method stub
		return null;
	}

}
