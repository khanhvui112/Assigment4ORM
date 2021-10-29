package fa.training.dao.Imp;

import fa.training.enity.InterView;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author san vui
 * @create 20/10/2021 - 11:44 PM
 * @sanvankhanh@gmail.com
 */
class InterViewDaoImpTest {

    private InterViewDaoImp interViewDaoImp = new InterViewDaoImp();

    @Test
    void findAll() {
        List<InterView> interViewList = new ArrayList<>();
        assertNotNull(interViewDaoImp.findAll(interViewList));
    }

    @Test
    void insertInterViewTrue() {
        String dateStr = "15/10/2020";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate date = LocalDate.parse(dateStr,formatter);
        InterView interView = new InterView("AM",date,"Nguyen Van Ga","No comment","Pro","Good",1);
        assertTrue(interViewDaoImp.insertInterView(interView));
    }
    @Test
    void insertInterViewFalseTest() {
        String dateStr = "15/10/2020";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate date = LocalDate.parse(dateStr,formatter);
        InterView interView = new InterView("AM",date,"Nguyen Van Ga","No comment","Pro","Good",10);
        assertFalse(interViewDaoImp.insertInterView(interView));
    }

    @Test
    void updateInterViewTrueTest() {
        String dateStr = "15/10/2020";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate date = LocalDate.parse(dateStr,formatter);
        InterView interView = new InterView(2,"AM",date,"Nguyen Van Hoang"," comment","VN","Better",1);
        assertTrue(interViewDaoImp.updateInterView(interView));
    }

    @Test
    void updateInterViewFalseTest() {
        String dateStr = "15/10/2020";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate date = LocalDate.parse(dateStr,formatter);
        InterView interView = new InterView(2,"AM",date,"Nguyen Van Hoang"," comment","VN","Better",6);
        assertFalse(interViewDaoImp.updateInterView(interView));
    }

    @Test
    void deleteInterViewTrueTest() {
        assertTrue(interViewDaoImp.deleteInterView(2));
    }

    @Test
    void deleteInterViewFalse() {
        assertFalse(interViewDaoImp.deleteInterView(8));
    }
}