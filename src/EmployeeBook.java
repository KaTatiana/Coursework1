//        1. Создать класс EmployeeBook.
//        2. Перенести хранилище сотрудников в него (массив), закрыть к нему доступ извне (сделать приватным).
//        3. Все статические методы по работе с массивом перенести в этот класс и сделать нестатическими.

public class EmployeeBook {
    private final Employee[] employees=new Employee[10];

    public EmployeeBook()
    {
    }

    public void masEmployeeBook() {
        employees[0] = new Employee("Иван", "Иванович", "Иванов", 1, 52000);
        employees[1] = new Employee("Петр", "Иванович", "Иванов", 2, 62000);
        employees[2] = new Employee("Петр", "Иванович", "Петров", 2, 42000);
        employees[3] = new Employee("Петр", "Иванович", "Семенов", 3, 92000);
        employees[4] = new Employee("Петр", "Иванович", "Смирнов", 5, 72000);
        employees[5] = new Employee("Петр", "Иванович", "Ларин", 4, 62000);
        employees[6] = new Employee("Петр", "Иванович", "Ложкин", 3, 52000);
        employees[7] = new Employee("Петр", "Иванович", "Яковлев", 2, 67000);
        employees[8] = new Employee("Петр", "Иванович", "Леонов", 5, 77000);
        employees[9] = null; // employees[9] = new Employee("Петр", "Иванович", "Сорокин", 2, 82000);
    }

    public void employeesFullPrint(){
        for (Employee employee : employees) {
            if(employee!=null) {
                System.out.println(employee.toString());
            }
        }
    }
    public void employeesNamePrint(){
        for (Employee employee : employees) {
            if(employee!=null) {
                System.out.println(employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymic());
            }
        }
    }
    // Напечатать всех сотрудников отдела (все данные, кроме отдела)
    public void employeesPrint(int numDepartment){
        System.out.println("Список сотрудников отдела "+numDepartment+" :");
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == numDepartment) {
                System.out.println(employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymic() + " " + employee.getSalary());
            }
        }
    }

    public void employeesSalary(){
        double sumCost=0.0;
        for (Employee employee : employees) {
            if (employee == null) continue;
            sumCost += employee.getSalary();
        }
        System.out.println("Сумма затрат на зарплаты в месяц отдела : "+sumCost);
    }
    public void employeesAverageSalary(){
        double sumCost=0.0;
        for (Employee employee : employees) {
            if (employee == null) continue;
            sumCost += employee.getSalary();
        }
        System.out.println("Среднее значение зарплат: "+sumCost/10);
    }
    public void employeesMinSalary(){
        double minSalary=employees[0].getSalary();
        String minSalaryEmployeeName="";
        for (Employee employee : employees) {
            if (employee == null) continue;
            if (minSalary > employee.getSalary()) {
                minSalary = employee.getSalary();
                minSalaryEmployeeName = employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymic();
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой: "+minSalaryEmployeeName);
    }
    public void employeesMaxSalary(){
        double maxSalary;
        maxSalary = employees[0].getSalary();
        String maxSalaryEmployeeName="";
        for (Employee employee : employees) {
            if (employee == null) continue;
            if (maxSalary < employee.getSalary()) {
                maxSalary = employee.getSalary();
                maxSalaryEmployeeName = employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymic();
            }

        }
        System.out.println("Сотрудник с максимальной зарплатой: "+maxSalaryEmployeeName);
    }
    public void employeesSalary(int department){
        double sumCost=0.0;
        for (Employee employee : employees) {
            if (employee == null) continue;
            if (department == employee.getDepartment()) {
                sumCost += employee.getSalary();
            }
        }
        System.out.println("Сумма затрат на зарплаты в месяц отдела "+ department +": "+sumCost);
    }
    public void employeesAverageSalary(int department){
        double sumCost=0.0;
        for (Employee employee : employees) {
            if (employee == null) continue;
            if (department == employee.getDepartment()) {
                sumCost += employee.getSalary();
            }
        }
        System.out.println("Среднее значение зарплат: "+sumCost/10);
    }
    public void employeesMinSalary(int department){
        double minSalary=employees[0].getSalary();
        String minSalaryEmployeeName="";
        for (Employee employee : employees) {
            if (employee == null) continue;
            if (department == employee.getDepartment()) {
                if (minSalary > employee.getSalary()) {
                    minSalary = employee.getSalary();
                    minSalaryEmployeeName = employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymic();
                }
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой: "+minSalaryEmployeeName);
    }
    public void employeesMaxSalary(int department){
        double maxSalary;
        maxSalary = employees[0].getSalary();
        String maxSalaryEmployeeName="";
        for (Employee employee : employees) {
            if (employee == null) continue;
            if (department == employee.getDepartment()) {
                if (maxSalary < employee.getSalary()) {
                    maxSalary = employee.getSalary();
                    maxSalaryEmployeeName = employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymic();
                }
            }
        }
        System.out.println("Сотрудник с максимальной зарплатой: "+maxSalaryEmployeeName);
    }
    public void indexingSalary(int department, double increasePercent){
        int indStrDepartment=0;
        int indStrFullEmployee=0;
        for (Employee employee : employees) {
            if(employee==null) continue;
            if (department == employee.getDepartment()) {
                employee.setSalary(employee.getSalary() + employee.getSalary() * increasePercent / 100);
                if(indStrDepartment==0) {System.out.println("Индексация зарплаты для сотрудников отдела " + employee.getDepartment());}
                System.out.println(employee.getSurname()+" "+employee.getName()+" "+employee.getPatronymic() +" "+ employee.getSalary());
                indStrDepartment++;
            } else if (department == 0) {
                employee.setSalary(employee.getSalary()+employee.getSalary() * increasePercent / 100);
                if(indStrFullEmployee==0) System.out.println("Индексация зарплаты для всех сотрудников");
                System.out.println(employee.getSurname()+" "+employee.getName()+" "+employee.getPatronymic() +" "+ employee.getSalary());
                indStrFullEmployee++;
            }
        }
    }
    public void masMinSalary(double salary) {
        for (int i = 0; i < employees.length; i++){
            if (employees[i]!=null&&i == 0) {
                System.out.println("Сотрудники с зарплатой ниже " + salary + " :");
            }
            if (employees[i]!=null&&employees[i].getSalary() < salary) {
                System.out.println(employees[i].getSurname() + " " + employees[i].getName() + " " + employees[i].getPatronymic() + " " + employees[i].getSalary());
            }
        }
    }
    public void masMaxSalary(double salary) {
        for(int i=0; i<employees.length; i++) {
            if(employees[i]!=null&&i==0) {
                System.out.println("Сотрудники с зарплатой выше " + salary + " :");
            }
            if(employees[i]!=null&&employees[i].getSalary()>=salary){
                System.out.println(employees[i].getSurname() + " " + employees[i].getName() + " " + employees[i].getPatronymic()+" "+employees[i].getSalary());
            }
        }
    }
}
