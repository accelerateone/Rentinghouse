package com.yuanlrc.base.service.houseInfo;

import com.yuanlrc.base.bean.PageBean;
import com.yuanlrc.base.dao.houseInfo.HouseInfoDao;
import com.yuanlrc.base.entity.houseInfo.HouseInfo;
import com.yuanlrc.base.entity.houseInfo.HouseInfoSort;
import com.yuanlrc.base.entity.houseInfo.HouseInfoVo;
import com.yuanlrc.base.entity.houseInfo.HouseLabel;
import com.yuanlrc.base.entity.houseInfoEnum.HouseAgeEnum;
import com.yuanlrc.base.entity.houseInfoEnum.HouseAreaEnum;
import com.yuanlrc.base.entity.houseInfoEnum.HouseFloorEnum;
import com.yuanlrc.base.entity.houseInfoEnum.PriceEnum;
import com.yuanlrc.base.entity.housingEstate.HousingEstate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class HouseInfoService {
    @Autowired
    private HouseInfoDao houseInfoDao;
    /**
     * 添加/编辑
     */
    public HouseInfo save(HouseInfo houseInfo){
        return houseInfoDao.save(houseInfo);
    }

    /**
     * 根据区查找
     * @param district
     * @param id
     * @return
     */
    public List<HouseInfo> findTop8ByDistrictLikeAndIdNot(String district,Long id){
        return houseInfoDao.findTop8ByDistrictLikeAndIdNot("%"+district+"%",id);
    }

    /**
     * 删除
     */
    public void delete(Long id){
        houseInfoDao.deleteById(id);
    }
    /**
     * 通过id查找
     */
    public HouseInfo find(Long id){
        return houseInfoDao.find(id);
    }
    /**
     * 通过小区id查询
     */
    public List<HouseInfo> findByHousingEstateId(Long id){
        return houseInfoDao.findByHousingEstateId(id);
    }
    /**
     * 查询所有
     */
    public List<HouseInfo> findAll(){
        return houseInfoDao.findAll();
    }

    /**
     *  普通分页查询
     */
    public PageBean<HouseInfo> findList(HouseInfo houseInfo, PageBean<HouseInfo> pageBean){
        Pageable pageable = PageRequest.of(pageBean.getCurrentPage()-1, pageBean.getPageSize());
        Page<HouseInfo> findAll = houseInfoDao.findAll(pageable);
        pageBean.setContent(findAll.getContent());
        pageBean.setTotal(findAll.getTotalElements());
        pageBean.setTotalPage(findAll.getTotalPages());
        return pageBean;
    }


    /**
     * 后台分页查询
     */
    public PageBean<HouseInfo> findListByName(PageBean<HouseInfo> pageBean, String name) {
        Specification<HouseInfo> specification = new Specification<HouseInfo>() {
            @Override
            public Predicate toPredicate(Root<HouseInfo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates  = new ArrayList<>();

                if (name != null){
                    Predicate predicate1 = criteriaBuilder.like(root.get("housingEstate").get("name"), "%" + name+ "%");
                    predicates.add(predicate1);
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        Pageable pageable = PageRequest.of(pageBean.getCurrentPage() - 1, pageBean.getPageSize());
        Page<HouseInfo> findAll = houseInfoDao.findAll(specification,pageable);
        pageBean.setContent(findAll.getContent());
        pageBean.setTotal(findAll.getTotalElements());
        pageBean.setTotalPage(findAll.getTotalPages());
        return pageBean;
    }

    /**
     * 查询前三条
     */
    public List<HouseInfo> findTop3By(){
        return houseInfoDao.findTop3By();
    }


    /**
     * 多条件复杂查询/分页/排序
     */
    public PageBean<HouseInfo> findListByTerm(HouseInfoVo houseInfoVo,PageBean<HouseInfo> pageBean){
        Specification<HouseInfo> specification = new Specification<HouseInfo>() {
            @Override
            public Predicate toPredicate(Root<HouseInfo> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                query.distinct(true);
                //省市区
                List<Predicate> predicateList = new ArrayList<>();
                List<Predicate> housePriceList = new ArrayList<>();//售价
                List<Predicate> houseTypeList = new ArrayList<>();//房型
                List<Predicate> houseAreaList = new ArrayList<>();//面积
                List<Predicate> houseOrientationList = new ArrayList<>();//朝向
                List<Predicate> houseFloorList = new ArrayList<>();//楼层
                List<Predicate> houseAgeList = new ArrayList<>();//楼龄
                List<Predicate> houseRenovationList = new ArrayList<>();//装修
                List<Predicate> housePurposeList = new ArrayList<>();//用途
                List<Predicate> houseElevatorList = new ArrayList<>();//电梯
                List<Predicate> houseOwnershipList = new ArrayList<>();//权属
                List<Predicate> houseArchitectureTypeList = new ArrayList<>();//建筑类型
                List<Predicate> houseLabelList = new ArrayList<>(); //房屋标签
                List<Predicate> searchList = new ArrayList<>();//区，小区名

                //根据区或镇搜索
                Join<HousingEstate, HouseInfo> join1 = root.join("housingEstate", JoinType.LEFT);
                if (StringUtils.isNotBlank(houseInfoVo.getSearch())){
                    searchList.add(criteriaBuilder.like(join1.get("name"), "%"+houseInfoVo.getSearch()+"%"));
                    searchList.add(criteriaBuilder.like(root.get("district"), "%"+houseInfoVo.getSearch()+"%"));
                }


                //市
                if(StringUtils.isNotBlank(houseInfoVo.getCity())){
                    if (!houseInfoVo.getCity().equals("选择城市")){
                        predicateList.add(criteriaBuilder.like(root.get("city"),"%"+houseInfoVo.getCity()+"%"));
                    }
                }
                //出售情况
                if (houseInfoVo.getHouseSales()!=null){
                    predicateList.add(criteriaBuilder.equal(root.get("houseSales"),houseInfoVo.getHouseSales()));
                }
                //售价
                if (!houseInfoVo.getHousePrice().isEmpty()){
                    for (Integer integer : houseInfoVo.getHousePrice()) {
                        if (integer!=null){
                            if (PriceEnum.TWOUP.getCode().intValue() == integer.intValue()){
                                housePriceList.add(criteriaBuilder.lt(root.get("specificPrice"),200));
                            }else if (PriceEnum.TWOTOTHREE.getCode().intValue() == integer.intValue()){
                                housePriceList.add(criteriaBuilder.between(root.get("specificPrice"),200,300));
                            } else if (PriceEnum.THREETOFOUR.getCode().intValue() == integer.intValue()){
                                housePriceList.add(criteriaBuilder.between(root.get("specificPrice"),300,400));
                            } else if (PriceEnum.FOURTOFIVE.getCode().intValue() == integer.intValue()){
                                housePriceList.add(criteriaBuilder.between(root.get("specificPrice"),400,500));
                            } else if (PriceEnum.FIVETOEIGTH.getCode().intValue() == integer.intValue()){
                                housePriceList.add(criteriaBuilder.between(root.get("specificPrice"),500,800));
                            } else if (PriceEnum.EIGHTTOTEN.getCode().intValue() == integer.intValue()){
                                housePriceList.add(criteriaBuilder.between(root.get("specificPrice"),800,1000));
                            }
                        }
                    }
                }
                //房型
                if (!houseInfoVo.getHouseType().isEmpty()){
                    for (Integer integer : houseInfoVo.getHouseType()) {
                        if (integer != null){
                            houseTypeList.add(criteriaBuilder.equal(root.get("houseType"),integer));
                        }
                    }
                }
                //面积
                if (!houseInfoVo.getHouseArea().isEmpty()){
                    for (Integer integer : houseInfoVo.getHouseArea()) {
                        if (integer!=null){
                            if (HouseAreaEnum.UNDERFIFTY.getCode().intValue()==integer.intValue()){
                                houseAreaList.add(criteriaBuilder.lt(root.get("area"),50.0));
                            }else if(HouseAreaEnum.FIFTYTOSEVENTY.getCode().intValue()==integer.intValue()){
                                houseAreaList.add(criteriaBuilder.between(root.get("area"),50.0,70.0));
                            }else if(HouseAreaEnum.SEVENTYTONINETY.getCode().intValue()==integer.intValue()){
                                houseAreaList.add(criteriaBuilder.between(root.get("area"),70.0,90.0));
                            }else if(HouseAreaEnum.NINETYTOONEHUNDREDONE.getCode().intValue()==integer.intValue()){
                                houseAreaList.add(criteriaBuilder.between(root.get("area"),90.0,110.0));
                            }else if(HouseAreaEnum.ONEHUNDREDONETOONEHUNDREDTHREE.getCode().intValue()==integer.intValue()){
                                houseAreaList.add(criteriaBuilder.between(root.get("area"),110.0,130.0));
                            }else if(HouseAreaEnum.ONEHUNDREDTHREETOONEHUNDREDFIVE.getCode().intValue()==integer.intValue()){
                                houseAreaList.add(criteriaBuilder.between(root.get("area"),130.0,150.0));
                            }
                        }
                    }
                }
                //朝向
                if (!houseInfoVo.getHouseOrientation().isEmpty()){
                    for (Integer integer : houseInfoVo.getHouseOrientation()) {
                        if (integer!=null){
                            houseOrientationList.add(criteriaBuilder.equal(root.get("houseOrientation"),integer));
                        }
                    }
                }
                //楼层
                if (!houseInfoVo.getHouseFloor().isEmpty()){
                    for (Integer integer : houseInfoVo.getHouseFloor()) {
                        if (integer!=null){
                            if (HouseFloorEnum.LOW.getCode().intValue()==integer.intValue()){
                                houseFloorList.add(criteriaBuilder.lt(root.get("floor"),10));
                            }else if (HouseFloorEnum.MIDDLE.getCode().intValue()==integer.intValue()){
                                houseFloorList.add(criteriaBuilder.between(root.get("floor"),10,20));
                            }else if (HouseFloorEnum.HIGH.getCode().intValue()==integer.intValue()){
                                houseFloorList.add(criteriaBuilder.gt(root.get("floor"),20));
                            }
                        }
                    }
                }
                //楼龄
                if (!houseInfoVo.getHouseAge().isEmpty()){
                    for (Integer integer : houseInfoVo.getHouseAge()) {
                        if (integer!=null){
                            if (HouseAgeEnum.FIVEYEAR.getCode().intValue()==integer.intValue()){
                                houseAgeList.add(criteriaBuilder.lt(root.get("buildingAge"),5));
                            }else if (HouseAgeEnum.TENYEAR.getCode().intValue()==integer.intValue()){
                                houseAgeList.add(criteriaBuilder.lt(root.get("buildingAge"),10));
                            }else if (HouseAgeEnum.FIFTEENTYEAR.getCode().intValue()==integer.intValue()){
                                houseAgeList.add(criteriaBuilder.lt(root.get("buildingAge"),15));
                            }else if (HouseAgeEnum.TWENTYYEARIN.getCode().intValue()==integer.intValue()){
                                houseAgeList.add(criteriaBuilder.lt(root.get("buildingAge"),20));
                            }else if (HouseAgeEnum.TWENTYYEARUP.getCode().intValue()==integer.intValue()){
                                houseAgeList.add(criteriaBuilder.gt(root.get("buildingAge"),20));
                            }
                        }
                    }
                }
                //装修
                if (!houseInfoVo.getHouseRenovation().isEmpty()){
                    for (Integer integer : houseInfoVo.getHouseRenovation()) {
                        if (integer!=null){
                            houseRenovationList.add(criteriaBuilder.equal(root.get("houseRenovation"),integer));
                        }
                    }
                }
                //用途
                if (!houseInfoVo.getHousePurpose().isEmpty()){
                    for (Integer integer : houseInfoVo.getHousePurpose()) {
                        if (integer!=null){
                            housePurposeList.add(criteriaBuilder.equal(root.get("housePurpose"),integer));
                        }
                    }
                }
                //电梯
                if (!houseInfoVo.getHouseElevator().isEmpty()){
                    for (Integer integer : houseInfoVo.getHouseElevator()) {
                        if (integer!=null){
                            houseElevatorList.add(criteriaBuilder.equal(root.get("houseElevator"),integer));
                        }
                    }
                }
                //权属
                if (!houseInfoVo.getHouseOwnership().isEmpty()){
                    for (Integer integer : houseInfoVo.getHouseOwnership()) {
                        if (integer!=null){
                            houseOwnershipList.add(criteriaBuilder.equal(root.get("houseOwnership"),integer));
                        }
                    }
                }
                //建筑类型
                if (!houseInfoVo.getHouseArchitectureType().isEmpty()){
                    for (Integer integer : houseInfoVo.getHouseArchitectureType()) {
                        if (integer!=null){
                            houseArchitectureTypeList.add(criteriaBuilder.equal(root.get("houseArchitectureType"),integer));
                        }
                    }
                }
                Predicate and = criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));

                Predicate searchOr = criteriaBuilder.or(searchList.toArray(new Predicate[searchList.size()]));
                if (!searchOr.getExpressions().isEmpty()) {
                    and = criteriaBuilder.and(and, searchOr);
                }

                //售价
                Predicate housePriceOr = criteriaBuilder.or(housePriceList.toArray(new Predicate[housePriceList.size()]));
                if (!housePriceOr.getExpressions().isEmpty()){
                    and = criteriaBuilder.and(and,housePriceOr);
                }
                //房型
                Predicate houseTypeOr = criteriaBuilder.or(houseTypeList.toArray(new Predicate[houseTypeList.size()]));
                if (!houseTypeOr.getExpressions().isEmpty()){
                    and = criteriaBuilder.and(and,houseTypeOr);
                }
                //面积
                Predicate houseAreaOr = criteriaBuilder.or(houseAreaList.toArray(new Predicate[houseAreaList.size()]));
                if (!houseAreaOr.getExpressions().isEmpty()){
                    and = criteriaBuilder.and(and,houseAreaOr);
                }
                //朝向
                Predicate  houseOrientationOr = criteriaBuilder.or( houseOrientationList.toArray(new Predicate[ houseOrientationList.size()]));
                if (!houseOrientationOr.getExpressions().isEmpty()){
                    and = criteriaBuilder.and(and,houseOrientationOr);
                }
                //楼层
                Predicate  houseFloorOr = criteriaBuilder.or(houseFloorList.toArray(new Predicate[houseFloorList.size()]));
                if (!houseFloorOr.getExpressions().isEmpty()){
                    and = criteriaBuilder.and(and,houseFloorOr);
                }
                //楼龄
                Predicate houseAgeOr = criteriaBuilder.or(houseAgeList.toArray(new Predicate[houseAgeList.size()]));
                if (!houseAgeOr.getExpressions().isEmpty()){
                    and = criteriaBuilder.and(and,houseAgeOr);
                }
                //装修
                Predicate houseRenovationOr = criteriaBuilder.or(houseRenovationList.toArray(new Predicate[houseRenovationList.size()]));
                if (!houseRenovationOr.getExpressions().isEmpty()){
                    and = criteriaBuilder.and(and,houseRenovationOr);
                }
                //用途
                Predicate housePurposeOr = criteriaBuilder.or(housePurposeList.toArray(new Predicate[housePurposeList.size()]));
                if (!housePurposeOr.getExpressions().isEmpty()){
                    and = criteriaBuilder.and(and,housePurposeOr);
                }
                //电梯
                Predicate houseElevatorOr = criteriaBuilder.or(houseElevatorList.toArray(new Predicate[houseElevatorList.size()]));
                if (!houseElevatorOr.getExpressions().isEmpty()){
                    and = criteriaBuilder.and(and,houseElevatorOr);
                }
                //权属
                Predicate houseOwnershipOr = criteriaBuilder.or(houseOwnershipList.toArray(new Predicate[houseOwnershipList.size()]));
                if (!houseOwnershipOr.getExpressions().isEmpty()){
                    and = criteriaBuilder.and(and,houseOwnershipOr);
                }
                //建筑类型
                Predicate houseArchitectureTypeOr = criteriaBuilder.or( houseArchitectureTypeList.toArray(new Predicate[houseArchitectureTypeList.size()]));
                if (!houseArchitectureTypeOr.getExpressions().isEmpty()){
                    and = criteriaBuilder.and(and,houseArchitectureTypeOr);
                }

                //房屋标签
                ListJoin<HouseInfo, HouseLabel> join = root.join(root.getModel().getList("houseLabel",HouseLabel.class),JoinType.LEFT);
                if (!houseInfoVo.getHouseLabel().isEmpty()){
                    for (Integer integer : houseInfoVo.getHouseLabel()) {
                        if (integer!=null){
                            houseLabelList.add(criteriaBuilder.equal(join.get("id"),integer));
                        }
                    }
                }

                Predicate houseLabelOr = criteriaBuilder.or(houseLabelList.toArray(new Predicate[houseLabelList.size()]));
                if (!houseLabelList.isEmpty()){
                    and = criteriaBuilder.and(and,houseLabelOr);
                }
                //最新发布排序
                if (houseInfoVo.getCreateTimeSort()!=null){
                    if (houseInfoVo.getCreateTimeSort().intValue()== HouseInfoSort.NEW){
                        query.orderBy(criteriaBuilder.desc(root.get("createTime")));
                    }
                }
                //房屋总价排序
                if (houseInfoVo.getSpecificPriceSort()!=null){
                    if (houseInfoVo.getSpecificPriceSort().intValue()==HouseInfoSort.ASCENDING){
                        query.orderBy(criteriaBuilder.asc(root.get("specificPrice")));
                    }
                    if (houseInfoVo.getSpecificPriceSort().intValue()==HouseInfoSort.DESCENDING){
                        query.orderBy(criteriaBuilder.desc(root.get("specificPrice")));
                    }
                }
                //房屋单价排序
                if (houseInfoVo.getUnitPriceSort()!=null){
                    if (houseInfoVo.getUnitPriceSort().intValue()==HouseInfoSort.ASCENDING){
                        query.orderBy(criteriaBuilder.asc(root.get("unitPrice")));
                    }
                    if (houseInfoVo.getUnitPriceSort().intValue()==HouseInfoSort.DESCENDING){
                        query.orderBy(criteriaBuilder.desc(root.get("unitPrice")));
                    }
                }
                //房屋面积排序
                if (houseInfoVo.getAreaSort()!=null){
                    if (houseInfoVo.getAreaSort().intValue()==HouseInfoSort.ASCENDING){
                        query.orderBy(criteriaBuilder.asc(root.get("area")));
                    }
                    if (houseInfoVo.getAreaSort().intValue()==HouseInfoSort.DESCENDING){
                        query.orderBy(criteriaBuilder.desc(root.get("area")));
                    }
                }
                return and;
            }
        };
        Pageable pageable = PageRequest.of(pageBean.getCurrentPage() - 1,pageBean.getPageSize());
        Page<HouseInfo> findAll = houseInfoDao.findAll(specification, pageable);
        pageBean.setContent(findAll.getContent());
        pageBean.setTotal(findAll.getTotalElements());
        pageBean.setTotalPage(findAll.getTotalPages());
        return pageBean;
    }


    /**
     * 返回二手房总数
     */
    public Long count (){
        return houseInfoDao.count();
    }
}
