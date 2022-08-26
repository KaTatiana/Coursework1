//1. Создать класс Employee, который содержит информацию о Ф.И.О., отделе и зарплате сотрудника.
//        Отделы для простоты должны быть названы от 1 до 5.
//        2. Добавить статическую переменную-счетчик, которая будет отвечать за id.
//        3. Добавить в класс Employee поле id, которое проставляется из счетчика, а затем счетчик увеличивает свое значение.
//        4. Добавить возможность получать значения полей из Employee (геттеры) для всех полей.
//        5. Добавить возможность устанавливать значения полей отдела и зарплаты (сеттеры).
//        6. По умолчанию все поля должны передавать через конструктор (кроме id) и заполняться в нем
//        (включая id, который нужно получить из счетчика).

import java.util.concurrent.atomic.AtomicInteger;

public class Employee {
    private final String name;
    private final String patronymic;
    private final String surname;
    private int department;
    private double salary;
    private static int counter = 0;
    private int id;

    public Employee(String name, String patronymic,  String surname, int department, int salary) {
        this.name = name;
        this.patronymic=patronymic;
        this.surname = surname;
        this.department=department;
        this.salary=salary;
        id = counter++;
    }

    public String getName() { return name; }
    public String getPatronymic() { return patronymic; }
    public String getSurname() { return surname; }
    public int getDepartment() { return department; }
    public double getSalary() { return salary; }

    public void setDepartment(int department) {
        this.department= department;
    }public void setSalary(double salary){
        this.salary= salary;
    }
    public String toString() {
        return surname + " " + name + " " + patronymic + " " + " " + department + " " +salary;
    }
}
