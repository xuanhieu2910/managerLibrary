package vuonghieu.project.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import vuonghieu.project.dto.ChartDTO;
import vuonghieu.project.entity.*;
import vuonghieu.project.mapper.row.BorrowDetailsMapper;
import vuonghieu.project.mapper.row.BorrowMapper;

import java.util.*;
@Component
public class ChartDaoImpl {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<BorrowDetails> getBookBorrow(){//So sach muon
        String sql="SELECT*FROM borrow_details";
        return namedParameterJdbcTemplate.query(sql,new BorrowDetailsMapper());
    }

    public List<BorrowDetails> getBookBorrowed(){//So sach hoan tra
        String sql = "SELECT*FROM borrow_details where borrowed=1";
        return namedParameterJdbcTemplate.query(sql,new BorrowDetailsMapper());
    }

    public List<Borrow>studentsBorrow(){
        String sql = "SELECT*FROM borrow";
        return namedParameterJdbcTemplate.query(sql,new BorrowMapper());
    }

    /**
     *
     * CHART RESULT SUM
     *
     * */

    public int countStudent(){
        String sql="SELECT COUNT(DISTINCT borrow.mssv) FROM borrow";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public int countBookImport(){
        String sql ="SELECT SUM(book.quantity) FROM book";
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }

    public int countBookRefund(){
        String sql="SELECT COUNT(borrow_details.borrowed) FROM borrow_details WHERE borrowed=1";
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }

    public int countBookBorrowed(){
        String sql="SELECT COUNT(borrow_details.borrowed) FROM borrow_details";
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }
}


