FROM nginx:latest
LABEL image="tnas/alticci-spa"
LABEL version="1.0"
LABEL description="SPA Application for Alticci Sequence"
WORKDIR /etc/nginx
COPY ./nginx.conf ./conf.d/default.conf
COPY ./dist/alticci /usr/share/nginx/html
EXPOSE 8000
