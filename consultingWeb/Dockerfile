### STAGE 1: Build ###
FROM node:16.10-alpine AS build
WORKDIR /usr/src/app
COPY ./consultingWeb/package.json ./consultingWeb/package-lock.json ./
RUN npm install
COPY ./consultingWeb/ .
RUN npm run build
### STAGE 2: Run ###
FROM nginx:1.17.1-alpine
COPY ./consultingWeb/nginx.conf /etc/nginx/nginx.conf
COPY --from=build /usr/src/app/dist/consulting-web /usr/share/nginx/html