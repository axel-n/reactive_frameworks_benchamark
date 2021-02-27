# spring-webflux simple project

## config
testing with emulate read,write to database
read=(min=150ms, max=200ms)
write=(min=200ms, max=300ms)

## apache ab results
Concurrency Level:      1000
Time taken for tests:   1.529 seconds
Complete requests:      30000
Failed requests:        0
Total transferred:      4050000 bytes
HTML transferred:       1920000 bytes
Requests per second:    19623.50 [#/sec] (mean)
Time per request:       50.959 [ms] (mean)
Time per request:       0.051 [ms] (mean, across all concurrent requests)
Transfer rate:          2587.08 [Kbytes/sec] received

Connection Times (ms)
min  mean[+/-sd] median   max
Connect:        0   23   2.9     23      34
Processing:     8   27   5.2     26      60
Waiting:        0   20   4.9     19      49
Total:         30   50   5.2     48      85
