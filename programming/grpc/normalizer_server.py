import logging
from concurrent import futures
from os import getenv
from json import dumps

import grpc
from time import time
import normalizer_pb2
import normalizer_pb2_grpc

import re
import string


punctuation = str.maketrans({key: None for key in string.punctuation})


LOGGING_FORMATTER = {
    'time': '%(asctime)s',
    'severity': '%(levelname)s',
    'source_code': '%(name)s:%(lineno)d',
    'process_id': 'pid:%(process)d %(threadName)s',
    'message':'%(message)s',
}

logging.basicConfig(
    level=logging.INFO,
    format=dumps(LOGGING_FORMATTER),
)

logger = logging.getLogger(__name__)

class Normalizer:
    def normalize(self, text: str) -> str:
        try:
            text = text.encode('raw_unicode_escape').decode('utf-8')
        except UnicodeDecodeError:
            pass

        text = text.lower().translate(punctuation)
        text = re.sub(r'\s+', ' ', text)
        text = text.strip()
        return text


class Handler(normalizer_pb2_grpc.NormalizerHandlerServicer):

    def normalize(self, request, context):
        start_time = time()
        response = normalizer_pb2.NormalizerResponse(
            title=Normalizer().normalize(request.title)
        )
        start_time = time() - start_time
        logger.info(f'Receive request with title:{request.title} in {start_time:.3f}s')
        return response


def serve():
    GRPC_PORT = getenv('GRPC_PORT', '50051')
    GRPC_MAX_WORKERS = int(getenv('GRPC_MAX_WORKERS', 10))
    

    server = grpc.server(
        futures.ThreadPoolExecutor(max_workers=GRPC_MAX_WORKERS)
    )

    normalizer_pb2_grpc.add_NormalizerHandlerServicer_to_server(Handler(), server)

    server.add_insecure_port('[::]:' + GRPC_PORT)
    server.start()

    server.wait_for_termination()


if __name__ == '__main__':
    serve()