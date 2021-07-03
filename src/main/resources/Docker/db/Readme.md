## Comandos 
### Build
docker build -t wbaamaral/algamoneydb .
### Push Dockerhub
docker push wbaamaral/algamoneydb:latest
### Docker run
docker run -e MYSQL_ROOT_PASSWORD=root -p 3306:3306 --name faas -d wbaamaral/algamoneydb:latest