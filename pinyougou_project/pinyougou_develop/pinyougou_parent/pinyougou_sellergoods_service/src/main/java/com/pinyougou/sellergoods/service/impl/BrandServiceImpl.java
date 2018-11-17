package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private TbBrandMapper tbBrandMapper;

    /**
     * 查询所有品牌
     * @return
     */
    @Override
    public List<TbBrand> findAll() {
        return tbBrandMapper.selectByExample(null);
    }

    /**
     * 分页查询
     * @param page 当前页码
     * @param rows 当前页的记录数
     * @return
     */
    @Override
    public PageResult findPage(int page, int rows) {
        //分页工具
        PageHelper.startPage(page,rows);
        Page<TbBrand> pages = (Page<TbBrand>)tbBrandMapper.selectByExample(null);
        return new PageResult(pages.getTotal(),pages.getResult());
    }

    /**
     * 添加信息
     * @param tbBrand 品牌对象
     * @return
     */
    @Override
    public void add(TbBrand tbBrand) {
        tbBrandMapper.insert(tbBrand);
    }

    /**
     * 根据id查询
     * @param id 品牌id
     * @return
     */
    @Override
    public TbBrand fingOne(long id) {
        return tbBrandMapper.selectByPrimaryKey(id);
    }

    /**
     * 更新
     * @param brand
     */
    @Override
    public void update(TbBrand brand) {
        tbBrandMapper.updateByPrimaryKey(brand);
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    public void delete(long[] ids) {
        for(long id : ids){
            tbBrandMapper.deleteByPrimaryKey(id);
        }
    }

    /**
     * 条件查询
     * @param brand
     * @param page
     * @param rows
     * @return
     */
    @Override
    public PageResult findPage(TbBrand brand, int page, int rows) {
        PageHelper.startPage(page,rows);
        TbBrandExample example = new TbBrandExample();
        TbBrandExample.Criteria criteria = example.createCriteria();
        if(brand != null){
            if(brand.getName() != null && brand.getName().length() > 0){
                criteria.andNameLike("%" +brand.getName()+"%");
            }
            if(brand.getFirstChar() != null && brand.getFirstChar().length() > 0){
                criteria.andFirstCharLike("%" + brand.getFirstChar() + "%");
            }
        }
        Page pages = (Page) tbBrandMapper.selectByExample(example);
        return new PageResult(pages.getTotal(),pages.getResult());
    }

    @Override
    public List<Map> selectOptionList() {
        return tbBrandMapper.selectOptionList();
    }
}
