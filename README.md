# Desafio Ponto

## Pré-Requisitos

1. Criar um campo personalizado (Custom Field) para o usuário com a chave "Pis".

## Configuração

1. Realizar o deploy dos arquivos (.jar) do serviço e portlet, no Liferay :
    * **com.desafio.ponto.api-1.0.0.jar**
    * **com.desafio.ponto.service-1.0.0.jar**
    * **com.desafio.ponto.web-1.0.0.jar**

2. Criar uma página com suporte a Widget
    * selecionar o widget **Desafio Ponto** da categoria *Desafio Ponto*.
    * Adiciona-lo á página.

## Importação de Dados

Realizar uma requisição para a url */api/jsonws/desafioponto.registroponto/importar-pontos* enviando os seguintes parametros :

* **companyId**

* **pis**

* **batidas**
    * O Campo batidas deve receber um JSON no seguinte formato:
```json
    {  
    "batidas":[  
        "03/01/2019 19:30",
        "03/01/2019 17:30",
        "03/01/2019 17:00",
        "03/01/2019 08:00",
        "04/01/2019 19:30",
        "04/01/2019 17:30",
        "04/01/2019 17:00",
        "04/01/2019 08:00"
    ]
    }
```
### Exemplo CURL

curl http://localhost:8080/api/jsonws/desafioponto.registroponto/importar-pontos \
  -u test@liferay.com:test \
  -d companyId=20099 \
  -d pis=1234567890 \
  -d batidas='%7B%22batidas%22%3A%5B%2228/12/2019%2019%3A30%22%2C%2228/12/2019%2017%3A30%22%2C%2228/12/2019%2017%3A00%22%2C%2228/12/2019%2008%3A00%22%5D%7D'

### Exemplo Liferay Services
```js
Liferay.Service(
  '/desafioponto.registroponto/importar-pontos',
  {
    companyId: 20099,
    pis: 1234567890,
    batidas: '%7B%22batidas%22%3A%5B%2228/12/2019%2019%3A30%22%2C%2228/12/2019%2017%3A30%22%2C%2228/12/2019%2017%3A00%22%2C%2228/12/2019%2008%3A00%22%5D%7D'
  },
  function(obj) {
    console.log(obj);
  }
);
````

Também pode ser executado atráves do */api/jsonws/*

## Funcionalidades

### Desafio Ponto Portlet

    1. Registrar o ponto pelo portlet.
    2. Consulta dos registros e marcações (batidas) de um dia em especifico.

### Serviços

    1. Registrar o ponto.
    2. Consultar o ponto por dia.
    3. Consultar o ponto pela competencia(mês).
    4. Importação de batidas.

## Recursos do Liferay utilizados no projeto

    * Portlet
    * Service Builder - Webservices e persistencia
    * Campos personalizados (Custom fields)

## Informações do ambiente de desenvolivmento

Liferay 7.1
* Product information:
  * installation type: binary
  * build number: 7110
  * service pack version:
    - available SP version: Not available
    - installable SP version: Not available
  * patching-tool version: 2.0.7
  * time: 2018-12-28 17:01Z
  * plugins: no plugins detected

SGBD - MySQL 5.7
