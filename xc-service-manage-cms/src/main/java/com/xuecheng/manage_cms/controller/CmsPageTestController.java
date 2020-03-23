package com.xuecheng.manage_cms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xuecheng.api.cms.CmsPageControllerApi;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;

/**
 * 
 * @author WuMJ
 *
 */
@RestController //@Controller + @ResponseBody
@RequestMapping("/cms/testpage")
public class CmsPageTestController implements CmsPageControllerApi{

	@Override
	@GetMapping("/list/{page}/{size}")   //@RequestMapping(method = RequestMethod.GET)
	public QueryResponseResult findList(@PathVariable("page") int page,@PathVariable("size") int size,
			QueryPageRequest queryPageRequest) {
		QueryResult<CmsPage> queryResult = new QueryResult<>();
		// TODO Auto-generated method stub
		QueryResponseResult result = new QueryResponseResult(CommonCode.SUCCESS, queryResult); 
		return result;
	}

}
