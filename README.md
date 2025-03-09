# VetBuddy User Guide

Welcome to **VetBuddy**, your personal assistant for managing tasks efficiently. This guide will help you get started quickly.

---

## **Getting Started**


### **Running VetBuddy from a JAR File**
If you want to run VetBuddy from the source code, follow these steps:

**Prerequisites:**  
- JDK 17
  
**Download & Run VetBuddy**  
   - Download **VetBuddy.jar** latest version from [GitHub Releases](https://github.com/Basudeb2005/ip/releases).  
   - Open a terminal or command prompt and navigate to the download location.
   - Run:
     ```sh
     java -jar VetBuddy.jar
     ```

---

## **Features and Commands**

VetBuddy helps manage your tasks with simple commands.

### **1. Adding Tasks**
- **Todo**: Adds a basic task.  
  ```
  todo <task description>
  ```
  Example:  
  ```
  todo Buy groceries
  ```

- **Deadline**: Adds a task with a deadline.  
  ```
  deadline <task description> /by <date/time>
  ```
  Example:  
  ```
  deadline Finish report /by Monday 5pm
  ```

- **Event**: Adds an event with a start and end time.  
  ```
  event <task description> /from <start time> /to <end time>
  ```
  Example:  
  ```
  event Team meeting /from 2pm /to 4pm
  ```

---

### **2. Managing Tasks**
- **List all tasks**:  
  ```
  list
  ```
  Example output:
  ```
  Here are the tasks in your list:
  1. [T][ ] Buy groceries
  2. [D][ ] Finish report (by: Monday 5pm)
  3. [E][ ] Team meeting (from: 2pm to: 4pm)
  ```

- **Mark a task as done**:  
  ```
  mark <task number>
  ```
  Example:  
  ```
  mark 2
  ```

- **Unmark a task**:  
  ```
  unmark <task number>
  ```
  Example:  
  ```
  unmark 2
  ```

- **Delete a task**:  
  ```
  delete <task number>
  ```
  Example:  
  ```
  delete 3
  ```

---

### **3. Finding Tasks**
- **Search for tasks by keyword**:  
  ```
  find <keyword>
  ```
  Example:  
  ```
  find meeting
  ```

---

### **4. Exiting**
- **Quit the application**:  
  ```
  bye
  ```
  Example output:
  ```
  =================================================
  Bye. Hope to see you again soon!
  =================================================
  ```
---

## **Conclusion**
VetBuddy helps you stay organized with simple commands to manage your tasks effectively. Try it out today and simplify your workflow!

