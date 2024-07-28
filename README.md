## Performance

### Java (189.3MiB)

```
CONTAINER ID   NAME         CPU %     MEM USAGE / LIMIT     MEM %     NET I/O           BLOCK I/O    PIDS
5f2aedaa3b72   email-java   0.09%     189.3MiB / 46.99GiB   0.39%     20.5kB / 4.57kB   0B / 246kB   42

REPOSITORY                      TAG                               IMAGE ID       CREATED          SIZE
email-java                      latest                            b45bbd67b066   24 hours ago     467MB
```

### Golang (7.301MiB)

```
CONTAINER ID   NAME         CPU %     MEM USAGE / LIMIT     MEM %     NET I/O           BLOCK I/O    PIDS
96a685e35b0d   email-go     0.00%     7.301MiB / 46.99GiB   0.02%     28.6kB / 6.55kB   0B / 0B      9

REPOSITORY                      TAG                               IMAGE ID       CREATED          SIZE
email-go                        latest                            386407446e76   24 hours ago     560MB
```

### Rust (4.168MiB)

```
CONTAINER ID   NAME         CPU %     MEM USAGE / LIMIT     MEM %     NET I/O           BLOCK I/O   PIDS
63bae4b03826   email-rust   0.05%     4.168MiB / 46.99GiB   0.01%     27.1kB / 6.42kB   0B / 0B     11

REPOSITORY                      TAG                               IMAGE ID       CREATED          SIZE
email-rust                      latest                            b892612fdd3e   24 hours ago     1.42GB
```

## Summary

- Java: Uses the most memory (189.3MiB) and has the highest number of processes (42).
- Golang: Uses significantly less memory (7.301MiB) and has fewer processes (9).
- Rust: Uses the least memory (4.168MiB) and has a moderate number of processes (11).

### Conclusion

- Golang is approximately 25.93 times more lightweight than Java in terms of memory usage.
- Rust is approximately 45.42 times more lightweight than Java in terms of memory usage.