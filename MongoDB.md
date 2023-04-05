# MongoDB Setup
We will get a MongoDB server running on our system at port 27017 (The default MongoDB port).

## Setup MongoDB Server
There are several ways to setup this MongoDB server. I will walk through one of them.

### Method 1: Docker
#### 1. Follow instructions to install [Docker](https://docs.docker.com/get-docker) on your system.
> *Note: There are also many ways to install Docker on your system. If you install Docker Desktop, it should include a plugin called **Compose**, which will allow us to follow the rest of this section. Otherwise, you can follow other installation methods, or use a different method than Docker to setup the MongoDB database.*

#### 2. Create the server and database using docker compose
There is a file called `docker-compose.yml` in the root of this directory with instructions for the plugin to install, run and start a MongoDB server. Activate this by running the following:
```shell
docker compose up;
```
> *Note: The above command maybe different depending on the system or installation method.*

At this point, we now should have our server setup and accessible from our Java application.