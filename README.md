# CompletableFuture
s
## Overview
This Java project demonstrates the usage of `CompletableFuture` methods, including:
- `runAsync()`
- `supplyAsync()`
- `thenApplyAsync()`
- `thenAcceptAsync()`
- `thenRunAsync()`

The program performs three main tasks asynchronously:
1. Generate a sequence of natural numbers, calculate the minimum sum of consecutive pairs, and display the result.
2. Generate a 3x3 matrix, display each column asynchronously, and demonstrate `thenRunAsync`.
3. Generate a sequence of real numbers, calculate a specific result using min and max functions, and display the result.

The execution time of all tasks is logged.



## How to Run

1. **Clone the repository:**
   ```bash
   git clone git@github.com:eLQeR/KP-4-JAVA.git
   cd completablefuture-demo
   ```

2. **Compile the project:**
   ```bash
   javac CompletableFutureDemo.java
   ```

3. **Run the program:**
   ```bash
   java CompletableFutureDemo
   ```

4. **View Logs:**
   The results and execution times will be displayed in the console.

## Expected Output
- A random sequence of natural numbers with their minimum sum of consecutive pairs.
- A 3x3 matrix displayed by columns.
- A random sequence of real numbers with the calculated result.
- Execution time for all tasks.

## Author
Developed by Ярослав Бізюк ТВ-22

## License
This project is licensed under the MIT License.

