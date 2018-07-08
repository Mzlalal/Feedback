package net.newture.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.newture.dao.BaseDao;
import net.newture.dao.impl.BaseDaoImpl;
import net.newture.domain.TeachingBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.BaseService;

@Service
public class BaseServiceImpl implements BaseService{
	@Autowired
	private BaseDao baseDao;
	
	@Override
	public int deleteBase(Integer id) {
		TeachingBase base = baseDao.findId(id);
		if (base == null) {
			Struts2Utils.setAttribute("msg", "删除基地信息出错：找不到指定教学基地");
			return -1;
		} else {
			this.baseDao.delete(base);
			return 1;
		}
	}

	@Override
	public int updateBase(TeachingBase base) {
//		System.out.println(base);
		if(base == null){
			Struts2Utils.setAttribute("msg", "更新基地信息出错：找不到指定教学基地");
			return -1;
		} else{
			this.baseDao.update(base);
			return 1;
		}
	}

	@Override
	public void findAllBase() {
		List<TeachingBase> bases = baseDao.findAllTeachingBase();
		Struts2Utils.setAttribute("bases", bases);
	}

	@Override
	public int saveBase(TeachingBase base) {
		this.baseDao.save(base);
		return 1;
	}

}
