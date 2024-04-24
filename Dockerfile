# Use official MySQL image
FROM mysql:latest

# Environment variables
ENV MYSQL_ROOT_PASSWORD=root
ENV MYSQL_DATABASE=AOS_DEMO
ENV MYSQL_USER=AOS_DEMO_USER
ENV MYSQL_PASSWORD=aos_pass

EXPOSE 3306