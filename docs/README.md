# User Guide
Tobias's Duke
## Features 
Managing todos, deadlines and events 
Duke is in charge of listing and keeping track of your tasks (todos,deadlines and events)

Saving and Loading
Duke also automatically saves your current list into your computer
and automatically uploads the saved list everytime you start a new session

### Task Management Commands

#### Add tasks to a list - `todo` / `deadline` / `event`
Allows user to add tasks of different types to their list

* ToDos: tasks without any due date/time 

* Deadlines: tasks that needs to be completed before a specific date/time

* Events: tasks that start at a specific time and ends at a specific time

#### List tasks - `list`
Allows the user to display back to them their list of task

#### Find tasks - `find`
Allows the user to search for tasks that contains the keyword

#### Mark as Done - `done`
Allows the user to mark tasks as done

#### Delete a task in list - `delete`
Allows the user to remove an unwanted task from the list

#### Exit Duke - `bye`
Allows the user to exit Duke

## Command Usage

### Add
Adds a task to the list

Format - `todo <task description>` / `deadline <task description /by <date/time>` / `event <task description> /at <date/time>`

Important Note - date/time format: d-MM-yyyy HHmm

#### Example of Usage:
* Todo
`todo read a book`

* Deadline
`deadline do assignment /by 2-12-2020 1800`

* Event 
`event carnival /at 2-02-2021 0900`

#### Expected Outcome:
* Todo 
```
____________________________________________________________
Got it. I've added this task:
  [T][✘] read a book
Now you have 1 task in the list.
____________________________________________________________
```

* Deadline 
```
____________________________________________________________
Got it. I've added this task:
  [D][✘] do assignment (by: Dec 02 2020 1800)
Now you have 2 task in the list.
____________________________________________________________
```

* Event 
```
____________________________________________________________
Got it. I've added this task:
  [E][✘] carnival (at: Feb 02 2021 0900)
Now you have 3 task in the list.
____________________________________________________________
```

### List
lists out all tasks present in the list 

Format - `list`

#### Example of Usage:
`list`

#### Expected Outcome:
```
____________________________________________________________
Here are the tasks in your list:
1.[T][✘] read a book
2.[D][✘] do assignment (by: Dec 02 2020 1800)
3.[E][✘] carnival (at: Feb 02 2021 0900)
____________________________________________________________
```

### Find
Finds and list all task that matches the keyword

Format - `find <keyword>`

#### Example of Usage:
`find book`

#### Expected Outcome:
```
____________________________________________________________
Here are the matching tasks in your list:
1.[T][✘] read a book
____________________________________________________________
```

### Done 
Marks a task in the list at the index provided as done

Format - `done <task index>`

#### Example of Usage:
`done 1`

#### Expected Outcome:
```
____________________________________________________________
Nice! I've marked this task as done:
[T][✓] read a book
____________________________________________________________
```

### Delete
Deletes a task in the list at the index provided by the user

Format - `delete <task index>`

#### Example of Usage:
`delete 1`

#### Expected Outcome:
```
____________________________________________________________
Noted. I've removed this task:
[T][✓] read a book
Now you have 2 tasks in the list.
____________________________________________________________
```

### Exit 
Exits duke programme 

#### Example of Usage:
`bye` 

#### Expected Outcome:
```
____________________________________________________________
Bye. Hope to see you again soon!
____________________________________________________________

Process finished with exit code 0
```
