package com.yuanlrc.base.service.admin;

import com.yuanlrc.base.bean.PageBean;
import com.yuanlrc.base.dao.housingEstate.HousingEstateDao;
import com.yuanlrc.base.entity.admin.User;
import com.yuanlrc.base.entity.admin.UserRoleTypeEnum;
import com.yuanlrc.base.entity.housingEstate.HousingEstate;
import com.yuanlrc.base.entity.rentHouse.RentHouse;
import com.yuanlrc.base.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * 小区业务处理层
 * @author wangzihan
 * @date : 2021/1/7 13:42
 */
@Service
public class HousingEstateService {

    @Autowired
    private HousingEstateDao housingEstateDao;

    /**
     * 根据小区id查询
     * @param id
     * @return
     */
    public HousingEstate find(Long id){
        return housingEstateDao.find(id);
    }

    /**
     * 按照小区名查找小区
     * @param name
     * @return
     */
    public HousingEstate findByName(String name){
        return housingEstateDao.findByName(name);
    }
    /**
     * 查询所有
     */
    public List<HousingEstate> findAll(){
        return housingEstateDao.findAll();
    }

    /**
     * 通过所在小区模糊搜索
     * @param district
     * @return
     */
    public List<HousingEstate> findByDistrictLike(String district){
        return housingEstateDao.findByDistrictLike("%"+district+"%");
    }

    /**
     * 小区添加/编辑操作
     * @param housingEstate
     * @return
     */
    public HousingEstate save(HousingEstate housingEstate){
        return housingEstateDao.save(housingEstate);
    }

    /**
     * 分页查询小区列表
     * @param housingEstate
     * @param pageBean
     * @return
     */
    public PageBean<HousingEstate> findList(HousingEstate housingEstate, PageBean<HousingEstate> pageBean) {

        Specification<HousingEstate> specification = new Specification<HousingEstate>() {
            @Override
            public Predicate toPredicate(Root<HousingEstate> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                User user = SessionUtil.getLoginedUser();
                List<Predicate> predicates  = new ArrayList<>();
                if (user.getUserType().getCode() != 0){
                    Predicate predicate = criteriaBuilder.equal(root.get("user"), user);
                    predicates.add(predicate);
                }
                if (housingEstate.getName() != null){
                    Predicate predicate1 = criteriaBuilder.like(root.get("name"), "%" + housingEstate.getName() + "%");
                    predicates.add(predicate1);
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        Pageable pageable = PageRequest.of(pageBean.getCurrentPage() - 1, pageBean.getPageSize());
        Page<HousingEstate> findAll = housingEstateDao.findAll(specification,pageable);
        pageBean.setContent(findAll.getContent());
        pageBean.setTotal(findAll.getTotalElements());
        pageBean.setTotalPage(findAll.getTotalPages());
        return pageBean;
    }


    /**
     * 判断小区名是否存在，添加和编辑均可判断
     * @param name
     * @param id
     * @return
     */
    public boolean isExistName(String name,Long id){
        HousingEstate housingEstate = housingEstateDao.findByName(name);
        if(housingEstate != null){
            //表示小区名存在，接下来判断是否是编辑小区的本身
            if(housingEstate.getId().longValue() != id.longValue()){
                return true;
            }
        }
        return false;
    }

    /**
     * 按照小区id删除
     * @param id
     */
    public void delete(Long id){
        housingEstateDao.deleteById(id);
    }

    /**
     * 返回小区总数
     * @return
     */
    public long total(){
        return housingEstateDao.count();
    }


    
}
