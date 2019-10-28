package com.shop.employee;

public class EmployeeList {
    //存储员工数量
    private int employeeNumber;
    private static EmployeeList instance=new EmployeeList();
    //默认数量为“0”
    private EmployeeList(){
        instance.employeeNumber=0;
    }
    public static EmployeeList getEmployeeList(){
        return instance;
    }
    //雇佣一个员工
    public Employee employSomeone(){
        instance.employeeNumber++;
       return Employee.getEmployee();
    }
}
