package vuonghieu.project.service.impl;

import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vuonghieu.project.dao.impl.ChartDaoImpl;
import vuonghieu.project.dto.ChartDTO;
import vuonghieu.project.entity.Borrow;
import vuonghieu.project.entity.BorrowDetails;
import vuonghieu.project.entity.Students;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

@Component
public class ChartServiceImpl {

    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("YYYY-MM-dd");
    public static final String[]now = SIMPLE_DATE_FORMAT.format(new Date()).split("-");
    public static int dateNow = Integer.parseInt(now[2]);
    public static int monthNow = Integer.parseInt(now[1]);
    public static int yearNow = Integer.parseInt(now[0]);
    public List<BorrowDetails>borrowDetailsList;
    public ChartDTO chartDTO = new ChartDTO();
    @Autowired
    ChartDaoImpl chartDao;


    /**
     *
     *  CHART SUM UNTIL NOW
     *
     *
     * */

    public ChartDTO getSumResultChart(){
            chartDTO.setBookBorrow(chartDao.countBookBorrowed());
            chartDTO.setBookReturn(chartDao.countBookRefund());
            chartDTO.setBookImport(chartDao.countBookImport());
            chartDTO.setStudentBorrow(chartDao.countStudent());
            return chartDTO;
    }

    public int getBookImport(){
        return 0;
    }

    public int getSumStudentsBorrow(){
        return 0;
    }

    public int getSumBookRefund(){ // Sach da hoan tra
        return 0;
    }

    public int getSumBookBorrowed(){// Sach da muon
        return 0;
    }

































    /**
     *
     *
     *  CHART DETAILS
     *
     *
     * */
    public ChartDTO present(){
        chartDTO.setBookBorrow(bookBorrow(chartDao.getBookBorrow()));
        chartDTO.setBookReturn(bookBorrowed(chartDao.getBookBorrowed()));
        chartDTO.setStudentBorrow(studentBorrow(chartDao.studentsBorrow()));
        return chartDTO;
    }



    public ChartDTO oneDayAgo(){
        borrowDetailsList = chartDao.getBookBorrow();
        return null;
    }

    public ChartDTO oneWeekAgo(){
        borrowDetailsList = chartDao.getBookBorrow();

        return null;
    }

    public ChartDTO oneMonthAgo(){
        borrowDetailsList = chartDao.getBookBorrow();

        return null;
    }

    public ChartDTO oneYearAgo(){
        borrowDetailsList = chartDao.getBookBorrow();

        return null;
    }

    public int bookBorrow(List<BorrowDetails>borrowDetails){
        int count =0;
        for (BorrowDetails borrows:borrowDetails) {
            String[] dateBorrow = SIMPLE_DATE_FORMAT.format(borrows.getCreatedOn()).split("-");

            int date =Integer.parseInt(dateBorrow[2]);
            int month =Integer.parseInt(dateBorrow[1]);
            int year =Integer.parseInt(dateBorrow[0]);
            if(dateNow==date && monthNow==month && yearNow==year){
                ++count;
            }
        }
        return count;
    }

    public int bookBorrowed(List<BorrowDetails>borrowDetails){
        int count =0;
        for (BorrowDetails borrows:borrowDetails) {
            String[] dateBorrow = SIMPLE_DATE_FORMAT.format(borrows.getCreatedOn()).split("-");

            int date =Integer.parseInt(dateBorrow[2]);
            int month =Integer.parseInt(dateBorrow[1]);
            int year =Integer.parseInt(dateBorrow[0]);
            if(dateNow==date && monthNow==month && yearNow==year){
                ++count;
            }
        }
        return count;
    }

    public int studentBorrow(List<Borrow>borrowList){
        List<Integer>students = new ArrayList<>();
        for (Borrow borrow:borrowList) {
            String[] dateBorrow = SIMPLE_DATE_FORMAT.format(borrow.getCreatedOn()).split("-");
            int date =Integer.parseInt(dateBorrow[2]);
            int month =Integer.parseInt(dateBorrow[1]);
            int year =Integer.parseInt(dateBorrow[0]);
            if(dateNow==date && monthNow==month && yearNow==year ){
                if(students.size()>0) {
                    for (Integer students1 : students) {
                        if (!students1.equals(borrow.getMssv())) {
                            students.add(borrow.getMssv());
                            break;
                        }
                    }
                }
                else{
                    students.add(borrow.getMssv());
                }
            }
        }
        return students.size();
    }
}
