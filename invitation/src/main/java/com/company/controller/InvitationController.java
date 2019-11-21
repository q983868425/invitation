package com.company.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.pojo.Invitation;
import com.company.service.InvitationService;
import com.company.util.PageUtil;

@Controller
public class InvitationController {

	private Logger log = Logger.getLogger(InvitationController.class);

	@Resource
	private InvitationService invitationService;

	/**
	 * @param model
	 * @category 查询所有控制器
	 */
	@RequestMapping("/list")
	public String showAll(PageUtil pageUtil, Model model) {
		System.out.println("jinru");
		//第一次访问页码为空则设置为1
		if (pageUtil.getPage() == null) {
			pageUtil.setPage(1);
		}
		//设置每页显示数据量
		Integer pagesize = 5;
		pageUtil.setPagesize(pagesize);
		//查询当前页码的数据
		List<Invitation> list = invitationService.selectAll(pageUtil);
		// 获得数据总行数
		Integer count = invitationService.selectcount();
		// 调用工具类的方法得到总页数
		Integer totalpage = PageUtil.getTotalPage(count, pagesize);
		//将查询到的数据集合、页码以及总页数放入model
		model.addAttribute("list", list);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("page", pageUtil.getPage());
		return "list";
	}

	/**
	 * @param model
	 * @category 查看帖子详情
	 */
	@RequestMapping("/findById")
	public String showOne(@Param("id") int id, Model model) {
		System.out.println("jinrukongzhiqi ");
		Invitation invitation = invitationService.selectById(id);
		model.addAttribute("invitation", invitation);
		return "info";
	}

	@RequestMapping("/toadd")
	public String toadd() {
		return "add";
	}

	@RequestMapping("/add")
	public String add(Invitation invitation) {
		invitationService.add(invitation);
		return "redirect:list.action";
	}

	@RequestMapping("/delete")
	public String deleteById(int[] ids) {
		System.out.println("da");
		log.debug(Arrays.toString(ids));
		invitationService.deleteById(ids);
		return "redirect:list.action";
	}

	@RequestMapping("/toupdate")
	public String toupdate(int id, Model model) {
		Invitation invitation = invitationService.selectById(id);
		model.addAttribute(invitation);
		return "update";
	}

	@RequestMapping("/update")
	public String update(@ModelAttribute("invitation") Invitation invitation) {
		System.out.println("aaa");
		invitationService.update(invitation);
		return "redirect:list.action";
	}

}