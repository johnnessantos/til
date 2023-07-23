up:
	@docker compose up -d

down:
	@docker compose down

create-product:
	curl -X POST http://localhost:8080/products -H "Content-type: application/json" -d '{"title": "product 1", "description": "description of product 1"}'
