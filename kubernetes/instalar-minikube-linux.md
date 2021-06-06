# Instalando e configurando Kubernetes
O kubernetes pode ser usado em ambiente de desenvolvimento/local ou em produção em nuvem ou datacenters **on-premises**. Portanto, para fins de estudo irei aprender como instalar kubernetes(k8s) em ambiente local.


Existem várias opções de instalar o k8s mas uma das mais utilizadas em ambiente local é utilizando o [minikube](https://minikube.sigs.k8s.io/docs/), o minikube executa um único nó de cluster k8s.

Requisitos necessários ([Saiba mais](https://minikube.sigs.k8s.io/docs/start/)):
> 2 CPU ou mais

> 2GB memória

> 20GB de disco

> Container ou gerenciador de máquinas virtuais: Docker, Hyperkit/VirtualBox.

Importante dizer que para executar em ambiente local é preciso de que seu computador tenha virtualização em conjunto com seu sistema operacional.

## Instalando

A instalação do minikube existe a necessidade de selecionar o driver utilizado, olhando na documentação do próprio [minikube](https://minikube.sigs.k8s.io/docs/drivers/) para linux o [Docker](https://minikube.sigs.k8s.io/docs/drivers/docker/) é o preferido. O docker é o driver preferido em todos os principais sistemas MAC, Windows e Linux pela sua caracteristica de ser _cross platform_.


Instalação:
```bash
curl -LO https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64
sudo install minikube-linux-amd64 /usr/local/bin/minikube
```


Uso:
```bash
minikube start --driver=docker

# Configurando o docker como driver padrão
minikube config set driver docker
```

Após executar o comando start, o minikube retorna algumas informações acerca da instalação e faz o download do kubernetes para seu ambiente local.