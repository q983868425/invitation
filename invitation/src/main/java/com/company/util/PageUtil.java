package com.company.util;

/**
 * @author Administrator
 * @category 分页工具类
 */
public class PageUtil {
	
	/**
	 * 当前页码
	 */
	private Integer page;
	/**
	 * 数据总量
	 */
	private Integer count;
	/**
	 * 总页数
	 */
	private Integer totalpage;

	/**
	 * 每页显示条数
	 */
	private Integer pagesize;

	public Integer getPagesize() {
		return pagesize;
	}

	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(Integer totalpage) {
		this.totalpage = totalpage;
	}

	public static Integer getParmPage(Integer page, Integer pagesize) {
		return (page - 1) * pagesize;
	}

	public static Integer getTotalPage(Integer count, Integer pagesize) {
		if (count % pagesize > 0) {
			return (count / pagesize) + 1;
		} else {
			return (count / pagesize);
		}
	}

}
