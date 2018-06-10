package top.yigege.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import top.yigege.dao.WorksDao;
import top.yigege.domain.Works;

@Service("worksService")
public class WorksService {
	@Resource
	private WorksDao worksDao;
	public void setWorksDao(WorksDao worksDao) {
		this.worksDao = worksDao;
	}
	
	/**
	 * 添加作品
	 * @param works
	 */
	
	public void addWorks(Works works) {
		worksDao.saveWorks(works);
		
	}

	
	
	/**
	 * 返回所有作品
	 * @return
	 */
	public List<Works> getAllWoks() {
		
		return worksDao.getAll();
	}

	
	/**
	 * 通过姓名返回所有作品
	 * @param name
	 * @return
	 */
	public List<Works> getWorksByName(String name) {
		
		return worksDao.getWorksByName(name);
	}

	public Works getWorksByWorksId(String worksId) {
		// TODO Auto-generated method stub
		
		return worksDao.getWorksById(Integer.parseInt(worksId));
	}

	public void starWorks(String worksId) {
		
		worksDao.starWorks(Integer.parseInt(worksId));
		
	}

	public List<Works> getFindWoksByRemark(String remark) {
		// TODO Auto-generated method stub
		return worksDao.getFindWorksByRemark(remark);
	}
	
}
