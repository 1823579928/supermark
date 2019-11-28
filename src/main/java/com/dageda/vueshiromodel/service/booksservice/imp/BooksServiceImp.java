package com.dageda.vueshiromodel.service.booksservice.imp;

import com.dageda.vueshiromodel.dao.BooksMapper;
import com.dageda.vueshiromodel.entity.books.Books;
import com.dageda.vueshiromodel.service.booksservice.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BooksServiceImp
 * @Description: 图书Service实现类
 * @Author 邹捷
 * @Date 2019/11/26
 * @Version V1.0
 **/
@Service("booksService")
public class BooksServiceImp implements BooksService {
    @Autowired
    private BooksMapper booksMapper;

    @Override
    public List<Books> getBooksList(Integer currentPage, Integer pageSize) {
        return booksMapper.getBooksList(currentPage,pageSize);
    }

    @Override
    public Integer booksCount() {
        return booksMapper.booksCount();
    }

    @Override
    public Integer insertBooks(Books books) {
        return booksMapper.insertBooks(books);
    }

    @Override
    public Integer deleteBooks(Integer id) {
        return booksMapper.deleteBooks(id);
    }

    @Override
    public Integer updateBooks(Books books) {
        return booksMapper.updateBooks(books);
    }
}
