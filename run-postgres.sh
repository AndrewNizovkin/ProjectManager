docker run -d --name postgres-container -e POSTGRES_DB=projectdb -e POSTGRES_USER=andrew -e POSTGRES_PASSWORD=1234 -p 5432:5432 -v /home/andrew/projectdb:/var/lib/postgresql/data postgres:alpine3.19
