package com.yuanlrc.base.service.admin;

import com.yuanlrc.base.bean.PageBean;
import com.yuanlrc.base.dao.admin.RentHouseDao;
import com.yuanlrc.base.entity.admin.User;
import com.yuanlrc.base.entity.admin.UserRoleTypeEnum;
import com.yuanlrc.base.entity.housingEstate.HousingEstate;
import com.yuanlrc.base.entity.rentHouse.RentHoursePriceEnum;
import com.yuanlrc.base.entity.rentHouse.RentHouse;
import com.yuanlrc.base.entity.rentHouse.RentHouseFeatures;
import com.yuanlrc.base.entity.rentHouse.RentHouseQueryVo;
import com.yuanlrc.base.util.SessionUtil;
import freemarker.ext.rhino.RhinoFunctionModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 租房业务处理层
 *
 * @author wangzihan
 * @date : 2021/1/9 16:31
 */
@Service
public class RentHouseService {

    @Autowired
    private RentHouseDao rentHouseDao;

    /**
     * 通过小区查找
     * @param housingEstateName
     * @return
     */
    public List<RentHouse> findTop4ByHousingEstate_NameAndIdNot(String housingEstateName,Long id){
        return rentHouseDao.findTop4ByHousingEstate_NameAndIdNot(housingEstateName,id);
    }


    public List<RentHouse> findTop3By (){
        return rentHouseDao.findTop3By();
    }

    /**
     * 找到本省市区的其他8条房源信息
     * @param district
     * @param city
     * @param province
     * @param id
     * @return
     */
    public List<RentHouse> findTop8ByDistrictLikeAndCityLikeAndProvinceLikeAndIdNot(String district,String city,String province,Long id){
        return rentHouseDao.findTop8ByDistrictLikeAndCityLikeAndProvinceLikeAndIdNot("%"+district+"%","%"+city+"%","%"+province+"%",id);
    }

    /**
     * 根据租房id查询
     * @param id
     * @return
     */
    public RentHouse find(Long id) {
        return rentHouseDao.find(id);
    }

    /**
     * 按照租房名查找租房
     *
     * @param name
     * @return
     */
    public RentHouse findByName(String name) {
        return rentHouseDao.findByName(name);
    }

    /**
     * 查询所有
     */
    public List<RentHouse> findAll() {
        return rentHouseDao.findAll();
    }

    /**
     * 租房添加/编辑操作
     *
     * @param rentHouse
     * @return
     */
    public RentHouse save(RentHouse rentHouse) {
        return rentHouseDao.save(rentHouse);
    }


