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
    public int CategoryCount() throws Exception {
        return categoryDatamanager.CategoryCount();
    }

    @Override
    public int DefaultCount() throws Exception {
        return categoryDatamanager.DefaultCount();
    }

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
    public List getCategoryData(CategoryFormBean categoryFormBean) throws Exception
    {
        return categoryDatamanager.getCategoryData(categoryFormBean) ;
    }
    
    @Override
    public int editCategoryDetail(CategoryFormBean categoryFormBean) throws Exception
    {
        return categoryDatamanager.editCategoryDetail(categoryFormBean);
    }
    
    @Override
    public int deleteCategoryDetail(CategoryFormBean categoryFormBean) throws Exception
    {
        return categoryDatamanager.deleteCategoryDetail(categoryFormBean);
    }

    @Override
    public List getCategoryNameList(CategoryFormBean categoryFormBean) throws Exception 
    {
        return categoryDatamanager.getCategoryNameList(categoryFormBean);
    }
}
