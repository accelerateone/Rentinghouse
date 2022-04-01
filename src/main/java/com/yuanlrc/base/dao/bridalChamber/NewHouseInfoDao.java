package com.yuanlrc.base.dao.bridalChamber;

import com.yuanlrc.base.entity.bridalChamber.NewHouseInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewHouseInfoDao extends JpaRepository<NewHouseInfo,Long>, JpaSpecificationExecutor<NewHouseInfo> {

    @Query("select nhi from NewHouseInfo nhi where nhi.id = :id")
    NewHouseInfo find(@Param("id")Long id);



    @Query(value="select * from ylrc_new_house_info where property_type = :code and city = :city limit 6",nativeQuery = true)
    List<NewHouseInfo> firstSixByPropertyType(@Param("code")Integer code,@Param("city")String city);


    List<NewHouseInfo> findTop3By();




}
