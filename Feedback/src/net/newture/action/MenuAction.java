package net.newture.action;

import org.springframework.beans.factory.annotation.Autowired;

import net.newture.domain.Menu;
import net.newture.framework.ActionBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.MenuService;

public class MenuAction extends ActionBase {
	private Menu menu;
	private Integer id;
	private String condName;
	private String condValue;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Autowired
	private MenuService menuService;

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	//新增系统菜单
	public String add(){
		return "add";
	}
	
	public String toadd(){
		// 保存菜单信息
		try {
			if (menuService.saveMenu(menu) !=1) {
				return ERROR;
			}
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "保存菜单信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage() : "")
					+ "<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("msg", "保存菜单信息成功！");
		return SUCCESS;
		
	}
	//查询所有系统菜单列表
	public String xitong(){
		try {
			menuService.findAllmenu();
		} catch (Exception e) {
			e.printStackTrace();
			Struts2Utils.setAttribute("msg", "查询菜单出错");
			return ERROR;
		}
		return "list";
	}
	//条件查询菜单
	public String found(){
		return "found";
	}
	
	public String queryByCond(){
		try {
			if (condValue == null || condValue.trim().equals("")) {
				Struts2Utils.setAttribute("msg", "必须输入查询条件值！");
				return "queryCheckError";
			}
			menu = menuService.findByCond(condName, condValue);
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg",
					"查询菜单信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage()
							: "") + "<br/>"
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return ERROR;
		}
		if (menu == null) {
			return ERROR;
		} else {
			return "found";
		}
	}
	// 删除菜单
	public String delete() {
		try {
			if (menuService.deleteMenu(id) != 1) {
				return ERROR;
			}
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "删除菜单出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage() : "")
					+ "<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("msg", "删除菜单成功！");
		return SUCCESS;
	}
	//修改菜单
	public String update(){
	try {
		if (menuService.updateMenu(menu) == 1) {
			Struts2Utils.setAttribute("msg", "修改菜单成功");
		}
	} catch (Exception e) {
		Struts2Utils.setAttribute("msg","修改菜单"
						+ (e.getCause() != null? (e.getCause().getCause() != null ? e.getCause().getCause() : ""): ""));
		return ERROR;
	}
	return SUCCESS;
	}
	
	public String toupdate(){
		return "toupdate";
	}
	
	// 批量删除
	public String batchDelete() {
		try {
			// 获取 复选框选中状态
			String ids[] = Struts2Utils.getParameterValues("ids");
			for (int i = 0; i < ids.length; i++) {
				menuService.deleteMenu(Integer.parseInt(ids[i]));
			}
		} catch (Exception e) {
			Struts2Utils.setAttribute("msg", "删除菜单信息出错：" + "<br/>" + (e.getMessage() != null ? e.getMessage() : "")
					+ "<br/>"
					+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "") : ""));
			return ERROR;
		}
		Struts2Utils.setAttribute("msg", "删除菜单信息成功！");
		return SUCCESS;
	}

	public String getCondName() {
		return condName;
	}

	public void setCondName(String condName) {
		this.condName = condName;
	}

	public String getCondValue() {
		return condValue;
	}

	public void setCondValue(String condValue) {
		this.condValue = condValue;
	}
	
}
