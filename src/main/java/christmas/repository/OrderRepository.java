package christmas.repository;

import christmas.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private final List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return new ArrayList<>(orders); // 불변 리스트 반환 (캡슐화)
    }
}