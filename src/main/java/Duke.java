import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Duke {

    public static void printLine() {
        System.out.println("    ____________________________________________________________");
    }

    public static void main(String[] args) {
        String logo = "      ____        _        \n"
                + "     |  _ \\ _   _| | _____ \n"
                + "     | | | | | | | |/ / _ \\\n"
                + "     | |_| | |_| |   <  __/\n"
                + "     |____/ \\__,_|_|\\_\\___|\n";
        printLine();
        System.out.println(logo);
        printLine();
        System.out.println("    Hey there! I'm Duke");
        System.out.println("    What can I do for you?");
        printLine();

        Scanner scanner = new Scanner(System.in);
        List<Task> list = new ArrayList<>();
        while (true) {
            String token = scanner.nextLine();
            // String[] words = token.split("/");
            String[] split = token.split(" ", 2);
            if (token.equals("bye")) {
                printLine();
                System.out.println("    Bye. Hope to see you again soon!");
                printLine();
                break;
            } else if (token.equals("list")) {
                printLine();
                System.out.println("     Here are the tasks in your list:");
                for (int i = 0; i < list.size(); i++) {
                    System.out.println("     " + (i + 1) + ". " + list.get(i));
                }
                printLine();
            } else if (split[0].equals("done")) {
                int num = Integer.parseInt(split[1]) - 1;
                list.get(num).markDone();
                printLine();
                System.out.println("     Nice! I've marked this task as done: ");
                System.out.println("       " + list.get(num));
                printLine();
            } else {
                char tag = split[0].toUpperCase().charAt(0);
                Task task = new Task(token);
                if (tag == 'T') {
                    task = new Todo(split[1]);
                    list.add(new Todo(split[1]));
                } else if (tag == 'D') {
                    task = new Deadline(split[1]);
                    list.add(new Deadline(split[1]));
                } else if (tag == 'E') {
                    task = new Event(split[1]);
                    list.add(new Event(split[1]));
                }
                printLine();
                System.out.println("     Got it. I've added this task: ");
                System.out.println("       " + task);
                System.out.println("     Now you have " + list.size() + " tasks in the list.");
                printLine();
            }
        }
    }
}

