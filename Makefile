go:
	make rebuild && \
	make dev

rebuild:
	cd stopapp && \
	mvn clean package

dev:
	docker-compose up --build

run:
	docker-compose up --build -d

stop:
	docker-compose down

clear:
	docker-compose down --rmi all --remove-orphans