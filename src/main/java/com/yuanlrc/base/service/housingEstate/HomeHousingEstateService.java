package com.yuanlrc.base.service.housingEstate;

import com.yuanlrc.base.bean.PageBean;
import com.yuanlrc.base.dao.housingEstate.HousingEstateDao;
import com.yuanlrc.base.entity.houseInfoEnum.HouseAgeEnum;
import com.yuanlrc.base.entity.housingEstate.AveragePriceEnum;
import com.yuanlrc.base.entity.housingEstate.HousingEstate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 前台小区业务处理层
 *
 * @author wangzihan
 * @date : 2021/1/8 18:45
 */
@Service
public class HomeHousingEstateService {


    @Autowired
    private HousingEstateDao housingEstateDao;

    /**
     * 对小区进行条件查询并分页
     *
     * @param pageBean
     * @return
     */
    public PageBean<HousingEstate> findList(PageBean<HousingEstate> pageBean, String province, String city, String district,
                                            String town, HouseAgeEnum houseAge, AveragePriceEnum averagePrice) {
        Specification<HousingEstate> specification = new Specification<HousingEstate>() {
            @Override
            public Predicate toPredicate(Root<HousingEstate> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                if (province != null) {
                    Predicate predicate = criteriaBuilder.like(root.get("province"), "%" + province + "%");
                    predicates.add(predicate);
                }
                if (city != null) {
                    Predicate predicate1 = criteriaBuilder.like(root.get("city"), "%" + city + "%");
                    predicates.add(predicate1);
                }
                if (district != null) {
                    Predicate predicate2 = criteriaBuilder.like(root.get("district"), "%" + district + "%");
                    predicates.add(predicate2);
                }
                if (town != null) {
                    Predicate predicate3 = criteriaBuilder.like(root.get("province"), "%" + town + "%");
                    predicates.add(predicate3);
                }
                //房龄
                if (houseAge != null) {
                    Calendar calendar = Calendar.getInstance();
                    int year = calendar.get(Calendar.YEAR);
                    if (houseAge.getCode() == 0) {
                        Predicate predicate3 = criteriaBuilder.gt(root.get("completedYear"), year - 5);
                        predicates.add(predicate3);
                    } else if (houseAge.getCode() == 1) {
                        Predicate predicate3 = criteriaBuilder.gt(root.get("completedYear"), year - 10);
                        predicates.add(predicate3);
                    } else if (houseAge.getCode() == 2) {
                        Predicate predicate3 = criteriaBuilder.gt(root.get("completedYear"), year - 15);
                        predicates.add(predicate3);
                    } else if (houseAge.getCode() == 3) {
                        Predicate predicate3 = criteriaBuilder.gt(root.get("completedYear"), year - 20);
                        predicates.add(predicate3);
                    } else if (houseAge.getCode() == 4) {
                        Predicate predicate3 = criteriaBuilder.lt(root.get("completedYear"), year - 20);
                        predicates.add(predicate3);
                    }
                }
                //均价
                if (averagePrice != null) {
                    if (averagePrice.getCode() == 0){
                        Predicate predicate4 = criteriaBuilder.lt(root.get("averagePrice"), 30000);
                        predicates.add(predicate4);
                    }else if (averagePrice.getCode() == 1){
                        Predicate predicate4 = criteriaBuilder.between(root.get("averagePrice"), 30000,40000);
                        predicates.add(predicate4);
                    }else if (averagePrice.getCode() == 2){
                        Predicate predicate4 = criteriaBuilder.between(root.get("averagePrice"), 40000,50000);
                        predicates.add(predicate4);
                    }else if (averagePrice.getCode() == 3){
                        Predicate predicate4 = criteriaBuilder.between(root.get("averagePrice"), 50000,60000);
                        predicates.add(predicate4);
                    }else if (averagePrice.getCode() == 4){
                        Predicate predicate4 = criteriaBuilder.between(root.get("averagePrice"), 60000,70000);
                        predicates.add(predicate4);
                    }else if (averagePrice.getCode() == 5){
                        Predicate predicate4 = criteriaBuilder.gt(root.get("averagePrice"), 70000);
                        predicates.add(predicate4);
                    }
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        Pageable pageable = PageRequest.of(pageBean.getCurrentPage() - 1, pageBean.getPageSize());
        Page<HousingEstate> findAll = housingEstateDao.findAll(specification, pageable);
        pageBean.setContent(findAll.getContent());
        pageBean.setTotal(findAll.getTotalElements());
        pageBean.setTotalPage(findAll.getTotalPages());
        return pageBean;
    }

}
