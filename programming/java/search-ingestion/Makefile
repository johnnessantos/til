.PHONY=up
up:
	@docker compose up -d

.PHONY=down
down:
	@docker compose down

.PHONY=create-product
create-product:
	@curl -X POST http://localhost:8080/products -H "Content-type: application/json" -d '{"title": "product 1", "description": "description of product 1"}'
	@curl -X POST http://localhost:8080/products -H "Content-type: application/json" -d '{"title": "product 2", "description": "description of product 2"}'

.PHONY=search-product
search-product:
	@curl -X GET http://localhost:8080/products?title=product -H "Content-type: application/json"

.PHONY=create-products-index
create-products-index:
	@echo "Creating products index"
	@sleep 10
	@curl -X PUT http://localhost:9200/products?pretty -H 'Content-Type: application/json' -d '{"settings": {"number_of_shards": 1},"mappings": {"properties": {"uuid": { "type": "text" }, "title": { "type": "text" }, "description": { "type": "text" }}}}'

.PHONY=run
run: up create-products-index
	@cd ./api-indexer/ && ./gradlew bootRun
