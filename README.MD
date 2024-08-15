# Functional Design: Principles, Patterns And Practices

# Functional Basics

## Immutability

- What Is Functional Programming?
  Programming without assignment statements.

```
main() {
    while(!done())
        doSomething();
}
```

- Sum first 10 squares
  [SumFirstSquares.java](src%2Fmain%2Fjava%2Fcom%2Fsaga%2Fsaml%2FSumFirstSquares.java)

If you want to get rid of assignment statements, you have to use recursion
instead of creating a new stack frame for the recursive call, we simply reused the current stack frame by jumping back
to the top of the function
This is called tail call optimization (TCO) and all functional languages make use of it.

### The Problem with Assignment

functional programming is programming without variables.
The values in functional programs do not vary.

- Why?
  //Block A
  …
  x=1;
  ...
  //Block B
  ...

The state of the system during the execution of Block A is different from the state of the system in Block B
This meansthat Block A must execute before Block B
This is called a sequential or temporal coupling
When multiple threads are competing for the processor
keeping the temporal couplings in the correct order becomes a challenge
every once in a great while they may execute in the wrong order
We call those situations race conditions.

- Where would you put a log line? log("i=%d, sum=%d", i, sum);

```
1: int sumFirstTenSquaresHelper(int sum, int i) {
2:  while (i<=10) {
3:    sum+=i*i;
4:    i++;
5:  }
6:  return sum;
7: }
```

- There are three possibilities.
- after line 2 or 4, then the logged data will be correct
- If you insert the log statement after line 3, then the logged data will be incorrect
- That is a temporal coupling
- For functional programming there is no such a problem

```
int sumFirstTenSquaresHelper(int sum, int i) {
return (i>10) ? sum : sumFirstTenSquaresHelper(sum+i*i, i+1);
}
```

### So Why Is It Called Functional?

- A function is a mathematical object that maps inputs to outputs.
- Given y = f(x). If you give x to f, you will get y every single time.
- The state of the system in which f executes is irrelevant to f.
- A function is referentially transparent if you can always replace the function call with its value

### No Change of State?

- functional programs compute a new state from an old state, without changing the old state
- we can create a “functional” program that responds quite nicely to input events

```
State system(State state, Event event) {
 return done(state) ? state : system(state, getEvent)
}
```

### Immutability

- The values we name are all constants.
- In spirit, the entire history of every one of those constants remains intact, unchanged, and immutable.

## Persistent Data

### Making Copies

- We can’t be changing elements in existing arrays,
- That would make those arrays variables.
- So we’ll have to make copies of them whenever we need to change an element

### Structural Sharing

- structures that behave very much like arrays
- but that also efficiently maintains the history of their past states.
- These data structures are n-ary trees

### Recursion and Iteration

two different varieties of recursion;

- Traditional Recursion: A function calls itself directly to solve a problem by breaking it down into smaller instances
  of the same problem until reaching a base case.
  - More memory consuption caused by duplicated variables on each frame (without TCO)

[FactorialRecursion.java](src%2Fmain%2Fjava%2Fdev%2Fjgregorio%2Fcourse%2Ffunctiona%2Fdesign%2Ffunctional%2Fbasics%2FFactorialRecursion.java)```

- Iteration (as a form of recursion): uses loops to mimic recursion, avoiding direct self-calls and potentially
  offering better performance through tail call optimization.
  - Less memory consuption as variables result and n are not duplicated
  
[FactorialIterative.java](src%2Fmain%2Fjava%2Fdev%2Fjgregorio%2Fcourse%2Ffunctiona%2Fdesign%2Ffunctional%2Fbasics%2FFactorialIterative.java)

## Laziness
- A lazy list is an object that knows how to compute its next value. 
- we called such objects iterators.
- When we executed the def that created list-of-fibs , no Fibonacci numbers were calculated, and no memory was allocated 
- The calculations only take place, and the memory is only allocated, as the elements of the list are accessed

## Statefulness



