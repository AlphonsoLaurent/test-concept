1.- compilar #con este comando ya genera la imagen docker
mvn clean install 



Docker

cmd+p+q = es para salir del bach de un docker

#docker ps ===== listado de docker que están corriendo
docker ps -a

#docker run -it name nombre_nueva_docker nombre_del_docker original 

#docker attach id_docker para acceder el modo bach
Example: docker attach 33082c44de44

# Detener todos los contenedores
$ docker stop $(docker ps -a -q)

# Borrar todos los contenedores
$ docker rm $(docker ps -a -q)

# Borrar todas las imagenes
$ docker rmi $(docker images -q)

Para crear una nueva image de un docker
Respaldar un docker con los cambios hechos en ella
Docker commit id-image-del-docker
Example: docker commit f75580fc9ef8

Levantar un docker con volumen 
docker run -d -p 49165:22 -p 49161:1521 -p 49162:8080 -v $(pwd)/data:data arahman/docker-oracle-xe-11g /sbin/my_init
LEVANTA EL SERVIDOR DE BASE DE DATOS ORACLE


docker start 1d56d083f4d8


docker run -d -p 8095:8095 -v $(pwd)/data:data proof-of-concept/proof-of-concept:0.0.1-SNAPSHOT




docker run -d -p 8081:8888 -v $(pwd)/ proof-of-concept:latest


docker run -d -it --name micro1 -p 8082:8888 -v $(pwd)/ proof-of-concept:latest

dockers
docker run -d -it --name oracle-xe-alt -v  /Users/Shared/oracle/xe/data:/sbin/my_init arahman/docker-oracle-xe-11g


BORRA TODOS LOS DOCKERS CON STATUS EXITED
docker ps -aq -f status=exited | xargs docker rm 

Eliminar todas las imágenes de docker

docker rmi $(docker images -q)



Este comando borra todos los dockers que no tienen tag <none>

docker rmi $(docker images -f "dangling=true" -q)


Este comando borra y forza borrar ademas dependencias que lo están usando

docker rmi -f 5736493873a9


Docker stop {nombre del docker}
Docker start {nombre del docker}


Si desea eliminar solo los contenedores con un estado dead :

docker rm $(docker ps --all -q -f status=dead)



kubectl run kubernetes-bootcamp --image= proof-of-concept:latest --port=8085

kubectl run kubernetes-bootcamp --image=gcr.io/google-samples/kubernetes-bootcamp:v1 --port=8080

 



2.- mvn clean install

3.- docker run -d -it --name desambdv2 -p 8083:8090 -v $(pwd)/ desam:latest



docker run -d -it --name desambdvn -p 8089:8090 -v $(pwd)/ desam:latest






 

