import grpc
import normalizer_pb2
import normalizer_pb2_grpc

from concurrent.futures import ThreadPoolExecutor, wait


def generate_title(index: int) -> str:
    return (
        f'{index} - Smartphone Motorola Moto G32 128GB Preto 4G '
        'Octa-Core 4GB RAM 6,5” Câm. Tripla + Selfie 16MP'
    )

def run():
    with grpc.insecure_channel('localhost:50051') as channel:
        stub = normalizer_pb2_grpc.NormalizerHandlerStub(channel)
        with ThreadPoolExecutor(max_workers=10) as executor:
            futures = [
                executor.submit(stub.normalize, normalizer_pb2.NormalizerRequest(title=generate_title(i)))
                for i in range(1) 
            ]

        wait(futures)
        for f in futures:
            print(f.result(), end='')

if __name__ == '__main__':
    run()
