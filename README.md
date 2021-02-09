# kodetest
Implemented an application which can format numerical inputs to written text.

### Pull the application from Docker Hub
```docker pull ayanle3000/kodetest```

### Or build it

Build a new .jar file with 
```mvn clean install```

Then create a docker image
```docker build -f Dockerfile -t kodetest .```

### Run the application
```docker run -p 9000:9000 kodetest```
or
```docker run -p 9000:9000 ayanle3000/kodetest```


### Run the tests
You can run the tests using
```mvn clean test```
