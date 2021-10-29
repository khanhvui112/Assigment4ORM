package fa.training.dao;

import fa.training.enity.InterView;

import java.util.List;

/**
 * @author san vui
 * @create 20/10/2021 - 10:54 PM
 * @sanvankhanh@gmail.com
 */
public interface InterViewDao {
    List<InterView> findAll(List<InterView> interViewList);

    boolean insertInterView(InterView interView);

    boolean updateInterView(InterView interView);

    boolean deleteInterView(int id);
}
