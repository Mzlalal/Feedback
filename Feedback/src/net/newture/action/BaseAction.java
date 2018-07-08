package net.newture.action;

import org.springframework.beans.factory.annotation.Autowired;

import net.newture.domain.TeachingBase;
import net.newture.framework.ActionBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.BaseService;

public class BaseAction extends ActionBase{
	private TeachingBase base;
	private Integer id;
	/** 操作类型：1新增 2修改 3删除 */
	private Integer operateType;
	
	@Autowired
	private BaseService baseService;
	
	public TeachingBase getBase() {
		return base;
	}

	public void setBase(TeachingBase base) {
		this.base = base;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BaseService getBaseService() {
		return baseService;
	}

	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}

	public Integer getOperateType() {
		return operateType;
	}

	public void setOperateType(Integer operateType) {
		this.operateType = operateType;
	}

	/**
	 * 查找所有基地
	 */
	public String findAllBase(){
		baseService.findAllBase();
		return "list";
	}
	
	/**
	 * 删除指定基地
	 */
	public String delete(){
	try {
		if (baseService.deleteBase(id)==1) {
			Struts2Utils.setAttribute("msg", "删除id为" + id + "的基地成功");
		}
	} catch (Exception e) {
		Struts2Utils.setAttribute("msg", "删除id为" + id + "	的基地失败<br/>"
				+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
		return ERROR;
	}
	return SUCCESS;
	}
	
	/**
	 * 保存基地信息
	 */
	public String save() {
		if (base.getBaseName() == null || base.getBaseName().trim().equals("")) {
			Struts2Utils.setAttribute("msg", "基地名称不能为空！");
			return ERROR;
		}
		try {
			if (baseService.saveBase(base) != 1) {
				return ERROR;
			}
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "更新基地信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage(): "")
					+ "<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			
			return ERROR;
		}
		System.out.println(base.getBaseName());
		System.out.println(base.getBaseId());
		Struts2Utils.setAttribute("msg", "更新基地信息成功！");
		return SUCCESS;
	}
	
	/**
	 * 修改基地信息
	 */
	public String update(){
		try {
			Integer id = Integer.valueOf(Struts2Utils.getParameter("base.baseId"));
			String  name = Struts2Utils.getParameter("base.baseName");
			base.setBaseId(id);
			base.setBaseName(name);
			System.out.println("修改时获取的id为："+id);
			System.out.println("修改时获取的name为："+name);
			if (baseService.updateBase(base)==1) {
				Struts2Utils.setAttribute("msg", "更新id为" + id + "的基地成功");
			}
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "更新id为" + id + "	的基地失败<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 批量删除基地信息
	 */
	public String dels() {
		try {
			// 获取 复选框选中状态
			String ids[] = Struts2Utils.getParameterValues("ids");
			for (int i = 0; i < ids.length; i++) {
				baseService.deleteBase(Integer.parseInt(ids[i]));
			}
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "批量删除基地信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage() : "")
					+ "<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("msg", "批量删除基地信息成功！");
		return SUCCESS;
	}
}
