package com.yuanlrc.base.dao.houseInfo;

import com.yuanlrc.base.entity.houseInfo.HousePictures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HousePicturesDao extends JpaRepository<HousePictures,Long> {
    /**
     * 通过id查询
     */
    @Query("select p from HousePictures p where p.id = :id")
    HousePictures find(@Param("id") Long id);

    /**
     * 通过房间信息查询
     */
    List<HousePictures> findByHouseInfoId(Long id);
}
