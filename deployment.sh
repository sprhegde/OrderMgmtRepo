#!/bin/sh

gcloud compute ssh --zone us-central1-a sprhegde@instance-1 

docker login -u _json_key -p '$(cat sprhegde-d8b0d97ec19d.json)'  https://gcr.io 
  
set -e 
  
set -x 

source ~/.bashrc

docker images
  
pwd
      
docker-compose up

