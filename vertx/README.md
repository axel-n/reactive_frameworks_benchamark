# vertx simple project

## config
testing with emulate read,write to database
```
read=(min=150ms, max=200ms)
write=(min=200ms, max=300ms)
```

## apache ab results
just run in IDE and run several times

```
Concurrency Level:      1000
Time taken for tests:   1.261 seconds
Complete requests:      30000
Failed requests:        0
Total transferred:      4500000 bytes
HTML transferred:       1920000 bytes
Requests per second:    23795.08 [#/sec] (mean)
Time per request:       42.025 [ms] (mean)
Time per request:       0.042 [ms] (mean, across all concurrent requests)
Transfer rate:          3485.61 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0   16   2.9     16      32
Processing:     7   25   4.5     25      41
Waiting:        0   19   4.7     20      38
Total:         21   41   4.2     41      54

```
