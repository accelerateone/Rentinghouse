package com.yuanlrc.base.service.admin;

import com.yuanlrc.base.entity.admin.UserRoleTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.yuanlrc.base.bean.PageBean;
import com.yuanlrc.base.dao.admin.UserDao;
import com.yuanlrc.base.entity.admin.User;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户管理service
 * @author Administrator
 *
 */
@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	/**
	 * 根据用户id查询
	 * @param id
	 * @return
	 */
	public User find(Long id){
		return userDao.find(id);
	}
	
	/**
	 * 按照用户名查找用户
	 * @param username
	 * @return
	 */
	public User findByUsername(String username){
		return userDao.findByUsername(username);
	}
	
	/**
	 * 用户添加/编辑操作
	 * @param user
	 * @return
	 */
	public User save(User user){
		return userDao.save(user);
	}



    /**
     * 分页查询用户列表
     * @param pageBean
     * @return
     */
	public PageBean<User> findList(PageBean<User> pageBean, String username, UserRoleTypeEnum userType) {
		Specification<User> specification = new Specification<User>() {
			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates  = new ArrayList<>();
				Predicate predicate = criteriaBuilder.equal(root.get("userType"), userType.getCode());
				predicates.add(predicate);
				if (username != null){
                    Predicate predicate1 = criteriaBuilder.like(root.get("username"), "%" + username + "%");
                    predicates.add(predicate1);
				}
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		};
		Pageable pageable = PageRequest.of(pageBean.getCurrentPage() - 1, pageBean.getPageSize());
		Page<User> findAll = userDao.findAll(specification,pageable);
		pageBean.setContent(findAll.getContent());
		pageBean.setTotal(findAll.getTotalElements());
		pageBean.setTotalPage(findAll.getTotalPages());
		return pageBean;
	}
	
	/**
	 * 判断用户名是否存在，添加和编辑均可判断
	 * @param username
	 * @param id
	 * @return
	 */
	public boolean isExistUsername(String username,Long id){
		User user = userDao.findByUsername(username);
		if(user != null){
			//表示用户名存在，接下来判断是否是编辑用户的本身
			if(user.getId().longValue() != id.longValue()){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 按照用户id删除
	 * @param id
	 */
	public void delete(Long id){
		userDao.deleteById(id);
	}

	/**
	 * 根据用户类型查询
	 * @param userRoleTypeEnum
	 * @return
	 */
	public List<User> findByUserType(UserRoleTypeEnum userRoleTypeEnum){
		return userDao.findByUserType(userRoleTypeEnum);
	}
	
	/**
	 * 返回用户总数
	 * @return
	 */
	public long total(){
		return userDao.count();
	}

	/**
	 * 返回经纪人总数
	 * @return
	 */
	public int countByAgent(){
		return userDao.countByUserType(UserRoleTypeEnum.AGENT);
	}

	/**
	 * 返回顾问总数
	 * @return
	 */
	public int countByConsultant(){
		return userDao.countByUserType(UserRoleTypeEnum.CONSULTANT);
	}

}
