FROM gitpod/workspace-mysql:latest

USER root

# install 'gcloud', 'kubectl' and `helm` cli commands
RUN echo "deb [signed-by=/usr/share/keyrings/cloud.google.gpg] https://packages.cloud.google.com/apt cloud-sdk main" | tee -a /etc/apt/sources.list.d/google-cloud-sdk.list \
 && curl https://packages.cloud.google.com/apt/doc/apt-key.gpg | apt-key --keyring /usr/share/keyrings/cloud.google.gpg add - \
 && apt-get update \
 && apt-get install -yq google-cloud-sdk kubectl \
 && curl -L https://git.io/get_helm.sh | bash

# install docker
RUN curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add - \
 && add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable" \
 && apt-get update \
 && apt-get install -yq docker-ce docker-ce-cli containerd.io
ENV DOCKER_HOST=tcp://localhost:2375

RUN wget https://github.com/wagoodman/dive/releases/download/v0.8.1/dive_0.8.1_linux_amd64.deb \
 && apt install ./dive_0.8.1_linux_amd64.deb

ENV MAVEN_USER_HOME=/workspace/.m2

USER gitpod


# version 2
