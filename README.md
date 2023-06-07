# Sistema de Registro de Pacientes - API

## Descrição do Projeto

O Sistema de Registro de Pacientes é uma API simples desenvolvida com o framework Spring Boot, que permite o cadastro, atualização e consulta de informações de pacientes e médicos. Cada paciente possui uma identidade única que o identifica no sistema. A API oferece as seguintes funcionalidades:

- Cadastro de Pacientes: Permite adicionar um novo paciente ao banco de dados, coletando informações relevantes como identidade, nome, endereço, data de nascimento, histórico médico, etc.
- Atualização de Registros de Pacientes: O sistema deve permitir a atualização de informações de um paciente existente. Isso deve incluir a capacidade de modificar qualquer um dos dados coletados durante o registro.
- Marcação de Consultas: O sistema deve permitir o agendamento de consultas médicas para os pacientes registrados. As consultas devem incluir informações relevantes como o paciente, o médico, a data e hora da consulta, e a área médica da consulta.
- Consulta de Pacientes por Área Médica: O sistema deve permitir a visualização de todas as consultas marcadas para uma determinada área médica.
- Histórico de Consultas de Pacientes: O sistema deve fornecer a capacidade de visualizar o histórico de consultas de um paciente individual. Isso deve incluir todas as consultas passadas e futuras do paciente.
- Cadastro de Médicos: O sistema deve ser capaz de adicionar um novo médico ao banco de dados. Deve-se coletar informações relevantes do médico, como nome, endereço, data de nascimento, especialidade, etc.
- Atualização de Registros de Médicos: O sistema deve permitir a atualização de informações de um médico existente. Isso deve incluir a capacidade de modificar qualquer um dos dados coletados durante o registro.
- Exclusão de Registros de Médicos: O sistema deve permitir a remoção de um médico do banco de dados.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Banco de Dados (MySQL)
- Hibernate
- Spring Data JPA

## API Endpoints

A API oferece os seguintes endpoints:

- `POST /pacientes`: Cria um novo paciente.
- `PUT /pacientes/{id}`: Atualiza as informações de um paciente existente.
- `GET /pacientes/{id}`: Retorna as informações de um paciente específico.
- `GET /pacientes`: Retorna a lista de todos os pacientes cadastrados.
- `POST /consultas`: Agenda uma nova consulta.
- `GET /consultas/{id}`: Retorna as informações de uma consulta específica.
- `GET /consultas`: Retorna a lista de todas as consultas marcadas.
- `GET /consultas/area/{area}`: Retorna a lista de consultas marcadas para uma determinada área médica.
- `GET /pacientes/{id}/consultas`: Retorna o histórico de consultas de um paciente específico.
- `POST /medicos`: Cria um novo médico.
- `PUT /medicos/{id}`: Atualiza as informações de um médico existente.
- `GET /medicos/{id}`: Retorna as informações de um médico específico.
- `GET /medicos`: Retorna a lista de todos os médicos cadastrados.
- `DELETE /medicos/{id}`: Remove um médico do sistema.

## Equipe
- Marco Túlio da Silva Rocha - Dev Back-End
- Juliana Sousa Lobo - Dev Back-End

## Contribuição

1. Faça o fork do projeto.
2. Crie uma branch para sua contribuição.
3. Faça as alterações e commit.
4. Envie um pull request.

## Contato

- Email: sousalobojuliana@gmail.com
- GitHub: github.com/JulianaLobo 
- Email: marcotuliopessoal@gmail.com
- GitHub: github.com/marcotuliosr 
