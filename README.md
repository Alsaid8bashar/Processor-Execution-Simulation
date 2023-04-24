Processor Execution Simulator

This project is a simulation of processor execution for tasks or processes. The simulator receives an input text file that describes all tasks' information, including creation time, execution time, and priority. Based on this information, the simulator simulates the processor's execution of tasks.

The simulator has a fixed number of processors that are synchronized, i.e., they all have the same clock. Each processor is given a unique ID, and the clock cycles are also given unique IDs. Tasks are assigned unique IDs as well. A processor can execute only one task at a time. If there are multiple processors, a maximum of one task can run on each processor.

The simulator has a queue for holding tasks. When a task is created, it is automatically added to the queue. The simulator has a scheduler that is responsible for determining the assignment of tasks waiting in the queue to processors that are available. If there is a processor available, the scheduler prioritizes the assignment of tasks with high priority over tasks with low priority. In case of a tie, the scheduler chooses the task with the longest execution time. If still a tie, the scheduler chooses any task at random. 

The task execution cannot be interrupted. If a task has started executing on a processor, it holds this processor until its execution is complete. Task creation time is negligible, which means that if a task is created during cycle N, and there is an available processor, it can be immediately assigned to this processor in the same cycle N.

The simulator takes three arguments as input. The first argument is an integer that represents the number of processors. The second argument is an integer that represents the total number of clock cycles in the simulation. The third argument is a string that represents the path to the text file that contains tasks' information.

The simulator produces a cycle-by-cycle report about important events during the simulation, such as created tasks, running tasks, completed tasks, and the processor's state. The report is printed on the console, and it provides insights into the simulation's progress. The report is designed to be simple, readable, and informative.

The project implements various design patterns and data structures to ensure efficient and scalable task scheduling. It provides a flexible and robust framework for simulating processor execution and can be used to gain insights into the performance of different scheduling algorithms.

Overall, this project demonstrates the power of simulation in modeling complex systems and provides a solid foundation for building more sophisticated simulations in the future.