    /**
     * 分页查询租房列表
     * @param rentHouse
     * @param pageBean
     * @param type  1是前台调用，2是后台调用
     * @return
     */
    public PageBean<RentHouse> findList(RentHouse rentHouse,PageBean<RentHouse> pageBean,Integer type) {

        Specification<RentHouse> specification = new Specification<RentHouse>() {
            @Override
            public Predicate toPredicate(Root<RentHouse> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                User user = SessionUtil.getLoginedUser();
                List<Predicate> predicates  = new ArrayList<>();
                if (type == 2){
                    if (user!= null && user.getUserType().getCode() != 0){
                        Predicate predicate = criteriaBuilder.equal(root.get("user"), user);
                        predicates.add(predicate);
                    }
                    if (rentHouse.getName() != null){
                        Predicate predicate1 = criteriaBuilder.like(root.get("name"), "%" + rentHouse.getName() + "%");
                        predicates.add(predicate1);
                    }
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        Pageable pageable = PageRequest.of(pageBean.getCurrentPage() - 1, pageBean.getPageSize());
        Page<RentHouse> findAll = rentHouseDao.findAll(specification,pageable);
        pageBean.setContent(findAll.getContent());
        pageBean.setTotal(findAll.getTotalElements());
        pageBean.setTotalPage(findAll.getTotalPages());
        return pageBean;
    }


    /**
     * 判断租房名是否存在，添加和编辑均可判断
     * @param name
     * @param id
     * @return
     */
    public boolean isExistName(String name, Long id) {
        RentHouse rentHouse = rentHouseDao.findByName(name);
        if (rentHouse != null) {
            //表示租房名存在，接下来判断是否是编辑租房的本身
            if (rentHouse.getId().longValue() != id.longValue()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 按照租房id删除
     *
     * @param id
     */
    public void delete(Long id) {
        rentHouseDao.deleteById(id);
    }

    /**
     * 返回租房总数
     *
     * @return
     */
    public long total() {
        return rentHouseDao.count();
    }

    /**
     * 多条件查询
     * @param rentHouseQueryVo
     * @param pageBean
     * @return
     */
    public PageBean<RentHouse> conditionsQuery(RentHouseQueryVo rentHouseQueryVo, PageBean<RentHouse> pageBean) {

        Specification<RentHouse> specification = new Specification<RentHouse>() {
            @Override
            public Predicate toPredicate(Root<RentHouse> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                //去重
                criteriaQuery.distinct(true);

                List<Predicate> predicateList = new ArrayList<>();
                List<Predicate> priceList = new ArrayList<>();//价格
                List<Predicate> houseTypeList = new ArrayList<>();//户型
                List<Predicate> rentHouseFeaturesList = new ArrayList<>();//特色
                List<Predicate> houseOrientationList = new ArrayList<>();//朝向
                List<Predicate> leaseTypeList = new ArrayList<>();//租期
                List<Predicate> floorTypeList = new ArrayList<>();//楼层
                List<Predicate> elevatorList = new ArrayList<>();//电梯
                List<Predicate> searchList = new ArrayList<>();//区，小区名


                //市
                if (StringUtils.isNotBlank(rentHouseQueryVo.getCity())) {
                    if (!rentHouseQueryVo.getCity().equals("请选择市")) {
                        predicateList.add(criteriaBuilder.like(root.get("city"), "%"+rentHouseQueryVo.getCity()+"%"));
                    }
                }

                //租房方式
                if (rentHouseQueryVo.getRentHouseWay()!= null && rentHouseQueryVo.getRentHouseWay() != -1 ) {
                    predicateList.add(criteriaBuilder.equal(root.get("rentHouseWay"), rentHouseQueryVo.getRentHouseWay()));
                }

                //租金
                if (!rentHouseQueryVo.getPriceList().isEmpty()) {
                    for (Integer integer : rentHouseQueryVo.getPriceList()) {
                        if (integer != null) {
                            if (RentHoursePriceEnum.LESSONE.getCode() == integer) {
                                priceList.add(criteriaBuilder.lt(root.get("price"), 1000));
                            } else if (RentHoursePriceEnum.ONETOONEFIVE.getCode() == integer) {
                                priceList.add(criteriaBuilder.between(root.get("price"), 1000, 1500));
                            } else if (RentHoursePriceEnum.ONEFIVETOTWO.getCode() == integer) {
                                priceList.add(criteriaBuilder.between(root.get("price"), 1500, 2000));
                            } else if (RentHoursePriceEnum.TWOTOTHREE.getCode() == integer) {
                                priceList.add(criteriaBuilder.between(root.get("price"), 2000, 3000));
                            } else if (RentHoursePriceEnum.THREETOFIVE.getCode() == integer) {
                                priceList.add(criteriaBuilder.between(root.get("price"), 3000, 5000));
                            } else if (RentHoursePriceEnum.FIVETOEIGHT.getCode() == integer) {
                                priceList.add(criteriaBuilder.between(root.get("price"), 5000, 8000));
                            } else if (RentHoursePriceEnum.EIGHTABOVE.getCode() == integer) {
                                priceList.add(criteriaBuilder.gt(root.get("price"), 8000));
                            }
                        }
                    }
                }

                //户型
                if (!rentHouseQueryVo.getHouseTypeList().isEmpty()) {
                    for (Integer integer : rentHouseQueryVo.getHouseTypeList()) {
                        if (integer != null) {
                            houseTypeList.add(criteriaBuilder.equal(root.get("houseType"), integer));
                        }
                    }
                }

                //房屋朝向
                if (!rentHouseQueryVo.getHouseOrientationList().isEmpty()) {
                    for (Integer integer : rentHouseQueryVo.getHouseOrientationList()) {
                        if (integer != null) {
                            houseOrientationList.add(criteriaBuilder.equal(root.get("houseOrientation"), integer));
                        }
                    }
                }

                //特色
                ListJoin<RentHouse, RentHouseFeatures> join = root.join(root.getModel().
                        getList("rentHouseFeaturesList", RentHouseFeatures.class), JoinType.LEFT);
                if (!rentHouseQueryVo.getRentHouseFeaturesList().isEmpty()) {
                    for (Integer integer : rentHouseQueryVo.getRentHouseFeaturesList()) {
                        if (integer != null) {
                            rentHouseFeaturesList.add(criteriaBuilder.equal(join.get("id"), integer));
                        }
                    }
                }

                //租期
                if (!rentHouseQueryVo.getLeaseTypeList().isEmpty()) {
                    for (Integer integer : rentHouseQueryVo.getLeaseTypeList()) {
                        if (integer != null) {
                            leaseTypeList.add(criteriaBuilder.equal(root.get("leaseType"), integer));
                        }
                    }
                }

                //楼层
                if (!rentHouseQueryVo.getFloorTypeList().isEmpty()) {
                    for (Integer integer : rentHouseQueryVo.getFloorTypeList()) {
                        if (integer != null) {
                            floorTypeList.add(criteriaBuilder.equal(root.get("floorType"), integer));
                        }
                    }
                }

                //电梯
                if (!rentHouseQueryVo.getElevatorList().isEmpty()) {
                    for (Integer integer : rentHouseQueryVo.getElevatorList()) {
                        if (integer != null) {
                            elevatorList.add(criteriaBuilder.equal(root.get("elevator"), integer));
                        }
                    }
                }

                //根据区或镇搜索
                Join<HousingEstate, RentHouse> join1 = root.join("housingEstate", JoinType.LEFT);
                if (StringUtils.isNotBlank(rentHouseQueryVo.getSearch())){
                    searchList.add(criteriaBuilder.like(join1.get("name"), "%"+rentHouseQueryVo.getSearch()+"%"));
                    searchList.add(criteriaBuilder.like(root.get("town"), "%"+rentHouseQueryVo.getSearch()+"%"));
                }

                //拼接条件
                Predicate and = criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));

                Predicate searchOr = criteriaBuilder.or(searchList.toArray(new Predicate[searchList.size()]));
                if (!searchOr.getExpressions().isEmpty()) {
                    and = criteriaBuilder.and(and, searchOr);
                }
                //特色
                Predicate rentHouseFeaturesOr = criteriaBuilder.or(rentHouseFeaturesList.toArray(new Predicate[rentHouseFeaturesList.size()]));
                if (!rentHouseFeaturesOr.getExpressions().isEmpty()) {
                    and = criteriaBuilder.and(and, rentHouseFeaturesOr);
                }
                //价格
                Predicate priceOr = criteriaBuilder.or(priceList.toArray(new Predicate[priceList.size()]));
                if (!priceOr.getExpressions().isEmpty()) {
                    and = criteriaBuilder.and(and, priceOr);
                }
                //户型
                Predicate houseTypeOr = criteriaBuilder.or(houseTypeList.toArray(new Predicate[houseTypeList.size()]));
                if (!houseTypeOr.getExpressions().isEmpty()) {
                    and = criteriaBuilder.and(and, houseTypeOr);
                }
                //朝向
                Predicate houseOrientationOr = criteriaBuilder.or(houseOrientationList.toArray(new Predicate[houseOrientationList.size()]));
                if (!houseOrientationOr.getExpressions().isEmpty()) {
                    and = criteriaBuilder.and(and, houseOrientationOr);
                }
                //租期
                Predicate leaseTypeOr = criteriaBuilder.or(leaseTypeList.toArray(new Predicate[leaseTypeList.size()]));
                if (!leaseTypeOr.getExpressions().isEmpty()) {
                    and = criteriaBuilder.and(and, leaseTypeOr);
                }
                //楼层
                Predicate floorTypeOr = criteriaBuilder.or(floorTypeList.toArray(new Predicate[floorTypeList.size()]));
                if (!floorTypeOr.getExpressions().isEmpty()) {
                    and = criteriaBuilder.and(and, floorTypeOr);
                }
                //电梯
                Predicate elevatorOr = criteriaBuilder.or(elevatorList.toArray(new Predicate[elevatorList.size()]));
                if (!elevatorOr.getExpressions().isEmpty()) {
                    and = criteriaBuilder.and(and, elevatorOr);
                }
                //按照最新上架排序
                if (!"-1".equals(rentHouseQueryVo.getNewReleases()) && StringUtils.isNotBlank(rentHouseQueryVo.getNewReleases())) {
                    criteriaQuery.orderBy(criteriaBuilder.desc(root.get("createTime")));
                }
                //按照价格排序
                if (!"-1".equals(rentHouseQueryVo.getPriceSort()) && StringUtils.isNotBlank(rentHouseQueryVo.getPriceSort())) {
                    if (rentHouseQueryVo.getPriceSort().equals("0")) {
                        criteriaQuery.orderBy(criteriaBuilder.desc(root.get("price")));
                    } else if (rentHouseQueryVo.getPriceSort().equals("1")) {
                        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("price")));
                    }
                }
                //按照面积排序
                if (!"-1".equals(rentHouseQueryVo.getAreaSort()) && StringUtils.isNotBlank(rentHouseQueryVo.getAreaSort())) {
                    if (rentHouseQueryVo.getAreaSort().equals("0")) {
                        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("area")));
                    } else if (rentHouseQueryVo.getAreaSort().equals("1")) {
                        criteriaQuery.orderBy(criteriaBuilder.desc(root.get("area")));
                    }
                }
                return and;
            }
        };
        Pageable pageable = PageRequest.of(pageBean.getCurrentPage() - 1, pageBean.getPageSize());
        Page<RentHouse> findAll = rentHouseDao.findAll(specification, pageable);
        pageBean.setContent(findAll.getContent());
        pageBean.setTotal(findAll.getTotalElements());
        pageBean.setTotalPage(findAll.getTotalPages());
        return pageBean;
    }


}
