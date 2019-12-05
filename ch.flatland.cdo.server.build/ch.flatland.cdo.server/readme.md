docker build -t 3ap-cdo .
docker run -p 8080:8080 --name 3ap-cdo  3ap-cdo:latest
docker stop 3ap-cdo
docker rm 3ap-cdo


docker tag bf471c2c8677 robao/3ap-cdo:latest
docker push robao/3ap-cdo
