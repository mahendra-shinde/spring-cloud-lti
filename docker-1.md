1.	Docker : Container Platform 
	(Build, Ship & Deploy Containers across windows/linux)

2.	Container: An application wrapped in a self
		contained package, which has Runtime, Libraries
		Private IPs and Isolated file system.

3.	Docker available on:

	  Linux: Natively Available, easier to install
			CPU level virtualization : Not Required

	  Windows: Available Natively on Windows Server 2016/2019
		   Windows 10 PRO/ENT  Requires CPU level Virt.

	Windows 10 PRO has support for Linux Containers through
		HYPER-V
	Windows Server 2016/2019 has no support for 
		Linux Containers

How to Install docker desktop on Windows 10 PRO/ENT
1. Check your Windows 10 Version Start Menu -> Settings > System > About
2. If it's Windows 10 PRO/ENT, Start Menu -> Settings and search for "Turn On/off Windows Features"
	2.1 Containers
	2.2 Hyper-V
3. Accept the changes and wait for System restart.
4. go to docker.com and sign-up for new account.
	https://hub.docker.com/signup

	Once Signed In, Download Docker Desktop and Install it.

 docker run -d --name web1 -p 8080:80 nginx:alpine

docker run	Create and Start new Container
-d		Run new container in DETACHED mode 
--name web1	Assign user-defined name to new container (OPTIONAL)
-p 8080:80	The container PORT "80" to be mapped to local port "8080"
nginx:alpine	The name of container image


To check result
Point your browser to http://localhost:8080/

docker stop web1
docker rm web1