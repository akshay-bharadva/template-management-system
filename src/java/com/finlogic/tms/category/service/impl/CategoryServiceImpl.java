/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.category.service.impl;

import com.finlogic.tms.category.bean.CategoryFormBean;
import com.finlogic.tms.category.datamanager.CategoryDataManager;
import com.finlogic.tms.category.service.CategoryService;
import com.finlogic.util.CommonMember;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author njuser
 */
@Service(value = "CategoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDataManager categoryDatamanager;

    @Override
    public List getTemplateType() throws Exception {
        return categoryDatamanager.getTemplateType();
    }

    @Override
    public int insertCategoryDetail(CategoryFormBean categoryFormBean) throws Exception {
          CommonMember.appendLogFile("Master 2" );
        return categoryDatamanager.insertCategoryDetail(categoryFormBean);
    }

    @Override
    public List getAllCategoryDetail(CategoryFormBean categoryFormBean) throws Exception {
        return categoryDatamanager.getAllCategoryDetail(categoryFormBean);
    }
    
    @Override
    public List getCategoryData(String categoryId) throws Exception
    {
        return categoryDatamanager.getCategoryData(categoryId) ;
    }
    
    @Override
    public int editCategoryDetail(CategoryFormBean categoryFormBean) throws Exception
    {
        return categoryDatamanager.editCategoryDetail(categoryFormBean);
    }
    
    @Override
    public int deleteCategoryDetail(String categoryId) throws Exception
    {
        return categoryDatamanager.deleteCategoryDetail(categoryId);
    }
}
