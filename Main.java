    package Projects.ToDoList;

    import java.util.ArrayList;
    import java.util.Scanner;
    import java.util.InputMismatchException;

    public class Main {
        public static void main(String[] args) {

            ArrayList<Task> tasks = new ArrayList<>();
            Scanner input = new Scanner(System.in);
            
            while(true){
                System.out.println("\n=== To-DO List ===");
                System.out.println("1. Add task");
                System.out.println("2. View tasks");
                System.out.println("3. Mark task as completed");
                System.out.println("4. Delete task");
                System.out.println("5. Exit");

                System.out.print("\nEnter your choice: ");
                int choice = input.nextInt();
                input.nextLine(); // to clear newline

                switch(choice){
                    case 1:
                        System.out.print("Enter task name: ");
                        String taskName = input.nextLine();
                        if(taskName.isEmpty()) {
                            System.out.println("Task name cannot be empty!");
                            
                        } else {
                            tasks.add(new Task(taskName));
                            System.out.println("Task added successfully!");
                        }
                        break;
                    
                    case 2:
                        System.out.println("\n=== To-DO List ===");
                        if(tasks.isEmpty()){
                            System.out.println("No tasks found!");
                        }
                        else{
                            for(int i = 0; i < tasks.size(); i++){
                                System.out.println((i+1) + ". " + tasks.get(i));
                            }
                        }
                        break;

                    case 3: 
                        int markNum = 0;
                        try {
                            System.out.print("Enter task number to mark as completed: ");
                            markNum = input.nextInt();
                            input.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input, please enter a number.");
                            input.nextLine();
                            break;
                        }
                        if (markNum > 0 && markNum <= tasks.size()) {
                            tasks.get(markNum - 1).markCompleted();
                            System.out.println("Task marked as completed!");
                        } else {
                            System.out.println("Invalid task number.");
                        }
                        break;
                    
                    case 4:
                        int removeIndex = 0;
                        try {
                            System.out.print("Enter task number to remove: ");
                            removeIndex = input.nextInt();
                            input.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input, please enter a number.");
                            input.nextLine();
                            break;
                        }
                        if (removeIndex > 0 && removeIndex <= tasks.size()) {
                            tasks.remove(removeIndex - 1);
                            System.out.println("Task removed successfully!");
                        } else {
                            System.out.println("Invalid task number.");
                        }
                        break;

                    case 5:
                        System.out.println("Exiting... Have a productive day!");
                        input.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }
                
            }
            
        }
        
    }