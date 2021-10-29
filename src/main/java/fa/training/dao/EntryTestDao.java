package fa.training.dao;

import fa.training.enity.EntryTest;
import fa.training.enity.InterView;

import java.util.List;

/**
 * @author san vui
 * @create 20/10/2021 - 10:54 PM
 * @sanvankhanh@gmail.com
 */
public interface EntryTestDao {
    List<EntryTest> findAll(List<EntryTest> entryTestList);

    boolean insertInterView(EntryTest entryTest);

    boolean updateInterView(EntryTest entryTest);

    boolean deleteInterView(int id);
}
