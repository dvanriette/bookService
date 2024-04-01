docker network create netSEN300
docker run -d --name SEN300BasketServiceDBRedis -p 6379:6379 --net netSEN300 redis:latest

docker build -t sen300basketserviceapi:1 .
docker run -d -p 8082:8080 --name SEN300BasketServiceAPI --net netSEN300 sen300basketserviceapi:1
