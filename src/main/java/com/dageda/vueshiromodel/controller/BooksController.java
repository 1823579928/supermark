package com.dageda.vueshiromodel.controller;

import com.dageda.vueshiromodel.entity.books.Books;
import com.dageda.vueshiromodel.service.booksservice.BooksService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName BooksController
 * @Description:    图书controller类
 * @Author 邹捷
 * @Date 2019/11/26
 * @Version V1.0
 **/
@RestController
@RequestMapping("/books")
@CrossOrigin
public class BooksController {

    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Autowired
    private BooksService booksService;


    /**
     * 获取图书列表
     * @param currentPage
     * @param pageSize
     * @return
     */
    @RequestMapping(value="/getBooks")
    public List<Books> getBooks(Integer currentPage, Integer pageSize){
        List<Books> booksList = booksService.getBooksList((currentPage-1)*pageSize,pageSize);
        return booksList;
    }

    /**
     * 删除图书
     * @param id
     * @return
     */
    @RequestMapping(value="/delBooks")
    public boolean delBooks(Integer id){
        if(booksService.deleteBooks(id)>0){
            logger.info("删除图书");
            return true;
        }
        return false;
    }

    /**
     * 添加图书
     * @param books
     * @return
     */
    @RequestMapping(value="/addBooks")
    public Integer addBooks(Books books) {
        logger.info("添加图书");
        booksService.insertBooks(books);
        return books.getId();
    }

    /**
     * 获取图书总条数
     * @return
     */
    @RequestMapping(value="/count")
    public Integer count(){
        return booksService.booksCount();
    }

    /**
     * 修改图书
     * @param books
     * @return
     */
    @RequestMapping(value="/upBooks")
    public boolean upBooks(Books books){
        if(booksService.updateBooks(books)>0){
            logger.info("修改图书！");
            return true;
        }
        return false;
    }
}
