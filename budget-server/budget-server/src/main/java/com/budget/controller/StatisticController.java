
package com.budget.controller;

import com.budget.dto.StatisticQueryDTO;
import com.budget.result.Result;
import com.budget.service.StatisticService;
import com.budget.vo.StatisticCategoryVO;
import com.budget.vo.StatisticVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("budget/statistic")
@Slf4j
@Api(tags = "统计相关接口")
public class StatisticController {
    @Autowired
    private StatisticService statisticService;

    @ApiOperation("按日期汇总")
    @PostMapping()
    public Result<List<StatisticVO>> summary(@RequestBody StatisticQueryDTO statisticQueryDTO) {
        log.info("按日期汇总:{}", statisticQueryDTO);
        List<StatisticVO> statisticQueryVOList = statisticService.summary(statisticQueryDTO);
        return Result.success(statisticQueryVOList);
    }
    @ApiOperation("按类型汇总")
    @PostMapping("/category")
    public Result<List<StatisticCategoryVO>> summaryByType(@RequestBody StatisticQueryDTO statisticQueryDTO) {
        log.info("按类型汇总:{}", statisticQueryDTO );
        List<StatisticCategoryVO> statisticQueryVOList = statisticService.summaryByType(statisticQueryDTO);
        return Result.success(statisticQueryVOList);
    }

}


