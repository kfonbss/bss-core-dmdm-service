pipeline {
	agent { label 'Master-Node' }
	environment {
		KUBECONFIG = '/home/jenkins/.kube/config'
		REGISTRY_150 = '172.16.80.150:5000'
		SERVICE_NAME = 'bss-core-dmdm-service'
		DOCKER_IMAGE = 'bss-core-dmdm-service'
		TAG = 'dev'
	}
	stages {
		stage('Checkout Code') {
			steps {
				git branch: 'dev',
				url: 'https://github.com/kfonbss/bss-core-dmdm-service.git',
				credentialsId: 'kfonbss-git-token'
			}
		}
		stage('Build Image') {
			steps {
				sh '''
                    docker rmi $REGISTRY_150/$DOCKER_IMAGE:$TAG || true
                    docker build -t $REGISTRY_150/$DOCKER_IMAGE:$TAG .
                '''
			}
		}
		stage('Push Image → Registry 150') {
			steps {
				sh '''
                    docker push $REGISTRY_150/$DOCKER_IMAGE:$TAG
                '''
			}
		}
		stage('Deploy to Kubernetes') {
			steps {
				sh '''
                    cd /home/jenkins/workspace/$SERVICE_NAME/infra/helm/$SERVICE_NAME
                    kubectl scale deployment $SERVICE_NAME --replicas=0 || true
                    helm upgrade --install --force $SERVICE_NAME . -f values-dev.yaml
                '''
			}
		}
	}
}