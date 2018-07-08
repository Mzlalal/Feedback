package net.newture.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.newture.dao.ClassDao;
import net.newture.framework.DaoBase;

public class TestDaoBase {
	@Test
	@Transactional
	public void testGetClass() {
		String xmlPath = "applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		ClassDao daoBase = applicationContext.getBean("classDaoImpl", ClassDao.class);
		daoBase.findAllClass();
	}

	@Test
	@Transactional
	public void testGetSingleResult1() {
		String xmlPath = "applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		DaoBaseTester daoBase = applicationContext.getBean("daoBaseTester", DaoBaseTester.class);
		String hql = " select idcard from User where userId = 1";
		System.out.println(daoBase.getSingleResult(hql));
	}

	@Test
	@Transactional
	public void testGetSingleResult2() {
		String xmlPath = "applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		DaoBaseTester daoBase = applicationContext.getBean("daoBaseTester", DaoBaseTester.class);
		String hql = " select count(user) from User user where loginName='admin' and password='E10ADC3949BA59ABBE56E057F20F883E'";
		assertEquals(1, ((Long) daoBase.getSingleResult(hql)).intValue());
	}

	@Test
	@Transactional
	public void testGetSingleResult3() {
		String xmlPath = "applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		DaoBaseTester daoBase = applicationContext.getBean("daoBaseTester", DaoBaseTester.class);
		String hql = " select count(user) from User user where loginName=?";
		assertEquals(1, ((Long) daoBase.getSingleResult(hql, "luohl")).intValue());
	}

	@Test
	@Transactional
	public void testGetSingleResult4() {
		String xmlPath = "applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		DaoBaseTester daoBase = applicationContext.getBean("daoBaseTester", DaoBaseTester.class);
		String hql = " select count(user) from User user where loginName=? and password=?";
		assertEquals(1, ((Long) daoBase.getSingleResult(hql,
				new Object[] { "admin", "E10ADC3949BA59ABBE56E057F20F883E" })).intValue());
	}

	@Test
	@Transactional
	public void testQueryBySql1() {
		String xmlPath = "applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		DaoBaseTester daoBase = applicationContext.getBean("daoBaseTester", DaoBaseTester.class);

		StringBuffer sql = new StringBuffer();

		sql.append(" select rl.role_id, ");
		sql.append("        rl.role_name, ");
		sql.append("        mn.menu_id, ");
		sql.append("        mn.parent_menu_id, ");
		sql.append("        mnp.menu_name as parent_menu_name, ");
		sql.append("        mn.menu_name, ");
		sql.append("        mn.url, ");
		sql.append("        mn.menu_desc ");
		sql.append("   from role rl, role_menu rm, menu mn, menu mnp ");
		sql.append("  where rm.role_id = rl.role_id ");
		sql.append("    and rm.menu_id = mn.menu_id ");
		sql.append("    and mn.parent_menu_id = mnp.menu_id(+) ");
		sql.append("    and mn.valid_flag = 1 ");
		sql.append("    and rm.role_id = 1 ");
		sql.append("  order by mn.parent_menu_id, rm.disp_order ");

		List list = daoBase.queryBySql(sql.toString());
		// 循环输出结果
		for (int i = 0; i < list.size(); i++) { // 循环输出集合中的对象
			Object[] obj = (Object[]) list.get(i);// 将输出对象放入数组中
			// 循环输出数组中的元素
			for (int j = 0; j < obj.length; j++) {
				System.out.print(obj[j] + "  ");
			}
			System.out.println();
		}
	}

	@Test
	@Transactional
	public void testQueryBySql2() {
		String xmlPath = "applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		DaoBaseTester daoBase = applicationContext.getBean("daoBaseTester", DaoBaseTester.class);

		StringBuffer sql = new StringBuffer();

		sql.append(" select fs.course_id, ");
		sql.append("        cr.course_name, ");
		sql.append("        fit.fit_id, ");
		sql.append("        fit.fit_name, ");
		sql.append("        fi.fi_id, ");
		sql.append("        fi.fi_name, ");
		sql.append("        fi.item_value, ");
		sql.append("        avg(fs.score) as score ");
		sql.append("   from feedback           fb, ");
		sql.append("        feedback_score     fs, ");
		sql.append("        feedback_item      fi, ");
		sql.append("        feedback_item_type fit, ");
		sql.append("        classes            cl, ");
		sql.append("        users              tch, ");
		sql.append("        course             cr ");
		sql.append("  where fs.feedback_id = fb.feedback_id ");
		sql.append("    and fb.class_id = cl.class_id ");
		sql.append("    and fs.teacher_id = tch.user_id ");
		sql.append("    and fs.course_id = cr.course_id ");
		sql.append("    and fs.fi_id = fi.fi_id ");
		sql.append("    and fi.fit_id = fit.fit_id ");
		sql.append("    and fb.status > 0 ");
		sql.append("    and fb.school_year = ? ");
		sql.append("    and fb.semester = 1 ");
		sql.append("    and fb.times = ? ");
		sql.append("    and fit.fit_id in (?) ");
		sql.append("    and cl.class_id = ? ");
		sql.append("  group by fb.feedback_id, ");
		sql.append("           cl.class_id, ");
		sql.append("           cl.class_name, ");
		sql.append("           fb.feedback_name, ");
		sql.append("           fb.school_year, ");
		sql.append("           fb.semester, ");
		sql.append("           fb.times, ");
		sql.append("           fs.teacher_id, ");
		sql.append("           tch.name, ");
		sql.append("           fs.course_id, ");
		sql.append("           cr.course_name, ");
		sql.append("           fit.fit_id, ");
		sql.append("           fit.fit_name, ");
		sql.append("           fi.fi_id, ");
		sql.append("           fi.fi_name, ");
		sql.append("           fi.item_value, ");
		sql.append("           fi.disp_order ");
		sql.append("  order by fb.feedback_id, ");
		sql.append("           cl.class_id, ");
		sql.append("           fb.school_year, ");
		sql.append("           fb.semester, ");
		sql.append("           fb.times, ");
		sql.append("           fs.teacher_id, ");
		sql.append("           fs.course_id, ");
		sql.append("           fit.fit_id, ");
		sql.append("           fi.disp_order ");

		List<String> table_1 = new ArrayList<String>(), table_2 = new ArrayList<String>();
		List table1 = daoBase.queryBySql(sql.toString(), new Object[] { 2018, 1, 1, 1});

		int typeTableId;

		String socre, couserId;
		// 循环输出结果
		for (int i = 0; i < table1.size(); i++) { // 循环输出集合中的对象
			Object[] table = (Object[]) table1.get(i);
			// 获取报表反馈类型
			typeTableId = Integer.parseInt(table[2].toString());
			// 第1列课程名
			couserId = table[0].toString();
			// 第8列 平均分
			socre = table[7].toString();
			//		<tr class="gradeA odd">
			//            <td class="center">为人师表,关心学生,要求严格 </td>
			//              <td class="center">9.65</td>
			//
			switch (typeTableId) {
			case 1:
				if(("1").equals(couserId)) {
					table_1.add(socre);
				}

				if(("2").equals(couserId)) {
					table_2.add(socre);
				}
				break;
			}
		}
		for(String item : table_1) {
			System.out.println(item);
		}
	}
}

@Repository
class DaoBaseTester extends DaoBase {

}
