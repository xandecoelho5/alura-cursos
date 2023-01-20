test:
	@ ./mvnw test

package:
	@ ./mvnw clean package -DskipTests

docker-image-build: package
	@ docker build -t caelum/clines-api .

run: docker-image-build
	@ docker-compose up -d

stop:
	@ docker-compose down -v

deploy: docker-image-build
	@ heroku container:login
	@ heroku container:push web
# 	@ make deploy_on_heroku

deploy_on_heroku:
	@ heroku container:release web
