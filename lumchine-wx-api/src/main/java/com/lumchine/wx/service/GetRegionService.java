package com.lumchine.wx.service;

import com.lumchine.db.domain.LumchineRegion;
import com.lumchine.db.service.LumchineRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhy
 * @date 2019-01-17 23:07
 **/
@Component
public class GetRegionService {

	@Autowired
	private LumchineRegionService regionService;

	private static List<LumchineRegion> lumchineRegions;

	protected List<LumchineRegion> getLumchineRegions() {
		if(lumchineRegions==null){
			createRegion();
		}
		return lumchineRegions;
	}

	private synchronized void createRegion(){
		if (lumchineRegions == null) {
			lumchineRegions = regionService.getAll();
		}
	}
}
