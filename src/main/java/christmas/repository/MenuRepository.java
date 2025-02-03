package christmas.repository;

import christmas.model.Menu;

import java.util.ArrayList;
import java.util.List;

public class MenuRepository {
    private final List<Menu> menus = new ArrayList<>();

    public MenuRepository() {
        addMenu();
    }

    private void addMenu() {
        menus.clear();
        menus.add(new Menu("양송이수프", 6000, "애피타이저"));
        menus.add(new Menu("타파스", 5500, "애피타이저"));
        menus.add(new Menu("시저샐러드", 8000, "애피타이저"));

        menus.add(new Menu("티본스테이크", 55000, "메인"));
        menus.add(new Menu("바비큐립", 54000, "메인"));
        menus.add(new Menu("해산물파스타", 35000, "메인"));
        menus.add(new Menu("크리스마스파스타", 25000, "메인"));

        menus.add(new Menu("초코케이크", 15000, "디저트"));
        menus.add(new Menu("아이스크림", 5000, "디저트"));

        menus.add(new Menu("제로콜라", 3000, "음료"));
        menus.add(new Menu("레드와인", 60000, "음료"));
        menus.add(new Menu("샴페인", 25000, "음료"));
    }

    public Menu findByName(String menuName) {
        return menus.stream()
                .filter(menu -> menu.getName().trim().equals(menuName.trim())) // 공백 제거 후 비교
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
