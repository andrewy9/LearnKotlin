# Structured Concurrency


## Combination of language features and best practices
- Cancel work when no longer needed
- Keep track of work while it's running
- Signal errors on failure


### Need to ensure That coroutines are not 'lost' 
- Can lead to leaked resources


### Cancellations needs to be managed
- More details later


### Exceptions need to be managed
- More details later


### Coroutines can be only bne launched within a scope
- This delimits within a scope of the coroutine (CoroutineBuilder)
- Gives mechanism to manage the coroutine

## GlobalScope

### What's wrong with 'Global' scope
- Working with a large scope (the largest possible in this case) is very difficult
    > [ e.g.] Suppose a coroutine's lifetime is tied to the UI.
    > - Need to cancel the scope when the UI element is destroyed
    > - We need to limit the cancellation of the coroutine to a specific to the UI
    > - GlobalScope will however cancel ALL the scope 

- What we do instead
  - coroutineScope
  - also supervisorScope (more later)
  - create own scope (more later)


## Use coroutineScope

### Use this to create a scope for the coroutines (coroutineScope builder)
- Provide parallel decomposition of work
  > When coroutineScope is created, multiple other coroutines can be created within which
  > can be run in parallel. 
- Scope ends when all coroutines end
  > CoroutineScope won't end until all the nested coroutines inside do.

## Best Practices

### Structured Concurrency has some best practices
- Never use GlobalScope
- Never block the calling thread in a suspended function
- When a suspend function returns, all of its work is done