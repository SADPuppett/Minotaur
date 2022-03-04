Samuel Hearn

To run my code run the following prompts for the relevant problem.

javac MinotaurVase.java
java MinotaurVase

javac MinotaurMaze.java
java MinotaurMaze

For the Maze Problem, I did made a the number of threads 10 and while i could have made 
it possible for input to change this I felt it wasnt needed to see its functionality.
The theory behind is is that the leader is the first person who enters or someone the group designated
before the maze travelling started. He is the only person who replaces the cupcake. 
When another person goes they eat the cake, and stop entering the maze on subsequent runs or stop eating the 
cake. 
This continues until the leader sees that the cupcake is not missing, because then no one 
ate the cupcake he replaced meaning they have all ate and can tell the minotaur they have all gone eaten.

For the minotaur's vase problem I chose the thrid option. This one's performance is the best because with the queue 
not all the threads constantly looking at the room if its available, the current thread simply notifies the next one when the
room is available instead. I also decided to put the sleep function inside the thread to show the process
of actually viewing the room.