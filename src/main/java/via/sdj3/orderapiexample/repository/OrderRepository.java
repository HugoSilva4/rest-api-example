package via.sdj3.orderapiexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import via.sdj3.orderapiexample.model.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
