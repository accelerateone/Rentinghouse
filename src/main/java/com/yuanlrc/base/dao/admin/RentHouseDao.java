package com.yuanlrc.base.dao.admin;

import com.yuanlrc.base.entity.admin.User;
import com.yuanlrc.base.entity.rentHouse.RentHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.ListJoin;
import java.util.List;

/**
 * 租房数据库处理层
 * @author wangzihan
 * @date : 2021/1/9 16:29
 */
@Repository
public interface RentHouseDao extends JpaRepository<RentHouse,Long>, JpaSpecificationExecutor<RentHouse> {

    /**
     * 根据租房id查询
     * @param id
     * @return
     */
    @Query("select rh from RentHouse rh where id = :id")
    RentHouse find(@Param("id")Long id);





    /**
     * 按照租房名查找租房信息
     * @param name
     * @return
     */
    RentHouse findByName(String name);

    /**
     * 通过小区查找4条租房信息
     * @param housingEstateName
     * @return
     */
    List<RentHouse> findTop4ByHousingEstate_NameAndIdNot(String housingEstateName,Long id);

    /**
     * 查找3条租房信息
     * @return
     */
    List<RentHouse> findTop3By();

    /**
     * 找到本省市区的其他8条房源信息
     * @param district
     * @param city
     * @param province
     * @param id
     * @return
     */
    List<RentHouse> findTop8ByDistrictLikeAndCityLikeAndProvinceLikeAndIdNot(String district,String city,String province,Long id);

}
