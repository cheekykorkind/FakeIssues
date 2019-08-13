#!/bin/sh

# echo color
RED='\033[1;31m'
GREEN='\033[0;32m'
NC='\033[0m' # No Color


if [ $1 != "up" ] && [ $1 != "down" ]; then
    echo "${RED}Use up or down.${NC}"
    exit 1
fi

UID=$(id -u $USER)
GID=$(id -g $USER)
UNAME=$(echo "$USER")
MY_DOCKER_IMAGE_NAME="fake_issue"

cp docker-compose.yml docker-compose-copy.yml

sed -i "s/\(UID=70000\)/UID=${UID}/" docker-compose-copy.yml
sed -i "s/\(GID=70000\)/GID=${GID}/" docker-compose-copy.yml
sed -i "s/\(vagrant1\)/${UNAME}/" docker-compose-copy.yml
sed -i "s/\(dynamic_uid_image\)/${MY_DOCKER_IMAGE_NAME}/" docker-compose-copy.yml

echo "${GREEN}docker-compose-copy.yml created${NC}"

if [ $1 = "up" ]; then
    docker-compose -f docker-compose-copy.yml build --no-cache ${MY_DOCKER_IMAGE_NAME} \
    && echo "${GREEN}Additional step : docker-compose build --no-cache ${MY_DOCKER_IMAGE_NAME} ${NC}" \
    && docker-compose -f docker-compose-copy.yml up -d \
    && echo "${GREEN}Additional step : docker-compose up -d ${NC}" \
    && docker exec ${MY_DOCKER_IMAGE_NAME} chown -R ${UNAME}:${UNAME} /home/${UNAME}/opt \
    && echo "${GREEN}Additional step : docker exec ${MY_DOCKER_IMAGE_NAME} chown -R ${UNAME}:${UNAME} /home/${UNAME}/opt ${NC}" \
    && echo "${GREEN}Additional finish : You can use [docker-compose -f docker-compose-copy.yml] instead of docker-compose${NC}"
else
    docker-compose -f docker-compose-copy.yml down && echo "${GREEN}docker-compose down${NC}"
    rm docker-compose-copy.yml && echo "${GREEN}docker-compose-copy.yml removed${NC}"
fi