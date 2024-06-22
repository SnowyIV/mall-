package com.geekAca;

//使用面向对象编程模拟购车，可以实现客户对象掏钱，销售对象交车功能。
public class Test {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setName("张三丰");
        customer.setSex('男');
        customer.setPhone(158888888);
        System.out.println("客户姓名：" + customer.getName() + "，客户性别:" + customer.getSex() + ",客户电话：" + customer.getPhone());

        Sale sale = new Sale();
        sale.setName("张三");
        sale.setSex('男');
        sale.setPhone(1566888888);
        System.out.println("销售姓名：" + sale.getName() + "，销售性别:" + sale.getSex() + ",销售电话：" + sale.getPhone());

        Car car = new Car();
        car.setName("byd");
        car.setPrice(500);
        System.out.println("车品牌为" + car.getName() + ",价格为" + car.getPrice());

        double money = customer.giveMoney();

        customer.fetchCar(car);

        sale.saleCar(car.getPrice());
    }
}
