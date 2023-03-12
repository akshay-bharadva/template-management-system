/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.tms.category.datamanager;

import com.finlogic.tms.category.bean.CategoryFormBean;

import java.util.List;

/**
 *
 * @author njuser
 */
public interface CategoryDataManager {

    public List getTemplateType() throws Exception;

    public int insertCategoryDetail(CategoryFormBean categoryFormBean) throws Exception;
    
    public List getAllCategoryDetail(CategoryFormBean categoryFormBean) throws Exception ;
    
    public List getCategoryData(String categoryId) throws Exception;
    
    public int editCategoryDetail(CategoryFormBean categoryFormBean) throws Exception;
    
    public int deleteCategoryDetail(String categoryId) throws Exception;
}
