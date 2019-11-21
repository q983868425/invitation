package com.company.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.company.pojo.Invitation;

/**
 * @author 张延龙
 * @category 帖子业务逻辑接口
 */
public interface InvitationDao {
	/**
	 * @param id
	 * @return
	 * @category 根据ID查询帖子
	 * 
	 */
	public Invitation selectById(int id);

	/**
	 * @return
	 * @category 查询所有帖子
	 */
	public List<Invitation> selectAll(@Param("page") int page, @Param("count") int count);

	/**
	 * @return
	 * @category 查询数据总量，用来确定页数
	 */
	public int selectcount();

	/**
	 * @param invitation 添加一个帖子
	 */
	public void add(Invitation invitation);

	/**
	 * @param idArr 根据id集合删除帖子
	 */
	public void deleteById(int[] idArr);

	/**
	 * @param invitation 更新帖子
	 */
	public void update(Invitation invitation);
}
