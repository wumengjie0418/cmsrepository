package com.xuecheng.manage_cms.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.xuecheng.framework.domain.cms.CmsPage;

/**
 * 
 * @author WuMJ
 * 泛型+主键类型
 *
 */
public interface CmsPageTestRespository extends MongoRepository<CmsPage, String>{
	/**
	 * 同springDataJpa一样，springDataMongoDB 也提供了自定义方法的规则，如下：
	 * 按照findByXXX,findByXXXAndYYY
	 * countByXXXAndYYY等规则定义方法，实现查询操作的。
	 * 
	 */
	//根据条件分页拆查询
	Page<CmsPage> findBySiteIdAndPageType(String siteId, String pageType, Pageable pageable);
}
