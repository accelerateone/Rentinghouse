package com.yuanlrc.base.service.houseInfo;

import com.yuanlrc.base.bean.PageBean;
import com.yuanlrc.base.dao.houseInfo.HouseInfoDao;
import com.yuanlrc.base.dao.houseInfo.HouseInspectionRecordDao;
import com.yuanlrc.base.entity.houseInfo.HouseInfo;
import com.yuanlrc.base.entity.houseInfo.HouseInspectionRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HouseInspectionRecordService {
    @Autowired
    private HouseInspectionRecordDao houseInspectionRecordDao;
    @Autowired
    private HouseInfoDao houseInfoDao;

    /**
     * 添加/编辑
     */
    public HouseInspectionRecord save(HouseInspectionRecord houseInspectionRecord) {
        return houseInspectionRecordDao.save(houseInspectionRecord);
    }

    /**
     * 添加/编辑
     */
    @Transactional(rollbackFor = Exception.class)
    public Boolean save1(HouseInspectionRecord houseInspectionRecord) {
        Boolean flag = true;
        try {
            HouseInfo houseInfo = houseInspectionRecord.getHouseInfo();
            houseInfo.setWatchNumber(houseInfo.getWatchNumber() + 1);
            houseInfoDao.save(houseInfo);
            houseInspectionRecordDao.save(houseInspectionRecord);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            flag = false;
            return flag;
        }
        return flag;
    }

    /**
     * 删除
     */
    public void delete(Long id) {
        houseInspectionRecordDao.deleteById(id);
    }

    /**
     * 通过id查询
     */
    public HouseInspectionRecord find(Long id) {
        return houseInspectionRecordDao.find(id);
    }

    /**
     * 通过房屋id查询带看记录
     */
    @Transactional
    public List<HouseInspectionRecord> findByHouseInfoId(Long id) {

        List<HouseInspectionRecord> houseInspectionRecordList = houseInspectionRecordDao.findByHouseInfo_IdOrderByCreateTimeDesc(id);
        if (houseInspectionRecordList.isEmpty()){
            return houseInspectionRecordList;
        }
        List<HouseInspectionRecord> houseInspectionRecords = houseInspectionRecordList.stream().distinct().collect(Collectors.toList());
        if(houseInspectionRecords.size() >= 6){
            houseInspectionRecords = houseInspectionRecords.subList(0, 5);
        }
        houseInspectionRecords.forEach(item -> {
            Integer integer = houseInspectionRecordDao.countByUser_IdAndHouseInfo_Id(item.getUser().getId(),item.getHouseInfo().getId());
            item.setCoun(integer);
        });

        return houseInspectionRecords;
    }

    /**
     * 通过房屋id查询近7天内带看次数
     */
    public BigInteger findWithinSevenDays(Long id) {
        Object withinSevenDays = houseInspectionRecordDao.findWithinSevenDays(id);
        return (BigInteger) withinSevenDays;
    }

    /**
     * 通过房屋id查询近30天内带看次数
     */
    public BigInteger findWithinThirtyDays(Long id) {
        Object withinSevenDays = houseInspectionRecordDao.findWithinThirtyDays(id);
        return (BigInteger) withinSevenDays;
    }

    /**
     * 查询所有
     */
    public List<HouseInspectionRecord> findAll() {
        return houseInspectionRecordDao.findAll();
    }

    /**
     * 分页查询
     */
    public PageBean<HouseInspectionRecord> findList(HouseInspectionRecord houseInspectionRecord, PageBean<HouseInspectionRecord> pageBean) {
        ExampleMatcher withMatcher = ExampleMatcher.matching().withMatcher("user.username", ExampleMatcher.GenericPropertyMatchers.contains());
        withMatcher = withMatcher.withIgnorePaths("user.status", "user.sex", "user.yearsOfService", "user.identity", "user.type");
        Example<HouseInspectionRecord> example = Example.of(houseInspectionRecord, withMatcher);
        Pageable pageable = PageRequest.of(pageBean.getCurrentPage() - 1, pageBean.getPageSize());
        Page<HouseInspectionRecord> findAll = houseInspectionRecordDao.findAll(example, pageable);
        pageBean.setContent(findAll.getContent());
        pageBean.setTotal(findAll.getTotalElements());
        pageBean.setTotalPage(findAll.getTotalPages());
        return pageBean;
    }
}
