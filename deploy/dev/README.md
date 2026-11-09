# Dev Kubernetes deployment

This deployment runs one API replica on the `workload=app` node. It uses the
dev PostgreSQL instance at `10.40.1.71` and the shared, password-protected
Redis container on `rwbss-dev-plt01` (`10.40.1.225:6379`). The API is exposed
through a private NodePort:

- URL: `http://10.40.1.225:30180/bss-core-dmdm-service`
- Connect the laptop to the Client VPN before accessing it.

The database Secret (`bss-core-dmdm-db`) and shared Redis Secret
(`bss-core-dmdm-redis`) are created directly in Kubernetes and must not be
committed. The Redis password is stored in AWS Systems Manager Parameter Store
as a `SecureString`; the Terraform output gives the parameter ARN. Use an
authorized AWS identity to retrieve it with `aws ssm get-parameter
--with-decryption`, then populate the Kubernetes Secret. Other services can
use the same host, port, and password. Harbor's `library` project is public,
so the workload does not need a registry pull secret.

The pipeline deploys immutable commit-tagged images. The manifest's `dev` tag
is a bootstrap/default tag updated by each successful pipeline run.

Apply the resources from the control plane with:

```sh
export KUBECONFIG=/etc/kubernetes/admin.conf
kubectl apply -k deploy/dev
```

## Jenkins deployment

The `dev-deployment` branch contains a Jenkins Pipeline that builds the image
on `rwbss-jen-ag01`, pushes a commit-tagged image and the mutable `dev` tag to
the public Harbor `library` project at `10.40.2.107`, updates this Deployment,
and checks its rollout and health endpoint. Jenkins polls SCM every five
minutes. Run the pipeline once before applying this Kustomize directory so
the initial `dev` image exists in Harbor.

Create a Pipeline job in Jenkins at `http://10.40.2.102:8080` with:

- SCM: `https://github.com/kfonbss/bss-core-dmdm-service.git`
- Branch: `*/dev-deployment`
- Script path: `Jenkinsfile`

The Jenkins global username/password credential `harbor-credentials` is used
for Harbor pushes. The Pipeline also requires a Jenkins **Secret file**
credential named `dev-kubeconfig`. It must contain a kubeconfig for the
`jenkins-deployer` ServiceAccount, not the cluster-admin kubeconfig. The
included Role grants only `get`, `patch`, and `watch` on Deployments in this
namespace. Apply `deploy/dev/jenkins-deployer.yaml` (or `kubectl apply -k
deploy/dev`) before creating that credential. Store the kubeconfig securely
and rotate its ServiceAccount token periodically; never commit it.

Harbor currently serves HTTP on the private VPC. The Jenkins build agent and
dev application worker are configured to use this endpoint as an insecure
HTTP registry. Use Harbor TLS before moving beyond this private development
environment.
