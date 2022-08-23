//        1. Создать класс EmployeeBook.
//        2. Перенести хранилище сотрудников в него (массив), закрыть к нему доступ извне (сделать приватным).
//        3. Все статические методы по работе с массивом перенести в этот класс и сделать нестатическими.

public class EmployeeBook {
    private final Employee[] employee=new Employee[10];

    public EmployeeBook()
    {
    }

    public void masEmployeeBook() {
        employee[0] = new Employee("Иван", "Иванович", "Иванов", 1, 52000);
        employee[1] = new Employee("Петр", "Иванович", "Иванов", 2, 62000);
        employee[2] = new Employee("Петр", "Иванович", "Петров", 2, 42000);
        employee[3] = new Employee("Петр", "Иванович", "Семенов", 3, 92000);
        employee[4] = new Employee("Петр", "Иванович", "Смирнов", 5, 72000);
        employee[5] = new Employee("Петр", "Иванович", "Ларин", 4, 62000);
        employee[6] = new Employee("Петр", "Иванович", "Ложкин", 3, 52000);
        employee[7] = new Employee("Петр", "Иванович", "Яковлев", 2, 67000);
        employee[8] = new Employee("Петр", "Иванович", "Леонов", 5, 77000);
        employee[9] = new Employee("Петр", "Иванович", "Сорокин", 2, 82000);
    }
    public void employeePrint( String reg){
        for (Employee value : employee) {
            if (reg.equals("oll")) {
                System.out.println(value.toString());
            } else if (reg.equals("name")) {
                System.out.println(value.surname + " " + value.name + " " + value.patronymic);
            }
        }
    }
    public void employeePrint(int numDepartment){
        for(int i=0; i<employee.length; i++) {
            if(i==0){
                System.out.println("Список сотрудников отдела "+numDepartment+" :");
            }
            if (employee[i].department==numDepartment) {
                System.out.println(employee[i].surname + " " + employee[i].name + " " + employee[i].patronymic + " " + employee[i].salary);
            }
        }
    }
    public void masStat(){
        double sumCost=0;
        double maxSalary=employee[0].salary;
        double minSalary=employee[0].salary;
        String maxSalaryEmployeeName="";
        String minSalaryEmployeeName="";

        for (Employee value : employee) {
            sumCost += value.salary;
            if (maxSalary < value.salary) {
                maxSalary = value.salary;
                maxSalaryEmployeeName = value.surname + " " + value.name + " " + value.patronymic;
            }
            if (minSalary > value.salary) {
                minSalary = value.salary;
                minSalaryEmployeeName = value.surname + " " + value.name + " " + value.patronymic;
            }
        }
        System.out.println("Сумма затрат на зарплаты в месяц: "+sumCost);
        System.out.println("Сотрудник с минимальной зарплатой: "+minSalaryEmployeeName);
        System.out.println("Сотрудник с максимальной зарплатой: "+maxSalaryEmployeeName);
        System.out.println("Среднее значение зарплат: "+sumCost/10);
    }
    public void masStat(int department){
        double sumCost=0.0;
        double maxSalary;
        maxSalary = employee[0].salary;
        double minSalary=employee[0].salary;
        String maxSalaryEmployeeName="";
        String minSalaryEmployeeName="";


        for (Employee value : employee) {
            if (department == value.department) {
                sumCost += value.salary;
                if (maxSalary < value.salary) {
                    maxSalary = value.salary;
                    maxSalaryEmployeeName = value.surname + " " + value.name + " " + value.patronymic;
                }
                if (minSalary > value.salary) {
                    minSalary = value.salary;
                    minSalaryEmployeeName = value.surname + " " + value.name + " " + value.patronymic;
                }
            }
        }
        System.out.println("Сумма затрат на зарплаты в месяц отдела "+ department +": "+sumCost);
        System.out.println("Сотрудник с минимальной зарплатой: "+minSalaryEmployeeName);
        System.out.println("Сотрудник с максимальной зарплатой: "+maxSalaryEmployeeName);
        System.out.println("Среднее значение зарплат: "+sumCost/10);
    }
    public void indexingSalary(int department, double indexingSalary){
        int indStrDepartment=0;
        int indStrOll=0;
        for (Employee value : employee) {
            if (department == value.department) {
                value.salary += value.salary * indexingSalary / 100;
                if(indStrDepartment==0) {System.out.println("Индексация зарплаты для сотрудников отдела " + value.department);}
                System.out.println(value.surname+" "+value.name+" "+value.patronymic +" "+ value.salary);
                indStrDepartment++;
            } else if (department == 0) {
                value.salary += value.salary * indexingSalary / 100;
                if(indStrOll==0) System.out.println("Индексация зарплаты для всех сотрудников");
                System.out.println(value.surname+" "+value.name+" "+value.patronymic +" "+ value.salary);
                indStrOll++;
            }
        }
    }
    public void masMinSalary(double salary) {
        for (int i = 0; i < employee.length; i++) {
            if (i == 0) {
                System.out.println("Сотрудники с зарплатой ниже " + salary + " :");
            }
            if (employee[i].salary < salary) {
                System.out.println(employee[i].surname + " " + employee[i].name + " " + employee[i].patronymic + " " + employee[i].salary);
            }
        }
    }
    public void masMaxSalary(double salary) {
        for(int i=0; i<employee.length; i++) {
            if(i==0) {
                System.out.println("Сотрудники с зарплатой выше " + salary + " :");
            }
            if(employee[i].salary>=salary){
                System.out.println(employee[i].surname + " " + employee[i].name + " " + employee[i].patronymic+" "+employee[i].salary);
            }
        }
    }
}
