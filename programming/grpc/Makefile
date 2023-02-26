PROTO_OUTPUT=.

complile-protos:
	@python -m grpc_tools.protoc -I ./protos \
		--python_out=${PROTO_OUTPUT} \
		--pyi_out=${PROTO_OUTPUT} \
		--grpc_python_out=${PROTO_OUTPUT} ./protos/*.proto

clear:
	@find . | grep -E "(__pycache__|\.pyc|_pb)" | xargs rm -rf

run-greeter-server:
	@python greeter_server.py

run-greeter-client:
	@python greeter_client.py