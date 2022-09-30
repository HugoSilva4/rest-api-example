package via.sdj3.orderapiexample.repository;

import org.springframework.stereotype.Repository;
import via.sdj3.orderapiexample.model.Order0;

import java.util.*;

@Repository
public class OrderRepository0 {
    private static final Map<Long, Order0> orderMap = new HashMap<>();
    static {
        initDataSource();
    }

    private static void initDataSource() {
        Order0 o1 = new Order0(1L, "Morning goodies", 25.0, true);
        Order0 o2 = new Order0(2L, "Fridays beer", 45.0, false);
        Order0 o3 = new Order0(3L, "Evening snacks and drinks", 37.50, false);

        orderMap.put(o1.getId(), o1);
        orderMap.put(o2.getId(), o2);
        orderMap.put(o3.getId(), o3);
    }

    // CRUD operations (later we inherit from interface ()CrudRepo or JpaRepo)

    // C - Create
    public Order0 save(Order0 o){
        orderMap.put(o.getId(), o);
        return o;
    }

    // R - GET
    public Order0 findById(Long id) {
        return orderMap.get(id);
    }

    // U - Update
    public Order0 update(Order0 o){
        // simply saves the object
        orderMap.put(o.getId(), o);
        return o;
    }
    // D - Delete
    public void deleteById(Long id) { // void just for test
        orderMap.remove(id);
    }

    // R - find all
    public List<Order0> findAll() {
        Collection<Order0> c = orderMap.values();
        List<Order0> orderList = new ArrayList<>();
        orderList.addAll(c);
        return orderList;
    }
}
