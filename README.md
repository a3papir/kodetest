# kodetest
Implemented an application which can format numerical inputs to written text.

## Build the application
Build a new .jar file with 
```mvn clean install```

Then create a docker image
```docker build -f Dockerfile -t kodetest .```

### Or just pull it from Docker Hub
```docker pull ayanle3000/kodetest```

### Running the application
```docker run -p 9000:9000 kodetest```
or
```docker run -p 9000:9000 ayanle3000/kodetest```


### Running the tests
You can run the tests using
```mvn clean test```
