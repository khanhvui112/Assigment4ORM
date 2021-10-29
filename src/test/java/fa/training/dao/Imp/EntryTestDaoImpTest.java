package fa.training.dao.Imp;

import fa.training.enity.EntryTest;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author san vui
 * @create 20/10/2021 - 11:00 PM
 * @sanvankhanh@gmail.com
 */
class EntryTestDaoImpTest {
    private EntryTestDaoImp entryTestDaoImp = new EntryTestDaoImp();

    @Test
    void findAllTest() {
        List<EntryTest>entryTests = new ArrayList<>();
        assertNotNull(entryTestDaoImp.findAll(entryTests));
    }

    @Test
    void insertInterViewTrue() {
        String dateStr = "15/10/2020";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate date = LocalDate.parse(dateStr,formatter);
        EntryTest entryTest  = new EntryTest("San vui",date,"VN",5.3,"Junior",6.3,"pass","KO","NO",5);
        assertTrue(entryTestDaoImp.insertInterView(entryTest));
    }
    @Test
    void insertInterViewFalseTest() {
        String dateStr = "15/10/2020";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate date = LocalDate.parse(dateStr,formatter);
        EntryTest entryTest  = new EntryTest("San vui",date,"VN",5.3,"Junior",6.3,"pass","KO","NO",15);
        assertFalse(entryTestDaoImp.insertInterView(entryTest));
    }

    @Test
    void updateInterViewTrue() {
        String dateStr = "15/10/2021";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate date = LocalDate.parse(dateStr,formatter);
        EntryTest entryTest  = new EntryTest(1004,"AM",date,"US",8,"Junior",6.3,"fail","KO",5,"C++");
        assertTrue(entryTestDaoImp.updateInterView(entryTest));
    }

    @Test
    void updateInterViewFalse() {
        String dateStr = "15/10/2021";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate date = LocalDate.parse(dateStr,formatter);
        EntryTest entryTest  = new EntryTest(104,"AM",date,"US",8,"Junior",6.3,"fail","KO",5,"C++");
        assertFalse(entryTestDaoImp.updateInterView(entryTest));
    }

    @Test
    void deleteInterViewTrueTest() {
        assertTrue(entryTestDaoImp.deleteInterView(1004));
    }
    @Test
    void deleteInterViewFalseTest() {
        assertFalse(entryTestDaoImp.deleteInterView(16));
    }
}