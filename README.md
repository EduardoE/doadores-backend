# Doadores-backend

- Este projeto consiste no backend da aplicação doadores e foi desenvolvido com Spring Boot Java utilizando o Eclipse.

# Instruções

- Clonar o projeto
- Configurar a conexão com o banco mysql (Instalar o mysql caso o mesmo não esteja instalado na máquina)
  
 ### Para configurar a conexão, basta editar o arquivo application properties com as seguintes informações:
   
- spring.datasource.url=jdbc:mysql://localhost:3306/doadores?useTimezone=true&serverTimezone=UTC
- spring.datasource.username=root (seu usuário mysql)
- spring.datasource.password=12345 (sua senha)
   
- Criar o scheema de nome "doadores" no mysql
- Startar a aplicação
