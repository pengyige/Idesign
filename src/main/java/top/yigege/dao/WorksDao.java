package top.yigege.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import top.yigege.domain.Works;

@Repository("workDao")
public interface WorksDao {
	/**
	 * 添加作品
	 * @param works
	 */
	void saveWorks(Works works);

	List<Works> getAll();

	List<Works> getWorksByName(String name);

	Works getWorksById(Integer worksId);

	void starWorks(Integer parseInt);

	List<Works> getFindWorksByRemark(String remark);
}
