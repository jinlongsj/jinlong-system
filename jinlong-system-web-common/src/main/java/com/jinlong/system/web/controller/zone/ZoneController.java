package com.jinlong.system.web.controller.zone;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jinlong.system.common.constant.ControllerConstant;
import com.jinlong.system.common.utils.exception.LogicException;
import com.jinlong.system.model.dto.ResultDTO;
import com.jinlong.system.model.vo.zone.ZoneVO;
import com.jinlong.system.service.zone.IZoneService;

/**
 * @description 地区信息视图层控制器
 * @author 肖学进
 */
@RestController
@RequestMapping("/zone")
public class ZoneController {
	
	/**
	 * 日志记录器
	 */
	private Log log = LogFactory.getLog(ZoneController.class);
	
	/**
	 * Spring注入省市县区地区信息Service业务层接口
	 */
	@Autowired
	private IZoneService zoneService;
	
	/**
	 * @description 查询省、自治区、直辖市列表信息
	 * @return
	 */
	@RequestMapping(value = "/show", method = RequestMethod.POST)
	public ResultDTO show() {
		log.info("Zone show start!");
		ResultDTO result = new ResultDTO();
		try {
			List<ZoneVO> zoneList = zoneService.findAllParent();
			if (null != zoneList && 0 < zoneList.size()) {
				result.setSuccess(ControllerConstant.ZONE_SHOW_MSG, zoneList);
			} else if (null != zoneList) {
				result.setResultNull(ControllerConstant.ZONE_SHOW_MSG, zoneList);
			} else {
				result.setError(ControllerConstant.ZONE_SHOW_MSG);
			}
		} catch (Exception e) {
			log.error("Zone show failed! Exception = " + e);
			result.setException(ControllerConstant.ZONE_SHOW_MSG, e.getMessage());
			return result;
		}
		log.info("Zone show end!");
		return result;
	}
	
	/**
	 * @description 通过本级地区ID查询下一级地区集合
	 * @return
	 */
	@RequestMapping(value = "/showByParentId", method = RequestMethod.POST)
	public ResultDTO showByParentId(@RequestBody int zoneId) {
		log.info("Zone showByParentId start! Parameter zoneId = " + zoneId);
		ResultDTO result = new ResultDTO();
		try {
			if (0 != zoneId) {
				List<ZoneVO> zoneList = zoneService.findSon(zoneId);
				if (null != zoneList && 0 < zoneList.size()) {
					result.setSuccess(ControllerConstant.ZONE_SHOW_BY_PARENT_ID_MSG, zoneList);
				} else if (null != zoneList) {
					result.setResultNull(ControllerConstant.ZONE_SHOW_BY_PARENT_ID_MSG, zoneList);
				} else {
					result.setError(ControllerConstant.ZONE_SHOW_BY_PARENT_ID_MSG);
				}
			} else {
				result.setParameterNull(ControllerConstant.ZONE_SHOW_BY_PARENT_ID_MSG);
			}
		} catch (Exception e) {
			log.error("Zone showByParentId start! Exception = " + e);
			result.setException(ControllerConstant.ZONE_SHOW_BY_PARENT_ID_MSG, e.getMessage());
			return result;
		}
		log.info("Zone showByParentId end!");
		return result;
	}
	
	/**
	 * @description 通过当前的的地区ID，查询他的父ID信息
	 * @return
	 */
	@RequestMapping(value = "/showParentIdByZone", method = RequestMethod.POST)
	public ResultDTO showParentIdByZone(@RequestBody int zoneId) {
		log.info("Zone showByParentId start! Parameter zoneId = " + zoneId);
		ResultDTO result = new ResultDTO();
		try {
			if (0 != zoneId) {
				ZoneVO zone = zoneService.findParent(zoneId);
				if (null != zone) {
					result.setSuccess(ControllerConstant.ZONE_SHOW_PARENT_ID_BY_ZONE_MSG, zone);
				} else {
					result.setResultNull(ControllerConstant.ZONE_SHOW_PARENT_ID_BY_ZONE_MSG);
				}
			} else {
				result.setParameterNull(ControllerConstant.ZONE_SHOW_PARENT_ID_BY_ZONE_MSG);
			}
		} catch (LogicException e) {
			log.error("Zone showByParentId start! Parameter zoneId = " + zoneId);
			result.setException(ControllerConstant.ZONE_SHOW_PARENT_ID_BY_ZONE_MSG, e.getMessage());
			return result;
		}
		log.info("Zone showByParentId end! ");
		return result;
	}

}