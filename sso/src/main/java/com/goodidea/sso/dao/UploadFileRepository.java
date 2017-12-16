package com.goodidea.sso.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.goodidea.sso.domin.Log;
import com.goodidea.sso.domin.UploadFile;

/**
 * 
* @ClassName: UploadFileRepository 
* @Description:   文件上传Dao
* @author lsg
* @date 2017年8月14日 上午9:40:16 
*
 */
public interface UploadFileRepository extends JpaSpecificationExecutor<UploadFile>,PagingAndSortingRepository<UploadFile, Long> {

}
