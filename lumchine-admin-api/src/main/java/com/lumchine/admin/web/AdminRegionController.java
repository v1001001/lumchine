package com.lumchine.admin.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.lumchine.admin.vo.RegionVo;
import com.lumchine.core.util.ResponseUtil;
import com.lumchine.db.domain.LumchineRegion;
import com.lumchine.db.service.LumchineRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin/region")
@Validated
public class AdminRegionController {
    private final Log logger = LogFactory.getLog(AdminRegionController.class);

    @Autowired
    private LumchineRegionService regionService;

    @GetMapping("/clist")
    public Object clist(@NotNull Integer id) {
        List<LumchineRegion> regionList = regionService.queryByPid(id);
        return ResponseUtil.okList(regionList);
    }

    @GetMapping("/list")
    public Object list() {
        List<RegionVo> regionVoList = new ArrayList<>();

        List<LumchineRegion> provinceList = regionService.queryByPid(0);
        for (LumchineRegion province : provinceList) {
            RegionVo provinceVO = new RegionVo();
            provinceVO.setId(province.getId());
            provinceVO.setName(province.getName());
            provinceVO.setCode(province.getCode());
            provinceVO.setType(province.getType());

            List<LumchineRegion> cityList = regionService.queryByPid(province.getId());
            List<RegionVo> cityVOList = new ArrayList<>();
            for (LumchineRegion city : cityList) {
                RegionVo cityVO = new RegionVo();
                cityVO.setId(city.getId());
                cityVO.setName(city.getName());
                cityVO.setCode(city.getCode());
                cityVO.setType(city.getType());

                List<LumchineRegion> areaList = regionService.queryByPid(city.getId());
                List<RegionVo> areaVOList = new ArrayList<>();
                for (LumchineRegion area : areaList) {
                    RegionVo areaVO = new RegionVo();
                    areaVO.setId(area.getId());
                    areaVO.setName(area.getName());
                    areaVO.setCode(area.getCode());
                    areaVO.setType(area.getType());
                    areaVOList.add(areaVO);
                }

                cityVO.setChildren(areaVOList);
                cityVOList.add(cityVO);
            }
            provinceVO.setChildren(cityVOList);
            regionVoList.add(provinceVO);
        }

        return ResponseUtil.okList(regionVoList);
    }
}
