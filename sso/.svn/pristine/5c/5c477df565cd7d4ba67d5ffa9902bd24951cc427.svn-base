package com.goodidea.sso.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.domain.Page;

public class PageUtils {
	
    public static Map<String, Object> getPageMap(Page<?> objPage) {  
        
        Map<String, Object> resultMap = new HashMap<String, Object>();  
  
        resultMap.put("resultList", objPage.getContent()); // 数据集合  
        resultMap.put("totalNum", objPage.getTotalElements()); // 总记录数  
        resultMap.put("totalPage", objPage.getTotalPages()); // 总页数  
        resultMap.put("pageNum", objPage.getNumber()); // 当前页码  
        resultMap.put("pageSize", objPage.getSize()); // 每页显示数量  
  
        return resultMap;  
    } 
}
