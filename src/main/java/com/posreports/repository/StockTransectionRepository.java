package com.posreports.repository;

import com.posreports.entity.StockTransection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StockTransectionRepository extends JpaRepository<StockTransection,Long> {

//    @Query("SELECT st FROM StockTransection st WHERE st.accessDate BETWEEN :startDate AND :endDate GROUP BY st.id")
//    List<StockTransection> getAllWhichHaveAccessDateBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

//    @Query("SELECT st FROM StockTransection st WHERE st.accessDate BETWEEN :startDate AND :endDate " +
//            "AND st.id IN (" +
//            "  SELECT MAX(st2.id) " +
//            "  FROM StockTransection st2 " +
//            "  WHERE st2.id = st.id " +
//            "  GROUP BY st2.id" +
//            ")")
//    List<StockTransection> getAllWhichHaveAccessDateBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
