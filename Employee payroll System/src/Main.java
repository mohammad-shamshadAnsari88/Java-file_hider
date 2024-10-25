import java.util.ArrayList;

abstract class Employee{

    private String name;
    private int id;


    public Employee(String name, int id){
        this.name = name;
        this.id =id;
    }

    public String getName(){
        return name;
    }

    public  int getId(){
        return id;
    }


  public abstract double calculateSalary();

  @Override
  public String toString(){
      return " Employee [name ="+name+", id= "+id+",salary = "+calculateSalary()+"]";
  }
}

 class FullTimeEmployee extends Employee{

    private double monthlySalary;


    public FullTimeEmployee(String name, int id , double monthlySalary){

      //if we want to use parent class's constructor use "Super keyword"

        super(name , id);
        this.monthlySalary =monthlySalary;

    }

     @Override
     public double calculateSalary() {
         return monthlySalary;
     }
 }

 class PartTimeEmployee extends Employee {

    private int hoursWorked;
    private double hourlyRate;


    public PartTimeEmployee(String name, int id , int hoursWorked, double hourlyRate){
        super(name,id);
        this.hoursWorked =hoursWorked;
        this.hourlyRate = hourlyRate;

    }

    @Override
     public double calculateSalary(){
        return hoursWorked * hourlyRate ;
    }
 }

 class PayRollSystem{

    private ArrayList<Employee>  employeeList;

    public PayRollSystem(){
        employeeList = new ArrayList<>();
    }
    public  void  addEmployee(Employee employee){

        employeeList.add(employee);

    }
    public void removeEmployee(int id){

        Employee employeeToRemove = null;

        for (Employee employee : employeeList ){
            if(employee.getId()==id){
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null){
            employeeList.remove(employeeToRemove);
        }
    }
     public void displayEmployee(){
        for (Employee employee : employeeList){
            System.out.println(employee);
        }


     }
 }




public class Main {
    public static void main(String[] args) {

PayRollSystem payRollSystem = new PayRollSystem();
FullTimeEmployee emp1 = new FullTimeEmployee("abhi" ,1,70000);
PartTimeEmployee emp = new PartTimeEmployee( "lovely" , 2 , 40 , 150 );

payRollSystem.addEmployee(emp1);
payRollSystem.addEmployee(emp);

        System.out.println("initial Employee Details : ");
        payRollSystem.displayEmployee();

        payRollSystem.removeEmployee(2);
        System.out.println(" Remaining Employee Details : ");
        payRollSystem.displayEmployee();


    }
}