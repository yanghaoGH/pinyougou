package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import entity.PageResult;

import java.util.List;
import java.util.Map;

/**
 * 查询所有品牌
 */
public interface BrandService {
    /**
     * 查询所有品牌
     * @return
     */
    List<TbBrand> findAll();

    /**
     * 分页查询
     * @param page 当前页码
     * @param rows 当前页的记录数
     * @return
     */
    PageResult findPage(int page,int rows);

    /**
     * 添加数据
     * @param tbBrand 品牌对象
     */
    void add(TbBrand tbBrand);

    /**
     * 根据id查询
     * @param id 品牌id
     * @return
     */
    TbBrand fingOne(long id);

    /**
     * 更新
     * @param brand
     */
    void update(TbBrand brand);

    /**
     * 批量删除
     * @param ids
     */
    void delete(long[] ids);

    /**
     * 条件查询
     * @param brand
     * @param page
     * @param rows
     * @return
     */
    PageResult findPage(TbBrand brand,int page,int rows);

    List<Map> selectOptionList();
}
