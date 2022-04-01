package com.yuanlrc.base.service.bridalChamber;

import com.yuanlrc.base.bean.PageBean;
import com.yuanlrc.base.dao.bridalChamber.NewHouseInfoDao;
import com.yuanlrc.base.entity.admin.Role;
import com.yuanlrc.base.entity.admin.User;
import com.yuanlrc.base.entity.admin.UserRoleTypeEnum;
import com.yuanlrc.base.entity.bridalChamber.HousingCharacteristics;
import com.yuanlrc.base.entity.bridalChamber.NewHouseInfo;
import com.yuanlrc.base.entity.bridalChamber.NewHouseInfoVO;
import com.yuanlrc.base.entity.bridalChamber.PropertyTypeEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewHouseInfoService {

    @Autowired
    private NewHouseInfoDao newHouseInfoDao;

    /**
     * 根据name查询
     *
     * @param pageBean
     * @param newHouseInfo
     * @return
     */
    public PageBean<NewHouseInfo> findAllByName(PageBean<NewHouseInfo> pageBean, NewHouseInfo newHouseInfo) {
        ExampleMatcher withMatcher = ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());
        Example<NewHouseInfo> example = Example.of(newHouseInfo, withMatcher);
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Pageable pageable = PageRequest.of(pageBean.getCurrentPage() - 1, pageBean.getPageSize(), sort);
        Page<NewHouseInfo> findAll = newHouseInfoDao.findAll(example, pageable);
        pageBean.setContent(findAll.getContent());
        pageBean.setTotal(findAll.getTotalElements());
        pageBean.setTotalPage(findAll.getTotalPages());
        return pageBean;
    }

    /**
     * 多条件动态查询
     *
     * @param pageBean
     * @return
     */
    public PageBean<NewHouseInfo> specificationNewHouseInfo(PageBean<NewHouseInfo> pageBean, NewHouseInfoVO newHouseInfoVO) {
        Specification<NewHouseInfo> specification = new Specification<NewHouseInfo>() {
            @Override
            public Predicate toPredicate(Root<NewHouseInfo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.like(root.get("firstFigurePath"), "%" + "" + "%");

                if (!StringUtils.isEmpty(newHouseInfoVO.getCity()) && !"选择城市".equals(newHouseInfoVO.getCity())) {
                    Predicate predicateCity = criteriaBuilder.like(root.get("city"), "%" + newHouseInfoVO.getCity().trim() + "%");
                    predicate = criteriaBuilder.and(predicate, predicateCity);
                }

                List<Predicate> decorateStateCodeList = new ArrayList<>();  //装修状态
                List<Predicate> openingTimeCodeList = new ArrayList<>();    //开盘时间
                List<Predicate> propertyTypeCodeList = new ArrayList<>();   //物业类型
                List<Predicate> sellingTheStateCodeList = new ArrayList<>();    //售卖状态
                List<Predicate> housingCharacteristicsIdList = new ArrayList<>();   //特色

                if (newHouseInfoVO.getBuiltUpAreaMinValue() != null && newHouseInfoVO.getBuiltUpAreaMaxValue() != null) {
                    Predicate predicatebuiltUpArea = criteriaBuilder.between(root.get("builtUpArea"), newHouseInfoVO.getBuiltUpAreaMinValue(), newHouseInfoVO.getBuiltUpAreaMaxValue());
                    predicate = criteriaBuilder.and(predicate, predicatebuiltUpArea);
                }
                if (newHouseInfoVO.getMoneyMinValue() != null && newHouseInfoVO.getMoneyMaxValue() != null) {
                    Predicate predicateaveragePrice = criteriaBuilder.between(root.get("averagePrice"), newHouseInfoVO.getMoneyMinValue(), newHouseInfoVO.getMoneyMaxValue());
                    predicate = criteriaBuilder.and(predicate, predicateaveragePrice);
                }


                //装修状态
                if (!newHouseInfoVO.getDecorateStateCodeList().isEmpty()) {
                    for (Integer code : newHouseInfoVO.getDecorateStateCodeList()) {
                        if (code != null) {
                            decorateStateCodeList.add(criteriaBuilder.equal(root.get("decorateState"), code));
                        }
                    }
                }

                if (!newHouseInfoVO.getOpeningTimeCodeList().isEmpty()) {
                    for (Integer code : newHouseInfoVO.getOpeningTimeCodeList()) {
                        if (code != null) {
                            openingTimeCodeList.add(criteriaBuilder.equal(root.get("openingTime"), code));
                        }
                    }
                }

                if (!newHouseInfoVO.getPropertyTypeCodeList().isEmpty()) {
                    for (Integer code : newHouseInfoVO.getPropertyTypeCodeList()) {
                        if (code != null) {
                            propertyTypeCodeList.add(criteriaBuilder.equal(root.get("propertyType"), code));
                        }
                    }
                }

                if (!newHouseInfoVO.getSellingTheStateCodeList().isEmpty()) {
                    for (Integer code : newHouseInfoVO.getSellingTheStateCodeList()) {
                        if (code != null) {
                            sellingTheStateCodeList.add(criteriaBuilder.equal(root.get("sellingTheState"), code));
                        }
                    }
                }


                Predicate decorateStateCodeOr = criteriaBuilder.or(decorateStateCodeList.toArray(new Predicate[decorateStateCodeList.size()]));
                Predicate openingTimeCodeOr = criteriaBuilder.or(openingTimeCodeList.toArray(new Predicate[openingTimeCodeList.size()]));
                Predicate propertyTypeCodeOr = criteriaBuilder.or(propertyTypeCodeList.toArray(new Predicate[propertyTypeCodeList.size()]));
                Predicate sellingTheStateCodeOr = criteriaBuilder.or(sellingTheStateCodeList.toArray(new Predicate[sellingTheStateCodeList.size()]));

                if (!decorateStateCodeOr.getExpressions().isEmpty()) {
                    predicate = criteriaBuilder.and(predicate, decorateStateCodeOr);
                }
                if (!openingTimeCodeOr.getExpressions().isEmpty()) {
                    predicate = criteriaBuilder.and(predicate, openingTimeCodeOr);
                }
                if (!propertyTypeCodeOr.getExpressions().isEmpty()) {
                    predicate = criteriaBuilder.and(predicate, propertyTypeCodeOr);
                }
                if (!sellingTheStateCodeOr.getExpressions().isEmpty()) {
                    predicate = criteriaBuilder.and(predicate, sellingTheStateCodeOr);
                }

                if (newHouseInfoVO.getAveragePriceSort() != null) {
                    if (newHouseInfoVO.getAveragePriceSort() == 1) {
                        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("averagePrice")));
                    }
                    if (newHouseInfoVO.getAveragePriceSort() == 0) {
                        criteriaQuery.orderBy(criteriaBuilder.desc(root.get("averagePrice")));
                    }
                }

                if (newHouseInfoVO.getLatestOpeningHoursSort() != null) {
                    if (newHouseInfoVO.getLatestOpeningHoursSort() == 1) {
                        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("latestOpeningHours")));
                    }
                    if (newHouseInfoVO.getLatestOpeningHoursSort() == 0) {
                        criteriaQuery.orderBy(criteriaBuilder.desc(root.get("latestOpeningHours")));
                    }

                }

                if (!newHouseInfoVO.getName().replaceAll("\\s*", "").isEmpty()) {
                    Predicate predicateName = criteriaBuilder.like(root.get("name"), "%" + newHouseInfoVO.getName() + "%");
                    return predicateName;
                }

                criteriaQuery.distinct(true);

                return predicate;

            }
        };
        Pageable pageable = PageRequest.of(pageBean.getCurrentPage() - 1, pageBean.getPageSize());

        Page<NewHouseInfo> findAll = newHouseInfoDao.findAll(specification, pageable);


        pageBean.setContent(findAll.getContent());
        pageBean.setTotal(findAll.getTotalElements());
        pageBean.setTotalPage(findAll.getTotalPages());

        return pageBean;
    }


    /**
     * 查询所有
     *
     * @return
     */
    public List<NewHouseInfo> findAll() {
        return newHouseInfoDao.findAll();
    }

    /**
     * 根据别墅查询前六条
     *
     * @return
     */
    public List<NewHouseInfo> firstSixByPropertyType(Integer code,String city) {
        return newHouseInfoDao.firstSixByPropertyType(code, city);
    }

    /**
     * 查询前三条
     * @return
     */
    public List<NewHouseInfo> findTop3() {
        return newHouseInfoDao.findTop3By();
    }


    /**
     * 获取楼盘总数
     *
     * @return
     */
    public long count() {
        return newHouseInfoDao.count();
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    public NewHouseInfo find(Long id) {
        return newHouseInfoDao.find(id);
    }

    /**
     * 保存/编辑
     *
     * @param newHouseInfo
     * @return
     */
    public NewHouseInfo save(NewHouseInfo newHouseInfo) {
        return newHouseInfoDao.save(newHouseInfo);
    }

    /**
     * 根据id删除
     *
     * @param id
     */
    public void del(Long id) {
        newHouseInfoDao.deleteById(id);
    }


}
