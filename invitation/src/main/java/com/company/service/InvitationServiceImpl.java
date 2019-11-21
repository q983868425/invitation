package com.company.service;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.dao.InvitationDao;
import com.company.pojo.Invitation;
import com.company.util.PageUtil;

/**
 * @author 张延龙
 * @category 帖子业务逻辑实现类
 */
@Service
public class InvitationServiceImpl implements InvitationService {
	@Autowired
	private InvitationDao invitationDao;

	@Override
	public Invitation selectById(int id) {
		return invitationDao.selectById(id);
	}
	
	@Override
	public List<Invitation> selectAll(PageUtil pageUtil) {
		Integer page = PageUtil.getParmPage(pageUtil.getPage(), pageUtil.getPagesize());
		return invitationDao.selectAll(page, pageUtil.getPagesize());
	}

	@Override
	public void add(Invitation invitation) {
		invitation.setCreatedate(new Date(System.currentTimeMillis()));
		invitationDao.add(invitation);
	}

	@Override
	public void deleteById(int[] idArr) {
		invitationDao.deleteById(idArr);
	}

	@Override
	public void update(Invitation invitation) {
		invitationDao.update(invitation);
	}

	@Override
	public int selectcount() {
		return invitationDao.selectcount();
	}

}
