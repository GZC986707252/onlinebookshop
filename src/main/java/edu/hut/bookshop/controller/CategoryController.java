package edu.hut.bookshop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import edu.hut.bookshop.dao.CategoryMapper;
import edu.hut.bookshop.pojo.Category;
import edu.hut.bookshop.service.CategoryService;
import edu.hut.bookshop.util.ResultCode;
import edu.hut.bookshop.util.ResultVO;

/**
 * @Description: 分类管理模块控制器
 * @Author: guozongchao
 * @Date: 2020/6/2 2:03
 */
@RestController
@RequestMapping("category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@Resource
	private CategoryMapper categoryMapper;
	@GetMapping("/searchcode")
	public ResultVO categorySearchByCode(String categoryCode)
	{
		
		Category categories = categoryService.selectByByCategoryCode(categoryCode);
		if(categories!=null)
		return new ResultVO(ResultCode.SUCCESS,categories);
		else
			return new ResultVO(ResultCode.RECORD_NOT_FOUND,null);
	}
	@PostMapping("/delete")
	public ResultVO categoryDelete(String categoryCode)
	{
		int categories = categoryService.deleteByByCategoryCode(categoryCode);
		return new ResultVO(ResultCode.SUCCESS,null);
	}
	@PostMapping("/insert")
	public ResultVO categoryInsert(Category record)
	{
		
		int categories = categoryService.insert(record);
		return new ResultVO(ResultCode.SUCCESS,null);
	}
	@PostMapping("/update")
	public  ResultVO categoryUpdate(Category record)
	{
		int categories = categoryService.updateByCategoryCode(record);
		return new ResultVO(ResultCode.SUCCESS,null);
	}
	@GetMapping("/searchall")
	public  ResultVO categorySearchAll()
	{
		List<Category> categories = categoryService.selectAll();
		if(categories.size()!=0)
		return new ResultVO(ResultCode.SUCCESS,categories);
		else
			return new ResultVO(ResultCode.RECORD_NOT_FOUND,null);
	}	
}
