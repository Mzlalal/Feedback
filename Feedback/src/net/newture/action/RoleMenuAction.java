package net.newture.action;

import org.springframework.beans.factory.annotation.Autowired;

import net.newture.domain.Menu;
import net.newture.framework.ActionBase;
import net.newture.framework.util.Struts2Utils;
import net.newture.service.RoleMenuService;

public class RoleMenuAction extends ActionBase{
	private Menu menu;
	private int menuId;
	private boolean bool;
	@Autowired
	private RoleMenuService roleMenuService;

	
	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public boolean isBool() {
		return bool;
	}

	public void setBool(boolean bool) {
		this.bool = bool;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public RoleMenuService getRoleMenuService() {
		return roleMenuService;
	}

	public void setRoleMenuService(RoleMenuService roleMenuService) {
		this.roleMenuService = roleMenuService;
	}
	
	public String findAllRoleMenu(){
		roleMenuService.findAllParentMenu();
		return "list";
	}
	
	public String update(){
		System.out.println("传过来的值为："+menuId);
		int i = roleMenuService.findSonMenu(menuId);
		if(i>3){
			return "updatefour";
		}else if(i>2){
			return "updatethree";
		}else if(i>1){
			return "updatetwo";
		}else{
			return "updateone";
		}
	}
	
	public String save(){
		System.out.println("传过来进行保存的值"+menuId);
		System.out.println("传过来进行保存的值"+bool);
		System.out.println(menu);
		if(roleMenuService.saveMenu(menuId,bool)==1){
			Struts2Utils.setAttribute("msg", "操作成功，请您刷新下页面");
			return "success";
		}else{
			return "error";
		}
	}
	
}
